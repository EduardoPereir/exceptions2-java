package application;

import model.entitites.Account;
import model.exceptions.BusinessException;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter account data: ");
            System.out.print("Number: ");
            int accountNumber = scanner.nextInt();
            System.out.print("Holder: ");
            String holderName = scanner.next();
            System.out.print("Initial balance: ");
            Double initialBalance = scanner.nextDouble();
            System.out.print("Withdraw Limit: ");
            Double withdrawLimit = scanner.nextDouble();

            Account account = new Account(accountNumber, holderName, initialBalance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw:");
            Double withdrawAmount = scanner.nextDouble();

            account.withdraw(withdrawAmount);

            System.out.println("New balance: " + account.getBalance());
        }
        catch (BusinessException e) {
            System.out.println("Withdraw error : " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        scanner.close();
    }
}
