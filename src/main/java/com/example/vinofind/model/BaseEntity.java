package com.example.vinofind.model;

import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.time.LocalDate;

@SuperBuilder
public class BaseEntity {
    public boolean valid;
    public Date createdAt;
    public Date updatedAt;
    public Date deletedAt;

    BaseEntity(){
        this.createdAt = Date.valueOf(LocalDate.now());
        this.updatedAt = null;
        this.deletedAt = null;
        this.valid = true;
    }

    public void update(){
        this.updatedAt = Date.valueOf(LocalDate.now());
        this.deletedAt = null;
        this.valid = true;
    }

    public void delete(){
        this.deletedAt = Date.valueOf(LocalDate.now());
        this.valid = false;
    }

}
