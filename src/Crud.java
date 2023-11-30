
import java.sql.*;
import java.util.Scanner;

public class Crud {
    static final String dbUrl = "jdbc:mysql://localhost:3306/employee_db";
    static final String userName = "root";
    static final String password = "Hemz@12345";
    static Scanner scanner = new Scanner(System.in);
    static final String resultQuery = "select * from emp_table";
    static final String deleteQuery = "delete from emp_table where id=?";


    public static void createSingleEmployee() {
        Connection connection = null;
        try {
            System.out.println("Enter Employee id");
            int emp_id = scanner.nextInt();
            System.out.println("Enter Employee Name");
            String emp_name = scanner.next();
            System.out.println("Enter Employee salary");
            int sal = scanner.nextInt();
            System.out.println("Enter Employee Location");
            String location = scanner.next();
            System.out.println("Loading...");
            Thread.sleep(1000);
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement prepareStatement = connection.prepareStatement("insert into emp_table values (?,?,?,?)");
            prepareStatement.setInt(1, emp_id);
            prepareStatement.setString(2, emp_name);
            prepareStatement.setInt(3, sal);
            prepareStatement.setString(4, location);
            prepareStatement.executeUpdate();
            System.out.println("Employee Created...!");
        } catch (SQLException exception) {
            System.out.println(exception);
        } catch (InterruptedException exception) {
            System.out.println(exception);
        } catch (ClassNotFoundException exception) {
            System.out.println(exception);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException exception) {
                System.out.println(exception);
            }
        }
    }
    public static  void createMultipleEmployees(){
        Connection connection = null;
        System.out.println("Enter The Count of The Employees");
        int emp_count = scanner.nextInt();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection(dbUrl,userName,password);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into emp_table values(?,?,?,?)");
            for (int i = 1; i<=emp_count;i++){
                System.out.println("Add Employee "+i);
                System.out.println("Enter Employee Id");
                int emp_id = scanner.nextInt();
                System.out.println("Enter Employee Name");
                String emp_name = scanner.next();
                System.out.println("Enter Salary");
                int emp_sal = scanner.nextInt();
                System.out.println("Enter The Location");
                String emp_location = scanner.next();
                System.out.println("Employee "+i+" is Added\n");
                preparedStatement.setInt(1,emp_id);
                preparedStatement.setString(2,emp_name);
                preparedStatement.setInt(3,emp_sal);
                preparedStatement.setString(4,emp_location);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            if (emp_count > 1) {
                System.out.println(emp_count+" Employees Added");
            }
        } catch (ClassNotFoundException exception){
            System.out.println(exception);
        }catch (SQLException exception){
            System.out.println(exception);
        }finally {
            try{
                connection.close();
            }catch (SQLException exception){
                System.out.println(exception);
            }
        }
    }

    public static void fetchAllEmployees() throws ClassNotFoundException, SQLException, InterruptedException {
        System.out.println("Fetching Data...Wait...");
        Thread.sleep(2000);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        Statement statement = connection.createStatement();
        statement.executeQuery(resultQuery);
        ResultSet resultSet = statement.executeQuery(resultQuery);
        while (resultSet.next()) {
            System.out.println("\n-------> Employee " + resultSet.getInt(1) + " Details <-------\n");
            System.out.println("Id : " + resultSet.getInt(1));
            System.out.println("Name : " + resultSet.getString("ename"));
            System.out.println("Salary : " + resultSet.getInt("sal"));
            System.out.println("Location : " + resultSet.getString("location"));
            System.out.println("---------------------");
        }

    }

    public static void fetchEmployeeWithId() throws ClassNotFoundException, SQLException, InterruptedException {
        System.out.println("Enter ID");
        int empId = scanner.nextInt();
        System.out.println("Fetching Employee...Wait");
        Thread.sleep(1500);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        PreparedStatement prepareStatement = connection.prepareStatement("select * from emp_table where id =?");
        prepareStatement.setInt(1, empId);


        ResultSet resultSet = prepareStatement.executeQuery();


        while (resultSet.next()) {
            System.out.println("\n-------> Employee Details <-------\n");
            System.out.println("Id : " + resultSet.getInt(1));
            System.out.println("Name : " + resultSet.getString("ename"));
            System.out.println("Salary : " + resultSet.getInt("sal"));
            System.out.println("Location : " + resultSet.getString("location"));
            System.out.println("-----------------------");
        }
    }

    public static void updateEmpName() throws ClassNotFoundException, SQLException, InterruptedException {
        System.out.println("Enter Emp id");
        int emp_id = scanner.nextInt();
        System.out.println("Enter the new Name");
        String emp_new_name = scanner.next();
        System.out.println("Loading...Wait...");
        Thread.sleep(1000);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        PreparedStatement prepareStatement = connection.prepareStatement("update emp_table set ename =? where id =?");
        prepareStatement.setString(1, emp_new_name);
        prepareStatement.setInt(2, emp_id);
        prepareStatement.executeUpdate();
        System.out.println("Employee Name Updated..!");
    }

    public static void updateEmpSalary() throws ClassNotFoundException, SQLException, InterruptedException {
        System.out.println("Enter Emp id");
        int emp_id = scanner.nextInt();
        System.out.println("Enter the new Salary");
        int emp_new_sal = scanner.nextInt();
        System.out.println("Loading...Wait...");
        Thread.sleep(1000);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        PreparedStatement prepareStatement = connection.prepareStatement("update emp_table set sal =? where id =?");
        prepareStatement.setInt(1, emp_new_sal);
        prepareStatement.setInt(2, emp_id);
        prepareStatement.executeUpdate();
        System.out.println("Salary Updated..!");
    }

    public static void updateEmpLocation() throws ClassNotFoundException, SQLException, InterruptedException {
        System.out.println("Enter Emp id");
        int emp_id = scanner.nextInt();
        System.out.println("Enter the new Location");
        String emp_new_location = scanner.next();
        System.out.println("Loading...Wait...");
        Thread.sleep(1000);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        PreparedStatement prepareStatement = connection.prepareStatement("update emp_table set location =? where id =?");
        prepareStatement.setString(1, emp_new_location);
        prepareStatement.setInt(2, emp_id);
        prepareStatement.executeUpdate();
        System.out.println("Employee Location Updated..!");
    }

    public static void deleteEmployee() throws ClassNotFoundException, SQLException, InterruptedException {
        System.out.println("Enter Emp ID");
        int emp_id = scanner.nextInt();
        System.out.println("Deleting Employee...Wait...");
        Thread.sleep(1000);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, emp_id);
        preparedStatement.executeUpdate();
        System.out.println("Employee Deleted...!");
    }
}
