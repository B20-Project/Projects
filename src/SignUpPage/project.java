package SignUpPage;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        //FIRST NAME
        Scanner scan = new Scanner(System.in);
        String again="";
        String firstName;
        char firstNameLetter;
        String lastName;
        char lastNameLetter;
        int i = 0;
        int charCount = 0;
        int numCount = 0;
        int spaceCount = 0;
        do {
            System.out.println("Enter your first name "+again);
            char firstNameChar;
            String print = "";
            charCount = 0;
            numCount = 0;
            spaceCount = 0;
            firstName = scan.nextLine();
            int firstNameLength = firstName.length();
            for (i = 0; i < firstNameLength; i++) {
                firstNameChar = firstName.charAt(i);
                boolean CharNotValid = (firstNameChar >= 33 && firstNameChar <= 47) ||
                        (firstNameChar >= 58 && firstNameChar <= 64)
                        || (firstNameChar >= 91 && firstNameChar <= 96)
                        || (firstNameChar >= 123 && firstNameChar <= 126);
                boolean numNotValid = firstNameChar >= 48 && firstNameChar <= 57;
                if (CharNotValid) {
                    charCount++;
                }
                if (numNotValid) {
                    numCount++;
                }
                if (firstNameChar == ' ') {
                    spaceCount++;
                }
            }
            if (charCount > 0) {
                System.err.println("Must not have special characters");
            }
            if (numCount > 0) {
                System.err.println("Must not have numbers");
            }
            if (spaceCount > 0) {
                System.err.println("Must not have space");
            }
            if (firstName.length() < 2) {
                System.err.println("Must be at least 2 characters ");
            }
            if (firstName.length() > 16) {
                System.err.println("Must be last than 16 characters");
            }
            if (firstName.length() == 0) {
                System.err.println("Must not be empty");
            }
            again="again: ";
        } while (charCount > 0 || numCount > 0 || spaceCount > 0 || firstName.length() < 2 || firstName.length() > 16);
        firstNameLetter = firstName.charAt(0);
        if (firstNameLetter >= 97 && firstNameLetter <= 122) {
            firstNameLetter = firstName.toUpperCase().charAt(0);
            firstName = firstNameLetter + firstName.substring(1);
        }
        //Last NAME
        do {
            again="";
            System.out.println("Enter your last name"+again);
            char lastNameChar;
            String print = "";
            charCount = 0;
            numCount = 0;
            spaceCount = 0;
            lastName = scan.nextLine();
            int lastNameLength = lastName.length();
            for (i = 0; i < lastNameLength; i++) {
                lastNameChar = lastName.charAt(i);
                boolean CharNotValid = (lastNameChar >= 33 && lastNameChar <= 47) ||
                        (lastNameChar >= 58 && lastNameChar <= 64)
                        || (lastNameChar >= 91 && lastNameChar <= 96)
                        || (lastNameChar >= 123 && lastNameChar <= 126);
                boolean numNotValid = lastNameChar >= 48 && lastNameChar <= 57;
                if (CharNotValid) {
                    charCount++;
                }
                if (numNotValid) {
                    numCount++;
                }
                if (lastNameChar == ' ') {
                    spaceCount++;
                }
            }
            if (charCount > 0) {
                System.err.println("Must not have special characters");
            }
            if (numCount > 0) {
                System.err.println("Must not have numbers");
            }

            if (spaceCount > 0) {
                System.err.println("Must not have space");
            }
            if (lastName.length() < 2) {
                System.err.println("you must have at least 2 characters");
            }
            if (lastName.length() > 16) {
                System.err.println("you must have at least 16 characters");
            }
            if (lastName.length() == 0) {
                System.err.println("Must not be empty");
            }
            if (lastName.equalsIgnoreCase(firstName)) {
                System.err.println("Your last name is same as your first name");
            }
            again=" again";
        } while (charCount > 0 || numCount > 0 || spaceCount > 0 ||
                lastName.length() < 2 || lastName.length() > 16 ||
                lastName.equalsIgnoreCase(firstName));
        lastNameLetter = lastName.charAt(0);
        if (lastNameLetter >= 97 && lastNameLetter <= 122) {
            lastNameLetter = lastName.toUpperCase().charAt(0);
            lastName = lastNameLetter + lastName.substring(1);
        }
        //USER NAME
        String userName;
        char userNameLetter;
        int letterCount = 0;
        again="";
        do {
            System.out.println("Enter your user name"+again);
            char usernameChar;
            String print = "";
            charCount = 0;
            numCount = 0;
            spaceCount = 0;
            letterCount = 0;
            userName = scan.nextLine();
            int userNameLength = userName.length();
            for (i = 0; i < userNameLength; i++) {
                usernameChar = userName.charAt(i);
                boolean letter = (usernameChar >= 65 && usernameChar <= 90) || (usernameChar >= 97 && usernameChar <= 122);
                boolean specialChar = (usernameChar >= 33 && usernameChar <= 47) || (usernameChar >= 58 && usernameChar <= 64)
                        || (usernameChar >= 91 && usernameChar <= 96)
                        || (usernameChar >= 123 && usernameChar <= 126);
                boolean num = usernameChar >= 48 && usernameChar <= 57;
                if (letter) {
                    letterCount++;
                }
                if (specialChar) {
                    charCount++;
                }
                if (num) {
                    numCount++;
                }
                if (usernameChar == ' ') {
                    spaceCount++;
                }
            }
            if (letterCount < 1) {
                System.err.println("You have to have at least one letter.");
            }
            if (numCount < 1) {
                System.err.println("You have to have at least one number.");
            }
            if (charCount < 1) {
                System.err.println("You have to have at least one special character.");
            }
            if (spaceCount > 0) {
                System.err.println("You must not have space.");
            }
            if (userName.length() < 2) {
                System.err.println("You must have at least 2 characters.");
            }
            if (userName.length() > 16) {
                System.err.println("You must have at least 16 characters.");
            }
            if (userName.length() == 0) System.err.println("Must not be empty.");
            again=" again:";
        } while (letterCount < 1 || numCount < 1 || charCount < 1 || spaceCount > 0 || userName.length() < 2 || userName.length() > 16);
        //BirthDate
        System.out.println("Enter your birth day. Must be in \"MM/DD/YYYY\" format");
        charCount = 0;
        letterCount = 0;
        i=0;
        String birthDateFormat="";
        LocalDate time;
        int month;
        int day;
        int year;
        LocalDate birthDate;
        int age=0;
        int monthCount=0;
        int dayCount=0;
        int ageCount=0;
        do {
            numCount = 0;
            birthDateFormat = scan.nextLine();
            if(birthDateFormat.length()==10) {
                char firstM = birthDateFormat.charAt(0);
                char secondM = birthDateFormat.charAt(1);
                char firstSlash = birthDateFormat.charAt(2);
                char firstD = birthDateFormat.charAt(3);
                char secondD = birthDateFormat.charAt(4);
                char secondSlash = birthDateFormat.charAt(5);
                char firstY = birthDateFormat.charAt(6);
                char secondY = birthDateFormat.charAt(7);
                char thirdY = birthDateFormat.charAt(8);
                char forthY = birthDateFormat.charAt(9);
                int birthDayLength = birthDateFormat.length();
                age=0;
                monthCount=0;
                dayCount=0;
                ageCount=0;
                for (i = 0; i < birthDayLength; i++) {
                    boolean firstMCheck = firstM == '0' || firstM == '1';
                    boolean secondMCheck = secondM >= 48 && secondM <= 57;
                    boolean firstSlashCheck = firstSlash == '/';
                    boolean firstDCheck = firstD >= 48 && firstD <= 51;
                    boolean secondDCheck = secondD >= 48 && secondD <= 57;
                    boolean secondSlashCheck = secondSlash == '/';
                    boolean firstYCheck = firstY == '1' || firstY == '2';
                    boolean secondYCheck = secondY == '9' || secondY == '0';
                    boolean thirdYCheck = thirdY >= 48 && thirdY <= 57;
                    boolean forthYCheck = forthY >= 48 && thirdY <= 57;
                    if (i == 0 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9) {
                        if (!firstMCheck || !secondMCheck || !firstSlashCheck||!firstDCheck||!secondDCheck||!secondSlashCheck
                                ||!firstYCheck||!secondYCheck||!thirdYCheck||!forthYCheck) {
                            numCount++;
                        }
                    }
                }
                if(numCount>0){
                    System.err.println("Syntax Error. Enter you birth date again");
                }
                else{
                    time=LocalDate.now();
                    month=Integer.parseInt(birthDateFormat.substring(0,2));
                    day=Integer.parseInt(birthDateFormat.substring(3,5));
                    year=Integer.parseInt(birthDateFormat.substring(6,10));
                    if(month<=0||month>12){
                        monthCount++;
                    }
                    else if(day<=0||day>31||(year%4==0&&((month==4&&day>30)||(month==2&&day>29)||(month==6&&day>30)||
                            (month==9&&day>30)||(month==10&&day>30)))||
                            (year%4!=0&&((month==4&&day>30)||(month==2&&day>28)||(month==6&&day>30)||
                                    (month==9&&day>30)||(month==10&&day>30)))){
                        dayCount++;
                    }
                    else{

                        birthDate=LocalDate.of(year,month,day);
                        age= Period.between(birthDate,time).getYears();
                        if(age<10||age>100){
                            ageCount++;
                        }
                    }
                }
                if(monthCount>0){
                    System.err.println("invalid month.Enter you birth date again");
                }
                if(dayCount>0){
                    System.err.println("invalid day.Enter you birth date again");
                }
                if(ageCount>0){
                    System.err.println(age+" years old is not reasonable.Enter you birth date again ");
                }
            }
            else{
                System.err.println("Invalid format.Enter you birth date again");
            }
        }while (numCount>0||birthDateFormat.length()!=10||monthCount>0||ageCount>0||dayCount>0) ;
        //Password
        again="";
        String firstName1=firstName.toUpperCase();
        String lastName1=lastName.toUpperCase();
        String userName1=userName.toUpperCase();
        String password="";
        String password1;
        int capitalCount;
        int repeatCount;
        int increment;
        do{
            System.out.println("Enter password"+again);
            password=scan.nextLine();
            password1=password.toUpperCase();
            int lengthPassword=password.length();
            numCount=0;
            capitalCount=0;
            repeatCount=0;
            increment=0;
            for(i=0;i<lengthPassword;i++){
                char passwordLetter=password.charAt(i) ;
                boolean letter = (passwordLetter >= 65 && passwordLetter <= 90) || (passwordLetter >= 97 && passwordLetter <= 122);
                boolean number = passwordLetter >= 48 && passwordLetter <= 57;
                boolean specialChar = (passwordLetter >= 33 && passwordLetter <= 47) || (passwordLetter >= 58 && passwordLetter <= 64)
                        || (passwordLetter >= 91 && passwordLetter <= 96)
                        || (passwordLetter >= 123 && passwordLetter <= 126);
                boolean capital = passwordLetter >= 65 && passwordLetter <= 90;
                if (letter) {
                    letterCount++;
                }
                if (number) {
                    numCount++;
                }
                if (specialChar) {
                    charCount++;
                }

                if(capital){
                    capitalCount++;
                }
            }
            if(letterCount<1){
                System.err.println("You must have at least one letter");
            }
            if(numCount<1){
                System.err.println("You must have at least one number");
            }
            if(charCount<1){
                System.err.println("You must have at least one special character");
            }
            if(password.contains(" ")){
                System.err.println("You cannot have space");
            }
            if(capitalCount<1){
                System.err.println("You must have at least one capital letter");
            }
            if(password1.contains(firstName1)){
                System.err.println("Must not contain first name");
            }
            if(password1.contains(lastName1)){
                System.err.println("Must not contain last name");
            }
            if(password1.contains(userName1)){
                System.err.println("Must not contain user name");
            }
            if(password.contains(birthDateFormat)){
                System.err.println("Must not contain birth date");
            }
            if(password.length()<8){
                System.err.println("You must have at least 8 characters");
            }
            if(password.length()>16){
                System.err.println("Too long");
            }

            for ( i = 2; i < password.length(); i++) {
                char letter=password.charAt(i);
                if((int)letter==password.charAt(i-1)+1&&(int)letter==password.charAt(i-2)+2){
                    increment++;
                }

            }
            if(password.length()==0){
                System.err.println("Cannot be empty");
            }
            for( i=2;i<lengthPassword;i++){
                char letter=password.charAt(i);
                if(letter==password.charAt(i-1)&&letter==password.charAt(i-2)){
                    repeatCount++;
                }
            }
            if(repeatCount>0){
                System.err.println("You must not have repeating characters more than twice in a row");
            }
            if(increment>0){
                System.err.println("cannot have increment numbers");
            }
            again=" again";
        }while(letterCount<1||numCount<1||charCount<1||password.contains(" ")||capitalCount<1 ||password.length()>16||
                password1.contains(firstName1)||password1.contains(lastName1)|| password1.contains(userName1)||
                password.contains(birthDateFormat)||password.length()<8||repeatCount>0||increment>0);
        System.out.println("Congratulations! you have successfully registered.");
        System.out.println();
        System.out.println("First name: "+firstName);
        System.out.println("Last name: "+lastName);
        System.out.println("Username: "+userName);
        System.out.println("Birth date: "+birthDateFormat);
        System.out.println("Age: "+age);
        System.out.println("Password: "+"*".repeat(password.length()));

    }
}
