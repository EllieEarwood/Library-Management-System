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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReturnBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Borrow Record ID to return book: ");
        int recordId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Get book ID before deleting the borrow record
            String getBookSql = "SELECT book_id FROM borrow_records WHERE record_id = ?";
            PreparedStatement getBookStmt = conn.prepareStatement(getBookSql);
            getBookStmt.setInt(1, recordId);
            ResultSet rs = getBookStmt.executeQuery();

            int bookId = -1;
            if (rs.next()) {
                bookId = rs.getInt("book_id");
            }
            rs.close();
            getBookStmt.close();

            // Delete borrow record
            String deleteSql = "DELETE FROM borrow_records WHERE record_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(deleteSql);
            pstmt.setInt(1, recordId);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Book returned successfully.");

                // Update book availability back to TRUE
                if (bookId != -1) {
                    String updateSql = "UPDATE books SET is_available = TRUE WHERE book_id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                    updateStmt.setInt(1, bookId);
                    updateStmt.executeUpdate();
                    updateStmt.close();
                }
            } else {
                System.out.println("No record found with the given ID.");
            }

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}


