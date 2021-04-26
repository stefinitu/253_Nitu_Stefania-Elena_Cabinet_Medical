import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Opt10 {
    public void Opt10() throws ParseException, IOException {
        SingletonResult result=new SingletonResult();
        FileWriter csvWrite10 = new FileWriter("src\\PlanificariNoi.csv", true);
        Scanner sc10=new Scanner(System.in);
        Client pac;
        int nrPr=0;

        pac = new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        System.out.println("Introduceti numarul de programari:");
        nrPr= Integer.parseInt(sc10.nextLine());
        Programare[] programare=new Programare[nrPr];

        for(int i=0;i<nrPr;i++)
        {programare[i]=new Programare(0,0,pac,0,0,0,0,0,0,"");
            programare[i].CitireProg();
            VerificarePlanifWeekend verificareWeekend =new VerificarePlanifWeekend(programare[i]);
            verificareWeekend.VerificarePlanificareWeekend();
        }
        System.out.println("Noile date planificate sunt:");
        for(int i=0;i<nrPr;i++)
        {
            System.out.println("Pentru programarea "+(i+1)+ " avem: "+ programare[i].getZiPlanificare()+"/"+programare[i].getLunaPlanificare()+"/"+programare[i].getAnPlanificare());
            csvWrite10.append(programare[i].getClient().getNume());
            csvWrite10.append(",");
            csvWrite10.append(programare[i].getClient().getPrenume());
            csvWrite10.append(",");
            csvWrite10.append(Integer.toString(programare[i].getZiPlanificare()));
            csvWrite10.append("/");
            csvWrite10.append(Integer.toString(programare[i].getLunaPlanificare()));
            csvWrite10.append("/");
            csvWrite10.append(Integer.toString(programare[i].getAnPlanificare()));
            csvWrite10.append("/");
            csvWrite10.append("\n");
        }
        csvWrite10.flush();
        csvWrite10.close();
        result.getInstance().setOption(10);
        result.getInstance().WritingTimestamp();
    }
}
