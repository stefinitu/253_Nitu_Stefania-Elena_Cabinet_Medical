import java.util.Scanner;

public class ClientMinor extends Client {
    private String nume_insotitor;
    private String prenume_insotitor;
    private String nr_telefon_insotitor;

    public ClientMinor(double cnp, String nume, String prenume, String email, String nr_telefon, String gen, String adresa, String nume_insotitor, String prenume_insotitor, String nr_telefon_insotitor) {
        super(cnp, nume, prenume, email, gen, adresa);
        this.nume_insotitor = nume_insotitor;
        this.prenume_insotitor = prenume_insotitor;
        this.nr_telefon_insotitor = nr_telefon_insotitor;
    }

    public String getNume_insotitor() {
        return nume_insotitor;
    }

    public void setNume_insotitor(String nume_insotitor) {
        this.nume_insotitor = nume_insotitor;
    }

    public String getPrenume_insotitor() {
        return prenume_insotitor;
    }

    public void setPrenume_insotitor(String prenume_insotitor) {
        this.prenume_insotitor = prenume_insotitor;
    }

    public String getNr_telefon_insotitor() {
        return nr_telefon_insotitor;
    }

    public void setNr_telefon_insotitor(String nr_telefon_insotitor) {
        this.nr_telefon_insotitor = nr_telefon_insotitor;
    }
    public void AfisareClienti() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti cnp:");
        this.cnp=scanner.nextDouble();
        System.out.println("Introduceti numele:");
        this.nume=scanner.nextLine();
        System.out.println("Introduceti prenumele:");
        this.prenume=scanner.nextLine();
        System.out.println("Introduceti emailul:");
        this.email=scanner.nextLine();
        System.out.println("Introduceti genul persoanei:");
        this.gen=scanner.nextLine();
        System.out.println("Introduceti adresa:");
        this.adresa=scanner.nextLine();
        System.out.println("Introduceti numele insotitorului:");
        this.nume_insotitor=scanner.nextLine();
        System.out.println("Introduceti prenumele insotitorului:");
        this.prenume_insotitor=scanner.nextLine();
        System.out.println("Introduceti numarul de telefon al insotitorului:");
        this.nr_telefon_insotitor=scanner.nextLine();
        System.out.println("CNP:" + this.cnp + "\nNumele:" + this.nume + "\nPrenumele:" + this.prenume + "\nEmail:" + this.email + "\nGen:" + this.gen + "\nAdresa:" + this.adresa);
    }
}
