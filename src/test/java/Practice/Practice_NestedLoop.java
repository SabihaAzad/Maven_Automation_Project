package Practice;

import java.util.ArrayList;

public class Practice_NestedLoop {

    public static void main(String[] args) {

        ArrayList<String> destination = new ArrayList<>();
        destination.add("New york");
        destination.add("New Jersey");
        destination.add("Florida");

        ArrayList<Integer> adult = new ArrayList<>();
        adult.add(2);
        adult.add(3);
        adult.add(4);

        for (int i = 0; i < destination.size(); i++) {
            System.out.println("The i value is: " + i);

            for (int j = 1; j < adult.get(i); j++) {
                System.out.println("j value is: " + j + " and adult.get value is: " + adult.get(i));
            }// end of nested loop

            System.out.println("*********************");
        }//end of main loop
   /*
        j=1; 1<4
        j=2; 2<4
        j=3; 3<4
        j=4; 4<4
        j=5; 5<4
        j=6; 6<4
*/

    }
}
