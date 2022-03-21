package org.boagroup.roskildedaycare;

import java.sql.ResultSet;
import java.util.Scanner;

public class Console {
	static boolean isLogged = false;
	static Scanner sc = new Scanner(System.in);

	public static void login(Core core) {
		String username;
		String password;
		while (!isLogged) {
			System.out.println("Please log in");
			System.out.println("username: ");
			username = sc.nextLine();
			System.out.println("password: ");
			password = sc.nextLine();
			isLogged = core.login(username, password);
		}
	}

	public static void main(String[] args) {
		Core core = Core.getInstance();
		login(core);
		System.out.println("displaying users: ");
		ResultSet rs = core.list(new Query("Users","*",null));
		try {
			while (rs.next()){
				System.out.print("| " + rs.getString("Username")+" | ");
				System.out.println(rs.getString("Password") + " |");
			}
		} catch (Exception e) {e.printStackTrace();}
	}
}
