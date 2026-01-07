import java.sql.*;
import java.util.Scanner;

public class UpdateStudent {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Roll no whose data id to be Updated: ");
        int RollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Marks: ");
        int marks = sc.nextInt();

        sc.close();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "system",
                    "@pass"
            );

            PreparedStatement stmt =
                    con.prepareStatement("UPDATE students SET name=?, marks=? WHERE RollNo=?");

            stmt.setString(1, name);
            stmt.setInt(2, marks);
            stmt.setInt(3, RollNo);

            int count = stmt.executeUpdate();
            System.out.println(count + " row(s) updated successfully");

            con.close();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
