import java.util.Scanner;

public class Medic extends Personal {
    private double cod_parafa;
    private String specializare;
    private boolean rezident;
    private boolean garda;
    public Medic(double cnp, String nume, String prenume, String sectie, int zi_angajare, int luna_angajare, int an_angajare, double salariu, String nr_telefon, String email, double cod_parafa, String specializare, boolean rezident, boolean garda) {
        super(cnp, nume, prenume, sectie, zi_angajare, luna_angajare, an_angajare, salariu, nr_telefon, email);
        this.cod_parafa = cod_parafa;
        this.specializare = specializare;
        this.rezident = rezident;
        this.garda = garda;
}

    public double getCod_parafa() {
        return cod_parafa;
    }

    public String getSpecializare() {
        return specializare;
    }

    public boolean isRezident() {
        return rezident;
    }

    public boolean isGarda() {
        return garda;
    }

    public void setCod_parafa(double cod_parafa) {
        this.cod_parafa = cod_parafa;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public void setRezident(boolean rezident) {
        this.rezident = rezident;
    }

    public void setGarda(boolean garda) {
        this.garda = garda;
    }

    @Override
    public void CitirePersonal() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti cnp:");
        this.cnp=Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti numele:");
        this.nume=scanner.nextLine();
        System.out.println("Introduceti prenumele:");
        this.prenume=scanner.nextLine();
        System.out.println("Introduceti sectia:");
        this.sectie=scanner.nextLine();
        System.out.println("Introduceti ziua angajarii:");
        this.zi_angajare=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti luna angajarii:");
        this.luna_angajare=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti anul angajarii:");
        this.an_angajare=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti salariul:");
        this.salariu=Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti numarul de telefon:");
        this.nr_telefon=scanner.nextLine();
        System.out.println("Introduceti adresa de email:");
        this.email=scanner.nextLine();
        System.out.println("Introduceti codul parafei:");
        this.cod_parafa=Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti specializarea:");
        this.specializare=scanner.nextLine();
        System.out.println("Este rezident?:");
        this.rezident=Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Este medic de garda?:");
        this.garda=Boolean.parseBoolean(scanner.nextLine());;}
        @Override
    public void AfisarePersonal(){
        System.out.println("CNP:" + this.cnp + "\nNumele:" + this.nume + "\nPrenumele:" + this.prenume + "\nSectia: " + this.sectie +"\nZiua angajarii: " + this.zi_angajare + "\nLuna angajarii: " + this.luna_angajare + "\nAnul angajarii: " + this.an_angajare + "\nSalariul : " + this.salariu + "\nNumarul de telefon: " + this.nr_telefon + "\nAdresa de email: " + this.email + "\nCod parafa: "+ this.cod_parafa + "\nSpecializarea: "+ this.specializare + "\nESte rezident: "+ this.rezident + "\nEste medic de garda: "+ this.garda);
    }
}

