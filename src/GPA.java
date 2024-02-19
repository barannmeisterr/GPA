
public class GPA {
	//-----------------------------------------------------
	// Title: Course class
	// Author: Arda Baran
	// Description: The purpose of this class is to calculate general point average and control the satisfactory function.
	                 //if gpa below probation limit .you can not take new courses next semester.
	//-----------------------------------------------------
	
	
	
	
	
	
	
	Course course;

	public final int totalCreditsRequired = 136;

	public final double minGpaForDegree=2.00;

	public GPA() {
	this.course=null;
}

	
	public Course addCourse(Course cNode,String c_name,String l_grade,int c_credit) {
	if(cNode == null) {
		return new Course(c_name,l_grade,c_credit);
	}

	cNode.setNext(addCourse(cNode.getNext(),c_name,l_grade,c_credit));
	return cNode;
}

	public void addCourse(String c_name,String l_grade,int c_credit) {
	course = addCourse(course,c_name,l_grade,c_credit);
}
public GPA changeLetterGrade(GPA gpa,String c_name,String l_grade) {//this function is for re-taken courses.
	
	if(gpa.course==null) {
		return gpa;
	}
	
	if (gpa.course.getCourseName().equals(c_name)) {
		gpa.course.setLetterGrade(l_grade);
	}
	Course current =gpa.course;
	while(current.getNext()!=null) {
		if(current.getCourseName().equals(c_name)) {
			current.setLetterGrade(l_grade);
		}
		current=current.getNext();
	
	}
return gpa;
}
	public int NumOfCoursesTaken() {
	int size = 0;
	Course curr = course;
	while(curr!=null) {
		size = size+1;
	     curr=curr.getNext();
	}
	return size;
	}
	public double calculateGpa() {//calculates overall gpa.
	
	int creditAttemp=0;
	double achievedPoints = 0.00;
      
     Course current = course;

    while (current!=null) {
    	
            achievedPoints += convertLetterGradeToNumericGrade(current.getLetterGrade()) * current.getCreditOfCourse();
    	
    	creditAttemp +=current.getCreditOfCourse(); 
    
           current = current.getNext();
    }
     
    return achievedPoints / creditAttemp;

}
	public String IncrementLetterGrade(String letterGrade) {
		switch(letterGrade) {
			
		case "DD": 
			return "DC";
		case "DC":
			return "CC";
		case "CC":
			return "CB";
		case "CB":
			return "BB";
		case "BB":
			return "BA";
		case "BA":
		return "AA";
		default:
			return letterGrade;
		
		}
	}

public double convertLetterGradeToNumericGrade(String letterGrade) {
	switch(letterGrade) {
	case "AA":
		return 4.00;
	case "BA":
	     return 3.50;
	case "BB":
	      return 3.00;
	case "CB":
	       return 2.50;
	case "CC":
	       return 2.00;
	case "DC":
	       return 1.50;
	case "DD":
	       return 1.00;
	default:
        return 0.00;
	
	}
}
public int totalNumOfCreditsEarned() {
	int creditEarned=0;	      
     Course current = course;

    while (current!=null && (current.getLetterGrade().equals("AA")||current.getLetterGrade().equals("BA")||current.getLetterGrade().equals("BB")|| current.getLetterGrade().equals("CB")||current.getLetterGrade().equals("CC")||current.getLetterGrade().equals("DC")||current.getLetterGrade().equals("DD")||current.getLetterGrade().equals("FF"))	) {    	
    	if(!current.getLetterGrade().equals("FF")) {
    		creditEarned +=current.getCreditOfCourse(); 
    	}
    	
    	
    
           current = current.getNext();
    }
return creditEarned;

}
public void ccr() {
	 // Example: Adjust based on the actual program requirements
    int totalCreditsEarned = totalNumOfCreditsEarned();

    System.out.println("-------------------------------------------------------------");
    System.out.println("                   CURRICULUM COMPLIANCE REPORT               ");
    System.out.println("-------------------------------------------------------------");
    System.out.println("Name Surname: Arda BARAN");
    System.out.println("Student No: 19172802022");
    System.out.println("Faculty / Institute: Faculty of Engineering");
    System.out.println("Program: Computer Engineering (Vers: 2021)");
    System.out.println("Registration Date: 26.01.2022");
    System.out.println("Degree Awarded: Undergraduate");
    System.out.println("Secondary Field: Applied Data Analytics");
    System.out.println("-------------------------------------------------------------");
    System.out.printf("Minimum GPA for Degree: %.2f\n", minGpaForDegree );
    System.out.printf("Minimum GPA for Satisfactory: %.2f\n", probationLimit(totalCreditsEarned) );
    System.out.println("Total Number of Credits Required for Degree: " + totalCreditsRequired);
    System.out.println("Total Number of Credits Earned: " + totalCreditsEarned);
    System.out.println("Total Number of Credits Remained for Degree: " + (totalCreditsRequired - totalCreditsEarned) );
    System.out.println("-------------------------------------------------------------");
    System.out.printf("Current GPA: %.2f\n", calculateGpa());
    satisfactoryPrint();
    System.out.println("-------------------------------------------------------------");

}
public void printCourses() {
    
    Course current = course;
    while (current != null) {
        System.out.printf("| %-10s | %-1s |\n", current.getCourseName(), current.getLetterGrade());
        current = current.getNext();
    }

    System.out.println("-------------------------------------------------------------");
}
public double probationLimit(int totalCredit) {
	//--------------------------------------------------------
	// Summary: Probation Limit depends on the total credit
	// that you earned from the beginning to the current term.
	//--------------------------------------------------------
	
	if(totalCredit >= 0 && totalCredit <= 50) {
		return 1.60;
	}else if(totalCredit > 50 && totalCredit <= 100) {
		return 1.70;
	}else {
		return 1.80;
	}

}
public boolean checkSatisfactory() {
	double gno = calculateGpa();
	
	int earnedCredit = totalNumOfCreditsEarned();
	return (Math.round(gno) >= probationLimit(earnedCredit));
}
public void satisfactoryPrint() {
	System.out.println("");
	if(checkSatisfactory()) {
		System.out.println("Probation Status: Satisfactory");
	}else {
		System.out.println("Probation Status: Unsatisfactory");
	}
}
public String [] getLetterGradesOfCourses(GPA gpa) {
	String [] lettergrades = new String[gpa.NumOfCoursesTaken()];
	if(gpa.course==null) {
		return null;
	}
	
	if(gpa.course.getLetterGrade().equals("FF")
			||gpa.course.getLetterGrade().equals("DD")||
			gpa.course.getLetterGrade().equals("DC")||
			gpa.course.getLetterGrade().equals("CC")||
			gpa.course.getLetterGrade().equals("CB")||
			gpa.course.getLetterGrade().equals("BB")||
			gpa.course.getLetterGrade().equals("BA")||
			gpa.course.getLetterGrade().equals("AA")) {
		
		lettergrades[0] = gpa.course.getLetterGrade();
			
	}
	Course curr = course;
	int i = 0;
	while(curr!=null && i < gpa.NumOfCoursesTaken()) {
		if(curr.getLetterGrade().equals("FF")||curr.getLetterGrade().equals("DD")||
				curr.getLetterGrade().equals("DC")||curr.getLetterGrade().equals("CC")||
				curr.getLetterGrade().equals("CB")||curr.getLetterGrade().equals("BB")||
				curr.getLetterGrade().equals("BA")||curr.getLetterGrade().equals("AA")) {
			lettergrades[i]=curr.getLetterGrade();
		}
		curr= curr.getNext();
		i++;
		
	}
	return lettergrades;
}
}
