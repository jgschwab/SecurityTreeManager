package edu.ncsu.csc316.security_manager.ui;

import java.util.Scanner;

import edu.ncsu.csc316.security_manager.manager.SecurityTreeManager;

/**
 * CLI for SecurityTreeManager. Starts the program
 * and acts as the view and controller within the
 * MVC pattern for this software.
 * @author Justin Schwab
 *
 */
public class SecurityTreeManagerUI {
	/**
	 * Starts the program with a terminal interface
	 * @param args (Unused) command-line arguments
	 */
	public static void main(String[] args){
		System.out.println("Welcome to SecurityTreeManager!\n"
						 + "Choose an option:\n"
						 + "(1) - Build Attack Tree\n"
						 + "(2) - Build Log Tree\n"
						 + "(q) - Quit program");
		Scanner in = new Scanner(System.in);
		String token = in.next();
		SecurityTreeManager stm = null;
		while(!token.equals("q")){
			if(token.equals("1")){
				System.out.println("Please enter a PreOrder Traversal file\n"
						+ "and a PostOrder Traversal file,\n"
						+ "separated by a space");
				boolean valid = false;
				while(!valid){
					try{
						stm = new SecurityTreeManager(in.next(), in.next());
					} catch(IllegalArgumentException e){
						System.out.println("One or more file(s) not found.");
						System.out.println("Please enter a PreOrder Traversal file\n"
								+ "and a PostOrder Traversal file,\n"
								+ "separated by a space");
						continue;
					}
					valid = true;
				}
				String goalSumm = stm.propagateValues();
				System.out.println("Attack tree built!\nChoose an option:\n"
						 + "(1) - View goal node summary\n"
						 + "(2) - View level-order traversal\n"
						 + "(m) - Main menu");
				token = in.next();
				while(!token.equals("m")){
					if(token.equals("1")){
						System.out.println(goalSumm);
						System.out.println();
					} else if(token.equals("2")){
						System.out.println(stm.getAttackTreeLevelOrder());
						System.out.println();
					} else{
						System.out.println("Invlid Option");
					}
					System.out.println("Choose an option:\n"
							 + "(1) - View goal node summary\n"
							 + "(2) - View level-order traversal\n"
							 + "(m) - Main menu");
					token = in.next();
				}
				System.out.println("Choose an option:\n"
						 + "(1) - Build Attack Tree\n"
						 + "(2) - Build Log Tree\n"
						 + "(q) - Quit program");
				token = in.next();
			} else if(token.equals("2")){
				System.out.print("Please enter a Log File: ");
				boolean valid = false;
				while(!valid){
					try{
						stm = new SecurityTreeManager(in.next());
					} catch(IllegalArgumentException e){
						System.out.println(e.getMessage());
						System.out.print("Please enter a Log File: ");
						continue;
					}
					valid = true;
				}
				System.out.println("Choose an option:\n"
						 + "(1) - Filter Logs by Date\n"
						 + "(2) - View level-order traversal\n"
						 + "(m) - Main menu");
				token = in.next();
				while(!token.equals("m")){
					if(token.equals("1")){
						System.out.println("Please enter a date to search for\n"
								+ "(Format should be of the form \"MM-DD-YYYY\")\n"
								+ "or enter \"c\" to cancel and return to Log Tree menu.");
						String date = in.next();
						valid = true;
						while(!isValid(date)){
							if(date.equals("c")){
								valid = false;
								break;
							} else{
								System.out.println("Invalid date");
								System.out.println("Please enter a date to search for\n"
										+ "(Format should be of the form \"MM-DD-YYYY\")\n"
										+ "or enter \"c\" to cancel and return to Log Tree menu.");
								date = in.next();
							}
						}
						if(valid){
							System.out.println(stm.getLogEntriesForDate(date));
						}
					} else if(token.equals("2")){
						System.out.println(stm.getLogTreeLevelOrder());
					} else{
						System.out.println("Invlid Option");
					}
					System.out.println("Choose an option:\n"
						 + "(1) - Filter Logs by Date\n"
						 + "(2) - View level-order traversal\n"
						 + "(m) - Main menu");
					token = in.next();
				}
				System.out.println("Choose an option:\n"
						 + "(1) - Build Attack Tree\n"
						 + "(2) - Build Log Tree\n"
						 + "(q) - Quit program");
				token = in.next();
				
			} else {
				System.out.println("Invalid option");
				System.out.println("Choose an option:\n"
						 + "(1) - Build Attack Tree\n"
						 + "(2) - Build Log Tree\n"
						 + "(q) - Quit program");
				token = in.next();
			}
		}
		in.close();
		System.out.println("<terminated>");
	}

	/**
	 * Determines if a date string is valid with
	 * format checking and light error-checking
	 * @param date The date to check
	 * @return True if the date is valid
	 */
	private static boolean isValid(String date) {
		Scanner s = new Scanner(date);
		s.useDelimiter("-");
		if(!s.hasNextInt()){
			s.close();
			return false;
		}
		int month = s.nextInt();
		if(!s.hasNextInt()){
			s.close();
			return false;
		}
		int day = s.nextInt();
		if(!s.hasNextInt()){
			s.close();
			return false;
		}
		int year = s.nextInt();
		if(s.hasNext()){
			s.close();
			return false;
		}
		s.useDelimiter(" ");
		if(s.hasNext()){
			s.close();
			return false;
		}
		if(day < 1 || day > 31 || month < 1 || month > 12 || year < 0 || year > 9999){
			s.close();
			return false;
		}
		s.close();
		return true;
	}
}