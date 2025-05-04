public class BookTest {
    public static void main(String[] args) {
        testIsAvailable();
    }

    public static boolean isAvailable(String status) {
        return status.equalsIgnoreCase("available");
    }

    public static void testIsAvailable() {
        assert isAvailable("available") : "Test 1 Failed";
        assert !isAvailable("borrowed") : "Test 2 Failed";
        System.out.println("All unit tests passed.");
    }
}
