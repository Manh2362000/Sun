package com.example.sun.model;

import com.example.sun.entity.Sun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SunRepository extends JpaRepository<Sun, Integer> {
    @Query(value = "SELECT * FROM sun a WHERE a.name LIKE %:name%",
            nativeQuery = true)
    static List<Sun> findAllSun(
            @Param("name") String name);

}