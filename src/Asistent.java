import java.util.Scanner;

public class Asistent extends Personal {
    private int nrSaloaneAtribuite;

    public Asistent(String cnp, String nume, String prenume, String sectie, int zi_angajare, int luna_angajare, int an_angajare, double salariu, String nr_telefon, String email, int nrSaloaneAtribuite) {
        super(cnp, nume, prenume, sectie, zi_angajare, luna_angajare, an_angajare, salariu, nr_telefon, email);
        this.nrSaloaneAtribuite = nrSaloaneAtribuite;
    }

    public int getNrSaloaneAtribuite() {
        return nrSaloaneAtribuite;
    }

    public void setNrSaloaneAtribuite(int nrSaloaneAtribuite) {
        this.nrSaloaneAtribuite = nrSaloaneAtribuite;
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
        this.ziAngajare =Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti luna angajarii:");
        this.lunaAngajare =Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti anul angajarii:");
        this.anAngajare =Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti salariul:");
        this.salariu=Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti numarul de telefon:");
        this.nrTelefon =scanner.nextLine();
        System.out.println("Introduceti adresa de email:");
        this.email=scanner.nextLine();
        System.out.println("Introduceti numarul de saloane atribuite:");
        this.nrSaloaneAtribuite =Integer.parseInt(scanner.nextLine());
    }
    @Override
    public void AfisarePersonal()
    {
        System.out.println("CNP:" + this.cnp + "\nNumele:" + this.nume + "\nPrenumele:" + this.prenume + "\nSectia: " + this.sectie +"\nZiua angajarii: " + this.ziAngajare + "\nLuna angajarii: " + this.lunaAngajare + "\nAnul angajarii: " + this.anAngajare + "\nSalariul : " + this.salariu + "\nNumarul de telefon: " + this.nrTelefon + "\nAdresa de email: " + this.email + "\nNumar de saloane atribuite: "+ this.nrSaloaneAtribuite);
    }
}
