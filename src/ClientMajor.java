
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ClientMajor extends Client {
    private double idCardSanatate;
    private String nrTelefon;

    public ClientMajor(String cnp, String nume, String prenume, String email, String gen, String adresa, double idCardSanatate, String nrTelefon) {
        super(cnp, nume, prenume, email, gen, adresa);
        this.idCardSanatate = idCardSanatate;
        this.nrTelefon = nrTelefon;
    }

    public String getNumeInsotitor(){return " "; }
    public String getPrenumeInsotitor(){ return " ";}
    public String getNrTelefonInsotitor(){return " ";}
    @Override
    public double getIdCardSanatate() {
        return idCardSanatate;
    }

    public void setIdCardSanatate(double idCardSanatate) {
        this.idCardSanatate = idCardSanatate;
    }

    @Override
    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
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
        System.out.println("Introduceti genul persoanei (masculin/feminin):");
        this.gen=scanner.nextLine();
        System.out.println("Introduceti adresa:");
        this.adresa=scanner.nextLine();
        System.out.println("Introduceti ID-ul cardului de sanatate:");
        this.idCardSanatate =Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti numarul de telefon:");
        this.nrTelefon =scanner.nextLine();
    }
    @Override
    public void AfisareClienti() { System.out.println("CNP:" + this.cnp + "\nNumele:" + this.nume + "\nPrenumele:" + this.prenume + "\nEmail:" + this.email);
    }

    @Override
    public void CalculVarsta() throws IOException {
        FileWriter csvWritemaj = new FileWriter("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\DataNasterii.csv",true);
        String prefixAn;
        String sufixAn;
        int luna;
        int zi;
        if(cnp.length() != 13) {
            System.out.println("CNP invalid. Introduceti un CNP cu 13 cifre!");
        } else {
            int genInt = new Integer(cnp.substring(0,1));
            if(genInt == 1 || genInt == 2) {
                prefixAn = "19";
            } else {
                prefixAn = "20";
            }
            sufixAn = cnp.substring(1, 3);
            luna = new Integer(cnp.substring(3, 5));
            zi = new Integer(cnp.substring(5,7));
            String lunaM = aflaLuna(luna);
            String dataNasterii = Integer.toString(zi).concat(" ").concat(lunaM).concat(" ").concat(prefixAn).concat(sufixAn);
            System.out.println("\nData nasterii este:".concat(dataNasterii));
            csvWritemaj.append("Pacientul ");
            csvWritemaj.append(String.join(",", nume));
            csvWritemaj.append(String.join(",", dataNasterii));
            csvWritemaj.append("\n");
            csvWritemaj.flush();
            csvWritemaj.close();
        }

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
