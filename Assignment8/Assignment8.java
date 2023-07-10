//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Stephen Austria
//    StudentID: 1220159551
//      Lecture: T Th 1:30-2:45
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. 

import java.io.*;
import java.util.Scanner;

public class Assignment8
{
	public static void main(String[] args)
	{	// deaclared variables
		char input1;
		String deptName, numOfFacultyStr, nameOfUniversity;
		String firstName, lastName, academicLevel;
		String university;
		int numOfFaculty;

		boolean operation = false;
		int operation2 = 0;
		String line;
		String filename;

		// create a DeptManagement object. This is used throughout this class.
		DeptManagement deptManage1 = new DeptManagement();

		File file;
		//Try catch statement will execute even with certain errors
		try {
			// print out the menu
			printMenu();

			// create a BufferedReader object to read input from a keyboard
			InputStreamReader isr = new InputStreamReader(System.in );
			BufferedReader stdin = new BufferedReader(isr);

			do {
				System.out.print("\nWhat action would you like to perform?\n");
				line = stdin.readLine().trim(); //read a line
				input1 = line.charAt(0);
				input1 = Character.toUpperCase(input1);

				if (line.length() == 1) //check if a user entered only one character
				{
					switch (input1) {
					case 'A':
						//Add Department
						System.out.print("Please enter the department information:\n");
						System.out.print("Enter department name:\n");
						deptName = stdin.readLine().trim();
						System.out.print("Enter number of faculty:\n");
						numOfFacultyStr = stdin.readLine().trim();
						numOfFaculty = Integer.parseInt(numOfFacultyStr);
						System.out.print("Enter university name:\n");
						nameOfUniversity = stdin.readLine().trim();
						System.out.print("Enter faculty first name:\n");
						firstName = stdin.readLine().trim();
						System.out.print("Enter faculty last name:\n");
						lastName = stdin.readLine().trim();
						System.out.print("Enter faculty academic level:\n");
						academicLevel = stdin.readLine().trim();
						//if else statement will if the inputed department was added or not
                        if (deptManage1.addDepartment(deptName, nameOfUniversity, numOfFaculty, firstName, lastName, academicLevel)) {
                            System.out.print("Department added\n");
                        } else {
                            System.out.print("Department NOT added\n");
                        }
						break;
					case 'C':
						//Create a new department management
						deptManage1 = new DeptManagement();
						break;
						//*****
					case 'D':
						//Search by department's name and the university
						System.out.print("Please enter the department name to search:\n");
						deptName = stdin.readLine().trim();
						System.out.print("Please enter the university name to search:\n");
						university = stdin.readLine().trim();
						//Will print if the desired department exists or not
                        if (deptManage1.deptExists(deptName, university) > -1) {
                            System.out.print(deptName + " at " + university + " is found\n");
                        } else {
                            System.out.print(deptName + " at " + university + " is NOT found\n");
                        }    
						break;
					case 'E':
						//Search faculty
						System.out.print("Please enter the faculty first name to search:\n");
						firstName = stdin.readLine().trim();
						System.out.print("Please enter the faculty last name to search:\n");
						lastName = stdin.readLine().trim();
						System.out.print("Please enter the faculty academic level to search:\n");
						academicLevel = stdin.readLine().trim();
						//Will print if the desired faculty exists or not
						 int exists = deptManage1.facultyExists(firstName, lastName, academicLevel);
                         if (exists > -1) {
                             Department depart = deptManage1.deptList.get(exists);
                             System.out.print("Faculty: " + depart.getFaculty().getFirstName() +
                                     " " + depart.getFaculty().getLastName() + ", " + depart.getFaculty().getAcademicLevel() + " is found\n");
                         } else {
                             System.out.print("Faculty: " + firstName + " " + lastName + ", " + academicLevel + " is NOT found\n");
                         }
						break;
					case 'L':
						//List departments
						System.out.print(deptManage1.listDepartments());
						break;

					case 'N':
						deptManage1.sortByDepartmentName();
						System.out.print("sorted by department names\n");
						break;

					case 'O':
						deptManage1.sortByFacultyNumbers();
						System.out.print("sorted by faculty numbers\n");
						break;
					case 'P':
						deptManage1.sortByDeptFaculty();
						System.out.print("sorted by current faculty name\n");
						break;
					case 'Q':
						//Quit
						break;
					case 'R':
						//Remove a department
						System.out.print("Please enter the department name to remove:\n");
						deptName = stdin.readLine().trim();
						System.out.print("Please enter the university name to remove:\n");
						university = stdin.readLine().trim();

						operation = deptManage1.removeDepartment(deptName, university);

						if (operation == true)
							System.out.print(deptName + " at " + university + " is removed\n");
						else
							System.out.print(deptName + " at " + university + " is NOT removed\n");
						break;
					case 'T':
						//Close DeptManagement
						deptManage1.closeDeptManagement();
						System.out.print("Department management system closed\n");
						break;
					case 'U':
						//Write Text to a File
						System.out.print("Please enter a file name that we will write to:\n");
						filename = stdin.readLine().trim();
						try {
                            File file1 = new File(filename);
                            FileWriter fw = new FileWriter(file1);
                            System.out.print("Please enter a string to write inside the file:\n");
                            String text = stdin.readLine().trim();
                            fw.write(text + "\n");
                            fw.close();
                            System.out.print(filename + " is written\n");
						}
						catch(Exception e) {
							System.out.print("Write string inside the file error\n");
						}
						break;
					case 'V':
						//Read Text from a File
						System.out.print("Please enter a file name which we will read from:\n");
						filename = stdin.readLine().trim();
						try {
							//FileReader
                            FileReader fr = new FileReader(filename);
                            //File
                            File file_1 = new File(filename);
                            boolean exist = file_1.exists();
                            //Statement is created if it exists
                            if (exist == true) {
                                System.out.print(filename + " was read\n");
                            }
                            String fd = "";
                            int c;                           
                            System.out.print("The first line of the file is:\n");
                            while ((c = fr.read()) != 10) {
                                fd += ((char) c);
                            }
                            System.out.print(fd + "\n");
                            fr.close();
						}
						catch(FileNotFoundException e) {
							System.out.print(filename + " not found error\n");
						}
						catch(IOException e1) {
							System.out.print("Read string from the file error\n");
						}
						break;
					case 'W':
						//Serialize DeptManagement to a File
						System.out.print("Please enter a file name which we will write to:\n");
						filename = stdin.readLine().trim();
						try {
                            File files = new File(filename);
                            FileOutputStream fos = new FileOutputStream(files);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(deptManage1);
                            oos.flush();
                            fos.flush();
						}
						catch(NotSerializableException e) {
							System.out.print("Not serializable exception\n");
						}
						catch(IOException e_1) {
							System.out.print("Data file written exception\n");
						}
						break;
					case 'X':
						//Deserialize DeptManagement from a File
						System.out.print("Please enter a file name which we will read from:\n");
						filename = stdin.readLine().trim();
						try {
			                 FileInputStream fis = new FileInputStream(filename);
                             ObjectInputStream ois = new ObjectInputStream(fis);
                             DeptManagement manage = (DeptManagement) ois.readObject();
                             System.out.print(filename + " was read\n");
						}
						catch(ClassNotFoundException e) {
							System.out.print("Class not found exception\n");
						}

						catch(NotSerializableException e_1) {
							System.out.print("Not serializable exception\n");
						}
						catch(IOException e_2) {
							System.out.print("Data file read exception\n");
						}
						break;
					case '?':
						//Display Menu
						printMenu();
						break;
					default:
						System.out.print("Unknown action\n");
						break;
					}
				}
				else {
					System.out.print("Unknown action\n");
				}
			} while ( input1 != 'Q' || line . length () != 1);
		}
		catch(IOException exception) {
			System.out.print("IO Exception\n");
		}
	}

	/** The method printMenu displays the menu to a user **/
	public static void printMenu() {
		System.out.print("Choice\t\tAction\n" +
						 "------\t\t------\n" +
						 "A\t\tAdd a department\n" +
						 "C\t\tCreate a DeptManagement\n" +
						 "D\t\tSearch a department\n" +
						 "E\t\tSearch a faculty\n" +
						 "L\t\tList departments\n" +
						 "N\t\tSort by department names\n" +
						 "O\t\tSort by department faculty numbers\n" +
						 "P\t\tSort by current faculty name\n" +
						 "Q\t\tQuit\n" +
						 "R\t\tRemove a department\n" +
						 "T\t\tClose DeptManagement\n" +
						 "U\t\tWrite strings to a text file\n" +
						 "V\t\tRead strings from a text file\n" +
						 "W\t\tSerialize DeptManagement to a data file\n" +
						 "X\t\tDeserialize DeptManagement from a data file\n" +
						 "?\t\tDisplay Help\n");
	}
}