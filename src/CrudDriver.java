import java.sql.*;
import java.util.Scanner;

public class CrudDriver extends Crud {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        boolean rep = true;
        do {
            System.out.println("\n......Select The Input......\n");
            System.out.println("--> 1.Create Employee <--");
            System.out.println("--> 2.View Employees <--");
            System.out.println("--> 3.Update Employee <--");
            System.out.println("--> 4.Delete Employee <--");
            System.out.println("--> 5.Exit <-");
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1 -> {
                    System.out.println("1.Add Single Employee");
                    System.out.println("2.Add Multiple Employees");
                    int emp_input = scanner.nextInt();
                    switch (emp_input){
                        case 1->{
                            createSingleEmployee();
                        }
                        case 2 ->{
                            createMultipleEmployees();
                        }
                    }

                }
                case 2 -> {
                    System.out.println("\n.....Select The Input.....\n");
                    System.out.println("1.View All Employees");
                    System.out.println("2.View Employee Based on Emp ID");
                    int viewInput = scanner.nextInt();
                    switch (viewInput) {
                        case 1 -> {
                            fetchAllEmployees();
                        }
                        case 2 -> {
                            fetchEmployeeWithId();
                        }
                    }

                }
                case 3 -> {
                    System.out.println("....What You want to Update From Employee Table....");
                    System.out.println("1.Name");
                    System.out.println("2.Salary");
                    System.out.println("3.Location");
                    int updateInput = scanner.nextInt();
                    switch (updateInput) {
                        case 1 -> {
                            updateEmpName();
                        }
                        case 2 -> {
                            updateEmpSalary();
                        }
                        case 3 -> {
                            updateEmpLocation();
                        }
                    }
                }
                case 4 -> {
                   deleteEmployee();
                }
                case 5 -> {
                    rep = false;
                    System.out.println("Visit Again...");
                }
                default -> {
                    System.out.println("Input MissMatching");
                }
            }
        } while (rep);


    }


}
