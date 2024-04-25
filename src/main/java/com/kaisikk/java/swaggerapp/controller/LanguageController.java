package com.kaisikk.java.swaggerapp.controller;

import com.kaisikk.java.swaggerapp.domain.Language;
import com.kaisikk.java.swaggerapp.repo.LanguageRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Api(value = "language resources", description = "crud operations")
public class LanguageController {


    private LanguageRepo languageRepo;

    @GetMapping
    @ApiOperation(value = "show all languages", response = Iterable.class)
    public Iterable<Language> getAllLanguages(){
        return languageRepo.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "show language by id", response = Language.class)
    public Language getById(@PathVariable("id") Long id){
        return languageRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create language", response = Language.class)
    public Language createLanguage(@RequestBody Language language){
        return  languageRepo.save(new Language().setName(language.getName()).setAuthor(language.getAuthor()));
    }

}
