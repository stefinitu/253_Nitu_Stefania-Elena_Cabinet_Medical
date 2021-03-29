package Services;

public class CostSpitalizare {
    public int CostClientMajor(int nr_spit)
    {
        int cost_total_major=nr_spit*100;
       return cost_total_major;
    }

    public int CostClientMinor(int nr_spit)
    {
        int cost_total_minor=nr_spit*80;
        return cost_total_minor;
    }
}
