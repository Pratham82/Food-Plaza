package com.pojo;

public class Food {
    private int FoodID;
    private String FoodName;
    private String FoodCategory;
    private double FoodPrice;

    public Food(){
        super();
    }

    public Food(int FoodID, String FoodName, String FoodCategory, double FoodPrice){
        this.FoodID = FoodID;
        this.FoodName = FoodName;
        this.FoodCategory = FoodCategory;
        this.FoodPrice =FoodPrice;
    }

    public int getFooID(){
        return FoodID;
    }
    public String getFoodName(){
        return FoodName;

    }public String getFoodCategory(){
        return FoodCategory;
    }
    public double getFoodPrice(){
        return FoodPrice;
    }

    public void setFoodID(int FoodID){
        this.FoodID= FoodID;
    }
    public void setFoodName(String FoodName){
        this.FoodName= FoodName;
    }
    public void setFoodCategory(String FoodCategory){
        this.FoodCategory= FoodCategory;
    }
    public void setFoodID(double FoodPrice){
        this.FoodPrice= FoodPrice;
    }

    public String toString(){
        return "Food Details: \nFood ID: "+FoodID+", Food Name: "+FoodName+", Food Category: "+FoodCategory+", Food Price: "+FoodPrice;
    }

}
