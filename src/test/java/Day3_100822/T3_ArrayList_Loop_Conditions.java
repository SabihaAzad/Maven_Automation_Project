package Day3_100822;

import java.util.ArrayList;

public class T3_ArrayList_Loop_Conditions {
    public static void main(String[] args) {

        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("India");
        countries.add("Australia");

        //using for loop to iterate through countries list and print out only when the country is USA or Australia
        for (int i = 0; i < countries.size(); i++){
            //two equal signs will compare the values from right and left size
            //whereas one equal is used to set a value for a variable

            /*
            if (countries.get(i) == "USA"){

                System.out.println("Country is USA and index i is " + i);
            } else if (countries.get(i) == "Australia") {
                System.out.println("Country is Australia and index i is " + i);
            }
             */
//to comment/uncomment a block of code: command + shift + / for mac

            //using or (||) operator you can write both/multiple conditions in one if statement
            if(countries.get(i) == "USA" || countries.get(i) == "Australia"){
                System.out.println("Country is " + countries.get(i) + " And index is " + i);
            }
            }//end of loop
        }//end of main
    }//end of java class

