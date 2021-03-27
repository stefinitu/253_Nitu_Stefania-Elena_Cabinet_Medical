import java.util.Scanner;

public class Asistent extends Personal {
    private int nr_saloane_atribuite;

    public Asistent(String cnp, String nume, String prenume, String sectie, int zi_angajare, int luna_angajare, int an_angajare, double salariu, String nr_telefon, String email, int nr_saloane_atribuite) {
        super(cnp, nume, prenume, sectie, zi_angajare, luna_angajare, an_angajare, salariu, nr_telefon, email);
        this.nr_saloane_atribuite = nr_saloane_atribuite;
    }

    public int getNr_saloane_atribuite() {
        return nr_saloane_atribuite;
    }

    public void setNr_saloane_atribuite(int nr_saloane_atribuite) {
        this.nr_saloane_atribuite = nr_saloane_atribuite;
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
        System.out.println("Introduceti numarul de saloane atribuite:");
        this.nr_saloane_atribuite=Integer.parseInt(scanner.nextLine());
    }
    @Override
    public void AfisarePersonal()
    {
        System.out.println("CNP:" + this.cnp + "\nNumele:" + this.nume + "\nPrenumele:" + this.prenume + "\nSectia: " + this.sectie +"\nZiua angajarii: " + this.zi_angajare + "\nLuna angajarii: " + this.luna_angajare + "\nAnul angajarii: " + this.an_angajare + "\nSalariul : " + this.salariu + "\nNumarul de telefon: " + this.nr_telefon + "\nAdresa de email: " + this.email + "\nNumar de saloane atribuite: "+ this.nr_saloane_atribuite);
    }
}
