package kg.mogacom.authorizationservice.service.impl;

import kg.mogacom.authorizationservice.dao.AccountRep;
import kg.mogacom.authorizationservice.models.Account;
import kg.mogacom.authorizationservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRep rep;


    @Override
    public Account save(Account account) {
        return rep.save(account);
    }

    @Override
    public Account findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("Аккаунт не найден!"));
    }

    @Override
    public Account delete(Long id) {
        Account account = findById(id);
        account.setActive(false);
        return save(account);
    }

    @Override
    public List<Account> findAll() {

        return rep.findAll();
    }

    @Override
    public Account login(String login, String password) {
        Account account = rep.findByLogin(login);
        return rep.findByLogin(login);
    }
}
