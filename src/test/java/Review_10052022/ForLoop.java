package Review_10052022;

import java.util.ArrayList;

public class ForLoop {
    public static void main(String[] args) {

        ArrayList<String> phoneNumbers = new ArrayList<>();

        //now add the values for countries array
        phoneNumbers.add("7187187811");
        phoneNumbers.add("111111112");
        phoneNumbers.add("2222222345");
        phoneNumbers.add("5556667777");
        phoneNumbers.add("9993334444");

        for(int i=0; i < phoneNumbers.size(); i++) {

            //print out each zip code automatically
            System.out.println(phoneNumbers.get(i));

        }//end of for loop
    }//end of main

}//end of java class

