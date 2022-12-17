package kg.mogacom.authorizationservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mogacom.authorizationservice.models.Account;
import kg.mogacom.authorizationservice.models.dto.AccountDto;
import kg.mogacom.authorizationservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Аккаунт")
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    AccountDto save(@RequestBody AccountDto account) {
        return service.save(account);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск аккаунта по ID")
    AccountDto findById(@RequestParam Long id) {
        return service.findById(id);
    }


    @GetMapping("/findAll")
    @ApiOperation("Вывод всех аккаунтов")
    List<AccountDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    AccountDto delete(@RequestParam Long id) {
        return service.delete(id);
    }

    @GetMapping("/test")
    String test(@RequestParam List<Integer> id){
        System.out.println(id);
        return "success";
    }


    @GetMapping("/get/by/name")
    AccountDto getByUserName(@RequestParam String name,@RequestParam boolean active) {
        return service.findByUserName(name, active);
    }

    @GetMapping("/get/by/id")
    AccountDto getByUserId(@RequestParam Long id) {
        return service.getByUserId(id);
    }

}
