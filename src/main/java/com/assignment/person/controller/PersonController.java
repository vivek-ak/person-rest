package com.assignment.person.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private MappingJackson2HttpMessageConverter converter;

    private Logger log = LoggerFactory.getLogger(PersonController.class);

    @GetMapping(value = "/people")
    @CrossOrigin
    public ResponseEntity<Object> getPeopleData() {
        try {
            File personDataFile = new ClassPathResource("personData.json").getFile();
            Object personData = converter.getObjectMapper().readValue(personDataFile, Object.class);
            return new ResponseEntity<>(personData, HttpStatus.OK);
        } catch (IOException exp) {
            log.error("Not able to fetch person data {} -", exp);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
