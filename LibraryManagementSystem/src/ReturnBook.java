/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ellieearwood
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ReturnBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Borrow Record ID to return book: ");
        int recordId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM borrow_records WHERE record_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, recordId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("No record found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           
        }
    }
}

