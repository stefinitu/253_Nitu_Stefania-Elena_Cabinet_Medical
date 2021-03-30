package Services;

public class CostSpitalizare implements CostSpital {
    private int nrSpitallizare;

    public CostSpitalizare(int nrSpitallizare) {
        this.nrSpitallizare = nrSpitallizare;
    }

    public int getNrSpitallizare() {
        return nrSpitallizare;
    }

    public void setNrSpitallizare(int nrSpitallizare) {
        this.nrSpitallizare = nrSpitallizare;
    }
    @Override
    public int CostClientMajor()
    {
        int costTotalMajor=nrSpitallizare*100;
       return costTotalMajor;
    }

    @Override
    public int CostClientMinor()
    {
        int costTotalMinor=nrSpitallizare*80;
        return costTotalMinor;
    }
}
