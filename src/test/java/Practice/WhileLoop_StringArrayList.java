package Practice;

import java.util.ArrayList;

public class WhileLoop_StringArrayList {

    public static void main(String[] args) {

        ArrayList<String> catNames = new ArrayList<String>();

catNames.add("1");
catNames.add("2");
catNames.add("3");

int i=0;
while(i < catNames.size()){
    System.out.println("My cats names are " + catNames.get(i));
                i++;

        }//end of while loop

    }//end of main
}//end of java class
