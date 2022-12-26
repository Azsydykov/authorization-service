package kg.mogacom.authorizationservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mogacom.authorizationservice.models.dto.AccountDto;
import kg.mogacom.authorizationservice.models.request.AuthRequest;
import kg.mogacom.authorizationservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<?> save(@RequestBody AccountDto account) {
        try{
            return new ResponseEntity<>(service.save(account),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/create")
    @ApiOperation("Создание аккаунта")
    ResponseEntity<?> save(@RequestBody AuthRequest request) {
        try{
            return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск аккаунта по ID")
    ResponseEntity<?> findById(@RequestParam Long id) {
        try{
            return new ResponseEntity<>(service.findById(id),HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
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
