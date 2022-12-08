package kg.mogacom.authorizationservice.service.impl;

import kg.mogacom.authorizationservice.dao.AccountRep;
import kg.mogacom.authorizationservice.dao.UsersRep;
import kg.mogacom.authorizationservice.models.Account;
import kg.mogacom.authorizationservice.models.Users;
import kg.mogacom.authorizationservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRep rep;


    @Override
    public Users save(Users users) {
        return rep.save(users);
    }

    @Override
    public Users findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("Пользователь не найден!"));
    }

    @Override
    public Users delete(Long id) {
        Users users = findById(id);
        users.setActive(false);
        return save(users);
    }

    @Override
    public List<Users> findAll() {
        return rep.findAll();
    }
}
