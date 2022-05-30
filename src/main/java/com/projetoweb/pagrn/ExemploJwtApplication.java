package com.projetoweb.pagrn;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.projetoweb.pagrn.model.Usuario;
import com.projetoweb.pagrn.repository.UsuarioRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@SpringBootApplication
public class ExemploJwtApplication {

    @Autowired
    private UsuarioRepository repository;
    //@Autowired
    //private PasswordEncoder encoder;


    @PostConstruct
    public void initUsers() {

        List<Usuario> users = Stream.of(
                new Usuario(1L, "Ravan","ravan@gmail.com", "admin", encoder().encode("admin"), "ROLE_ADMIN"),
                new Usuario(2L, "Paulo","paulo@gmail.com", "user1", encoder().encode("user1"), "ROLE_USER")

        ).collect(Collectors.toList());

        repository.saveAll(users);

    }

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(ExemploJwtApplication.class, args);
    }


}