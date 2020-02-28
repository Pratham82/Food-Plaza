package com.test;

import com.dao.FoodDao;
import com.dao.FoodDaoImpl;
import com.pojo.Food;
import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodTest {
    public static void main(String[]args){
        Scanner scan= new Scanner(System.in);
        //Food Objects;
        int FoodID;
        String FoodName;
        String FoodCategory;
        double FoodPrice;

        int InitialChoice;
        char LastChoice;
        boolean flag;

        //Creating objects of classes and interfaces:
        Food FoodObj= null;
        FoodDao FoodDaoObj = new FoodDaoImpl();
        //Creating list of food:
        List<Food> FoodList = new ArrayList<Food>();

        do{
            System.out.println("*****Welcome to Food Plaza*****");
            System.out.println("1. Add Food");
            System.out.println("2. Update Food");
            System.out.println("3. Delete Food");
            System.out.println("4. Show All Food");
            System.out.println("5. Show Food by ID");
            System.out.println("6. Show Food by Name");

            System.out.print("Choose any option: ");
            InitialChoice = scan.nextInt();

            switch(InitialChoice){
                case 1:
                    System.out.println("*****Add Food*****");
                    System.out.print("Enter Food ID: ");
                    FoodID =scan.nextInt();
                    System.out.print("Enter Food Name: ");
                    FoodName = scan.next();
                    System.out.print("Enter Food Category: ");
                    FoodCategory =scan.next();
                    System.out.print("Enter Food Price: ");
                    FoodPrice = scan.nextDouble();
                    //The variables which has been taken from user is stored in FoodObj(Object of Food class) and the parameterized constructor.
                    FoodObj = new Food(FoodID,FoodName,FoodCategory,FoodPrice);
                    //flag os the boolean object which is used to call AddObj fn in FoodDaoImpl
                    flag=FoodDaoObj.AddFood(FoodObj);

                    //IF the output from the AddFood was true then we will get added successfully output
                    if(flag){
                        System.out.println("Food details added successfully");
                    }else{
                        System.out.println("Food details not added");
                    }
                    break;

                case 2:
                    System.out.println("*****Update Food*****");
                    System.out.print("Enter Food ID: ");
                    FoodID =scan.nextInt();
                    System.out.print("Enter Food Name: ");
                    FoodName = scan.next();
                    System.out.print("Enter Food Category: ");
                    FoodCategory =scan.next();
                    System.out.print("Enter Food Price: ");
                    FoodPrice = scan.nextDouble();
                    //The variables which has been taken from user is stored in FoodObj(Object of Food class) and the parameterized constructor.
                    FoodObj = new Food(FoodID,FoodName,FoodCategory,FoodPrice);
                    //flag os the boolean object which is used to call AddObj fn in FoodDaoImpl
                    flag=FoodDaoObj.UpdateFood(FoodObj);
                    if(flag){
                        System.out.println("Food details updated successfully");
                    }else{
                        System.out.println("Food details not updated");
                    }
                    break;

                case 3:
                    System.out.println("*****Delete Food*****");
                    System.out.print("Enter Food ID for deleting: ");
                    FoodID = scan.nextInt();
                    flag =FoodDaoObj.DeleteFood(FoodID);
                    //if(!FoodList.isEmpty()){
                        if(flag){
                            System.out.println("Food deleted successfully");
                        }else{
                            System.out.println("Food list is not deleted");
                        }
                    /*}else{
                        System.out.println("Food list is empty!!");
                    }*/
                    break;

                case 4:
                    System.out.println("*****Show All Food*****");
                    FoodList = FoodDaoObj.ShowAllFood();
                    for(Food f1:FoodList){
                        System.out.println(f1);
                    }
                    break;

                case 5:
                    System.out.println("*****Show Food by ID*****");
                    //Food ID will be invoked only when the Food object is not empty
                    if(FoodObj!=null){
                        System.out.print("Enter Food ID to search Food details: ");
                        FoodID = scan.nextInt();
                        //invocation of method
                        FoodObj= FoodDaoObj.SearchFoodByID(FoodID);
                        System.out.println(FoodObj);
                    }/*else if(FoodObj==null){
                        System.out.println("Food list is empty");
                    }*/else{
                        System.out.println("Food list is empty");
                    }
                    break;

                case 6:
                    System.out.println("*****Show Food by Name*****");
                    System.out.print("Enter Food Name to search Food details: ");
                    FoodName = scan.next();
                    FoodList =FoodDaoObj.SearchFoodByName(FoodName);
                    if(!FoodList.isEmpty()){
                        System.out.println("Food name found");
                        for(Food f2: FoodList){
                            System.out.println(f2);
                        }
                    }else{
                        System.out.println("Food list is empty");
                    }
                    break;

                default:
                    System.out.println("Enter correct choice !!");
            }

            System.out.print("If you want to continue enter y or Y: ");
            LastChoice= scan.next().charAt(0);
        }while(LastChoice=='y'||LastChoice=='Y');

    }
}
