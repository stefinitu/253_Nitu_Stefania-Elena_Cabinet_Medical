public class MaxMinAverage {
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

    public double Maxim()
    {
        double maxsal=0.0;
        for(int i=0;i<n;i++)
            if(maxsal<ang[i].getSalariu()) maxsal=ang[i].getSalariu();
        return maxsal;
    }

    public double Minim()
    {
        double minsal=ang[0].getSalariu();
        for(int i=1;i<n;i++)
            if(minsal>ang[i].getSalariu()) minsal=ang[i].getSalariu();
        return minsal;
    }

    public double Average()
    {
        double sum=0;
        for(int i=0;i<n;i++)
        sum=sum+ang[i].getSalariu();
        sum=sum/n;
        return sum;
    }
}
