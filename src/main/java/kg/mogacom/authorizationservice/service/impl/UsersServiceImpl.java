package kg.mogacom.authorizationservice.service.impl;

import kg.mogacom.authorizationservice.dao.UsersRep;
import kg.mogacom.authorizationservice.mappers.UsersMapper;
import kg.mogacom.authorizationservice.models.dto.AccountDto;
import kg.mogacom.authorizationservice.models.dto.UsersDto;
import kg.mogacom.authorizationservice.service.AccountService;
import kg.mogacom.authorizationservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRep rep;

    UsersMapper mapper = UsersMapper.INSTANCE;

    @Autowired
    private AccountService accountService;

    @Override
    public UsersDto save(UsersDto users) {
        AccountDto account = new AccountDto();
        account.setLogin(users.getAccount().getLogin());
        account.setPassword(users.getAccount().getPassword());
        account = accountService.save(account);
        users.setAccount(account);

        if (users.getName().isEmpty()) {
            throw new RuntimeException("Имя не может быть пустым!");
        }
        return mapper.toDto(rep.save(mapper.toEntity(users)));
    }

    @Override
    public UsersDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Пользователь не найден!")));
    }

    @Override
    public UsersDto delete(Long id) {
        UsersDto users = findById(id);
        users.setActive(false);
        return save(users);
    }

    @Override
    public List<UsersDto> findAll() {
        return mapper.toDto(rep.findAll());
    }
}
