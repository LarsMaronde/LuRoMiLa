package com.onlineshop.demo.rest;

import com.onlineshop.demo.jpa.entity.User;
import com.onlineshop.demo.remote.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("users")
    public User createUser(@RequestBody User user){
        return this.userService.createUser(user);
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userid){

        User user = userService.findOne(userid);

        if(user == null){
            return ResponseEntity.notFound().build();
        }

        userService.delete(user);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userid){
        User user = userService.findOne(userid);

        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }


    @PutMapping("users")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    //Calling the Warenverwaltung service
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("users/bestand/{id}")
    public int getBestand(@PathVariable(value = "id") Long artikelid){
        return userService.getBestand(artikelid);
    }

    //calling the Bewertung service
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("users/bewertung/{artikelid}/{userid}/{rating}/{beschreibung}")
    public void rateArtikel(@PathVariable(value = "artikelid") Long artikelid,
                            @PathVariable(value = "userid") Long userid,
                            @PathVariable(value = "rating") int rating,
                            @PathVariable(value = "beschreibung") String beschreibung){
        System.out.println("eingegangene anfrage");
        userService.rateArtikel(artikelid,userid,rating,beschreibung);
    }



}
