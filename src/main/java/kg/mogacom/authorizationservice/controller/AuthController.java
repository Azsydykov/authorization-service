package kg.mogacom.authorizationservice.controller;


import kg.mogacom.authorizationservice.models.request.AuthRequest;
import kg.mogacom.authorizationservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AccountService service;

    @PostMapping("/sing/in")
    ResponseEntity<String> auth(@RequestBody AuthRequest request ){
        try{
            return ResponseEntity.ok(service.auth(request));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }



}
