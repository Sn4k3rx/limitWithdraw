package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);

		try {
			System.out.println("Enter account Data: ");
			System.out.print("Number: ");
			int number = in.nextInt();
			System.out.print("Holder: ");
			in.next();
			String holder = in.nextLine();
			System.out.print("Initial Balance: ");
			double balance = in.nextDouble();
			System.out.print("withdraw limit: ");
			double withdrawLimit = in.nextDouble();

			Account account = new Account(number, holder, balance, withdrawLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");

			account.withdraw(in.nextDouble());
			System.out.println("value: " + account.getBalance());
		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Value invalid");
		}

		in.close();
	}
}