import java.io.IOException;
import java.util.Scanner;

public class TipClientAdd {
    int opt;
    Client[] c;
    int nrCl;

    public TipClientAdd(int opt, Client[] c, int nrCl) {
        this.opt = opt;
        this.nrCl = nrCl;
        this.c=c;
    }

    public void AddCl() throws IOException {
        Scanner scc=new Scanner(System.in);
        String l;
        System.out.println("Noul client");
        System.out.println("\nIntroduceti tipul de client (client minor/client major):");
        l=scc.nextLine();
        Client pacientNou;
        switch(l.toUpperCase()){
            case "CLIENT MINOR":
                pacientNou=new ClientMinor("000000", " ", " ", " ", " ", " ", " ", " ", " ");
                pacientNou.CitireClienti();
                AddClient add=new AddClient(c,pacientNou,nrCl);
                if(opt==0) add.AdaugareClient();
                else add.AdaugareClientMinCSV();
                break;
            case "CLIENT MAJOR":
                pacientNou=new ClientMajor("000000", " ", " ", " "," "," ",0," ");
                pacientNou.CitireClienti();
                AddClient addc=new AddClient(c,pacientNou,nrCl);
                if(opt==0) addc.AdaugareClient();
                else addc.AdaugareClientMajCSV();
                break;
            default:
                System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                break;
        }
    }
}
