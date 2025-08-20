import entities.Account;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number;
        String holder;
        double initialBalance;
        double withdrawLimit;
        double amount;

        System.out.println("Enter account data");
        System.out.printf("Number: ");
        number = sc.nextInt();
        System.out.printf("Holder: ");
        holder = sc.next();
        System.out.printf("Initial balance: ");
        initialBalance = sc.nextDouble();
        System.out.printf("Withdraw limit: ");
        withdrawLimit = sc.nextDouble();

        Account account = new Account(number, holder, initialBalance, withdrawLimit);
        System.out.printf("Enter amount for withdraw: ");
        amount = sc.nextDouble();
        try {
            account.withdraw(amount);
            System.out.println("New balance: " + account.getBalance());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}