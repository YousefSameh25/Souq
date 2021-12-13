/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static java.lang.System.out;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;
import project.otlob.*;

/**
 *
 * @author A.S.A
 */
public class project_main {
    
    public static Scanner input = new Scanner(System.in);
    public static String name, password, type, restaurant, phone, address;
    //check (Owner/Customer) id
    public static int id_w = -1, id_c = -1;
    //creat (static)obj from each class to use it direct in (main/super/sub) classes
    public static Owner    w;
    public static Customer c;
    public static Meal  m;
    public static Order o;
    public static Restaurant r;
    public static List<Owner>    owner    = new ArrayList<>();
    public static List<Customer> customer = new ArrayList<>();
    public static LocalDateTime myDate;
    public static DateTimeFormatter myFormat;
//    myDateObj = LocalDateTime.now();
//    myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy\nHH:mm:ss");
    /*-----------------------------------------------------------------------*/
    /*MainRegister(): Registration for (owners / Customers)*/
    public static void MainRegister() {
        out.println("Please Enter Your Type( 1- owner / 2- customer ): ");
        type = input.next();
        out.println("Please Enter Your Name: ");
        name = input.next();
        out.println("Please Enter Your Password: ");
        password = input.next();
        if (null == type) {
            out.println("Please enter the type correctly.");
        } else {
            switch (type) {
                case "1":
                    out.println("Please Enter Name Of Restaurant: ");
                    restaurant = input.next();
                    out.println("Please Enter Location Of Restaurant: ");
                    address = input.next();
                    r = new Restaurant(restaurant, address);
                    w = new Owner(r, name, password);
                    w.Register();
                    break;

                case "2":
                    out.println("Please Enter Your Mobile Number: ");
                    phone = input.next();
                    out.println("Please Enter Your Address: ");
                    address = input.next();
                    c = new Customer(phone, address, name, password);
                    c.Register();
                    break;
                default:
                    out.println("Please enter the type correctly.");
                    break;
            }
        }
    }

    /*----------------------------------------------------------------------*/
    /*MainLogin(): checking about (owners / Customers) and return(true) if they exist in lists.*/
    public static boolean MainLogin() {
        out.println("Please Enter Your Type( 1- owner / 2- customer ): ");
        type = input.next();
        out.println("Please Enter Your Name: ");
        name = input.next();
        out.println("Please Enter Your Password: ");
        password = input.next();
        if (null == type) {
            out.println("Please enter the type correctly.");
            return false;
        } else {
            switch (type) {
                case "1":
                    w = new Owner(name, password);
                    id_w = w.Login();
                    if (id_w == -1) {
                        return false;
                    }
                    return true;
                case "2":
                    c = new Customer(name, password);
                    id_c = c.Login();
                    if (id_c == -1) {
                        return false;
                    }
                    return true;
                default:
                    out.println("Please enter the type correctly.");
                    return false;
            }
        }
    }

    /*----------------------------------------------------------------------*/
    //owner
    /*AddMeal(): Add new meal to restaurant's owner.*/
    public static void AddMeal() {
        String Name, Describtion;
        double Price;
        out.println("Please Enter The Name Of Meal: ");
        Name = input.next();
        out.println("Please Enter The Price Of Meal: ");
        Price = input.nextDouble();
        out.println("Please Enter The Describtion Of Meal: ");
        //Data_Bus
        input = new Scanner(System.in);
        Describtion = input.nextLine();
        m = new Meal(Name, Price, Describtion);
        owner.get(id_w).Edit_Add(m);
    }

    /*----------------------------------------------------------------------*/
    //owner
    /*EditMeal(): Replace a new meal with another meal in the restaurant's list.*/
    public static void EditMeal() {
        String Name, Describtion;
        double Price;
        int num;
        out.println("Please Enter The Number Of Meal Of The Following: ");
        int i = 1;
        for (Meal meal : owner.get(id_w).getResturant().getMeals()) {
            out.println("("+i+") "+meal.getName());
            i++;
        }
        num = input.nextInt();
        out.println("Please Enter The Name Of Meal: ");
        Name = input.next();
        out.println("Please Enter The Price Of Meal: ");
        Price = input.nextDouble();
        out.println("Please Enter The Describtion Of Meal: ");
        //Data Bus
        input = new Scanner(System.in);
        Describtion = input.nextLine();
        m = new Meal(Name, Price, Describtion);
        owner.get(id_w).Edit_Set(m, (num-1));
    }

    /*----------------------------------------------------------------------*/
    //owner
    /*RemoveMeal(): Remove a meal from the restaurant's list.*/
    public static void RemoveMeal() {
        int num;
        out.println("Please Enter The Number Of Meal Of The Following: ");
        int i = 1;
        for (Meal meal : owner.get(id_w).getResturant().getMeals()) {
            out.println("("+i+") "+meal.getName());
            i++;
        }
        num = input.nextInt();
        owner.get(id_w).Edit_remove((num-1));
    }

    /*----------------------------------------------------------------------*/
    //owner
    /*ViewMeals(): Print the restaurant list of meals*/
    public static void ViewMeals() {
        owner.get(id_w).ListOfMeal();
    }

    /*----------------------------------------------------------------------*/
    //owner
    /*RestaurantOrders(): Print all restaurant's orders.*/
    public static void RestaurantOrders() {
        owner.get(id_w).Restaurant_Orders();
    }

    /*----------------------------------------------------------------------*/
    //customer
    /*Recharging(): Charging My_Card to buy anything from the application.*/
    public static void Recharging(){
        System.out.println("Enter the amount of money which want to deposit it.");
        double amount = input.nextInt();
        customer.get(id_c).setMrCard(amount);
    }
    /*----------------------------------------------------------------------*/
    //customer
    /*Menu(): Print the Menu of restaurants*/
    public static void Menu(){
        customer.get(id_c).View_Menu();
    }
    /*----------------------------------------------------------------------*/
    //customer
    /*MakeOrder(): To make orders from any restaurant.*/
    public static void MakeOrder(){
        out.println("Please choose the restaurant you want to buy from it.");
        customer.get(id_c).View_Restaurant();
        int id = input.nextInt();
        while(true){
        out.println("Please choice the meal you want to buy it.");
        customer.get(id_c).View_Meals((id-1));
        int ch = input.nextInt();
        //meal
        m = owner.get(id-1).getResturant().getMeals().get(ch-1);
        out.println("Please enter the quantity you want to buy it.");
        int quan = input.nextInt();
        double mrcard = quan * ( owner.get(id-1).getResturant().getMeals().get(ch-1).getPrice() ) * -1 ;
        customer.get(id_c).setMrCard(mrcard);
        myDate = LocalDateTime.now();
        myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDate.format(myFormat);
        //order
        o = new Order(id_c, m, quan, mrcard, formattedDate);
        customer.get(id_c).Add_Orders(id-1, o);
        out.println("Do you want to buy any thing else from this restaurant ?(Y/N)");
            String tx = input.next();
            if ("N".equals(tx) || "n".equals(tx)) {
                break;
            }
        }
    }
    /*----------------------------------------------------------------------*/
    //customer
    /*EditOrder(): make an order instead of another order from the same restaurant*/
    public static void EditOrder(){
        while(true){
        //validations
        out.println("Please choose the restaurant you want to edit the order from it.");
        customer.get(id_c).View_Restaurant();
        int id = input.nextInt();
        out.println("Please choose the order you want to edit it.");
        if(customer.get(id_c).View_Orders(id-1)){
            int ord = input.nextInt();
            double mrcard = owner.get(id-1).getResturant().getOrder().get(ord-1).getOrder_P();
            customer.get(id_c).setMrCard(mrcard);
            
            //make order instead of another order 
            out.println("Please choice the meal you want to buy it.");
            customer.get(id_c).View_Meals((id-1));
            int ch = input.nextInt();
            m = owner.get(id-1).getResturant().getMeals().get(ch-1);
            out.println("Please enter the quantity you want to buy it.");
            int quan = input.nextInt();
            mrcard = quan * ( owner.get(id-1).getResturant().getMeals().get(ch-1).getPrice() ) * -1 ;
            customer.get(id_c).setMrCard(mrcard);
            myDate = LocalDateTime.now();
            myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDate.format(myFormat);
            // order
            o = new Order(id_c, m, quan, mrcard, formattedDate);
            customer.get(id_c).Edit_Orders(id-1, ord-1, o);
        }
        else{
            System.out.println("oops, you don't make an order yet");
        }
        out.println("Do you want to buy any thing else from this restaurant ?(Y/N)");
            String tx = input.next();
            if ("N".equals(tx) || "n".equals(tx)) {
                break;
            }
        }   
    }
    /*----------------------------------------------------------------------*/
    //customer
    /*RemoveOrder(): Remove an order from the customer's orders list*/
    public static void RemoveOrder(){
        out.println("Please choose the restaurant you want to remove the order from it.");
        customer.get(id_c).View_Restaurant();
        int id = input.nextInt();
        out.println("Please choose the order you want to remove it.");
        if(customer.get(id_c).View_Orders(id-1)){
            int ord = input.nextInt();
            double mrcard = owner.get(id-1).getResturant().getOrder().get(ord-1).getOrder_P();
            customer.get(id_c).setMrCard(mrcard);
            customer.get(id_c).Remove_Orders(id-1, ord-1);
        }
        else{
            System.out.println("oops, you don't make an order yet");
        }
        
    }
    /*----------------------------------------------------------------------*/
    //customer
    /*PrintBill(): Print bill from a specific restaurant.*/
    public static void PrintBill(){
        out.println("Please choose the restaurant you want to print the bill from it.");
        customer.get(id_c).View_Restaurant();
        int id = input.nextInt();
        out.println("Please choose the order you want to print it.");
        if(customer.get(id_c).View_Orders(id-1)){
            int ord = input.nextInt();
            customer.get(id_c).Bill(id-1, ord-1);
        }
        else{
            System.out.println("oops, you don't make an order yet");
        }
    }
    /*----------------------------------------------------------------------*/
    //customer
    /*CustomerOrders(): Print all Customer's orders.*/
    public static void CustomerOrders(){
        customer.get(id_c).View_Orders_C();
    }
    /*----------------------------------------------------------------------*/
    public static void main(String[] args) {
        int choice;
        String ans;
        while (true) {
            out.println("....Welcome To Talabat Online....");
            out.println("Please choice (Register | Login | FillData):\n1-Register\t\t2-Login\t\t3-FillData");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    MainRegister();
                    break;
                case 2:
                    if (MainLogin()) {
                        switch (type) {
                            case "owner":
                                while (true) {
                                    out.println("1- Press(1) to add a meal.");
                                    out.println("2- Press(2) to edit a meal.");
                                    out.println("3- Press(3) to remove a meal.");
                                    out.println("4- Press(4) to view the list of meals.");
                                    out.println("5- Press(5) to view restaurant's orders.");
                                    choice = input.nextInt();
                                    switch (choice) {
                                        case 1:
                                            AddMeal();
                                            break;
                                        case 2:
                                            EditMeal();
                                            break;
                                        case 3:
                                            RemoveMeal();
                                            break;
                                        case 4:
                                            ViewMeals();
                                            break;
                                        case 5:
                                            RestaurantOrders();
                                            break;
                                    }
                                    out.println("Do you want to do any thing else ?(Y/N)");
                                    ans = input.next();
                                    if ("N".equals(ans) || "n".equals(ans)) {
                                        break;
                                    }
                                }
                                break;
                            case "customer":
                                while (true) { 
                                    out.println("1- Press(1) to Recharging the mrcard.");
                                    out.println("2- Press(2) to Make an order.");
                                    out.println("3- Press(3) to Edit an order.");
                                    out.println("4- Press(4) to Remove an order.");
                                    out.println("5- Press(5) to view the menu of the restaurants and meals.");
                                    out.println("6- Press(6) to view customer's orders.");
                                    out.println("7- Press(7) to print bill of order.");
                                    choice = input.nextInt();
                                  switch (choice) {
                                        case 1:
                                            Recharging();
                                            break;
                                        case 2:
                                            MakeOrder();
                                            break;
                                        case 3:
                                            EditOrder();
                                            break;
                                        case 4:
                                            RemoveOrder();
                                            break;
                                        case 5:
                                            Menu();  
                                            break;
                                        case 6:
                                            CustomerOrders();
                                            break;
                                        case 7:
                                            PrintBill();
                                            break;
                                    }
                                    out.println("Do you want to do any thing else ?(Y/N)");
                                    ans = input.next();
                                    if ("N".equals(ans) || "n".equals(ans)) {
                                        break;
                                    }
                                }   
                        break;
                        }
                    }
                    else{
                        out.println("Make sure the name and password is correct.");
                        break;
                    }
                    break;
                case 3:
                    new control.autoGenerationData().generate();
                    break;   
            }
            out.println("Do you want to exit the application ?(Y/N)");
            ans = input.next();
            if ("Y".equals(ans) || "y".equals(ans)) {
                break;
            }
        }

    }
    
}
