package kg.mogacom.authorizationservice.controller;

import io.swagger.annotations.Api;
import kg.mogacom.authorizationservice.dao.AccountRep;
import kg.mogacom.authorizationservice.models.Account;
import kg.mogacom.authorizationservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Аккаунт")
@RestController
@RequestMapping("/api/v1/account/save")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping()
    Account save(@RequestBody Account account) {
        return service.save(account);
    }

    @GetMapping("/findById")
    Account findById(@RequestParam Long id) {
        return service.findById(id);
    }

    @GetMapping("/findByLogin")
    Account findByLogin(@RequestParam String login, @RequestParam String password ) {
        return service.login(login,password);
    }

    @GetMapping("/findAll")
    List<Account> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/delete")
    Account delete(@RequestParam Long id) {
        return service.delete(id);
    }

}
