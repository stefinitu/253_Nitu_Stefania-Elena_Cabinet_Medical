import java.text.*;
import java.util.*;

public class Programare {
    private double idProgramare;
    private double codBiletTrimitere;
    private Client client;
    private int ziProgramare;
    private int lunaProgramare;
    private int anProgramare;
    private int zi_planificare;
    private int luna_planificare;
    private int an_planificare;
    private String sectia;

    public Programare(double idProgramare, double codBiletTrimitere, Client client, int ziProgramare, int lunaProgramare, int anProgramare, int zi_planificare, int luna_planificare, int an_planificare, String sectia) {
        this.idProgramare = idProgramare;
        this.codBiletTrimitere = codBiletTrimitere;
        this.client=client;
        this.ziProgramare = ziProgramare;
        this.lunaProgramare = lunaProgramare;
        this.anProgramare = anProgramare;
        this.zi_planificare = zi_planificare;
        this.luna_planificare = luna_planificare;
        this.an_planificare = an_planificare;
        this.sectia = sectia;
    }

    public double getIdProgramare() {
        return idProgramare;
    }

    public void setIdProgramare(double idProgramare) {
        this.idProgramare = idProgramare;
    }

    public double getCodBiletTrimitere() {
        return codBiletTrimitere;
    }

    public void setCodBiletTrimitere(double codBiletTrimitere) {
        this.codBiletTrimitere = codBiletTrimitere;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getZiProgramare() {
        return ziProgramare;
    }

    public void setZiProgramare(int ziProgramare) {
        this.ziProgramare = ziProgramare;
    }

    public int getLunaProgramare() {
        return lunaProgramare;
    }

    public void setLunaProgramare(int lunaProgramare) {
        this.lunaProgramare = lunaProgramare;
    }

    public int getAnProgramare() {
        return anProgramare;
    }

    public void setAnProgramare(int anProgramare) {
        this.anProgramare = anProgramare;
    }

    public int getZi_planificare() {
        return zi_planificare;
    }

    public void setZi_planificare(int zi_planificare) {
        this.zi_planificare = zi_planificare;
    }

    public int getLuna_planificare() {
        return luna_planificare;
    }

    public void setLuna_planificare(int luna_planificare) {
        this.luna_planificare = luna_planificare;
    }

    public int getAn_planificare() {
        return an_planificare;
    }

    public void setAn_planificare(int an_planificare) {
        this.an_planificare = an_planificare;
    }

    public String getSectia() {
        return sectia;
    }

    public void setSectia(String sectia) {
        this.sectia = sectia;
    }

    public void CitireProg()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti ID-ul programarii:");
        this.idProgramare =Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti codul biletului de trimitere:");
        this.codBiletTrimitere =Double.parseDouble(scanner.nextLine());
        String linie;
            System.out.println("Introduceti tipul de client (minor/major):");
            linie=scanner.next();
            switch(linie.toUpperCase()){
                case "MINOR":
                    this.client=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                    this.client.CitireClienti();
                    break;
                case "MAJOR":
                    this.client=new ClientMajor(" ", " ", " ", " "," "," ",0, " ");
                    this.client.CitireClienti();
                    break;
                default:
                    System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                    break;
            }
            scanner.nextLine();
        System.out.println("Introduceti ziua programarii:");
        this.ziProgramare =Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti luna programarii:");
        this.lunaProgramare =Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti anul programarii:");
        this.anProgramare =Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti ziua planificarii:");
        this.zi_planificare=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti luna planificarii:");
        this.luna_planificare=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti anul planificarii:");
        this.an_planificare=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti sectia:");
        this.sectia=scanner.nextLine();
    }

    public void AfisareProgramare()
    {
        System.out.println("ID-ul programarii este: " + idProgramare + "\nCodul biletului de trimitere este:" + codBiletTrimitere + "\nZiua programarii este: " + ziProgramare + "\nLuna programarii este: " + lunaProgramare + "\nAnul programarii este: " + anProgramare + "\nZiua planificarii este: " + zi_planificare + "\nLuna planificarii este: " + luna_planificare + "\nAnul planificarii este: " + an_planificare + "\nSectia este: " + sectia + "\nProgramarea corespunde lui: " + client.getNume() + " " + client.getPrenume());
    }

        }
