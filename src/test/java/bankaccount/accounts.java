package bankaccount;



import java.util.Scanner;

public class accounts {

  int checkingAccountBalance;
   int savingsAccountBalance;
   int savingsAccountNum;
   int checkingAccountNum;
   private int accountNum = 1000;
   int numAccount= 0;
    Scanner scanner= new Scanner(System.in);

    //method to deposit
    public void deposit(){
        System.out.println("PLease enter last 4digits account number you would like to deposit from");
        int last_4= scanner.nextInt();
        if (last_4==checkingAccountNum || last_4==savingsAccountNum) {
            System.out.println("Enter the amount you would like to deposit");
            double amount = scanner.nextDouble();
            if (amount > 0) {
                if (last_4 == checkingAccountNum) {
                    checkingAccountBalance += amount;
                } else if (last_4 == savingsAccountNum)
                    checkingAccountBalance += amount;
                System.out.println(amount + "$ has been added to balance");
            } else System.out.println("please enter a correct amount you would like to deposit");
        }
    }

    //method to withdraw
    public void withdraw(){
        System.out.println("Please enter last 4 digits account number you would like to withdraw from");
        int last_4= scanner.nextInt();
        if (last_4==checkingAccountNum || last_4==savingsAccountNum);{
        System.out.println("Enter the amount you would like to withdraw");
         double amount= scanner.nextDouble();
        if (amount<=checkingAccountNum || amount<=savingsAccountNum){
            if (last_4==checkingAccountNum)
            checkingAccountBalance -= amount;
            else if (last_4==savingsAccountNum)
                savingsAccountBalance -= amount;
            System.out.println(amount+ "$ has been withdrawn");
        } else System.out.println("the amount you wish to withdraw is more than current balance");

    }
    }

    //method to check balance
    public void checkBalance(){
        System.out.println("checking account balance: " + checkingAccountBalance);
        System.out.println("savings account balance" + savingsAccountBalance);
        System.out.println("you have a total of " + numAccount + "account");

    }

    //method to create account
    public void createAccount(int checkingAccount, int savingsAccount){
        System.out.println("welcome customer, please choose which account type you would like to open");
        System.out.println("A: Checking Account");
        System.out.println("B: Savings Account");
        System.out.println("Please choose A or B");
        String accountType = scanner.next();
        switch (accountType.toUpperCase()){
        case"A":
            System.out.println("Congrats on making a checking account with ");
            accountNum++;
            numAccount++;
            checkingAccount= accountNum;
            System.out.println("Last 4 digits of checking account" + accountNum);
            break;
            case"B":
                System.out.println("congrats on making a savings account");
                accountNum++;
                numAccount++;
                savingsAccount=accountNum;
                System.out.println("Last 4 digits of savings account" + accountNum);
                break;
            default:
                System.out.println("Sorry we only have 2 account type as of now");
        }




    }
}
