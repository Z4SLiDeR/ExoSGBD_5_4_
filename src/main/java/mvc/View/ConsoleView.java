package mvc.View;

import mvc.Controller.Controller;
import mvc.Model.BL.Section;
import mvc.Model.BL.Status;
import mvc.Model.DAL.Sections.ISectionDAO;
import mvc.Model.DAL.Sections.SectionDAO;
import mvc.Model.DAL.Status.IStatusDAO;
import mvc.Model.DAL.Status.StatusDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView implements IView{
    private final Scanner scanner;
    private ISectionDAO iSectionDAO;
    private IStatusDAO iStatusDAO;

    public ConsoleView(Controller controller) {
        this.scanner = new Scanner(System.in);
        this.iSectionDAO = new SectionDAO("jdbc:postgresql://localhost/ue1396", "postgres", "Lambrecqjeremy3227");
        this.iStatusDAO = new StatusDAO("jdbc:postgresql://localhost/ue1396", "postgres", "Lambrecqjeremy3227");
        start();
    }

    public void start() {
        System.out.println("Bienvenue dans l'application en ligne de commande !");
        boolean running = true;

        while (running) {
            System.out.println("\nChoisissez une action :");
            System.out.println("1. Afficher les sections");
            System.out.println("2. Afficher les statuts");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    showSections();
                    break;
                case "2":
                    showStatus();
                    break;
                case "3":
                    running = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    public void showStatus() {
        ArrayList<Status> statuses = iStatusDAO.getStatus();
        if (statuses != null && !statuses.isEmpty()) {
            System.out.println("\n\nListe des statuts disponibles :");
            for (Status status : statuses) {
                System.out.println("- " + status.getNom());
            }
        } else {
            System.out.println("Aucun statut disponible.");
        }
    }


    public void showSections(){
        ArrayList<Section> sections = iSectionDAO.getSections();
        if (sections != null && !sections.isEmpty()) {
            System.out.println("\n\nListe des statuts disponibles :");
            for (Section section : sections) {
                System.out.println("- " + section.getNom());
            }
        } else {
            System.out.println("Aucun statut disponible.");
        }
    }

    @Override
    public void setController(Controller control) {

    }

    @Override
    public Controller getController() {
        return null;
    }

    @Override
    public void launchApp() {

    }

    @Override
    public void stopApp() {

    }

    @Override
    public void showPrincipalWindow() {

    }

    @Override
    public void addNewSection() {

    }

    @Override
    public void showAllSections(ArrayList<String> listeSection) {

    }

    @Override
    public void showSection(ArrayList<String> infoSection) {

    }

    @Override
    public void addNewStatus() {

    }

    @Override
    public void showAllStatus(ArrayList<String> listeStatus) {

    }

    @Override
    public void showStatus(ArrayList<String> infoStatus) {

    }
}
