package MoneyMagic;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    // To store a couple of account numbers and pins
    HashMap<Integer, Integer> data = new HashMap<>();

    // Function for login
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(6005, 8917);
                data.put(6006, 8658);
                data.put(6007,7008);

                System.out.println("Welcome to the ATM !");
                System.out.println("Enter your customer number:");
                setCustomerNumber(input.nextInt());

                System.out.println("Enter your PIN Number:");
                setPinNumber(input.nextInt());

                int cn = getCustomerNumber();
                int pn = getPinNumber();

                if (data.containsKey(cn) && data.get(cn) == pn) {
                    getAccountType();
                } else {
                    System.out.println("\nWrong Customer Number or PIN Number\n");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid Characters. Only Numbers.\n");
                x = 2;
            }
        } while (x == 1);
    }

    // Function to get account type
    public void getAccountType() {
        System.out.println("Select the Account you want to access:");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");

        int selection = input.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using this ATM, bye.\n");
                break;
            default:
                System.out.println("\nInvalid Choice.\n");
                getAccountType();
                break;
        }
    }

    // Function to get Checking account type
    public void getChecking() {
        System.out.println("Checking Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw");
        System.out.println("Type 3 - Deposit");
        System.out.println("Choice:");

        int selection = input.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM, bye.");
                break;
            default:
                System.out.println("\nInvalid choice,\n");
                getChecking();
                break;
        }
    }

    // Function for saving bank account
    public void getSaving() {
        System.out.println("Saving Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw");
        System.out.println("Type 3 - Deposit");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice:");

        int selection = input.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM, bye.");
                break;
            default:
                System.out.println("\nInvalid choice,\n");
                getSaving();
                break;
        }
    }
}
