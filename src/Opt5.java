import java.io.IOException;
import java.util.Scanner;

public class Opt5 {
    public void Option5() throws IOException {
        SingletonResult result=new SingletonResult();
        Scanner scanner5=new Scanner(System.in);
        int nClients;
        Client persoana[] = new Client[100];
        String lines;
        System.out.println("Doriti citirea din fisier? (DA/NU)");
        lines=scanner5.nextLine();
        if(lines.toUpperCase().equals("NU")) {
            System.out.println("Introduceti numarul de clienti:");
            nClients = Integer.parseInt(scanner5.nextLine());
            TipClient tipCli = new TipClient(persoana, nClients);
            tipCli.TipCl();
            for (int i = 0; i < nClients; i++) {
                persoana[i].CalculVarsta();
            }
            result.getInstance().setOption(5);
            result.getInstance().WritingTimestamp();
        }
        else
        {
            TipClientAgeCSV ageClient=new TipClientAgeCSV();
            ageClient.TipClCSV();
            result.getInstance().setOption(5);
            result.getInstance().WritingTimestamp();
        }
    }
}
