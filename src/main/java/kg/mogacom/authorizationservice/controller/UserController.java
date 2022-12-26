package kg.mogacom.authorizationservice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mogacom.authorizationservice.models.dto.UsersDto;
import kg.mogacom.authorizationservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Пользователь")
@RestController
@RequestMapping("api/v1/user")
public class UserController {


    @Autowired
    private UsersService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody UsersDto users) {
        try {
            return new ResponseEntity<>(service.save(users), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск пользователя по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity(service.findById(id),HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех пользователей")
    List<UsersDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    UsersDto delete(@RequestParam Long id) {
        return service.delete(id);
    }

}
