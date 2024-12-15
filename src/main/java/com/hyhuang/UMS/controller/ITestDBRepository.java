package com.hyhuang.UMS.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITestDBRepository extends JpaRepository<TestDB, Long> {
    List<TestDB> findByEmail(String email);
}
