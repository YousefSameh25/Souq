/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import project.otlob.Customer;
import project.otlob.Meal;
import project.otlob.Owner;
import project.otlob.Restaurant;

/**
 *
 * @author A.S.A
 */
public class autoGenerationData {

    Meal m;
    Restaurant r;
    Owner o;
    List<Meal> mList = new ArrayList<>();

    Customer c;

    public void generate() {
        ///////////////
        // Owners

        mList = new ArrayList<>();
        m = new Meal("A1", 100 , " A + W + E + R + normal");
        mList.add(m);
        m = new Meal("A2", 200 , " A + W + E + R + spicy");
        mList.add(m);
        m = new Meal("A3", 250 , " A + W + E + R + spicy");
        mList.add(m);
        m = new Meal("A4", 300 , " A + W + E + R + normal");
        mList.add(m);
        r = new Restaurant("A","cairo", mList);
        o = new Owner(r,"ahmed","123");
        project_main.owner.add(o);

        mList = new ArrayList<>();
        m = new Meal("B1", 110 , " A + W + E + R + normal");
        mList.add(m);
        m = new Meal("B2", 240 , " A + W + E + R + spicy");
        mList.add(m);
        m = new Meal("B3", 260 , " A + W + E + R + spicy");
        mList.add(m);
        m = new Meal("B4", 395 , " A + W + E + R + normal");
        mList.add(m);
        r = new Restaurant("B","giza", mList);
        o = new Owner(r,"ali","321");
        project_main.owner.add(o);
        
        mList = new ArrayList<>();
        m = new Meal("C1", 140 , " A + W + E + R + normal");
        mList.add(m);
        m = new Meal("C2", 260 , " A + W + E + R + spicy");
        mList.add(m);
        m = new Meal("C3", 280 , " A + W + E + R + spicy");
        mList.add(m);
        m = new Meal("C4", 400 , " A + W + E + R + normal");
        mList.add(m);
        r = new Restaurant("C","sharkia", mList);
        o = new Owner(r,"samy","132");
        project_main.owner.add(o);
        
        mList = new ArrayList<>();
        m = new Meal("D1", 110 , " A + W + E + R + normal");
        mList.add(m);
        m = new Meal("D2", 240 , " A + W + E + R + spicy");
        mList.add(m);
        m = new Meal("D3", 260 , " A + W + E + R + spicy");
        mList.add(m);
        m = new Meal("D4", 395 , " A + W + E + R + normal");
        mList.add(m);
        r = new Restaurant("D","sharm elshekh", mList);
        o = new Owner(r,"mona","213");
        project_main.owner.add(o);
        
        mList = new ArrayList<>();
        m = new Meal("E1", 115 , " A + W + E + R + normal");
        mList.add(m);
        m = new Meal("E2", 243 , " A + W + E + R + spicy");
        mList.add(m);
        m = new Meal("E3", 277 , " A + W + E + R + spicy");
        mList.add(m);
        m = new Meal("E4", 335 , " A + W + E + R + normal");
        mList.add(m);
        r = new Restaurant("E","suiz", mList);
        o = new Owner(r,"karem","312");
        project_main.owner.add(o);

        /*----------------------------------------------------------------------------*/

        //Customers
        c = new Customer("011","5 H","soad","111");
        project_main.customer.add(c);

        c = new Customer("012","5 T","ramzy","222");
        project_main.customer.add(c);
        
        c = new Customer("010","5 W","salah","333");
        project_main.customer.add(c);

        c = new Customer("012","5 T","fady","444");
        project_main.customer.add(c);
        
    }
}
