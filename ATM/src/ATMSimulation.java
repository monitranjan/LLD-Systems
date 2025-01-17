public class ATMSimulation {
    public static void main(String[] args) {
        ATM atm1 = new ATM();
        ATM atm2 = new ATM();

        // Simulating user 1 actions in a separate thread
        Thread user1 = new Thread(() -> {
            System.out.println("User 1 starting transactions...");
            atm1.start();
        });

        // Simulating user 2 actions in a separate thread
        Thread user2 = new Thread(() -> {
            System.out.println("User 2 starting transactions...");
            atm2.start();
        });

        // Start both threads
        user1.start();
        user2.start();

        // Wait for both threads to finish
        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Both users have completed their transactions.");
    }
}