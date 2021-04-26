import java.io.IOException;
import java.util.Scanner;

public class Opt11 {

    public void Option11() throws IOException {
        SingletonResult result=new SingletonResult();
        Scanner scan11=new Scanner(System.in);
        int numarConsultatii=0;
        System.out.println("Introduceti numarul de consultatii:");
        numarConsultatii=Integer.parseInt(scan11.nextLine());
        Consultatie[] cs = new Consultatie[numarConsultatii];
        Client client_initial=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        Programare program=new Programare(0,0,client_initial,0,0,0,0,0,0," ");
        String[] namemed=new String[100];
        double[] pricemed=new double[100];
        int[] nrbucmed=new int[100];
        Reteta reteta=new Reteta(0,2,namemed,pricemed,nrbucmed);
        Medic doctor=new Medic(" ", " ", " ", " ", 0, 0, 0, 0.0, " "," ",0," ",true, true);
        for(int i=0;i<numarConsultatii;i++)
        {cs[i]=new Consultatie(" ",program,0,0,0," ",reteta,doctor,0);
            cs[i].CitireConsultatie();
            CosturiCSV costs=new CosturiCSV(cs[i]);
            costs.CostsCSV();}

        result.getInstance().setOption(11);
        result.getInstance().WritingTimestamp();
    }
}
