import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Book Title:");
        String title = scanner.nextLine();

        System.out.println("Enter Author:");
        String author = scanner.nextLine();

        System.out.println("Is the book available? (true/false):");
        boolean isAvailable = scanner.nextBoolean();

        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO books (title, author, is_available) VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setBoolean(3, isAvailable);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("New book added successfully.");
            } else {
                System.out.println("Failed to add book.");
            }

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }
}
