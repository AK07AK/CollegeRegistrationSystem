package StudentDataBaseApp;

import java.util.Scanner;

public class StudentDataBase {
    private String FirstName;
    private String LastName;
    private int year;
    private int tuitionBalance = 600;
    private String studentId;
    private String courseName;
    private String finalCourseSelected;
    private int dueAmount;
    private final int  courseAmount = 600;
    private static int id =1001;
    private int totalAmount;
    private int paymentMethodOption;
    public StudentDataBase()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name: ");
        this.FirstName= sc.nextLine();

        System.out.println("Enter the Second Name: ");
        this.LastName=sc.nextLine();

        System.out.println("Enter the Year of Study: ");
        this.year=sc.nextInt();

        generateStudentId();
        System.out.println(FirstName+LastName+" Your id is "+studentId);

        if(year==1)
            courseEnroll();
        else
            System.out.println(finalCourseSelected);
        System.out.println("Final Course is: "+finalCourseSelected);
        //payment
        System.out.println("***Payment Section***");
        System.out.println("For "+finalCourseSelected+" Total amount is :  "+totalAmount);
        selectpaymentMethod();
        System.out.println("Proceed to payment ? (Yes or No)");
        String proceed = sc.next();
        if(proceed.equals("Yes"))
        {
            payTuition();
        }

    }
    private String generateStudentId()
    {
         //this will increase the id of each student when this StudentDataBase is called
        studentId = year+""+id;
        id++;
        return studentId;
    }
    private void courseEnroll() {
        System.out.println("***Courses Available***");
        System.out.println("1.ComputerScience\n2.Cyber Security\n3.Information Technology\n4.Artificial Intelligence");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Course Id that you Want to Enroll: ");
        var courseId = sc.nextInt();
        while (true) {
            switch (courseId) {
                case 1:
                    courseName = "Computer Science";
                    break;
                case 2:
                    courseName = "Cyber Security";
                    break;
                case 3:
                    courseName = "Information Technology";
                    break;
                case 4:
                    courseName = "Artificial Intelligence";
                    break;

            }
            System.out.println("You have enrolled to " + courseName);
            System.out.println("Confirm?");
            System.out.println("YES or NO");
            String confirm = sc.next();
            if (confirm.equals("YES")) {
                System.out.println("Welcome to " +courseName+" Department ");
                finalCourseSelected = courseName;
                break;
            }
            else {
                System.out.println("Take time and Choose wisely :)");
            }
        }
         totalAmount = courseAmount;

    }
    private void selectpaymentMethod() {
        Scanner sc = new Scanner(System.in);
        System.out.println("You can Pay the Amount is Two Ways");

        System.out.println("1.Half Yearly\n2.Monthly\n3.fully");

        System.out.println("Enter the Payment Option: ");
        int paymentMethodChoice = sc.nextInt();

        if (paymentMethodChoice == 1) {
            paymentMethodOption = 1;
            System.out.println("Amount need to pay as 2 Half");
            System.out.println("First Half as " + (float) (totalAmount / 2));
            System.out.print("And remaining as " + (float) (totalAmount / 2));
        }
        if (paymentMethodChoice == 2) {
            paymentMethodOption = 2;
            System.out.println("Amount need to pay for 12 months ");
            System.out.println("Monthly " + (float) (totalAmount / 12) + " needs to be paid ");

        }
        if (paymentMethodChoice == 3) {
            paymentMethodOption = 3;
            System.out.println("Amount need to be paid on or before joining of college!");

        }
    }
        public void viewBalance()
        {
            System.out.println("Due Amount is : "+tuitionBalance);
        }
        public void payTuition()
        {
            viewBalance();
            Scanner sc = new Scanner(System.in);
            int cost;
            if(paymentMethodOption==1) {
                System.out.println("Pay "+(float)(totalAmount/2));
                cost = sc.nextInt();
                tuitionBalance=tuitionBalance-(totalAmount/2);

            }
            if(paymentMethodOption==2) {
                System.out.println("Pay "+(float)(totalAmount/12));
                cost = sc.nextInt();
                tuitionBalance=tuitionBalance-(totalAmount/2);
            }
            if(paymentMethodOption==3) {
                System.out.println("Pay "+totalAmount);
                cost = sc.nextInt();
                tuitionBalance=tuitionBalance-(totalAmount/2);

            }
            System.out.println("Thanks for the Payment");
            viewBalance();


        }


    }




    //Display the available Course NOTE: Each course they are enrolling costs $600

    //Students Can view the due amount.

    //Status of the student: Display Student Name, ID , Due they need to pay


