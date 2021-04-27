import java.io.IOException;
import java.util.Scanner;

public class Opt6 {
    public void Opt6() throws IOException {
        SingletonResult result=new SingletonResult();
        Scanner scc=new Scanner(System.in);
        int nrCl=0;
        Client[] c = new Client[100];
        System.out.println("Cititi clientii din fisier? (DA/NU)");
        String l=scc.nextLine();
        int opt=1;
        if(l.toUpperCase().equals("NU"))
        {
            opt=0;
            System.out.println("Introduceti numarul de clienti:");
            nrCl=Integer.parseInt(scc.nextLine());
            TipClient tipCli = new TipClient(c, nrCl);
            tipCli.TipCl();
        }
        TipClientAdd add=new TipClientAdd(opt,c,nrCl);
        AddClient addcl=new AddClient(c,c[0],nrCl);
        WarningAdd warningAdd=new WarningAdd();
        warningAdd.warning(addcl);
        add.AddCl();
        if(opt==0)
        {System.out.println("Dupa adaugare avem: ");
            for(int i=0;i<=nrCl;i++) {
                System.out.println("\nClientul nr " + (i + 1));
                c[i].AfisareClienti();
            }}
        result.getInstance().setOption(6);
        result.getInstance().WritingTimestamp();
    }
}
