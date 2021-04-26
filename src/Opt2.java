import Services.SumaMedCSV;
import Services.SumaMedicamente;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opt2 {
    public void Option2() throws IOException {
        SingletonResult result=new SingletonResult();
        SingletonCitire singletonCitire=new SingletonCitire();
        Scanner scn=new Scanner(System.in);
        List<List<String>> retete=new ArrayList<>();
        FileWriter csvWrite = new FileWriter("src\\CalculReteta.csv");
        System.out.println("Cititi retetele din fisier? (DA/NU)");
        String str2=scn.nextLine();
        if(str2.toUpperCase().equals("NU"))
        {int nrRetete;
            System.out.println("Introduceti numarul de retete:");
            nrRetete=scn.nextInt();
            Reteta[] r=new Reteta[nrRetete];
            for(int i=0;i<nrRetete;i++)
            {   String[] den=new String[100];
                double[] pr=new double[100];
                int[] bu=new int[100];
                r[i]=new Reteta(0,2,den,pr,bu);
            }
            for(int i=0;i<nrRetete;i++)
            {r[i].CitireReteta();}
            for(int i=0;i<nrRetete;i++)
            {
                SumaMedicamente sum = new SumaMedicamente(r[i].getNr_medicamente(),r[i].getNr_bucati(), r[i].getPret());
                double calc =sum.CalculSumaMed();
                csvWrite.append(String.join(",", Double.toString(calc)));
                csvWrite.append("\n");
                System.out.println("\nSuma medicamentelor de pe reteta "+(i+1)+" este "+calc);
            }
            csvWrite.flush();
            csvWrite.close();}
        else
        {
            double suma=0;
            singletonCitire.getInstanceRead().ReadingReteta();
            retete.addAll(singletonCitire.getInstanceRead().getRetete());
            SumaMedCSV sum=new SumaMedCSV(retete,0);
            sum.SumMedCSV();
        }
        SingletonResult.getInstance().setOption(2);
        SingletonResult.getInstance().WritingTimestamp();
    }
}
