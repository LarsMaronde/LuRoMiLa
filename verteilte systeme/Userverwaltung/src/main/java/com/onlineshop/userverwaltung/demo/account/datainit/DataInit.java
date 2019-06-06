package com.onlineshop.userverwaltung.demo.account.datainit;

import com.onlineshop.userverwaltung.demo.account.model.User;
import com.onlineshop.userverwaltung.demo.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataInit implements ApplicationRunner {

    private UserRepository userRepos;
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public DataInit(UserRepository userRepos){
        this.userRepos = userRepos;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{

        long count = userRepos.count();

        if (count == 0) {
            User user = new User();

            user.setVorname("John");

            Date d1 = df.parse("1980-12-20");
            user.setDateOfBirth(d1);
            //
            User user2 = new User();

            user2.setVorname("Smith");
            Date d2 = df.parse("1985-11-11");
            user2.setDateOfBirth(d2);

            userRepos.save(user);
            userRepos.save(user2);
        }



    }

}
