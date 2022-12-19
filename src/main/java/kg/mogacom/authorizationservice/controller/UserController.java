package kg.mogacom.authorizationservice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mogacom.authorizationservice.models.dto.UsersDto;
import kg.mogacom.authorizationservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
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
    UsersDto save(@RequestBody UsersDto users) {
        return service.save(users);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск пользователя по id")
    UsersDto findById(@RequestParam Long id) {
        return service.findById(id);
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
