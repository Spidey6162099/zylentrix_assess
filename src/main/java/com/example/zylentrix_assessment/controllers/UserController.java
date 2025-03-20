package com.example.zylentrix_assessment.controllers;

import com.example.zylentrix_assessment.Exceptions.UserCreationException;
import com.example.zylentrix_assessment.Exceptions.UserNotFoundException;
import com.example.zylentrix_assessment.dtos.UserDto;
import com.example.zylentrix_assessment.entities.UserInDB;
import com.example.zylentrix_assessment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<UserInDB> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id){
        try{
            return ResponseEntity.ok().body(userService.getById(id));
        }
        catch (UserNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id,@RequestBody UserDto userDto){
        try{
            userService.updateUser(id,userDto);
            return ResponseEntity.created(new URI("/users/"+id)).build();
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body("user not found");
        }
        catch(URISyntaxException e){
            return ResponseEntity.badRequest().body("invalid uri");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/users")
    public ResponseEntity<String> makeNewUser(@RequestBody UserDto userDto) {
    try{
        String id=userService.save(userDto);
        return ResponseEntity.created(new URI("/users/"+id)).build();
    }
    catch(UserCreationException e){
        return ResponseEntity.badRequest().body("user could not be added");
    }
    catch (URISyntaxException e){
        return ResponseEntity.badRequest().body("invalid uri");
    }

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body("user id invalid");
        }
    }



}
