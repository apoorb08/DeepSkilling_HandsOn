public class SingletonPatternExample {

    public static void main(String[] args) {
        System.out.println("--- Singleton Pattern Demo ---");

        System.out.println("\nGetting the logger instance...");
        Logger logger1 = Logger.getInstance();

        System.out.println("Getting the logger instance again...");
        Logger logger2 = Logger.getInstance();

        // Now, let's check if both variables point to the same object in memory.
        // If the singleton pattern is implemented correctly, they must be identical.
        System.out.println("\nVerifying that both references point to the same instance...");
        if (logger1 == logger2) {
            System.out.println("Success! logger1 and logger2 are the same instance.");
            System.out.println("Object HashCode: " + logger1.hashCode());
        } else {
            System.out.println("Error! A new, separate instance was created.");
        }

        // Use the logger. Since it's a singleton, both variables can be used
        // interchangeably to access the same logging object.
        System.out.println("\nUsing the logger to send messages:");
        logger1.log("This is the first message.");
        logger2.log("This is the second message from the same logger object.");
    }
}
