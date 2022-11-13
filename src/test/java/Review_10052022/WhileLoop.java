package Review_10052022;

public class WhileLoop {
    public static void main(String[] args) {
        //linear array of car brands (5)

        String [] carBrands;
        carBrands = new String[]{"Toyota","Lexus","Honda","Hyundai","Ford"};

        int i = 0;

        while(i < carBrands.length){

            System.out.println(carBrands[i]);

            //i++ is the same as i+1
            i++;

        }//end of while loop

    }//end of main
}//end of java class