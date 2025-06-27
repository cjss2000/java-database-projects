package views;

import java.util.Scanner;

public class MovieView {

    private Scanner scanner;

    public MovieView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenuBoard() {
        System.out.println("****Welcome to the internal Movie Database System****");
        System.out.println(" 1) Display all movies");
        System.out.println(" 2) Add a movie");
        System.out.println(" 3) Remove a movie");
        System.out.println(" 4) Change/Edit movie name");
        System.out.println(" 5) Specific Movie details");
        System.out.println(" 6) Movie ID check");
        System.out.println(" 7) Kill application");
    }

    public String userInput(String controllerMessage) {
        System.out.println(controllerMessage + ": ");
        String userInput = scanner.nextLine();
        if (userInput.isEmpty()) {
            userInput = scanner.nextLine();
        }
        return userInput;
    }

    public int numberInput(String controllerMessage) {
        System.out.println(controllerMessage + ": ");
        return scanner.nextInt();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
