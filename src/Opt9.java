import java.io.IOException;
import java.util.Scanner;

public class Opt9 {
    public void Option9() throws IOException {
        SingletonResult result=new SingletonResult();
        Scanner inp=new Scanner(System.in);
        System.out.println("Introduceti datele consultatiei:");
        System.out.println("Introduceti numarul de consultatii:");
        int nrcons=Integer.parseInt(inp.nextLine());
        InfoAngajare info=new InfoAngajare(" ",0,0,0,0.0);
        Consultatie[] consult=new Consultatie[nrcons];
        Client clientInit=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        Programare pro=new Programare(0,0,clientInit,0,0,0,0,0,0," ");
        String[] name=new String[100];
        double[] price=new double[100];
        int[] nrbuc=new int[100];
        Reteta ret=new Reteta(0,2,name,price,nrbuc);
        Medic doc=new Medic(" ", " ", " ", info, " "," ",0," ",true, true);
        for(int i=0;i<nrcons;i++)
        {consult[i]=new Consultatie(" ",pro,0,0,0," ",ret,doc,0);
            consult[i].CitireConsultatie();
            Reducere red=new Reducere(consult[i]);
            red.ReducereClienti();
        }
        result.getInstance().setOption(9);
        result.getInstance().WritingTimestamp();
    }
}
