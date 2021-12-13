/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import project.otlob.Customer;
import project.otlob.Meal;
import project.otlob.Owner;
import project.otlob.Restaurant;

/**
 *
 * @author A.S.A
 */
public class _0_0_0_Amain {

    public static String name, password, type, restaurant, phone, address;
    public static int id_w = -1, id_c = -1;
    public static Scanner input = new Scanner(System.in);
    public static Owner w;
    public static Customer c;
    public static Restaurant r;
    public static Meal m;
    public static List<Owner> owner = new ArrayList<>();
    public static List<Customer> customer = new ArrayList<>();
    public static List<Restaurant> restaurants = new ArrayList<>();
    

    public static void main(String[] args) {
        _0_0_0_Login l = new _0_0_0_Login();
        l.setVisible(true);
    }
}
