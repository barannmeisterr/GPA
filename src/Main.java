import java.util.Scanner;
import java.util.Locale;

public class Main {
public static double CurrentEarnedPoints(double gpa,int creditsCompleted) {//helper method for possible future report
	return gpa * creditsCompleted ;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	       int choice;
		
	   System.out.println("====================================================================");
 	   System.out.println("|   Press 1 To See Current Curriculum Compliance Report            |");
 	   System.out.println("|   Press 2 To See Possible Future Curriculum Compliance Report    |");
 	   System.out.println("====================================================================");
		
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
        gpa.addCourse("CMPE 371", "FF", 3);
        gpa.addCourse("CMPE 101", "CB", 3);
        
	
	
        
        
        
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

       default:
           System.out.println("Invalid Choice... Please Press 1 or 2!");
   }
	   sc.close();
   
	}
}

   