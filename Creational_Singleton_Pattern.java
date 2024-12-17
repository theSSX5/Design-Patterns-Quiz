
class Singleton {
   
    private static Singleton singleInstance;

    private Singleton() {
        System.out.println("Singleton instance created!");
    }

    public static synchronized Singleton getInstance() {
        if (singleInstance == null) {
            singleInstance = new Singleton();
        }
        return singleInstance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}


public class SingletonDemo {
    public static void main(String[] args) {
        
        Singleton instance1 = Singleton.getInstance();
        instance1.showMessage();

        Singleton instance2 = Singleton.getInstance();
        System.out.println("Are both instances the same? " + (instance1 == instance2));
    }
}
