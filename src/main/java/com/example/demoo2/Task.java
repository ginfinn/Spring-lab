package com.example.demoo2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.swing.text.View;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Integer Id;
    private String Number;
    private String name;
    private String client;

    enum Bool {
        done, dontDone
    }
    public void onClick(View v){
        Bool bool;
        bool = Bool.done;
        bool = Bool.dontDone;
        switch (bool) {

        }
    }


    public Task() {
    }

    public Task(String name, String client, String Number) {
        this.name = name;
        this.client = client;
        this.Number = Number;

    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}

