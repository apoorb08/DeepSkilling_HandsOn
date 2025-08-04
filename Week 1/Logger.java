public class Logger {

    // The single, static instance of the Logger.
    // 'volatile' ensures that changes to this variable are visible to all threads.
    private static volatile Logger instance;

    // The private constructor prevents any other class from instantiating.
    private Logger() {
        // This message will print only once when the single instance is created.
        System.out.println("Logger instance created.");
    }

    /**
     * Provides the global point of access to the Logger instance.
     * Uses double-checked locking for thread-safe lazy initialization.
     * @return The single instance of the Logger.
     */
    public static Logger getInstance() {
        // First check (not synchronized) improves performance.
        // The instance is returned directly if it already exists.
        if (instance == null) {
            // Synchronize on the class object to ensure thread safety.
            synchronized (Logger.class) {
                // Second check ensures another thread didn't create the instance
                // while the current thread was waiting for the lock.
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    /**
     * A sample method to demonstrate the logger's functionality.
     * @param message The message to be logged.
     */
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
