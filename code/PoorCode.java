public class UserManager {
    public void process() {
        // Long method with nested logic, duplication, and no separation of concerns
        for (int i = 1; i <= 20; i++) {
            System.out.println("Processing user " + i);
            if (i % 2 == 0) {
                System.out.println("User is even.");
            } else {
                System.out.println("User is odd.");
            }

            if (i % 10 == 0) {
                System.out.println("User " + i + " receives a special reward!");
            }
        }

        for (int i = 1; i <= 20; i++) {
            System.out.println("Processing user " + i);
            if (i % 2 == 0) {
                System.out.println("User is even.");
            } else {
                System.out.println("User is odd.");
            }

            if (i % 10 == 0) {
                System.out.println("User " + i + " receives a special reward!");
            }
        }
    }
    // Main
    public static void main(String[] args) {
        UserManager manager = new UserManager();
        manager.process();
    }
}
