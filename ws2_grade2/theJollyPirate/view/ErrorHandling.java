package view;

public class ErrorHandling  {

    public boolean socialFormat(String socialNumber){
        return socialNumber.matches("^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))0229)\\d{4}$"
                + "|^(((19|2[0-9])[0-9]{2})02(0[1-9]|1[0-9]|2[0-8]))\\d{4}$"
                + "|^(((19|2[0-9])[0-9]{2})(0[13578]|10|12)(0[1-9]|[12][0-9]|3[01]))\\d{4}$"
                + "|^(((19|2[0-9])[0-9]{2})(0[469]|11)(0[1-9]|[12][0-9]|30))\\d{4}$");
    }

    public boolean nameFormat(String firstName) {
        char[] c = firstName.toCharArray();
        for (char value : c) {
            if (!Character.isLetter(value))
                return true;
        }

        return false;
    }

    //Error messages ################################
    public void wrongInput() { System.out.println( "Your input is not an option, please try again."); }

    public void userAlreadyInDB() {System.out.println("The user is already registered member at Jolly Pirate") ;  }

    public void nameOrSocialFormat(){System.out.println("Wrong format - Names can not include non-characters and Social security number must be in the format:YYYYDDMMXXXX");}

    public void nameFormat(){System.out.println("Wrong format - Names can not include non-characters");}

    public void credFailure(){System.out.println("Credentials do not match or this membersID is not in the database. ");}

    public void noMemberRegistered(){System.out.println("There is no member registered in the database");}

    public void noBerths() {System.out.println("There are no berths available");   }

    public void noBoatsAreReg() {System.out.println("No boats registered at Jolly Pirate");   }

    public void boatNotFound() {System.out.println("A boat with this registration number was not found");   }

    public void lengthError() { System.out.println("We do NOT register boats under 1 meter or over 20 meters"); }

    public void boatAlreadyInRegistry() {System.out.println("The boat with this registration number is already in the database");}


}
