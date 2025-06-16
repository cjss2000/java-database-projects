package services;

import java.util.Scanner;

public class MovieView {

    private Scanner scanner;

    public MovieView(){
        this.scanner = new Scanner(System.in);
    }

    public void displayMenuBoard(){
        System.out.println("****Welcome to the internal Movie Database System****");
        System.out.println(" 1) Display all movies");
        System.out.println(" 2) Add a movie");
        System.out.println(" 3) Remove a movie");
        System.out.println(" 4) Edit movie data");
        System.out.println(" 5) Kill Application");
    }

    public String userInput(String controllerMessage){
        String userInput = scanner.nextLine();
        return userInput;
    }

    public int numberInput(String controllerMessage){
       return scanner.nextInt();

    }

    public void displayMessage(String message){
        System.out.println(message);
    }
}
