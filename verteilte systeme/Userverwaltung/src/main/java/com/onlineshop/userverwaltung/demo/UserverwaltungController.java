package com.onlineshop.userverwaltung.demo;


import com.onlineshop.userverwaltung.demo.account.model.User;
import com.onlineshop.userverwaltung.demo.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserverwaltungController {

    @Autowired
    private UserRepository userRepos;

    @RequestMapping("/")
    public String getHallo(){
        return "HallO";
    }

    @RequestMapping("/user")
    public String hello() {
        return "Hello user";
    }

    @ResponseBody
    @RequestMapping("/create")
    public String create(String username, String vorname, String nachname, String email, String dateOfBirth, String password){
        String userId = "";
        try {
            Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
            User user = new User(username, vorname, nachname, email, dob, password);
            userRepos.save(user);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String delete(int id){
        try {
            userRepos.deleteById(id);
        } catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    @ResponseBody
    @RequestMapping("get-by-email")
    public String getByEmail(String email) {
        String userId = "";
        try {
            User user = userRepos.findByEmail(email);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    @ResponseBody
    @RequestMapping("/update")
    public String updateUser(int id, String username, String vorname, String nachname, String email, String dateOfBirth, String password){
        try{
            User user = userRepos.findById(id);
            user.setUsername(username);
            user.setVorname(vorname);
            user.setNachname(nachname);
            user.setEmail(email);
            Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
            user.setDateOfBirth(dob);
            user.setPassword(password);
            userRepos.save(user);

        }catch(Exception ex){
            return "Error updating"+ex.toString();
        }
        return "User updated successfully";
    }

}
