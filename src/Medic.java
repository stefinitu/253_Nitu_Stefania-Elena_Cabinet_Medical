import java.util.*;

public class Medic extends Personal {
    private double codParafa;
    private String specializare;
    private boolean rezident;
    private boolean garda;
    public Medic(String cnp, String nume, String prenume, InfoAngajare infoAngajare, String nrTelefon, String email, double codParafa, String specializare, boolean rezident, boolean garda) {
        super(cnp, nume, prenume, infoAngajare, nrTelefon, email);
        this.codParafa = codParafa;
        this.specializare = specializare;
        this.rezident = rezident;
        this.garda = garda;
}

    public double getCodParafa() {
        return codParafa;
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

    public void setCodParafa(double codParafa) {
        this.codParafa = codParafa;
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
        this.cnp=scanner.nextLine();
        System.out.println("Introduceti numele:");
        this.nume=scanner.nextLine();
        System.out.println("Introduceti prenumele:");
        this.prenume=scanner.nextLine();
        System.out.println("Introduceti sectia:");
        this.infoAngajare.setSectie(scanner.nextLine());
        System.out.println("Introduceti ziua angajarii:");
        this.infoAngajare.setZiAngajare(Integer.parseInt(scanner.nextLine()));
        System.out.println("Introduceti luna angajarii:");
        this.infoAngajare.setLunaAngajare(Integer.parseInt(scanner.nextLine()));
        System.out.println("Introduceti anul angajarii:");
        this.infoAngajare.setAnAngajare(Integer.parseInt(scanner.nextLine()));
        System.out.println("Introduceti salariul:");
        this.infoAngajare.setSalariu(Double.parseDouble(scanner.nextLine()));
        System.out.println("Introduceti numarul de telefon:");
        this.nrTelefon =scanner.nextLine();
        System.out.println("Introduceti adresa de email:");
        this.email=scanner.nextLine();
        System.out.println("Introduceti codul parafei:");
        this.codParafa =Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti specializarea:");
        this.specializare=scanner.nextLine();
        System.out.println("Este rezident? (true/false):");
        this.rezident=Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Este medic de garda? (true/false):");
        this.garda=Boolean.parseBoolean(scanner.nextLine());;}
        @Override
    public void AfisarePersonal(){
        System.out.println("CNP:" + this.cnp + "\nNumele:" + this.nume + "\nPrenumele:" + this.prenume + "\nSectia: " + this.infoAngajare.getSectie() +"\nZiua angajarii: " + this.infoAngajare.getZiAngajare() + "\nLuna angajarii: " + this.infoAngajare.getLunaAngajare() + "\nAnul angajarii: " + this.infoAngajare.getAnAngajare() + "\nSalariul : " + this.infoAngajare.getSalariu() + "\nNumarul de telefon: " + this.nrTelefon + "\nAdresa de email: " + this.email + "\nCod parafa: "+ this.codParafa + "\nSpecializarea: "+ this.specializare + "\nESte rezident: "+ this.rezident + "\nEste medic de garda: "+ this.garda);
    }

    public void SporuriMedic()
    {
        this.infoAngajare.setSalariu(this.infoAngajare.getSalariu()+this.infoAngajare.getSalariu()*0.25);
    }
}

