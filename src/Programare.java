import java.util.Scanner;

public class Programare {
    private double id_programare;
    private double cod_bilet_trimitere;
    private Client client;
    private int zi_programare;
    private int luna_programare;
    private int an_programare;
    private int zi_planificare;
    private int luna_planificare;
    private int an_planificare;
    private String sectia;

    public Programare(double id_programare, double cod_bilet_trimitere, Client client, int zi_programare, int luna_programare, int an_programare, int zi_planificare, int luna_planificare, int an_planificare, String sectia) {
        this.id_programare = id_programare;
        this.cod_bilet_trimitere = cod_bilet_trimitere;
        this.client=client;
        this.zi_programare = zi_programare;
        this.luna_programare = luna_programare;
        this.an_programare = an_programare;
        this.zi_planificare = zi_planificare;
        this.luna_planificare = luna_planificare;
        this.an_planificare = an_planificare;
        this.sectia = sectia;
    }

    public double getId_programare() {
        return id_programare;
    }

    public void setId_programare(double id_programare) {
        this.id_programare = id_programare;
    }

    public double getCod_bilet_trimitere() {
        return cod_bilet_trimitere;
    }

    public void setCod_bilet_trimitere(double cod_bilet_trimitere) {
        this.cod_bilet_trimitere = cod_bilet_trimitere;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getZi_programare() {
        return zi_programare;
    }

    public void setZi_programare(int zi_programare) {
        this.zi_programare = zi_programare;
    }

    public int getLuna_programare() {
        return luna_programare;
    }

    public void setLuna_programare(int luna_programare) {
        this.luna_programare = luna_programare;
    }

    public int getAn_programare() {
        return an_programare;
    }

    public void setAn_programare(int an_programare) {
        this.an_programare = an_programare;
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
        this.id_programare=Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti codul biletului de trimitere:");
        this.cod_bilet_trimitere=Double.parseDouble(scanner.nextLine());
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
        this.zi_programare=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti luna programarii:");
        this.luna_programare=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti anul programarii:");
        this.an_programare=Integer.parseInt(scanner.nextLine());
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
        System.out.println("ID-ul programarii este: " + id_programare + "\nCodul biletului de trimitere este:" + cod_bilet_trimitere + "\nZiua programarii este: " + zi_programare + "\nLuna programarii este: " + luna_programare + "\nAnul programarii este: " + an_programare + "\nZiua planificarii este: " + zi_planificare + "\nLuna planificarii este: " + luna_planificare + "\nAnul planificarii este: " + an_planificare + "\nSectia este: " + sectia + "\nProgramarea corespunde lui: " + client.getNume() + " " + client.getPrenume());
    }
}
