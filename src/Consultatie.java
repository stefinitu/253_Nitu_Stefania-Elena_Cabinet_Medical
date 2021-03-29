import java.util.Scanner;

public class Consultatie implements IdentifiableCons {
    private String idConsultatie;
    private Programare prog;
    private int ziConsultatie;
    private int lunaConsultatie;
    private int anConsultatie;
    private String diagnostic;
    private Reteta reteta;
    private Medic medic;
    private int nrZileSpitalizare;

    public Consultatie(String idConsultatie, Programare prog, int ziConsultatie, int lunaConsultatie, int anConsultatie, String diagnostic, Reteta reteta, Medic medic, int nrZileSpitalizare) {
        this.idConsultatie =generateID();
        this.prog = prog;
        this.ziConsultatie = ziConsultatie;
        this.lunaConsultatie = lunaConsultatie;
        this.anConsultatie = anConsultatie;
        this.diagnostic = diagnostic;
        this.reteta=reteta;
        this.medic = medic;
        this.nrZileSpitalizare = nrZileSpitalizare;
    }

    public String getIdConsultatie() {
        return idConsultatie;
    }

    public void setIdConsultatie(String idConsultatie) {
        this.idConsultatie = idConsultatie;
    }

    public Programare getProg() {
        return prog;
    }

    public void setProg(Programare prog) {
        this.prog = prog;
    }

    public int getZiConsultatie() {
        return ziConsultatie;
    }

    public void setZiConsultatie(int ziConsultatie) {
        this.ziConsultatie = ziConsultatie;
    }

    public int getLunaConsultatie() {
        return lunaConsultatie;
    }

    public void setLunaConsultatie(int lunaConsultatie) {
        this.lunaConsultatie = lunaConsultatie;
    }

    public int getAnConsultatie() {
        return anConsultatie;
    }

    public void setAnConsultatie(int anConsultatie) {
        this.anConsultatie = anConsultatie;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Reteta getReteta() {
        return reteta;
    }

    public void setReteta(Reteta reteta) {
        this.reteta = reteta;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public int getNrZileSpitalizare() {
        return nrZileSpitalizare;
    }

    public void setNrZileSpitalizare(int nrZileSpitalizare) {
        this.nrZileSpitalizare = nrZileSpitalizare;
    }
    /*public Consultatie()
    {
        this.id_consultatie=generateID();
    }*/

    public void CitireConsultatie()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti programarea:");
        this.prog.CitireProg();
        System.out.println("Introduceti ziua consultatiei:");
        this.ziConsultatie =Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti luna consultatiei:");
        this.lunaConsultatie =Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti anul consultatiei:");
        this.anConsultatie =Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti diagnosticul:");
        this.diagnostic=scanner.nextLine();
        System.out.println("Introduceti reteta:");
        this.reteta.CitireReteta();
        System.out.println("Introduceti datele medicului:");
        this.medic.CitirePersonal();
        System.out.println("Introduceti numarul de zile de spitalizare:");
        this.nrZileSpitalizare =Integer.parseInt(scanner.nextLine());
    }
@Override
public String genID()
{
    return idConsultatie;
}

public void AfisareConsultatie()
{
    System.out.println("ID-ul consultatiei generat automat este: " + idConsultatie + "\nziua consultatiei" + ziConsultatie);
}

public void ReducereClient()
{

}
}
