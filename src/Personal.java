public abstract class Personal {
    protected String cnp;
    protected String nume;
    protected String prenume;
    protected String sectie;
    protected int ziAngajare;
    protected int lunaAngajare;
    protected int anAngajare;
    protected double salariu;
    protected String nrTelefon;
    protected String email;

    public Personal(String cnp, String nume, String prenume, String sectie, int ziAngajare, int lunaAngajare, int anAngajare, double salariu, String nrTelefon, String email) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.sectie = sectie;
        this.ziAngajare = ziAngajare;
        this.lunaAngajare = lunaAngajare;
        this.anAngajare = anAngajare;
        this.salariu = salariu;
        this.nrTelefon = nrTelefon;
        this.email = email;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
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

    public int getZiAngajare() {
        return ziAngajare;
    }

    public void setZiAngajare(int ziAngajare) {
        this.ziAngajare = ziAngajare;
    }

    public int getLunaAngajare() {
        return lunaAngajare;
    }

    public void setLunaAngajare(int lunaAngajare) {
        this.lunaAngajare = lunaAngajare;
    }

    public int getAnAngajare() {
        return anAngajare;
    }

    public void setAnAngajare(int anAngajare) {
        this.anAngajare = anAngajare;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    abstract void CitirePersonal();
    abstract void AfisarePersonal();
}
