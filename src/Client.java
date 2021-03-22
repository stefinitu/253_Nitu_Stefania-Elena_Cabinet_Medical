abstract public class Client {
    protected double cnp;
    protected String nume;
    protected String prenume;
    protected String email;
    protected String gen;
    protected String adresa;

    public Client(double cnp, String nume, String prenume, String email, String gen, String adresa) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.gen = gen;
        this.adresa = adresa;
    }

    public void setCnp(double cnp) {
        this.cnp = cnp;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public double getCnp() {
        return cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getEmail() {
        return email;
    }

    public String getGen() {
        return gen;
    }

    public String getAdresa() {
        return adresa;
    }
    abstract public void CitireClienti();
    abstract public void AfisareClienti();
}
