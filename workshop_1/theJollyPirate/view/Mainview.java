package view;

import model.Login;
import model.roles.Member;
import model.roles.Users;

import java.util.Scanner;

public class Mainview {
     Scanner input = new Scanner(System.in);

    public void welcome(){
        System.out.print("Welcome to Jolly Pirate Yacht Club! \n" +
                "Please choose from list: \n" +
                "1. Login: For booking a boat or change members information \n" +
                "2. Non-login: For view and search only \n" +
                "3. Close the program (you can also use \"q\") \n");
    }

    //Common messages  ##############################
    public void bar() {System.out.println("\n =============================================================================== \n");}
    public void loggedInMessage(String fullName) {
        System.out.println("You Are Logged In! Welcome " + fullName);
    }
    public void loggedOutMessage(String fullName) {System.out.println("You are logged out. Thank you " + fullName + " for using Jolly Pirate booking system."); }
    public void closingProgram( ) {System.out.println("Closing program.........");}
    public void programClosed( ) {System.out.println("Program closed.");}
    public void memberRegistered( ) {System.out.print(" has been registered to database and the username is: ");}
    public void promptFirstName() { System.out.println("Please, enter member's firstname: ");   }
    public void promptSurName() { System.out.println("Please, enter member's surname: ");   }
    public void promptSocialNumber() { System.out.println("Please, enter member's social security number (12 digits): ");   }
    public void promptPassword() {System.out.println("Please, enter member's chosen password: ");    }
    public void findMember() {System.out.println("Please, enter memberID: ");    }
    public void confirmRemoveMember(Users member) { System.out.print("Are you sure you want to remove " + member.getFullName() + ", social security number: " + member.getSocialNumber() + "?(yes/no)"); }
    public void memberRemoved(){System.out.println("Member has been removed from the database and associated boats");}

    //Control messages #######################
    public String getInput(){
        String uInput = input.next();
        return uInput;
    }

    public boolean confirm(){
        String input = getInput();
        if(input.equalsIgnoreCase("yes"))
            return true;
        else
            return false;
    }

    // TODO: 2020-08-29 Might have to split this up because login is domain class 
    public Login getCredentials(){
        Login login = new Login();
        System.out.print("Please enter your userId and Password.\n" +
                "UserID:  ");
                login.addLoginUserID(getInput());
        System.out.print("Password:  ");
        login.addPassword(getInput());
        return login;
    }

    public void compactList(Member users) {
        System.out.println(users.getFullName() + " UserID: "+ users.getLogin().getUserID() + " Number of boats: " + users.numberBoats());
    }

    //Option messages ##########################
    // TODO: 2020-08-28 Create non-login options
    public void nonLoginOptions(){
        System.out.print("List of options if not logged in");
    }

    public void loginOptions() {
        System.out.print("1. Create a member \n" +
                "2. Remove a member \n" +
                "3. Edit a member \n" +
                "4. Register a boat \n" +
                "5. Remove a boat \n" +
                "6. Edit a boat \n" +
                "7. View a compact members list \n" +
                "8. View a verbose members list \n" +
                "9. Log-out \n" +
                "10.Search for members or boats \n");
    }

    //Error messages ################################
    public void loginFailure() { System.out.println("User not found, please try again or use non-logged in options."); }
    public void wrongInput() { System.out.println("Your input is not an option, please try again."); }
    public void userAlreadyInDB() {System.out.println("The user is already registered member at Jolly Pirate") ;  }
    public void socialFormat(){System.out.println("Social security number(SSN) has a wrong format, use YYYYDDMMXXXX. Enter new SSN");}
    public void nameFormat(){System.out.println("Names can not include non-characters");}
    public void memberNotFound(){System.out.println("This membersID is not in the database");}
    public void noMemberRegistered(){System.out.println("There is no member registered in the database");}


}
