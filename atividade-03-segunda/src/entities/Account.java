package entities;

import exceptions.InvalidOperationException;

public class Account {

    private int number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Account(int number, String holder, double balance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        validateWithdraw(amount);
        this.balance -= amount;
    }

    public void validateWithdraw(double amount) {
        if (amount > this.getWithdrawLimit()) {
            throw new InvalidOperationException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (amount > this.getBalance()) {
            throw new InvalidOperationException("Withdraw error: Not enough balance");
        }

    }
}
