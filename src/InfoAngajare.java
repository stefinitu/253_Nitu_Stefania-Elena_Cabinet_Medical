public class InfoAngajare {
    private String sectie;
    private int ziAngajare;
    private int lunaAngajare;
    private int anAngajare;
    private double salariu;

    public InfoAngajare(String sectie, int ziAngajare, int lunaAngajare, int anAngajare, double salariu) {
        this.sectie=sectie;
        this.ziAngajare = ziAngajare;
        this.lunaAngajare = lunaAngajare;
        this.anAngajare = anAngajare;
        this.salariu = salariu;
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

    public String getSectie() {
        return sectie;
    }

    public void setSectie(String sectie) {
        this.sectie = sectie;
    }
}
