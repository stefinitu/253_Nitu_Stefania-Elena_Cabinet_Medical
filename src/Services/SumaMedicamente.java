package Services;
import java.util.*;
public class SumaMedicamente {
   public double CalculSumaMed(int nr_medicamente, int[] nr_bucati, double[] pret)
   {
       double suma = 0;
       for (int i = 0; i < nr_medicamente; i++) {
           double dnr_bucati = Double.valueOf(nr_bucati[i]);
           suma = suma + dnr_bucati * pret[i];
       }
       return suma;
   }
}
