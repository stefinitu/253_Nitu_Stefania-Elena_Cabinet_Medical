
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClientMinor extends Client {
    private String numeInsotitor;
    private String prenumeInsotitor;
    private String nrTelefonInsotitor;

    public ClientMinor(String cnp, String nume, String prenume, String email, String gen, String adresa, String numeInsotitor, String prenumeInsotitor, String nrTelefonInsotitor) {
        super(cnp, nume, prenume, email, gen, adresa);
        this.numeInsotitor = numeInsotitor;
        this.prenumeInsotitor = prenumeInsotitor;
        this.nrTelefonInsotitor = nrTelefonInsotitor;
    }
    @Override
    public String getNumeInsotitor() {
        return numeInsotitor;
    }

    public void setNumeInsotitor(String numeInsotitor) {
        this.numeInsotitor = numeInsotitor;
    }

    @Override
    public String getPrenumeInsotitor() {
        return prenumeInsotitor;
    }

    public void setPrenumeInsotitor(String prenumeInsotitor) {
        this.prenumeInsotitor = prenumeInsotitor;
    }

    @Override
    public String getNrTelefonInsotitor() {
        return nrTelefonInsotitor;
    }

    public void setNrTelefonInsotitor(String nrTelefonInsotitor) {
        this.nrTelefonInsotitor = nrTelefonInsotitor;
    }
    public double getIdCardSanatate() {return 0;}
    public String getNrTelefon() {return " ";}
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
        System.out.println("Introduceti numele insotitorului:");
        this.numeInsotitor =scanner.nextLine();
        System.out.println("Introduceti prenumele insotitorului:");
        this.prenumeInsotitor =scanner.nextLine();
        System.out.println("Introduceti numarul de telefon al insotitorului:");
        this.nrTelefonInsotitor =scanner.nextLine();

    }
    @Override
public void AfisareClienti() {
        System.out.println("CNP:" + this.cnp + "\nNumele:" + this.nume + "\nPrenumele:" + this.prenume + "\nEmail:" + this.email + "\nGen:" + this.gen + "\nAdresa:" + this.adresa + "\n Nume de familie insotitor: " + this.numeInsotitor + "\nPrenume insotitor: "+ this.prenumeInsotitor + "\nNumar de telefon insotitor: "+ this.nrTelefonInsotitor);}

    @Override
    public void CalculVarsta() throws IOException {
        String prefixAn=" ";
        String sufixAn=" ";
        FileWriter csvWritemin = new FileWriter("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\DataNasterii.csv",true);
        int luna;
        int zi;
        if(cnp.length() != 13) {
            System.out.println("CNP invalid. Introduceti un CNP cu 13 cifre!");
        } else  prefixAn="20";
            sufixAn = cnp.substring(1, 3);
            luna = new Integer(cnp.substring(3, 5));
            zi = new Integer(cnp.substring(5,7));
            String lunaM = aflaLuna(luna);
            String dataNasterii = Integer.toString(zi).concat(" ").concat(lunaM).concat(" ").concat(prefixAn).concat(sufixAn);
            System.out.println("\nData nasterii este:".concat(dataNasterii));
        csvWritemin.append("Pacientul ");
        csvWritemin.append(nume);
        csvWritemin.append(",");
        csvWritemin.append(dataNasterii);
        csvWritemin.append("\n");
        csvWritemin.flush();
        csvWritemin.close();
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