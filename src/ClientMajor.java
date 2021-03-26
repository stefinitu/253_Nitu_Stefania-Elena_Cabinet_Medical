import java.util.Scanner;
public class ClientMajor extends Client {
    private double id_card_sanatate;
    private String nr_telefon;

    public ClientMajor(double cnp, String nume, String prenume, String email, String gen, String adresa, double id_card_sanatate, String nr_telefon) {
        super(cnp, nume, prenume, email, gen, adresa);
        this.id_card_sanatate = id_card_sanatate;
        this.nr_telefon = nr_telefon;
    }

    public double getId_card_sanatate() {
        return id_card_sanatate;
    }

    public void setId_card_sanatate(double id_card_sanatate) {
        this.id_card_sanatate = id_card_sanatate;
    }

    public String getNr_telefon() {
        return nr_telefon;
    }

    public void setNr_telefon(String nr_telefon) {
        this.nr_telefon = nr_telefon;
    }


    @Override
    public void CitireClienti() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti cnp:");
        this.cnp=Double.parseDouble(scanner.nextLine());
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
        System.out.println("Introduceti ID-ul cardului de sanatate:");
        this.id_card_sanatate=Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti numarul de telefon:");
        this.nr_telefon=scanner.nextLine();
    }
    @Override
    public void AfisareClienti() { System.out.println("CNP:" + this.cnp + "\nNumele:" + this.nume + "\nPrenumele:" + this.prenume + "\nEmail:" + this.email);
    }
}
