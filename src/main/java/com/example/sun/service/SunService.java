package com.example.sun.service;

import com.example.sun.entity.Sun;
import com.example.sun.model.SunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SunService {
    @Autowired
    private SunRepository sunRepository;
    public List<Sun> findAll(String name){
        return SunRepository.findAllSun(name);
    }
    public Optional<Sun> findById(Integer id) {
        return SunRepository.findById(id);
    }
    public Sun save(Sun sun){
        return SunRepository.save(sun);
    }
    public void deleteById(Integer id){
        SunRepository.deleteById(id);
    }
}