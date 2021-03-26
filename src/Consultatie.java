import java.util.Scanner;

public class Consultatie implements IdentifiableCons {
    private String id_consultatie;
    private Programare prog;
    private int zi_consultatie;
    private int luna_consultatie;
    private int an_consultatie;
    private String diagnostic;
    private Reteta reteta;
    private Medic medic;
    private int nr_zile_spitalizare;

    public Consultatie(String id_consultatie, Programare prog, int zi_consultatie, int luna_consultatie, int an_consultatie, String diagnostic, Reteta reteta, Medic medic, int nr_zile_spitalizare) {
        //this.id_consultatie = id_consultatie;
        this.prog = prog;
        this.zi_consultatie = zi_consultatie;
        this.luna_consultatie = luna_consultatie;
        this.an_consultatie = an_consultatie;
        this.diagnostic = diagnostic;
        //Reteta cl_reteta=new Reteta(0,0,{""},0, 0);
        this.reteta=reteta;
        this.medic = medic;
        this.nr_zile_spitalizare = nr_zile_spitalizare;
    }

    public String getId_consultatie() {
        //id_consultatie=generateID();
        return id_consultatie;
    }

    public void setId_consultatie(String id_consultatie) {
        this.id_consultatie = id_consultatie;
    }

    public Programare getProg() {
        return prog;
    }

    public void setProg(Programare prog) {
        this.prog = prog;
    }

    public int getZi_consultatie() {
        return zi_consultatie;
    }

    public void setZi_consultatie(int zi_consultatie) {
        this.zi_consultatie = zi_consultatie;
    }

    public int getLuna_consultatie() {
        return luna_consultatie;
    }

    public void setLuna_consultatie(int luna_consultatie) {
        this.luna_consultatie = luna_consultatie;
    }

    public int getAn_consultatie() {
        return an_consultatie;
    }

    public void setAn_consultatie(int an_consultatie) {
        this.an_consultatie = an_consultatie;
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

    public int getNr_zile_spitalizare() {
        return nr_zile_spitalizare;
    }

    public void setNr_zile_spitalizare(int nr_zile_spitalizare) {
        this.nr_zile_spitalizare = nr_zile_spitalizare;
    }
    public Consultatie()
    {
        this.id_consultatie=generateID();
    }

    public void CitireConsultatie()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti programarea:");
        this.prog.CitireProg();
        System.out.println("Introduceti ziua consultatiei:");
        this.zi_consultatie=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti luna consultatiei:");
        this.luna_consultatie=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti anul consultatiei:");
        this.an_consultatie=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti diagnosticul:");
        this.diagnostic=scanner.nextLine();
        System.out.println("Introduceti reteta:");
        this.reteta.CitireReteta();
        System.out.println("Introduceti datele medicului:");
        this.medic.CitirePersonal();
        System.out.println("Introduceti numarul de zile de spitalizare:");
        this.nr_zile_spitalizare=Integer.parseInt(scanner.nextLine());
    }
@Override
public String genID()
{
    return id_consultatie;
}

public void AfisareConsultatie()
{
    System.out.println("ID-ul consultatiei generat automat este: " + id_consultatie + "\nziua consultatiei" + zi_consultatie);
}
}
