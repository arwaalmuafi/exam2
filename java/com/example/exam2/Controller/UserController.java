package com.example.exam2.Controller;

import com.example.exam2.ApiReasponse.ApiReasponse;
import com.example.exam2.Model.User;
import com.example.exam2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/exam/vi/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUSer(){
        ArrayList<User> users=userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUSer(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String massage= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiReasponse("user added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUSer(@PathVariable String id,@RequestBody @Valid User user,Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        boolean isUpdate = userService.updateService(user, id);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiReasponse("user is updated"));
        }
        return ResponseEntity.status(400).body(new ApiReasponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUSer(@PathVariable String id){
        boolean isDelete=userService.deleteService(id);

        if (isDelete){
            return ResponseEntity.status(200).body(new ApiReasponse("user is deleted"));
        }

        return ResponseEntity.status(400).body(new ApiReasponse("is not found"));
    }

    @GetMapping("/balance/{balance}")
    public ResponseEntity searchByBalance(@PathVariable int balance){
        ArrayList<User> users=userService.searchByBalance(balance);
        if(users==null){
            return ResponseEntity.status(400).body(new ApiReasponse("is null"));
        }

        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/balance/{age}")
    public ResponseEntity searchByage(@PathVariable int age){
        ArrayList<User> users=userService.searchByAge(age);
        if(users==null){
            return ResponseEntity.status(400).body(new ApiReasponse("is null"));
        }

        return ResponseEntity.status(200).body(users);
    }

















}
