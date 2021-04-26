import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opt7 {
    public void Option7() throws IOException {
        SingletonCitire singletonCitire=new SingletonCitire();
        SingletonResult result=new SingletonResult();
        int opt;
        Scanner s=new Scanner(System.in);
        Client[] clie=new Client[100];
        List<List<String>> clientimin=new ArrayList<>();
        List<List<String>> clientimaj=new ArrayList<>();
        int nrPacienti=0;
        System.out.println("Cititi clientii din fisier? (DA/NU)");
        String st=s.nextLine();
        String clientop=" ";
        opt=1;
        if(st.toUpperCase().equals("NU"))
        {System.out.println("Introduceti numarul de pacienti din baza de date:");
            nrPacienti=Integer.parseInt(s.nextLine());;
            TipClient tipclienti=new TipClient(clie,nrPacienti);
            tipclienti.TipCl();
            if(clie[0] instanceof ClientMinor) clientop="CLIENT MINOR";
            else clientop="CLIENT MAJOR";
        }
        else
        {
            System.out.println("Introduceti tipul de client (client minor/client major):");
            st=s.nextLine();
            switch(st.toUpperCase()){
                case "CLIENT MINOR":
                    singletonCitire.getInstanceRead().ReadingClientMinor();
                    clientimin.addAll(singletonCitire.getInstanceRead().getClientimin());
                    break;
                case "CLIENT MAJOR":
                    singletonCitire.getInstanceRead().ReadingClientMajor();
                    clientimaj.addAll(singletonCitire.getInstanceRead().getClientimaj());
                    break;
                default:
                    System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                    break;
            }
            if(clientimin.isEmpty()) clientop="CLIENT MAJOR";
            else clientop="CLIENT MINOR";
        }

        String alegere=" ";
        System.out.println("Introduceti CNP-ul persoanei pe care doriti sa o stergeti:");
        alegere=s.nextLine();
        if(opt==0)
        { DeleteClient del=new DeleteClient(clie,alegere);
            del.StergereClient();
            System.out.println("Afisam pacientii ramasi:");
            for(int i=0;i<nrPacienti-1;i++)
                clie[i].AfisareClienti();}
        else
        {
            DeleteClient del=new DeleteClient(clie,alegere);
            if(clientop.equals("CLIENT MINOR"))
            {
                del.setClmin(clientimin);
                del.StergereClientMinCSV();
            }
            else {
                del.setClmaj(clientimaj);
                del.StergereClientMajCSV();
            }
        }
        result.getInstance().setOption(7);
        result.getInstance().WritingTimestamp();
    }
}
