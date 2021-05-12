package bankaccount;

import java.util.Scanner;

public class customer {
    private String name;
    private final int ssn;
    private String address;

    Scanner scanner = new Scanner(System.in);
    public customer(String name, int ssn, String address){
       // System.out.println("Please enter your name");
        this.name=name;
        this.ssn=ssn;
        this.address=address;
    }
    //method to edit customer details
    public void editDetails(){
        System.out.println("which field you would like to update");
        System.out.println("A: name");
        System.out.println("B: address");
        System.out.println("Please choose A or B");
        String edit = scanner.next();
        switch (edit.toUpperCase()){
            case"A":
                System.out.println("Please enter your new name");
                 name = scanner.next();
                System.out.println("your name has been changed" + name);
                break;
            case"B":
                System.out.println("Please enter your new address");
                address = scanner.next();
                System.out.println("Your address has been changed" + address);
                break;
            default:
                System.out.println("Sorry this option not available");
        }

    }
    


}
