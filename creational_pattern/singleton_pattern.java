public class singleton_pattern {
    public class AirforceOne {

        // The sole instance of the class
        private static AirforceOne onlyInstance;
    
        // Make the constructor private so its only accessible to
        // members of the class.
        private AirforceOne() {
        }
    
        public void fly() {
            System.out.println("Airforce one is flying...");
        }
    
        // Create a static method for object creation
        // synchronized public static AirforceOne getInstance() //fixing multi-threading in singleton-pattern
         // The sole instance of the class
    // private static AirforceOne onlyInstance = new AirforceOne(); // another pattern to fix multi-threading in singleton pattern
        public static AirforceOne getInstance() {
    
            // Only instantiate the object when needed.
            if (onlyInstance == null) {
                onlyInstance = new AirforceOne();
            }
    
            return onlyInstance;
        }
    }
    
    public class Client {
    
        public void main() {
            AirforceOne airforceOne = AirforceOne.getInstance();
            airforceOne.fly();
        }
    }

    // Double-checked Locking pattern
    public class AirforceOneWithDoubleCheckedLocking {

        // The sole instance of the class. Note its marked volatile
        private volatile static AirforceOneWithDoubleCheckedLocking onlyInstance;
    
        // Make the constructor private so its only accessible to
        // members of the class.
        private AirforceOneWithDoubleCheckedLocking() {
        }
    
        public void fly() {
            System.out.println("Airforce one is flying...");
        }
    
        // Create a static method for object creation
        synchronized public static AirforceOneWithDoubleCheckedLocking getInstance() {
    
            // Only instantiate the object when needed.
            if (onlyInstance == null) {
                // Note how we are synchronizing on the class object
                synchronized (AirforceOneWithDoubleCheckedLocking.class) {
                    if (onlyInstance == null) {
                        onlyInstance = new AirforceOneWithDoubleCheckedLocking();
                    }
                }
            }
    
            return onlyInstance;
        }
    }
}
