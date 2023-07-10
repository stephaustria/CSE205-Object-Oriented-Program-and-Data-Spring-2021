//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Stephen Austria
//    StudentID: 1220159551
//      Lecture: T Th 1:30-2:45
//  Description: This class is a utility class that will be used to sort a list of Departments.

import java.util.*;

public class Sorts
{
	public static void sort(ArrayList<Department> deptList, Comparator<Department> xComparator) {

		//sorting method
		int a = 0;
		while(a < deptList.size()) {
			Department depart = deptList.get(a);
			int b = 0;
			while(b < deptList.size()) {
				int comp = xComparator.compare(depart, deptList.get(b));
				if (comp < 0) {
					Department d = deptList.get(b);
					deptList.set(b, depart);
					deptList.set(a, d);
					depart = d;
				}
				b++;
			}
			a++;
		}
		
	} //end sort
} //end class Sorts
