package services.database_config;

public class SingletonExample {

    private static SingletonExample singletonObject;

    private int id;
    private String title;

    private SingletonExample() {
        this.id = 0;
        this.title = "N/A";
    }

    public static SingletonExample getInstance() {
        if (singletonObject == null) {
            System.out.println("Calling getInstance() for the first time, creating an object");
            singletonObject = new SingletonExample();
        }
        System.out.println("Object created, returning the object value");
        System.out.println("--------------------------------------------");
        return singletonObject;
    }
}