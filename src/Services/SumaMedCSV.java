package Services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SumaMedCSV {
    List<List<String>> retete=new ArrayList<>();
    double suma=0;

    public SumaMedCSV(List<List<String>> retete, double suma) {
        this.retete = retete;
        this.suma = suma;
    }

    public void SumMedCSV() throws IOException {
        FileWriter csvWrite = new FileWriter("src\\CalculReteta.csv");
    for(List<String> date:retete)
    {   int nrmed=Integer.parseInt(date.get(1));
        for(int i=0;i<nrmed;i++)
        {String pret=date.get(2+nrmed+i);
            String nrb=date.get(2+2*nrmed+i);
            String newpret=pret.replaceAll("[{}]","");
            String newnrb=nrb.replaceAll("[{}]","");
            suma=suma+Double.parseDouble(newpret)*Integer.parseInt(newnrb);
        }
        csvWrite.append(Double.toString(suma));
        csvWrite.append("\n");
        suma=0;
    }
    csvWrite.flush();
    csvWrite.close();}

}
