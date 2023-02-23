package lockedMe.com.demo;

import java.util.Scanner;

import phase1.project.BusinessOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Clinet {
	public static void main(String[] args) {

		System.out.println("===================================================");
		System.out.println("Welcome to LockedMe.com Application\nDeveloped by:-Nikita S. Mandhana");
		System.out.println("===================================================");

		int ch = 0;
		String ch1 = null;
		do {

			// System.out.println("===================================================");
			System.out.println("\n1. Retrieving the file names in an ascending order.");
			System.out.println("2. Business-level operations.");
			System.out.println("3. close the application.");
			System.out.println("Please enter your choice: ");
			try {
				Scanner sc = new Scanner(System.in);
				ch = sc.nextInt();

				switch (ch) {
				case 1:
					displayFilesList();
					break;
				case 2:
					System.out.println("Business-level operations");
					System.out.println("a. Add a user specified file");
					System.out.println("b. Delete a user specified file");
					System.out.println("c. Search a user specified file");
					System.out.println("d. Return to the main menu");
					System.out.println("Please enter your choice: ");

					try {
						ch1 = sc.next();
					} catch (Exception e) {
						System.out.println("Null Exception occurred");
					}
					switch (ch1) {
					case "a":
						System.out.println("Enter File name with extension \n ");
						String fileCreate = sc.next();
						createFile(fileCreate);
						break;
					case "b":
						System.out.print("Enter File name with extention to be delete \n ");
						String fileDelete = sc.next();
						deleteFile(fileDelete);
						break;
					case "c":
						System.out.println("Enter the file name with extention to search \n");
						String fileSearch = sc.next();
						searchFile(fileSearch);
						break;
					case "d":
						System.out.println("");
						break;
					default:
						System.out.println("\n Please enter correct choice");
						break;
					}
					break;

				case 3:
					System.out.println(" *** Thanks for using LockedMe.com application *** ");
					System.exit(0);
					break;
				default:
					System.out.println("\nPlease enter correct choice");

				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		} while (true);

	}

	public static void displayFilesList() throws Exception {
		String m1 = (System.getProperty("user.dir"));
		// File f1 = new File("C:\\Users\\HP\\Downloads");
		File f1 = new File(m1);
		String list[] = f1.list();
		if (list.length == 0) {
			System.out.print("Selected folder is empty");
		} else {
			System.out.print("List of File is in an ascending order\n***********************");
			for (String l1 : list) {
				System.out.println(l1);
			}
		}
	}

	public static void createFile(String fileCreate) throws Exception {
		// String Path = "D:\\";
		// String Filename, FinalPath;
		// FinalPath = (Path + Filename);
		// File file = new File(FinalPath);
		//
		//
		File file = new File((System.getProperty("user.dir")) + "\\" + fileCreate);

		if (file.createNewFile())
			System.out.println("File is Created");
		else
			System.out.println("File already exists");
	}

	public static void deleteFile(String fileDelete) throws Exception {
		File file = new File((System.getProperty("user.dir")) + "\\" + fileDelete);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("File deleted successfully");
			}
		} else {
			System.out.println("File does not exist");
		}
	}
	
	public static void searchFile(String fileSearch) throws Exception {
		File file = new File((System.getProperty("user.dir")) + "\\" + fileSearch);
		if (file.exists()) {
			System.out.println("File found.");
			System.out.println(file.getName() + " at " + file.getAbsolutePath());
		} else {
			System.out.println("No result,File name does not exist");
		}
	}
	
}
