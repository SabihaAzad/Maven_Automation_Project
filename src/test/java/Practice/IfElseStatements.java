package Practice;

public class IfElseStatements {
    public static void main(String[] args) {

        int red, blue, orange;

        red = 1;
        blue = 2;
        orange = 3;

        if (red + blue < orange) {
            System.out.println("red+blue is greater than orange");

        } else if (blue + orange < red) {
            System.out.println("blue+orange is less than red");

        } else {
            System.out.println("red is less than blue+orange");

        }//end of conditions
    }//end of main
}//end of java class
