package mvc;

import mvc.Controller.Controller;
import mvc.View.ConsoleView;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        Choice();
    }

    public static void Choice()
    {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        boolean choice = false;
        do{
            System.out.println("Faite un choix :");
            System.out.println("1. Lancer l'application en mode Console");
            System.out.println("2. Lancer l'application en mode Application");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    ConsoleView consoleView = new ConsoleView(controller);
                    break;
                case "2":
                    controller.initialize();
                    controller.start();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }while(false);
    }

}
