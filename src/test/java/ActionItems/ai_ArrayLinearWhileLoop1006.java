package ActionItems;

public class ai_ArrayLinearWhileLoop1006 {
    public static void main(String[] args) {

        String[] region = new String[]{"Asia","North America","Africa","South America","Europe"};

        int[] areaCode = new int[]{1,2,3,4,5};

        int i = 0;

        while(i < areaCode.length){

            System.out.println("The area code for the region " + region[i] + " is " + areaCode[i]);

            i = i+1;

        }//end of while loop

    }//end of main
}//end of java class