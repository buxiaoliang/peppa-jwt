package com.xiao.peppa;

import com.xiao.peppa.model.Role;
import com.xiao.peppa.model.User;
import com.xiao.peppa.repository.RoleRepository;
import com.xiao.peppa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return (evt) -> {
            Role role1 = new Role();
            role1.setName("ROLE_USER");
            Role role2 = new Role();
            role2.setName("ROLE_ADMIN");

            if (roleRepository.findByName("ROLE_USER") == null) {
                roleRepository.save(role1);
            }

            if (roleRepository.findByName("ROLE_ADMIN") == null) {
                roleRepository.save(role2);
            }

            User user1 = new User();
            user1.setUsername("admin");
            user1.setPassword("$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi");
            user1.setEmail("admin@admin.com");
            user1.setEnabled(true);
            if (userRepository.findByUsername("admin") == null) {
                Set<Role> roles = new HashSet<Role>();
                roles.add(role1);
                roles.add(role2);
                user1.setRoles(roles);
                userRepository.save(user1);
            }

            User user2 = new User();
            user2.setUsername("user");
            user2.setPassword("$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC");
            user2.setEmail("user@user.com");
            user2.setEnabled(true);
            if (userRepository.findByUsername("user") == null) {
                Set<Role> roles = new HashSet<Role>();
                roles.add(role1);
                user2.setRoles(roles);
                userRepository.save(user2);
            }

            User user3 = new User();
            user3.setUsername("disabled");
            user3.setPassword("$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC");
            user3.setEmail("disabled@user.com");
            user3.setEnabled(false);
            if (userRepository.findByUsername("disabled") == null) {
                Set<Role> roles = new HashSet<Role>();
                roles.add(role1);
                user3.setRoles(roles);
                userRepository.save(user3);
            }
        };
    }

}
