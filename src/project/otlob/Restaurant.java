/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.otlob;

import java.util.*;

/**
 *
 * @author A.S.A
 */
public class Restaurant {

    private String RestaurantName;
    private String location;
    private List<Meal> meals = new ArrayList<>();
    private List<Order> order = new ArrayList<>();

    public Restaurant(String RestaurantName, String location) {
        this.RestaurantName = RestaurantName;
        this.location = location;
    }

    public Restaurant(String RestaurantName, String location, List<Meal> meals) {
        this.RestaurantName = RestaurantName;
        this.location = location;
        this.meals = meals;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String RestaurantName) {
        this.RestaurantName = RestaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
    

}
