public class Personal {
    protected double cnp;
    protected String nume;
    protected String prenume;
    protected String sectie;
    protected int zi_angajare;
    protected int luna_angajare;
    protected int an_angajare;
    protected double salariu;
    protected String nr_telefon;
    protected String email;

    public Personal(double cnp, String nume, String prenume, String sectie, int zi_angajare, int luna_angajare, int an_angajare, double salariu, String nr_telefon, String email) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.sectie = sectie;
        this.zi_angajare = zi_angajare;
        this.luna_angajare = luna_angajare;
        this.an_angajare = an_angajare;
        this.salariu = salariu;
        this.nr_telefon = nr_telefon;
        this.email = email;
    }

    public double getCnp() {
        return cnp;
    }

    public void setCnp(double cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getSectie() {
        return sectie;
    }

    public void setSectie(String sectie) {
        this.sectie = sectie;
    }

    public int getZi_angajare() {
        return zi_angajare;
    }

    public void setZi_angajare(int zi_angajare) {
        this.zi_angajare = zi_angajare;
    }

    public int getLuna_angajare() {
        return luna_angajare;
    }

    public void setLuna_angajare(int luna_angajare) {
        this.luna_angajare = luna_angajare;
    }

    public int getAn_angajare() {
        return an_angajare;
    }

    public void setAn_angajare(int an_angajare) {
        this.an_angajare = an_angajare;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public String getNr_telefon() {
        return nr_telefon;
    }

    public void setNr_telefon(String nr_telefon) {
        this.nr_telefon = nr_telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
