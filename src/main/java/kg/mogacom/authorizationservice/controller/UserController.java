package kg.mogacom.authorizationservice.controller;


import io.swagger.annotations.Api;
import kg.mogacom.authorizationservice.models.Account;
import kg.mogacom.authorizationservice.models.Users;
import kg.mogacom.authorizationservice.service.AccountService;
import kg.mogacom.authorizationservice.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Пользователь")
@RestController
@RequestMapping("api/v1/user")
public class UserController {


    @Autowired
    private UsersService service;

    @PostMapping()
    Users save(@RequestBody Users users) {
        return service.save(users);
    }

    @GetMapping("/findById")
    Users findById(@RequestParam Long id) {
        return service.findById(id);
    }

    @GetMapping("/findAll")
    List<Users> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/delete")
    Users delete(@RequestParam Long id) {
        return service.delete(id);
    }

}
