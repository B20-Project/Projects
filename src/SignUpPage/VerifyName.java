package SignUpPage;

import java.util.Arrays;
import java.util.Scanner;

public class VerifyName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstName; String again="";
        int digitCount=0,specialCount=0,spaceCount=0;

        do {
            System.out.println("enter your name "+again+"please");
            firstName = scan.nextLine().split("");

            if (!firstName[0].isEmpty()) {
                digitCount = (int) Arrays.stream(firstName).filter(each -> Character.isDigit(each.charAt(0))).count();
                specialCount = (int) Arrays.stream(firstName).filter(each -> !Character.isLetterOrDigit(each.charAt(0))).count();
                spaceCount = (int) Arrays.stream(firstName).filter(String::isBlank).count();

                if (firstName.length<2||firstName.length>16) System.out.println("name cannot be less than 2, more than 16 characters");
                if (digitCount!=0) System.out.println("name cannot contain numbers");
                if (specialCount!=0) System.out.println("name cannot contain special characters");
                if (spaceCount!=0) System.out.println("name cannot contain space");
            }else System.out.println("name cannot be empty");
            again="again ";

        }while(digitCount!=0||specialCount!=0||spaceCount!=0||firstName[0].isEmpty()||firstName.length<2||firstName.length>16);
    }
}
