
public class StuParser {
	public static Student parseStringToStudent(String lineToParse) {
		String[] intel = lineToParse.split("/");
		if(intel[0].equalsIgnoreCase("Graduate")) {
			Student student = new Graduate(intel[1], intel[2], intel[3], Integer.parseInt(intel[4]), Double.parseDouble(intel[5]), Double.parseDouble(intel[6]));
			return student;
		}
		else if(intel[0].equalsIgnoreCase("UnderGrad")) {
			boolean state = false;
			if(intel[6].equalsIgnoreCase("InState"))
				state = true;
			Student s = new UnderGrad(intel[1], intel[2], intel[3], Integer.parseInt(intel[4]), Double.parseDouble(intel[5]), state, Double.parseDouble(intel[7]));
				return s;
		}
		return null;
	}
}
