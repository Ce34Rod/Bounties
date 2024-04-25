package org.CERN.bounties.models;

import jakarta.persistence.Entity;

import java.util.ArrayList;


@Entity
public class User extends AbstractEntity{

    public String name;

    public ArrayList<String> inventory;

    public User(){};

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }
}
