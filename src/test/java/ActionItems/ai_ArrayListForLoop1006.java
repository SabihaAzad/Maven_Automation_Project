package ActionItems;

import java.util.ArrayList;

public class ai_ArrayListForLoop1006 {
    public static void main(String[] args) {

        ArrayList<String> Country = new ArrayList<>();

         Country.add("USA");
         Country.add("China");
         Country.add("Russia");
         Country.add("Mexico");
         Country.add("Greece");

        ArrayList<Integer> countryCode = new ArrayList<>();

        countryCode.add(1);
        countryCode.add(86);
        countryCode.add(7);
        countryCode.add(52);
        countryCode.add(30);

        for(int i=0; i < countryCode.size(); i++)

            System.out.println("The country code for " + Country.get(i) + " is " + countryCode.get(i));

    }//end of for loop
}//end of main



