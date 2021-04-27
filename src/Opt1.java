import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Opt1 {
    public void Option1() throws IOException {
        SingletonResult result=new SingletonResult();
        Scanner sc=new Scanner(System.in);
        int nrClienti;
        System.out.println("Introduceti numarul de clienti:");
        nrClienti=Integer.parseInt(sc.nextLine());
        Client cl[] = new Client[nrClienti];
        TipClient tipcl=new TipClient(cl,nrClienti);
        Arrays.sort(cl);
        for(int i=0;i<nrClienti;i++)
        {
            System.out.println("\nClientul nr "+(i+1));
            cl[i].AfisareClienti();
        }
        result.getInstance().setOption(1);
        result.getInstance().WritingTimestamp();
    }
}
