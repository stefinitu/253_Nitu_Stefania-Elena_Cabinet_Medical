import java.util.Scanner;

public class Reteta {
    private double id_reteta;
    private int nr_medicamente;
    private String[] denumire;
    private double[] pret;
    private int[] nr_bucati;

    public Reteta(double id_reteta, int nr_medicamente, String[] denumire, double[] pret, int[] nr_bucati) {
        this.id_reteta = id_reteta;
        this.nr_medicamente = nr_medicamente;
        this.denumire = denumire;
        this.pret = pret;
        this.nr_bucati = nr_bucati;
    }

    public double getId_reteta() {
        return id_reteta;
    }

    public void setId_reteta(double id_reteta) {
        this.id_reteta = id_reteta;
    }

    public int getNr_medicamente() {
        return nr_medicamente;
    }

    public void setNr_medicamente(int nr_medicamente) {
        this.nr_medicamente = nr_medicamente;
    }

    public String[] getDenumire() {
        return denumire;
    }

    public void setDenumire(String[] denumire) {
        this.denumire = denumire;
    }

    public double[] getPret() {
        return pret;
    }

    public void setPret(double[] pret) {
        this.pret = pret;
    }

    public int[] getNr_bucati() {
        return nr_bucati;
    }

    public void setNr_bucati(int[] nr_bucati) {
        this.nr_bucati = nr_bucati;
    }

    public double SumaMedicamente(int nr_medicemante, int[] nr_bucati, double[] pret)
    {
        double suma=0;
        for(int i=0;i<nr_medicamente;i++)
        {   double dnr_bucati=Double.valueOf(nr_bucati[i]);
            suma=suma+ dnr_bucati*pret[i];}
        return suma;
    }
    public void CitireReteta()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti ID-ul retetei:");
        this.id_reteta=scanner.nextDouble();
        System.out.println("Introduceti numarul de medicamente:");
        this.nr_medicamente=scanner.nextInt();
        for(int i=0;i<nr_medicamente;i++)
        {System.out.println("Introduceti denumirile medicamentelor:");
        System.out.println(i);
        this.denumire[i]=scanner.nextLine();}
        for(int i=0;i<nr_medicamente;i++)
        {System.out.println("Introduceti pretul fiecarui medicament:");
            System.out.println(i);
            this.pret[i]=scanner.nextDouble();}
        for(int i=0;i<nr_medicamente;i++)
        {System.out.println("Introduceti numarul de bucati pentru fiecare medicament:");
            System.out.println(i);
            this.nr_bucati[i]=scanner.nextInt();}
    }
    public void AfisareReteta()
    {
        System.out.println("ID Reteta:" + this.id_reteta + "\nNumarul de medicamente:" + this.nr_medicamente + "\nDenumirile:");
        for(int i=0;i<nr_medicamente;i++)
            System.out.println(this.denumire[i]);
        System.out.println("\nPretul fiecarui medicament: ");
        for(int i=0;i<nr_medicamente;i++)
            System.out.println(this.pret[i]);
        System.out.println("\nNumarul de bucati pentru fiecare medicament: ");
        for(int i=0;i<nr_medicamente;i++)
            System.out.println(this.nr_bucati[i]);
    }
}
