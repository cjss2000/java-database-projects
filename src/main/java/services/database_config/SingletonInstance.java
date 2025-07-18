package services.database_config;

public class SingletonInstance {

    private static SingletonInstance SingletonObject;
    //This is static because this variable belongs to this class itself, and not any other instance of this class potentially being called.

    private int id;


    private SingletonInstance(){
        this.id = 1;
    }

    public static SingletonInstance startInstance(){
        if (SingletonObject == null){
            System.out.println("Calling startInstance() method for the first time, object will now be created");
          //  System.out.println("Instance created with this ID: " + id);
            // Trying to use id variable assigned to it, but unable to call it. Assuming I need a to String method to view it or a getter? I know this is likely not needed, but just want to understand the logic.

            SingletonObject = new SingletonInstance();

        }

        return SingletonObject;
    }

}
