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
public class Owner extends Person {
    
    private Restaurant resturant ;
    
    public Owner(String UserName, String Password) {
        super(UserName, Password);
    }

    public Owner(Restaurant resturant, String UserName, String Password) {
        super(UserName, Password);
        this.resturant = resturant;
    }

    public Restaurant getResturant() {
        return resturant;
    }

    public void setResturant(Restaurant resturant) {
        this.resturant = resturant;
    }
    
    /*Register(): to add new owner to owners list.*/
    public void Register(){
        project_main.owner.add(this);
        out.println("Your Registeration Is Successfully");
    }
    
    /*Login(): search to check (user name / password) and return id.*/
    public int Login(){
        for(int i=0 ; i<project_main.owner.size() ; i++){
            if(project_main.owner.get(i).getUserName().equals(this.getUserName()) && project_main.owner.get(i).getPassword().equals(this.getPassword())){
                out.println("you are already registered");
                return i;
            }
        }
        out.println("There is an error, Please try again");
        return -1;
    }
    
    /*Edit_Add(Meal e): Add a new meal to the restaurant's list and print a new list after modifying.*/
    public void Edit_Add(Meal e){
        this.resturant.getMeals().add(e);
        out.println("The meal was successfully added.\nThe New List: ");
        for(int i=0 ; i<this.resturant.getMeals().size() ; i++){
         out.println("*---------------------------("+(i+1)+")---------------------------*");
         out.println("Name: "+this.resturant.getMeals().get(i).getName());
         out.println("price: "+this.resturant.getMeals().get(i).getPrice());
         out.println("Describtion: "+this.resturant.getMeals().get(i).getDescribtion());
         out.println("*---------------------------------------------------------*");
        }
    }
    
    /*Edit_Set(Meal e,int s): Replace a new meal with another meal in the restaurant's list and print a new list after modifying.*/
    public void Edit_Set(Meal e,int s){
        this.resturant.getMeals().set(s,e);
        out.println("The meal was successfully modified.\nThe New List: ");
        for(int i=0 ; i<this.resturant.getMeals().size() ; i++){
         out.println("*---------------------------("+(i+1)+")---------------------------*");
         out.println("Name: "+this.resturant.getMeals().get(i).getName());
         out.println("price: "+this.resturant.getMeals().get(i).getPrice());
         out.println("Describtion: "+this.resturant.getMeals().get(i).getDescribtion());
         out.println("*---------------------------------------------------------*");
        }
    }
    
    /*Edit_remove(int s): Remove a meal from the restaurant's list and print a new list after modifying.*/
    public void Edit_remove(int s){
        this.resturant.getMeals().remove(s);
        out.println("The meal was successfully deleted.\nThe New List: ");
        for(int i=0 ; i<this.resturant.getMeals().size() ; i++){
         out.println("*---------------------------("+(i+1)+")---------------------------*");
         out.println("Name: "+this.resturant.getMeals().get(i).getName());
         out.println("price: "+this.resturant.getMeals().get(i).getPrice());
         out.println("Describtion: "+this.resturant.getMeals().get(i).getDescribtion());
         out.println("*---------------------------------------------------------*");
        }
    }
    
    /*ListOfMeal(): Print the restaurant list of meals*/
    public void ListOfMeal(){
        for(int i=0 ; i<this.resturant.getMeals().size() ; i++){
         out.println("*---------------------------("+(i+1)+")---------------------------*");
         out.println("Name: "+this.resturant.getMeals().get(i).getName());
         out.println("price: "+this.resturant.getMeals().get(i).getPrice());
         out.println("Describtion: "+this.resturant.getMeals().get(i).getDescribtion());
         out.println("*---------------------------------------------------------*");
        }
    }
    
    /*Restaurant_Orders(): Print all restaurant's orders*/
    public void Restaurant_Orders(){
        int flag = 1;
        out.println("**-------------------------\\/\\/orders\\/\\/---------------------------**");
        for(int i=0 ; i < this.getResturant().getOrder().size() ; i++){
         id_c = this.getResturant().getOrder().get(i).getId_customer();
         out.println("*---------------------------("+(i+1)+")---------------------------*");
         out.println("Name: "+project_main.customer.get(id_c).getUserName());
         out.println("Meal: "+this.getResturant().getOrder().get(i).getMeal().getName());
         out.println("quantity: "+this.getResturant().getOrder().get(i).getQuantity());
         out.println("price: "+this.getResturant().getOrder().get(i).getOrder_P());
         out.println("Date: "+this.getResturant().getOrder().get(i).getDate());
         out.println("*---------------------------------------------------------*");
         flag = 0;
        }
        out.println("*---------------------------------------------------------*");
        if(!(flag==0)){
            System.out.println("Sorry, no one has purchased the restaurant yet"); 
        }
    }
}
