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
        this.denumire=denumire;
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

    public double SumaMed(int nr_medicamente, int[] nr_bucati, double[] pret) {
        double suma = 0;
        for (int i = 0; i < nr_medicamente; i++) {
            double dnr_bucati = Double.valueOf(nr_bucati[i]);
            suma = suma + dnr_bucati * pret[i];
        }
        return suma;
    }

    public void CitireReteta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti ID-ul retetei:");
        this.id_reteta = Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti numarul de tipuri de medicamente:");
        this.nr_medicamente = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti denumirile medicamentelor:");
        for (int i = 0; i < nr_medicamente; i++) {
            System.out.println((i+1));
            this.denumire[i] = scanner.nextLine();
        }
        System.out.println("Introduceti pretul fiecarui medicament:");
        for (int i = 0; i < nr_medicamente; i++) {
            System.out.println((i+1));
            this.pret[i] = Double.parseDouble(scanner.nextLine());
        }
        System.out.println("Introduceti numarul de bucati pentru fiecare tip de medicament:");
        for (int i = 0; i < nr_medicamente; i++) {
            System.out.println((i+1));
            this.nr_bucati[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    public void AfisareReteta() {
        System.out.println("ID Reteta:" + this.id_reteta + "\nNumarul de medicamente:" + this.nr_medicamente + "\nDenumirile:");
        for (int i = 0; i < nr_medicamente; i++)
            System.out.println(this.denumire[i]);
        System.out.println("\nPretul fiecarui medicament: ");
        for (int i = 0; i < nr_medicamente; i++)
            System.out.println(this.pret[i]);
        System.out.println("\nNumarul de bucati pentru fiecare medicament: ");
        for (int i = 0; i < nr_medicamente; i++)
            System.out.println(this.nr_bucati[i]);
    }

    public void ReducereMedicamente()
    {
        for(int i=0;i<nr_medicamente;i++)
            pret[i]=pret[i]-0.8*pret[i];
    }
    }
