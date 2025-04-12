public class UserManager {
    public void process() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Processing user " + i);
            printEvenOrOdd(i);
            rewardIfTenth(i);
        }
    }

    private void printEvenOrOdd(int number) {
        if (number % 2 == 0) {
            System.out.println("User is even.");
        } else {
            System.out.println("User is odd.");
        }
    }

    private void rewardIfTenth(int number) {
        if (number % 10 == 0) {
            System.out.println("User " + number + " receives a special reward!");
        }
    }
    // Main
    public static void main(String[] args) {
        UserManager manager = new UserManager();
        manager.process();
    }
}
