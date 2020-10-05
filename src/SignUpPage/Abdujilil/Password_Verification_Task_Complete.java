package SignUpPage.Abdujilil;

import java.util.Scanner;

public class Password_Verification_Task_Complete {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String firstname, lastname, username, birthDate, password;
        String number = "0123456789";
        String specialCharacter = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; // All Special Characters
        String passwordReplace = "";
        char[] numbers = number.toCharArray();
        char[] specialCharacters = specialCharacter.toCharArray();
        char[] letters = alphabet.toCharArray();
        int indexOfYear, currentYear, currentMonth, birthMonth, birthYear;
        int testNumb = 0, testNumb1 = 0, testNumb2 = 1, testNumb3 = 0, testNumb4 = 0;
        int testSpecial = 0, testSpecial1 = 0, testSpecial2 = 1, testSpecial3 = 0, testSpecial4 = 0;
        int testSpace = 0, testSpace1 = 0, testSpace2 = 0, testSpace3 = 0, testSpace4 = 0;
        int testLetter = 1 , testLetter1 = 0, testLetter2 = 0;
        int age = 0;
        int testCapital = 0;
        int testRepeatChar = 0;
        int testIncrement = 0;
        int testDecrement = 0;

        System.out.println("Welcome! Before you can access the site, you need to create a password." + "\n");
        System.out.println("Please enter your first name:");
        firstname = scan.nextLine();
        char[] firstnameChar = firstname.toCharArray();

        //   *********  Verify First name  *************



        do {
            for (char number1 : numbers) {
                for (char name1 : firstnameChar) {
                    if (number1 == name1){
                        ++testNumb;
                    }
                }
            }
            for (char special1 : specialCharacters) {
                for (char name1: firstnameChar) {
                    if (special1 == name1) {
                        ++testSpecial;
                    }
                }
            }
            for (char eachChar : firstnameChar) {
                if (eachChar == ' ') {
                    ++testSpace;
                }
            }
            if (testNumb > 0){
                System.out.println("First name cannot contain a number!");
                System.out.println("Please enter your first name again:");
                firstname = scan.nextLine();
                firstnameChar = firstname.toCharArray();
                testNumb = 0;
            }else if (testSpecial > 0) {
                System.out.println("First name cannot contain a special character!");
                System.out.println("Please enter your first name again:");
                firstname = scan.nextLine();
                firstnameChar = firstname.toCharArray();
                testSpecial = 0;
            } else if (testSpace > 0) {
                System.out.println("First name cannot contain space!");
                System.out.println("Please enter your first name again:");
                firstname = scan.nextLine();
                firstnameChar = firstname.toCharArray();
                testSpace = 0;
            } else if (firstname.length() == 0) {
                System.out.println("First name cannot be empty!");
                System.out.println("Please enter your first name again:");
                firstname = scan.nextLine();
                firstnameChar = firstname.toCharArray();
            } else if (firstname.length() < 2) {
                System.out.println("First name must be 2 characters or more!");
                System.out.println("Please enter your first name again:");
                firstname = scan.nextLine();
                firstnameChar = firstname.toCharArray();
            } else if (firstname.length() > 16) {
                System.out.println("First name must be 16 characters or less!");
                System.out.println("Please enter your first name again:");
                firstname = scan.nextLine();
                firstnameChar = firstname.toCharArray();
            } else {
                testNumb = 1;
                testSpecial = 1;
                testSpace = 1;
            }
        } while (testNumb == 0 && testSpecial == 0 && testSpace == 0);

        System.out.println("Your firstname is: " + firstname);   // Remove when the code is complete

        //   *********  Verify Last name   *************

        System.out.println("Please enter your last name:");
        lastname = scan.nextLine();
        char[] lastnameChar = lastname.toCharArray();

        do {
            for (char number1 : numbers) {
                for (char name1 : lastnameChar) {
                    if (number1 == name1){
                        ++testNumb1;
                    }
                }
            }
            for (char special1 : specialCharacters) {
                for (char name1: lastnameChar) {
                    if (special1 == name1) {
                        ++testSpecial1;
                    }
                }
            }
            for (char eachChar : lastnameChar) {
                if (eachChar == ' ') {
                    ++testSpace1;
                }
            }
            if (testNumb1 > 0){
                System.out.println("Last name cannot contain a number!");
                System.out.println("Please enter your last name again:");
                lastname = scan.nextLine();
                lastnameChar = lastname.toCharArray();
                testNumb1 = 0;
            }else if (testSpecial1 > 0) {
                System.out.println("Last name cannot contain a special character!");
                System.out.println("Please enter your last name again:");
                lastname = scan.nextLine();
                lastnameChar = lastname.toCharArray();
                testSpecial1 = 0;
            } else if (testSpace1 > 0) {
                System.out.println("Last name cannot contain space!");
                System.out.println("Please enter your last name again:");
                lastname = scan.nextLine();
                lastnameChar = lastname.toCharArray();
                testSpace1 = 0;
            } else if (lastname.length() == 0) {
                System.out.println("Last name cannot be empty!");
                System.out.println("Please enter your last name again:");
                lastname = scan.nextLine();
                lastnameChar = lastname.toCharArray();
            } else if (lastname.length() < 2) {
                System.out.println("Last name must be 2 characters or more!");
                System.out.println("Please enter your last name again:");
                lastname = scan.nextLine();
                lastnameChar = lastname.toCharArray();
            } else if (lastname.length() > 16) {
                System.out.println("Last name must be 16 characters or less!");
                System.out.println("Please enter your last name again:");
                lastname = scan.nextLine();
                lastnameChar = lastname.toCharArray();
            } else if (lastname.equalsIgnoreCase(firstname)) {
                System.out.println("Last name must not be the same as first name!");
                System.out.println("Please enter your last name again:");
                lastname = scan.nextLine();
                lastnameChar = lastname.toCharArray();
            } else {
                testNumb1 = 1;
                testSpecial1 = 1;
                testSpace1 = 1;
            }
        } while (testNumb1 == 0 && testSpecial1 == 0 && testSpace1 == 0);

        System.out.println("Your lastname is: " + lastname);   // Remove when the code is complete

        //   *********  Verify Username   *************

        System.out.println("Please enter your username:");
        username = scan.nextLine();
        char[] usernameChar = username.toCharArray();

        do {
            for (char number1 : numbers) {
                for (char name1 : usernameChar) {
                    if (number1 == name1){
                        --testNumb2;
                    }
                }
            }
            for (char special1 : specialCharacters) {
                for (char name1: usernameChar) {
                    if (special1 == name1) {
                        --testSpecial2;
                    }
                }
            }
            for (char eachChar : usernameChar) {
                if (eachChar == ' ') {
                    ++testSpace2;
                }
            }
            for (char letter : letters) {
                for (char nameChar : usernameChar) {
                    if (letter != nameChar) {
                     --testLetter;
                    }
                }
            }
            if (testNumb2 > 0 && username.length() > 1 && testSpace2 == 0 && username.length() < 16){
                System.out.println("Username must contain at least one number!");
                System.out.println("Please enter your username again:");
                username = scan.nextLine();
                usernameChar = username.toCharArray();
                testNumb2 = 1;
                testLetter = 1;
                testSpecial2 = 1;
            } else if (testSpecial2 > 0 && username.length() > 1 && testSpace2 == 0 && username.length() < 16) {
                System.out.println("Username must contain at least one special character!");
                System.out.println("Please enter your username again:");
                username = scan.nextLine();
                usernameChar = username.toCharArray();
                testSpecial2 = 1;
                testNumb2 = 1;
                testLetter = 1;
            } else if (testLetter > 0 && username.length() > 1 && testSpace2 == 0 && username.length() < 16) {
                System.out.println("Username must contain at least one letter!");
                System.out.println("Please enter your username again:");
                username = scan.nextLine();
                usernameChar = username.toCharArray();
                testSpecial2 = 1;
                testNumb2 = 1;
                testLetter = 1;
            } else if (testSpace2 > 0) {
                System.out.println("Username cannot contain space!");
                System.out.println("Please enter your username again:");
                username = scan.nextLine();
                usernameChar = username.toCharArray();
                testSpecial2 = 1;
                testNumb2 = 1;
                testSpace2 = 0;
                testLetter = 1;
            } else if (username.length() == 0) {
                System.out.println("Username cannot be empty!");
                System.out.println("Please enter your username again:");
                username = scan.nextLine();
                usernameChar = username.toCharArray();
            } else if (username.length() < 2) {
                System.out.println("Username must be 2 characters or more!");
                System.out.println("Please enter your username again:");
                username = scan.nextLine();
                usernameChar = username.toCharArray();
                testSpecial2 = 1;
                testNumb2 = 1;
                testLetter = 1;
            } else if (username.length() > 16) {
                System.out.println("Username must be 16 characters or less!");
                System.out.println("Please enter your username again:");
                username = scan.nextLine();
                usernameChar = username.toCharArray();
                testSpecial2 = 1;
                testNumb2 = 1;
                testLetter = 1;
            } else {
                testNumb2 = 0;
                testSpecial2 = 0;
                testLetter = 0;
                testSpace2 = 1;
            }
        } while (testNumb2 != 0 && testSpecial2 != 0 && testSpace2 == 0 && testLetter != 0);
        System.out.println("Username is: " + username);  // Remove when the code is complete

        //   *********  Verify Date Of Birth   *************

        System.out.println("Please enter your date of birth in MM/DD/YYYY :");
        birthDate = scan.nextLine();
        char[] birthdateChar = birthDate.toCharArray();

        do {
            for (char number1 : numbers) {
                for (char birthdate1 : birthdateChar) {
                    if (number1 == birthdate1){
                        ++testNumb3;
                    }
                }
            }
            for (char special1: birthdateChar) {
                if (special1 == '/') {
                    ++testSpecial3;
                }
            }

            for (char eachChar : birthdateChar) {
                if (eachChar == ' ') {
                    ++testSpace3;
                }
            }
            for (char letter : letters) {
                for (char birthdate1 : birthdateChar) {
                    if (letter == birthdate1) {
                        ++testLetter1;
                    }
                }
            }
            if (testNumb3 != 6 && birthDate.length() > 1 && testSpace3 == 0 && testSpecial3 != 2 && testLetter1 == 0){
                System.out.println("Date of birth must be in this format: MM/DD/YYYY!");
                System.out.println("Please enter your date of birth again:");
                birthDate = scan.nextLine();
                birthdateChar = birthDate.toCharArray();
                testNumb3 = 0;
                testSpecial3 = 0;
            } else if (testLetter1 > 0 && birthDate.length() > 1 && testSpace3 == 0 && username.length() < 16) {
                System.out.println("Date of birth must not contain any letter!");
                System.out.println("Please enter your date of birth again:");
                birthDate = scan.nextLine();
                birthdateChar = birthDate.toCharArray();
                testLetter1 = 0;
            } else if (testSpace3 > 0) {
                System.out.println("Date of birth cannot contain space!");
                System.out.println("Please enter your date of birth again:");
                birthDate = scan.nextLine();
                birthdateChar = birthDate.toCharArray();
                testSpecial3 = 0;
                testNumb3 = 0;
                testSpace3 = 0;
                testLetter1 = 0;
            } else if (birthDate.length() == 0) {
                System.out.println("Date of birth cannot be empty!");
                System.out.println("Please enter your date of birth again:");
                birthDate = scan.nextLine();
                birthdateChar = birthDate.toCharArray();
                testSpecial3 = 0;
                testNumb3 = 0;
                testSpace3 = 0;
                testLetter1 = 0;
            } else {
                indexOfYear = birthDate.lastIndexOf("/");
                birthYear = Integer.parseInt(birthDate.substring(indexOfYear+1));
                birthMonth = Integer.parseInt(birthDate.substring(0,2));
                System.out.println("What is the current year?");
                currentYear = scan.nextInt();
                System.out.println("what is the current month?");
                currentMonth = scan.nextInt();
                scan.nextLine();
                if (currentMonth >= birthMonth) {
                    age = currentYear - birthYear;
                } else {
                    age = currentYear - birthYear - 1;
                }
                if (age < 10 || age > 100) {
                    System.out.println("You are too young or too old!");
                    System.out.println("Please enter a valid date of birth:");
                    birthDate = scan.nextLine();
                    birthdateChar = birthDate.toCharArray();
                    testSpecial3 = 0;
                    testNumb3 = 0;
                    testSpace3 = 0;
                    testLetter1 = 0;
                }
            }
        } while (testNumb3 < 8 || testSpecial3 < 2 && testSpace3 == 0 && testLetter1 == 0);
        System.out.println("Your birthdate is: " + birthDate);
        System.out.println("You are " + age + " years old");

        //   *********  Verify Password   *************

        System.out.println("Please enter a password:");
        password = scan.nextLine();
        char[] passwordChar = password.toCharArray();

        do {
            for (char number1 : numbers) {
                for (char password1 : passwordChar) {
                    if (number1 == password1){
                        ++testNumb4;
                    }
                }
            }
            for (char special1 : specialCharacters) {
                for (char password1: passwordChar) {
                    if (special1 == password1) {
                        ++testSpecial4;
                    }
                }
            }

            for (char eachChar : passwordChar) {
                if (eachChar == ' ') {
                    ++testSpace4;
                }
            }
            for (char letter : letters) {
                for (char birthdate1 : passwordChar) {
                    if (letter == birthdate1) {
                        ++testLetter2;
                    }
                }
            }
            for (char i = 'A'; i <= 'Z'; i++) {
                for (char password1 : passwordChar) {
                    if (password1 == i) {
                        ++testCapital;
                    }
                }
            }
            for (int i = 0; i < password.length()-2; i++) {
                if (password.charAt(i) == password.charAt(i+1) && password.charAt(i) == password.charAt(i+2)) {
                    ++testRepeatChar;
                }
            }
            for (int i = 0; i < password.length()-2; i++) {
               if (passwordChar[i] > 47 && passwordChar[i] < 58) {
                   if (passwordChar[i+1] == passwordChar[i] +1 && passwordChar[i+2] == passwordChar[i+1] +1) {
                       ++testIncrement;
                   }
               }
            }
            for (int i = 0; i < password.length()-2; i++) {
                if (passwordChar[i] > 47 && passwordChar[i] < 58) {
                    if (passwordChar[i+1] == passwordChar[i] - 1 && passwordChar[i+2] == passwordChar[i+1] - 1) {
                        ++testDecrement;
                    }
                }
            }
            if (password.length() == 0) {
                System.out.println("Password cannot be empty!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
            } else if (testSpace4 > 0) {
                System.out.println("Password cannot contain space!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testSpace4 = 0;
                testLetter2 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (testSpecial4 == 0 && testNumb4 != 0 && testLetter2 != 0) {
                System.out.println("Password must contain at least one special character!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (testNumb4 == 0 && testSpecial4 != 0 && testLetter2 != 0) {
                System.out.println("Password must contain at least one number!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (testLetter2 == 0 && testSpecial4 != 0 && testNumb4 != 0) {
                System.out.println("Password must contain at least one letter!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (password.contains(firstname)) {
                System.out.println("Password must not contain your firstname!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (password.contains(lastname)) {
                System.out.println("Password must not contain your lastname!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (password.contains(username)) {
                System.out.println("Password must not contain your username!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (testCapital == 0) {
                System.out.println("Password must contain at least one capital letter!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (password.contains(birthDate)) {
                System.out.println("Password must not contain your date of birth!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (testRepeatChar > 0) {
                System.out.println("Password must not contain repeating characters more than twice in a row!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (testIncrement > 0) {
                System.out.println("Password must not contain three increment numbers!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (testDecrement > 0) {
                System.out.println("Password must not contain three decrement numbers!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (password.length() < 8) {
                System.out.println("Password must be at least 8 characters long!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            } else if (password.length() > 16) {
                System.out.println("Password must be no more than 16 characters long!");
                System.out.println("Please enter your password again:");
                password = scan.nextLine();
                passwordChar = password.toCharArray();
                testSpecial4 = 0;
                testNumb4 = 0;
                testLetter2 = 0;
                testSpace4 = 0;
                testCapital = 0;
                testRepeatChar = 0;
                testIncrement = 0;
                testDecrement = 0;
            }
        } while (testNumb4 == 0 || testSpecial4 == 0 || testSpace4 != 0 || testLetter2 == 0 || testCapital == 0 || testRepeatChar != 0 || testIncrement != 0 || testDecrement != 0);

        for (char eachPassword : passwordChar) {
            eachPassword ='*';
            passwordReplace += eachPassword;
        }

        if (firstname.charAt(0) >= 97 && firstname.charAt(0) <= 122) {     // Change first character to Capital
            firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
        }
        if (lastname.charAt(0) >= 97 && lastname.charAt(0) <= 122) {        // Change first character to Capital
            lastname = lastname.substring(0, 1).toUpperCase() + lastname.substring(1);
        }

        // ************** Report ****************

        System.out.println("********** Congratulations! You have successfully created a password! **********" + "\n");
        System.out.println("Please verify the information below is correct: \n");
        System.out.println("Firstname: " + firstname + "\n");
        System.out.println("Lastname: " + lastname + "\n");
        System.out.println("Username: " + username + "\n");
        System.out.println("Date of birth: " + birthDate + "\n");
        System.out.println("Age: " + age + "\n");
        System.out.println("Password: " + passwordReplace);

    }
}
