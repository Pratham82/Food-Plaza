package com.dao;


import com.pojo.Food;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FoodDaoImpl implements FoodDao{
    Food FoodObj = new Food();
    List<Food> FoodList = new ArrayList<Food>();

    @Override
    public boolean AddFood(Food f) {
        //Object which is created from test class with the constructor will be stored in FoodList.
        FoodList.add(f);
        return true;
    }

    @Override
    public boolean UpdateFood(Food FLocal) {
        FoodObj = SearchFoodByID(FLocal.getFooID());
        int count = 0;
        Iterator<Food> FoodItrU = FoodList.iterator();
        if(FoodObj!=null){
            while(FoodItrU.hasNext()){
                Food IDEnteredU = FoodItrU.next();
                if(FLocal.getFooID()==IDEnteredU.getFooID()){
                    break;
                }
                count++;
            }
            FoodList.set(count,FLocal);
            return true;
        }
        return false;
    }

    @Override
    public boolean DeleteFood(int FoodID) {
        FoodObj= SearchFoodByID(FoodID);
        Iterator<Food> FoodItr = FoodList.iterator();
        if(FoodObj!= null){
            while(FoodItr.hasNext()){
                Food IDEntered1 = FoodItr.next();

                if(IDEntered1.getFooID()==FoodID){
                    FoodItr.remove();
                }
            }//While loop ended
            return true;
        }//If loop ended
        return false;
    }

    @Override
    public List<Food> ShowAllFood() {
        return FoodList;
    }

    @Override
    public Food SearchFoodByID(int FoodID) {

        for (Food IDEntered : FoodList) {
            if (IDEntered.getFooID() == FoodID) {
                return IDEntered;
            }
            else{
                System.out.println("Food name not found");
            }
        }
        return null;
    }

    @Override
    public List<Food> SearchFoodByName(String FoodName) {
        Iterator<Food> FoodListItr = FoodList.iterator();
        List<Food> FoodListNew = new ArrayList<Food>();

        while(FoodListItr.hasNext()){
            Food NameEntered = FoodListItr.next();
            if(NameEntered.getFoodName().equalsIgnoreCase(FoodName)){
                FoodListNew.add(NameEntered);
            }/*else{
                System.out.println("Food name not found in list");
            }*/
        }
        return FoodListNew;
    }

}

/*      Using for each loop
/*      Using for each loop
        for (Food NameEntered : FoodList) {
                if (NameEntered.getFoodName().equalsIgnoreCase(FoodName)) {
                    FoodListNew.add(NameEntered);
                }
                System.out.println();
            }*/


//Search food BY ID
/*Iterator<Food> FoodListID = FoodList.iterator();
        while(FoodListID.hasNext()){
            Food IDEntered = FoodListID.next();
            if(IDEntered.getFooID()==FoodID){
                return IDEntered;
            }
        }*/