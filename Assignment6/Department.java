// Assignment #: 6
// Arizona State University - CSE205
// Name: Stephen Austria 
// Student ID: 1220159551
// Lecture Date and Time: Tuesday and Thursday 1:30 - 2:45

public class Department
{
     private String name;
     private int numberOfFaculty;
     private String university;

     public Department()
     {
           name = "?";
           numberOfFaculty = 0;
           university = "?";
     }
     //accesssor method
     public String getDeptName()
     {
           return name;
     }
     public int getNumberOfMembers()
     {
           return numberOfFaculty;
     }
     public String getUniversity()
     {
           return university;
     }

     //mutator methods
     public void setDeptName(String name)
     {
           this.name = name;
     }
     public void setNumberOfMembers(int numFaculty)
     {
           this.numberOfFaculty = numFaculty;
     }
     public void setUniversity(String name)
     {
           this.university = name;
     }

     public String toString()
     {
           return "\nDepartment Name:\t\t" + name + "\nNumber Of Faculty:\t" + numberOfFaculty +
                     "\nUniversity:\t\t" + university + "\n\n";
     }
}


