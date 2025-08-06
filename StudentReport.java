import java.util.*;
public class StudentReport {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char Choice;
        do {
            System.out.println("Enter your Subjects :");
            int subjects = input.nextInt();

            // create 1D Array to store subjects
            int[] marks = new int[subjects];
            // Input for subjects for loop
            for (int i = 0; i < subjects; i++) {
                System.out.println("Enter your subject " + (i + 1) + ": ");
                marks[i] = input.nextInt();

                //Validate using while loop
                while (marks[i] < 0 || marks[i] > 100) {
                    System.out.println("Invalid! Enter again (0-100):");
                    marks[i] = input.nextInt();
                }
            }
            //Calculate total and percentage
            int total = 0;
            for (int i = 0; i < subjects; i++) {
                total += marks[i];
            }
            double percentage = (double) total /subjects;

            //Display all subjects marks using for-each loop
            System.out.println("\n-----Subject Marks-----");
            for (int m :marks){
                System.out.println("Marks: "+m);
            }
            System.out.println("Total Marks: " + total);

            System.out.printf("Percentage: %.2f%%\n",percentage);

            // Grade  and pass /fail using if-else-if
            String grade;
            if(percentage >= 90){
                grade ="A";
            }else if(percentage >= 80){
                grade ="B";
            }else if(percentage >= 70) {
                grade = "C";
            }else if(percentage >= 60) {
                grade = "D";
            }else if(percentage >= 50) {
                grade = "E";
            }else{
                grade = "F";
            }
            System.out.println("Grade: "+grade);

            //Pass fail using if-else
            if (percentage >=40) {
                System.out.println("Status: PASS");
            }else {
                System.out.println("Status: FAIL");
            }
            //Ask user to continue using do-while loop
            System.out.println("\nDo you want to enter another Student? (y/n):");
            Choice=input.next().charAt(0);
        }while (Choice=='y' || Choice=='Y');

        input.close();
    }
}
