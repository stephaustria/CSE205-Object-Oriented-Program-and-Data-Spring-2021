// Assignment #: 1
//         Name: Stephen Austria
//    StudentID: 1220159551
//      Lecture: Tuesday and Thursday 1:30-2:45pm
//  Description: This class reads an integer from a keyboard and prints it out
//               along with other messages.

import java.util.Scanner;  // use the Scanner class located in the "java.util" directory

public class Assignment1 {
  public static void main (String[] args) {

     int number;

     Scanner scan = new Scanner(System.in);

     number = scan.nextInt();     // read an integer entered by a user

    // display the number with other messages
    System.out.print("This program reads an integer from a keyboard,\n"
                   + "and prints it out on the display screen.\n"
                   + "The number is:" + number + "\n"
                   + "Make sure that you get the exact same output as the expected one!\n");
  }
}


