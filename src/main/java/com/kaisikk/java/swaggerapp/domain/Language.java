package com.kaisikk.java.swaggerapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Accessors(chain = true)
@ApiModel(value = "class language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;


    @ApiModelProperty(value = "name of language", example = "python")
    private String name;

    @ApiModelProperty(value = "authors name", example = "gvido")
    private String author;

}
