package services.database_config;

public class TestSingletonExample {

    public static void main(String[] args) {
        // The line below is no longer valid as SingletonExample has a private constructor
        // and cannot be instantiated from anywhere but the class SingletonExample itself
        // SingletonExample singletonExample = new SingletonExample();

        // To call a static method (not only for this example, but in general)
        // we need to follow the syntax of: Classname.methodName()

        SingletonExample singletonExample1 = SingletonExample.getInstance();
        SingletonExample singletonExample2 = SingletonExample.getInstance();
        SingletonExample singletonExample3 = SingletonExample.getInstance();
    }

}
