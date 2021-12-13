/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.otlob;

/**
 *
 * @author A.S.A
 */
public class Order {
    private int  id_customer;
    private Meal meal;
    private int  quantity;
    private double  order_P;
    private String  date;

    public Order(int id_customer, Meal meal, int quantity, double order_P, String date) {
        this.id_customer = id_customer;
        this.meal = meal;
        this.quantity = quantity;
        this.order_P = order_P;
        this.date = date;
    }

    public Order(int quantity) {
        this.quantity = quantity;
    }

    public Order(double Tota_P) {
        this.order_P = Tota_P;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOrder_P() {
        return order_P;
    }

    public void setOrder_P(double Tota_P) {
        this.order_P = Tota_P;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}