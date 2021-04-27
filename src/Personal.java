

public abstract class Personal {
    protected String cnp;
    protected String nume;
    protected String prenume;
    protected InfoAngajare infoAngajare;
    protected String nrTelefon;
    protected String email;

    public Personal(String cnp, String nume, String prenume, InfoAngajare infoAngajare,  String nrTelefon, String email) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.infoAngajare=infoAngajare;
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

    public InfoAngajare getInfoAngajare() {
        return infoAngajare;
    }

    public void setInfoAngajare(InfoAngajare infoAngajare) {
        this.infoAngajare = infoAngajare;
    }

    abstract void CitirePersonal();
    abstract void AfisarePersonal();
}
