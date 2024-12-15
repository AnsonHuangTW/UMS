package com.hyhuang.UMS.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestDBController {
    @Autowired
    ITestDBRepository repo;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("/test-db-JPA/{userEmail}")
    public String TestSelectJPA(@PathVariable String userEmail){

        List<TestDB> data = repo.findByEmail(userEmail);
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).getName());
            System.out.println(data.get(i).getEmail());
        }
        return "Run JPA SELECT w/ " + userEmail;
    }

    @GetMapping("/test-db-JDBC/{userEmail}")
    public String TestSelectJDBC(@PathVariable String userEmail){
        String SQL = "SELECT id, name, email, password from users WHERE email = :mail";

        Map<String, Object> sqlParaMap = new HashMap<>();
        sqlParaMap.put("mail", userEmail);

        TestDBRowMapper dbData = new TestDBRowMapper();
        List<TestDB> userList = jdbcTemplate.query(SQL, sqlParaMap, dbData);
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getName());
            System.out.println(userList.get(i).getEmail());
        }

        return "Run JDBC SELECT w/ "+ userEmail;
    }




}
