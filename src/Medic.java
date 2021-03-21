public class Medic extends Personal {
    private double cod_parafa;
    private String specializare;
    private boolean rezident;
    private boolean garda;
    public Medic(double cnp, String nume, String prenume, String sectie, int zi_angajare, int luna_angajare, int an_angajare, double salariu, String nr_telefon, String email, double cod_parafa, String specializare, boolean rezident, boolean garda) {
        super(cnp, nume, prenume, sectie, zi_angajare, luna_angajare, an_angajare, salariu, nr_telefon, email);
        this.cod_parafa = cod_parafa;
        this.specializare = specializare;
        this.rezident = rezident;
        this.garda = garda;
}

    public double getCod_parafa() {
        return cod_parafa;
    }

    public String getSpecializare() {
        return specializare;
    }

    public boolean isRezident() {
        return rezident;
    }

    public boolean isGarda() {
        return garda;
    }

    public void setCod_parafa(double cod_parafa) {
        this.cod_parafa = cod_parafa;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public void setRezident(boolean rezident) {
        this.rezident = rezident;
    }

    public void setGarda(boolean garda) {
        this.garda = garda;
    }
}

