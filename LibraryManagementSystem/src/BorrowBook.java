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

public class BorrowBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Book ID to borrow: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO borrow_records (user_id, book_id, borrow_date) VALUES (?, ?, NOW())";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, bookId);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Failed to borrow book.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }
    }
}

