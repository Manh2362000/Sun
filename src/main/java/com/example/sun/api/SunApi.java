package com.example.sun.api;

import com.example.sun.entity.Sun;
import com.example.sun.model.SunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/sun")
public class SunApi {

    @Autowired
    SunRepository sunRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Sun> getList(@RequestParam(defaultValue = "") String name){
        if(name.length() > 0){
            return SunRepository.findAllSun(name);
        }else {
            return SunRepository.findAll();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Sun save(@RequestBody Sun sun){
        SunRepository.save(sun);
        return sun;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Sun getDetail(@PathVariable int id){
        return SunRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id){
        SunRepository.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Sun update(@PathVariable int id, @RequestBody Sun updateSun){
        Sun existing = SunRepository.findById(id).get();
        existing.setName(updateSun.getName());
        existing.setWage(updateSun.getWage());
        SunRepository.save(existing);
        return updateSun;
    }
}