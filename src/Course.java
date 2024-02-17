//-----------------------------------------------------
// Title: Course class
// Author: Arda Baran
// Description: This class consists of fundamental elements of a course such as letter grade,credit and the name of the course.
//-----------------------------------------------------

public class Course {
String letterGrade,courseName;
int creditOfCourse;
Course next;
public Course(String courseName,String letterGrade,int creditOfCourse) {//Constructor
	this.courseName=courseName;
	this.letterGrade=letterGrade;
	this.creditOfCourse=creditOfCourse;
	this.next=null;
}
public String getLetterGrade() {
	return letterGrade;
}
public void setLetterGrade(String letterGrade) {
	this.letterGrade = letterGrade;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public int getCreditOfCourse() {
	return creditOfCourse;
}
public void setCreditOfCourse(int creditOfCourse) {
	this.creditOfCourse = creditOfCourse;
}
public Course getNext() {
	return next;
}
public void setNext(Course next) {
	this.next = next;
}




}
