import java.util.Scanner;
import java.util.Locale;

public class Main {
public static double CurrentEarnedPoints(double gpa,int creditsCompleted) {//helper method for possible future report
	return gpa * creditsCompleted ;
}
public static double RequiredPoint(double desiredGpa,int desiredEarnedCredit,double currentGpa,int currentEarnedCredit) {
	return (desiredGpa * desiredEarnedCredit) - (currentGpa * currentEarnedCredit);
}
public static double RequiredSemesterGpa(double requiredPoint,int semesterCredit) {
	return requiredPoint / semesterCredit;
}
public static boolean controlDesiredGpa(double current, double desired) {
    return current >= desired;
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	       int choice;
		
	   System.out.println("========================================================================================================");
 	   System.out.println("|   Press 1 To See Current Curriculum Compliance Report                                                |");
 	   System.out.println("|   Press 2 To See Possible Future Curriculum Compliance Report                                        |");
 	   System.out.println("|   Press 3 To See Minimum Letter Grades You Have To Take For Per Course To Reach Satisfactory Limit   |");
 	   System.out.println("========================================================================================================");
		
 	  System.out.println("");
	   System.out.print("Choice: ");
	   choice=sc.nextInt();
	  
	   switch(choice) {
	   case 1 :		
		GPA gpa = new GPA();

        //Semester1 
		gpa.addCourse("CMPE 113", "DD", 3);       
		gpa.addCourse("ENG 101", "CC", 3);
		gpa.addCourse("HIST 101", "CB", 2);
        gpa.addCourse("MATH 101", "CB", 4);
        gpa.addCourse("PHYS 105", "DD", 4);
        gpa.addCourse("ART 130 ", "AA", 3);
        
        //Semester2
        gpa.addCourse("CMPE 114", "DD", 3);       
		gpa.addCourse("ENG 102", "DC", 3);
		gpa.addCourse("HIST 102", "CC", 2);
        gpa.addCourse("MATH 102", "CB", 4);
        gpa.addCourse("PHIL 104", "DD", 3);
        gpa.addCourse("SOC 103", "DC", 3);
        
        //Semester3
        gpa.addCourse("CMPE 201", "DD", 3);
        gpa.addCourse("CMPE 223", "DC", 3);
        gpa.addCourse("EE 207", "DC", 3);   
        gpa.addCourse("MATH 203", "DD", 3);
        gpa.addCourse("TUR 101", "DC", 2);
        gpa.addCourse("BIO 110", "CC", 3);
        
        //Semester4
        
        gpa.addCourse("CMPE 232", "CC", 3);
        gpa.addCourse("CMPE 252", "CC", 3);
        gpa.addCourse("MATH 240", "DD", 3);
        gpa.addCourse("TUR 102", "DC", 2);
        gpa.addCourse("LIT 100", "CB", 3);
        
	
        //Semester5
        gpa.addCourse("CMPE 371", "FF", 3);// can be changed by applying this method such as gpa.changeLetterGrade(gpa,"CMPE 371","DD") next terms when you re-take
        gpa.addCourse("CMPE 101", "CB", 3);                         //and pass the course...
        
	
	
        
        
        
        //Semester6
        gpa.addCourse("SPA 101", "DC", 3);
        
        
        
        
        
        
      //Semester7
        gpa.addCourse("CMPE 421", "DD", 3);

        
        
        
        
        
	    //Semester8
        gpa.addCourse("CMPE 472", "BB", 3);
	
        
	
        
        
      
     
        gpa.ccr();
	
        gpa.printCourses();
	break;
	
	   case 2:
		   Scanner sc2 = new Scanner(System.in).useLocale(Locale.US);
		   int totalCreditsEarned, numberOfFutureCourses,credit;
		   double currentGpa;
		   System.out.println("Enter Current Gpa: ");
            currentGpa = sc2.nextDouble();
           System.out.println("Total Number of Credits Earned: ");
            totalCreditsEarned = sc2.nextInt();
            double currentPoint= CurrentEarnedPoints(currentGpa,totalCreditsEarned);
            
           int currentAppliedCredit = totalCreditsEarned;
            // Additional input for future courses
           System.out.println("Enter the number of future courses: ");
            numberOfFutureCourses = sc2.nextInt();

           GPA futureGpa = new GPA();
           for (int i = 0; i < numberOfFutureCourses; i++) {
               System.out.println("Enter Future Course " + (i + 1) + " Grade (AA, BB, etc.): ");
               String grade = sc2.next();
               System.out.println("Enter Future Course " + (i + 1) + " Credit: ");
               credit = sc2.nextInt();
             
               futureGpa.addCourse("FutureCourse" + (i + 1), grade, credit);
               currentPoint+=futureGpa.convertLetterGradeToNumericGrade(grade) * credit;
              currentAppliedCredit+=credit;
           
           }
           double newGpa = currentPoint / currentAppliedCredit;
           int cearned = totalCreditsEarned + futureGpa.totalNumOfCreditsEarned();
           // Display future curriculum compliance report
           System.out.println("-------------------------------------------------------------");
           System.out.println("       FUTURE CURRICULUM COMPLIANCE REPORT       ");
           System.out.println("-------------------------------------------------------------");
           System.out.printf("Current GPA(±1): %.2f\n", newGpa);
           System.out.println("Total Number of Credits Earned: " + cearned);
           
           System.out.println("-------------------------------------------------------------");
           sc2.close();
           break;
	   case 3 : 
		   
		   GPA semesterGpa = new GPA();
		   
		   Scanner sc3 = new Scanner(System.in);
           System.out.println("Please Enter Desired GPA Or Required GPA : ");
		   double desiredGpa = sc3.nextDouble();
		   System.out.println("Please Enter Estimated Total Completed Credits After The End Of Next Semester: ");
		   int creditTotalDesired = sc3.nextInt();
		   System.out.println("Please Enter Your Current GPA: ");
		   double curr_Gpa = sc3.nextDouble();
		   System.out.println("Please Enter Current Completed Credits: ");
		   int currCompletedCredit = sc3.nextInt();		   
		   double neededPoint = RequiredPoint(desiredGpa,creditTotalDesired,curr_Gpa,currCompletedCredit);
		   int semCredit = creditTotalDesired - currCompletedCredit;		  
		   double minReqSemGpa = RequiredSemesterGpa(neededPoint,semCredit);		   
		   System.out.println("You Must Earn Minimum "+neededPoint+" Points To Achieve The Required Status For Next Semester ");
		   System.out.printf("Minimum Required Semester GPA to Achieve The Required Status: %.2f\n ", minReqSemGpa);
		   System.out.println("Enter The Number Of Courses You Will Take Next Semester : ");
		   int size = sc.nextInt();

		   System.out.println("Enter The Credits Of The Courses That You Will Take: " );
		   String initialLetterGrades[] = new String[size];
		   int semCredts[] = new int[size];
		   String courseNames [] = new String[size];
		   for (int i = 0 ; i<size; i++) {
			   initialLetterGrades[i]="DD";
			   courseNames[i]="Course "+(i+1);
			   System.out.println("Course "+(i+1)  +" Credit = ");
			   semCredts[i]=sc.nextInt(); 
		   semesterGpa.addCourse(courseNames[i], initialLetterGrades[i], semCredts[i]);

		   }
		   for(int i = 0 ; i<size && semesterGpa.calculateGpa() < minReqSemGpa;i++) {
			   if(semesterGpa.calculateGpa()<minReqSemGpa) {
					semesterGpa.changeLetterGrade(semesterGpa,courseNames[i],semesterGpa.IncrementLetterGrade(initialLetterGrades[i]));

			   }
			   
		   }

		  String[] changedLetterGrades= semesterGpa.getLetterGradesOfCourses(semesterGpa);
		 for(int i = 0 ; i<size ;i++) {
			 if( semesterGpa.calculateGpa() < minReqSemGpa) {
				 semesterGpa.changeLetterGrade(semesterGpa,courseNames[i],semesterGpa.IncrementLetterGrade(changedLetterGrades[i])); 
			 }else {
				 break;
				 
			 }
		 }
		 
		 System.out.println("Taken Courses And Minimum Required Letter Grades Per Course To Achieve The Required Status ");  
		 semesterGpa.printCourses();
		 System.out.printf("Minimum Semester GPA To Achieve The Required Status: %.2f\n", semesterGpa.calculateGpa() );
		   
		   sc3.close();
           break;
           
       default:
           System.out.println("Invalid Choice...");
   }
	   sc.close();
   
	}
}

   
