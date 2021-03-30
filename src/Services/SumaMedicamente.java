package Services;

public class SumaMedicamente implements Sumable{
    private int nrMedicamente;
    private int[] nrBucati;
    private double[] pret;

    public SumaMedicamente(int nrMedicamente, int[] nrBucati, double[] pret) {
        this.nrMedicamente = nrMedicamente;
        this.nrBucati = nrBucati;
        this.pret = pret;
    }

    public int getNrMedicamente() {
        return nrMedicamente;
    }

    public void setNrMedicamente(int nrMedicamente) {
        this.nrMedicamente = nrMedicamente;
    }

    public int[] getNrBucati() {
        return nrBucati;
    }

    public void setNrBucati(int[] nrBucati) {
        this.nrBucati = nrBucati;
    }

    public double[] getPret() {
        return pret;
    }

    public void setPret(double[] pret) {
        this.pret = pret;
    }

    @Override
    public double CalculSumaMed()
   {
       double suma = 0;
       for (int i = 0; i < nrMedicamente; i++) {
           double dnrBucati = Double.valueOf(nrBucati[i]);
           suma = suma + dnrBucati * pret[i];
       }
       return suma;
   }
}
