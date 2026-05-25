package com.studentmanagement.main;

import java.util.Scanner;

import com.studentmanagement.dao.StudentDAO;
import com.studentmanagement.dao.StudentDAOImpI;
import com.studentmanagement.model.Student;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO dao = new StudentDAOImpI();

        while(true) {

            System.out.println("\n1.Add");
            System.out.println("2.View");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("5.Exit");

            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch(ch) {

                case 1:

                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();

                    dao.addStudent(
                        new Student(id, name, dept, marks)
                    );

                    break;

                case 2:

                    dao.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();

                    System.out.print("New Marks: ");
                    double m = sc.nextDouble();

                    dao.updateStudent(uid, m);

                    break;

                case 4:

                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();

                    dao.deleteStudent(did);

                    break;

                case 5:

                    System.exit(0);
            }
        }
    }
}