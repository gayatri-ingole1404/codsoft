import java.util.Scanner;

class StudentGradeCalculator
{
	public static void main(String args[])
	{
	int hindiMarks,englishMarks,mathMarks,scienceMarks,socialScienceMarks;
	Scanner input=new Scanner(System.in);

	System.out.println("Enter Marks of Hindi Subject -");
	hindiMarks =input.nextInt();

	System.out.println("Enter Marks of English Subject -");
	englishMarks =input.nextInt();

	System.out.println("Enter Marks of Math Subject -");
	mathMarks =input.nextInt();

	System.out.println("Enter Marks of Science Subject -");
	scienceMarks =input.nextInt();

	System.out.println("Enter Marks of Social Science Subject -");
	socialScienceMarks =input.nextInt();

	int totalMarks=hindiMarks+englishMarks+mathMarks+scienceMarks+socialScienceMarks;
	System.out.println("Total Marks = "+totalMarks+" Out of 500");

	double average=totalMarks/5.0;
	System.out.println("Total Percentage = "+average);

	if(average>=90)
	{
	System.out.println("Grade = 'A'");
	}	
	else if(average>=75)
	{
	System.out.println("Grade = 'B'");
	}

	else if(average>=60)
	{
	System.out.println("Grade = 'C'");
	}

	else if(average>=45)
	{
	System.out.println("Grade = 'D'");
	}
	else
	{
	System.out.println("Grade = 'F'");
	}
        input.close();
	}
    

}