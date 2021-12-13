/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.otlob;

import control.project_main;
import static control.project_main.id_c;
import static java.lang.System.out;
/**
 *
 * @author A.S.A
 */
public class Customer extends Person {
    private double MrCard = 1000.0;
    private String MobileNumber;
    private String Address;

    public Customer( String UserName, String Password) {
        super(UserName, Password);
    }
    
    public Customer(String MobileNumber, String Address, String UserName, String Password) {
        super(UserName, Password);
        this.MobileNumber = MobileNumber;
        this.Address = Address;
    }
    
    
    
    public void setMobileNumber(String MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public String getAddress() {
        return Address;
    }
    
    public double getMrCard() {
        return MrCard;
    }

    public void setMrCard(double MrCard) {
        this.MrCard += MrCard;
    }
    
    
    /*Register(): to add new customer to customers list.*/
    public void Register(){
        project_main.customer.add(this);
        out.println("Your Registeration Is Successfully");
    }
    
    /*Login(): search to check (user name / password) and return id.*/
    public int Login(){
        
        for(int i=0 ; i<project_main.customer.size() ; i++){
            if(project_main.customer.get(i).getUserName().equals(this.getUserName()) && project_main.customer.get(i).getPassword().equals(this.getPassword())){
               out.println("you are already registered");
               return i;
            }
        }
        out.println("There is an error, Please try again");
        return -1;
    }
    
    /*View_Restaurant(): Print all restaurants which in application.*/
    public void View_Restaurant(){
        out.println("**---------------------------Restaurants---------------------------**");
        for(int i=0 ; i<project_main.owner.size() ; i++){
         out.println("("+(i+1)+") "+project_main.owner.get(i).getResturant().getRestaurantName());
        }
    }
    
    /*View_Meals(int id): Print the meals of a specific restaurant.*/
    public void View_Meals(int id){
        out.println("**-------------------------\\/\\/Meals\\/\\/---------------------------**");
        for(int i=0 ; i<project_main.owner.get(id).getResturant().getMeals().size() ; i++){
         out.println("*---------------------------("+(i+1)+")---------------------------*");
         out.println("Name: "+project_main.owner.get(id).getResturant().getMeals().get(i).getName());
         out.println("price: "+project_main.owner.get(id).getResturant().getMeals().get(i).getPrice());
         out.println("Describtion: "+project_main.owner.get(id).getResturant().getMeals().get(i).getDescribtion());
         out.println("*---------------------------------------------------------*");
        }
    }
    
    /*View_Menu(): Print the restaurants and their meals.*/
    public void View_Menu(){
        for(int i=0 ; i<project_main.owner.size() ; i++){
         
        out.println("**---------------------------("+project_main.owner.get(i).getResturant().getRestaurantName()+")---------------------------**");
         
         for(int j=0 ; j<project_main.owner.get(i).getResturant().getMeals().size() ; j++){
         
         out.println("*---------------------------("+(j+1)+")---------------------------*");
         out.println("Name: "+project_main.owner.get(i).getResturant().getMeals().get(j).getName());
         out.println("price: "+project_main.owner.get(i).getResturant().getMeals().get(j).getPrice());
         out.println("Describtion: "+project_main.owner.get(i).getResturant().getMeals().get(j).getDescribtion());
         out.println("*---------------------------------------------------------*");
        
         }
        
        } 
    }
    
    /*View_Orders(int id): check if a customer ordered any meals and (print all orders) and return(true) if there exist orders.*/
    public boolean View_Orders(int id){
        int flag = 1;
        out.println("**-------------------------\\/\\/orders\\/\\/---------------------------**");
        for(int i=0 ; i<project_main.owner.get(id).getResturant().getOrder().size() ; i++){
         if(project_main.owner.get(id).getResturant().getOrder().get(i).getId_customer()==id_c){
         out.println("*---------------------------("+(i+1)+")---------------------------*");
         out.println("Meal: "+project_main.owner.get(id).getResturant().getOrder().get(i).getMeal().getName());
         out.println("quantity: "+project_main.owner.get(id).getResturant().getOrder().get(i).getQuantity());
         out.println("price: "+project_main.owner.get(id).getResturant().getOrder().get(i).getOrder_P());
         out.println("Date: "+project_main.owner.get(id).getResturant().getOrder().get(i).getDate());
         out.println("*---------------------------------------------------------*");
         flag = 0;
         }
        }
        out.println("*---------------------------------------------------------*");
        if(!(flag==0)){
            return false;
        }
        else{
            return true;
        }
    }
    
    /*Add_Orders(int id, Order m): Add order to restaurant's orders.*/
    public void Add_Orders(int id, Order m){
        project_main.owner.get(id).getResturant().getOrder().add(m);
    }
    
    /*Edit_Orders(int id, int i, Order m): Edit order in restaurant's orders.*/
    public void Edit_Orders(int id, int i, Order m){
        project_main.owner.get(id).getResturant().getOrder().set(i, m);
    }
    
    /*Remove_Orders(int id , int i): Remove order from the restaurant's orders*/
    public void Remove_Orders(int id , int i){
        project_main.owner.get(id).getResturant().getOrder().remove(i);
    }
    
    /*Bill(int id , int i): Print bill of meal from a specific restaurant*/
    public void Bill(int id , int i){
         out.println("*---------------------------(Bill Of Meal)---------------------------*");
         out.println("Restaurant Name : "+project_main.owner.get(id).getResturant().getRestaurantName());
         out.println("Meal: "+project_main.owner.get(id).getResturant().getOrder().get(i).getMeal().getName());
         out.println("quantity: "+project_main.owner.get(id).getResturant().getOrder().get(i).getQuantity());
         out.println("price: "+project_main.owner.get(id).getResturant().getOrder().get(i).getOrder_P());
         out.println("Date: "+project_main.owner.get(id).getResturant().getOrder().get(i).getDate());
         out.println("*---------------------------------------------------------*");
    }
    
    /*View_Orders_C(): Print all orders which Customer ordered.*/
    public void View_Orders_C(){
        int flag = 1;
        out.println("**-------------------------\\/\\/orders\\/\\/---------------------------**");
        for(int i=0 ; i < project_main.owner.size() ; i++){
            for(int j=0 , k=1 ; j < project_main.owner.get(i).getResturant().getOrder().size() ; j++){
             if(project_main.owner.get(i).getResturant().getOrder().get(j).getId_customer()==id_c){
             out.println("*---------------------------("+(k++)+")---------------------------*");
             out.println("Restaurant Name : "+project_main.owner.get(i).getResturant().getRestaurantName());
             out.println("Meal: "+project_main.owner.get(i).getResturant().getOrder().get(j).getMeal().getName());
             out.println("quantity: "+project_main.owner.get(i).getResturant().getOrder().get(j).getQuantity());
             out.println("price: "+project_main.owner.get(i).getResturant().getOrder().get(j).getOrder_P());
             out.println("Date: "+project_main.owner.get(i).getResturant().getOrder().get(j).getDate());
             out.println("*---------------------------------------------------------*");
             flag = 0;
            }
          }
        }
        out.println("*---------------------------------------------------------*");
        if(!(flag==0)){
            System.out.println("oops, you don't make an order yet"); 
        }
    }
}
