import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentService {

    private Scanner sc = new Scanner(System.in);

    public void addStudent() {
        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, roll);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, dept);

            ps.executeUpdate();
            System.out.println("Student added successfully.");

        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void displayStudents() {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM student";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("---- Student Records ----");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("roll_no") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("department")
                );
            }

        } catch (Exception e) {
            System.out.println("Error fetching students.");
        }
    }

    public void searchStudent() {
        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Roll Number to search: ");
            int roll = sc.nextInt();

            String sql = "SELECT * FROM student WHERE roll_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, roll);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("roll_no") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("department")
                );
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            System.out.println("Error searching student.");
        }
    }

    public void updateStudent() {
        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Roll Number to update: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new Name: ");
            String name = sc.nextLine();

            System.out.print("Enter new Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new Department: ");
            String dept = sc.nextLine();

            String sql =
                    "UPDATE student SET name=?, age=?, department=? WHERE roll_no=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, dept);
            ps.setInt(4, roll);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            System.out.println("Error updating student.");
        }
    }

    public void deleteStudent() {
        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Roll Number to delete: ");
            int roll = sc.nextInt();

            String sql = "DELETE FROM student WHERE roll_no=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, roll);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting student.");
        }
    }
}
