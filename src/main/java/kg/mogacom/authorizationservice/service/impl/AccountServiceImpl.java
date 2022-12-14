package kg.mogacom.authorizationservice.service.impl;

import kg.mogacom.authorizationservice.dao.AccountRep;
import kg.mogacom.authorizationservice.exceptions.AccountNotFoundExc;
import kg.mogacom.authorizationservice.exceptions.AuthExc;
import kg.mogacom.authorizationservice.mappers.AccountMapper;
import kg.mogacom.authorizationservice.models.dto.AccountDto;
import kg.mogacom.authorizationservice.models.enums.AccountStatus;
import kg.mogacom.authorizationservice.models.request.AuthRequest;
import kg.mogacom.authorizationservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRep rep;

    AccountMapper mapper = AccountMapper.INSTANCE;


    @Override
    public AccountDto save(AccountDto account) {
        try{
            return mapper.toDto(rep.save(mapper.toEntity(account)));
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Логин уже существует!");
        }
    }


    @Override
    public String create(AuthRequest request) {
        try {
            if(request.getLogin()==null || request.getLogin().isEmpty()){
                throw new RuntimeException("Логин не может быть пустым!");
            }

            AccountDto accountDto = new AccountDto();
            accountDto.setPassword(request.getPassword());
            accountDto.setLogin(request.getLogin());
            save(accountDto);
            return  "Success";
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Аккаунт с таким логином уже существует!");
        }catch (Exception e){
            throw new RuntimeException("Произошла неизвестная ошибка!");
        }
    }

    @Override
    public AccountDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new AccountNotFoundExc("Аккаунт не найден!")));
    }

    @Override
    public AccountDto delete(Long id) {
        AccountDto account = findById(id);
        account.setActive(false);
        return save(account);
    }

    @Override
    public List<AccountDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public String auth(AuthRequest request) {
        AccountDto account= mapper.toDto(rep.findByLogin(request.getLogin()).orElseThrow(()-> new AccountNotFoundExc("Пользователь не найден")));
        switch (account.getStatus()){
            case ACTIVE:
                break;
            case BLOCKED:
                if (checkDate(account.getUpdateDate())){
                    account.setCount(0);
                    account.setStatus(AccountStatus.ACTIVE);
                    save(account);
                    break;
                }
                throw new RuntimeException("Ваш аккаунт заблокирован");
            case DELETED:
                throw new RuntimeException("Ваш аккаунт удален");
        }
        if (account.getPassword().equals(request.getPassword())){
            account.setCount(0);
            save(account);
            return "Success";
        }else {
            if (account.getCount()>=3){
                account.setStatus(AccountStatus.BLOCKED);
                save(account);
                throw new RuntimeException("Вы заблокированы.Повторите попытку через час");
            }
            account.setCount(account.getCount()+1);
            save(account);
            throw new RuntimeException("Вы ввели неверный пароль");
        }

    }

    private boolean checkDate(Date updateDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(updateDate);
        calendar.add(Calendar.HOUR,1);
        return new Date().after(calendar.getTime());
    }

    @Override
    public AccountDto findByUserName(String name, boolean active) {
        return mapper.toDto(rep.findByUserName(name, active));
    }

    @Override
    public AccountDto getByUserId(Long id) {
        return mapper.toDto(rep.findbyUserId(id));
    }


}
