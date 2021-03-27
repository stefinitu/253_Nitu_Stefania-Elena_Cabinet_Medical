import java.util.Scanner;

public class ClientMinor extends Client {
    private String nume_insotitor;
    private String prenume_insotitor;
    private String nr_telefon_insotitor;

    public ClientMinor(String cnp, String nume, String prenume, String email, String gen, String adresa, String nume_insotitor, String prenume_insotitor, String nr_telefon_insotitor) {
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
    @Override
    public void CitireClienti() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti cnp:");
        this.cnp=scanner.nextLine();
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
    }
    @Override
public void AfisareClienti() {
        System.out.println("CNP:" + this.cnp + "\nNumele:" + this.nume + "\nPrenumele:" + this.prenume + "\nEmail:" + this.email + "\nGen:" + this.gen + "\nAdresa:" + this.adresa + "\n Nume de familie insotitor: " + this.nume_insotitor + "\nPrenume insotitor: "+ this.prenume_insotitor + "\nNumar de telefon insotitor: "+ this.nr_telefon_insotitor);}

    @Override
    public void CalculVarsta()
    {
        String prefixAn=" ";
        String sufixAn=" ";
        int luna;
        int zi;
        if(cnp.length() != 13) {
            System.out.println("CNP invalid. Introduceti un CNP cu 13 cifre!");
        } else  prefixAn = "20";
            sufixAn = cnp.substring(1, 3);
            luna = new Integer(cnp.substring(3, 5));
            zi = new Integer(cnp.substring(5,7));
            String lunaM = aflaLuna(luna);
            String dataNasterii = Integer.toString(zi).concat(" ").concat(lunaM).concat(" ").concat(prefixAn).concat(sufixAn);
            System.out.println("\nData nasterii este:".concat(dataNasterii));
        }

    public static String aflaLuna(int luna) {
        switch (luna) {
            case 1:
                return "Ianuarie";

            case 2:
                return "Februarie";

            case 3:
                return "Martie";

            case 4:
                return "Aprilie";

            case 5:
                return "Mai";

            case 6:
                return "Iunie";

            case 7:
                return "Iulie";

            case 8:
                return "August";

            case 9:
                return "Septembrie";

            case 10:
                return "Obtombrie";

            case 11:
                return "Noiembrie";

            case 12:
                return "Decembrie";

            default:
                return "Nu exista";
        }
    }

    }