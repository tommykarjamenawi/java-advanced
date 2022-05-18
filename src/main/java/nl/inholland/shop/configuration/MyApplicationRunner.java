package nl.inholland.shop.configuration;

import nl.inholland.shop.model.Role;
import nl.inholland.shop.model.User;
import nl.inholland.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User testUser = new User();
        testUser.setUsername("test");
        testUser.setPassword("secret");
        testUser.setRoles(new ArrayList<>(Arrays.asList(Role.ROLE_USER)));

        userService.add(testUser);
    }
}
