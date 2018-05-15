package com.example.jankro.mealplanner.Objects;

class Ingredient {

    private String name;

    public Ingredient(String name){
        this.name = name.toLowerCase();
    }

    public String getName() {
        return name;
    }

}
