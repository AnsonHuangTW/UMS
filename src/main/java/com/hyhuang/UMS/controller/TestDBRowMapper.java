package com.hyhuang.UMS.controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDBRowMapper implements RowMapper<TestDB> {
    @Override
    public TestDB mapRow(ResultSet rs, int rowNum) throws SQLException {
        TestDB data = new TestDB();
        data.setId(rs.getInt("id"));
        data.setName(rs.getString("name"));
        data.setEmail(rs.getString("email"));
        data.setPassword(rs.getString("password"));
        return data;
    }
}
