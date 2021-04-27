import Services.MaxMinAvCalculator;

public class MaxMinAverage implements MaxMinAvCalculator {
    private Personal[] ang;
    private int n;

    public MaxMinAverage(Personal[] ang, int n) {
        this.ang = ang;
        this.n = n;
    }

    public Personal[] getAng() {
        return ang;
    }

    public void setAng(Personal[] ang) {
        this.ang = ang;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public double Maxim()
    {
        double maxsal=0.0;
        for(int i=0;i<n;i++)
            if(maxsal<ang[i].infoAngajare.getSalariu()) maxsal=ang[i].infoAngajare.getSalariu();
        return maxsal;
    }
@Override
    public double Minim()
    {
        double minsal=ang[0].infoAngajare.getSalariu();
        for(int i=1;i<n;i++)
            if(minsal>ang[i].infoAngajare.getSalariu()) minsal=ang[i].infoAngajare.getSalariu();
        return minsal;
    }
@Override
    public double Average()
    {
        double sum=0;
        for(int i=0;i<n;i++)
        sum=sum+ang[i].infoAngajare.getSalariu();
        sum=sum/n;
        return sum;
    }
}
