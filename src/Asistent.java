
import java.util.Scanner;

public class Asistent extends Personal {
    private int nrSaloaneAtribuite;

    public Asistent(String cnp, String nume, String prenume, InfoAngajare infoAngajare, String nr_telefon, String email, int nrSaloaneAtribuite) {
        super(cnp, nume, prenume, infoAngajare, nr_telefon, email);
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
        System.out.println("Introduceti numarul de saloane atribuite:");
        this.nrSaloaneAtribuite =Integer.parseInt(scanner.nextLine());
    }
    @Override
    public void AfisarePersonal()
    {
        System.out.println("CNP:" + this.cnp + "\nNumele:" + this.nume + "\nPrenumele:" + this.prenume + "\nSectia: " + this.infoAngajare.getSectie() +"\nZiua angajarii: " + this.infoAngajare.getZiAngajare() + "\nLuna angajarii: " + this.infoAngajare.getLunaAngajare() + "\nAnul angajarii: " + this.infoAngajare.getAnAngajare() + "\nSalariul : " + this.infoAngajare.getSalariu() + "\nNumarul de telefon: " + this.nrTelefon + "\nAdresa de email: " + this.email + "\nNumar de saloane atribuite: "+ this.nrSaloaneAtribuite);
    }
}
