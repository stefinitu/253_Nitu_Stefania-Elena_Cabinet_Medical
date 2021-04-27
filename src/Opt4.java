import java.io.FileWriter;
import java.io.IOException;

public class Opt4 {
    public void Option4() throws IOException {
        SingletonResult result=new SingletonResult();
        System.out.println("Datele consultatiei (Datele programarii, datele pacientului, datele retetei si datele medicului care efectueaza consultatia!)");
        Client cli=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");;
        Programare progr=new Programare(0,0,cli,0,0,0,0,0,0,"");
        String[] denum=new String[100];
        double[] pret=new double[100];
        int[] bucati=new int[100];
        Reteta re=new Reteta(0,2,denum,pret,bucati);
        InfoAngajare info=new InfoAngajare(" ",0,0,0,0.0);
        Medic med=new Medic(" ", " ", " ", info, " "," ",0," ",true, true);
        Consultatie cons=new Consultatie("",progr,0,0,0," ",re,med,0);
        cons.CitireConsultatie();
        FileWriter csvWrite4 = new FileWriter("src\\GenIDCons.csv",true);
        System.out.println("ID-ul consultatiei pacientului " + cons.getProg().getClient().getNume() + " " + cons.getProg().getClient().getPrenume() + " generat automat este: " + cons.getIdConsultatie());
        csvWrite4.append("Pacientul ");
        csvWrite4.append(cons.getProg().getClient().getNume());
        csvWrite4.append(String.join(",", cons.getIdConsultatie()));
        csvWrite4.append("\n");
        csvWrite4.flush();
        csvWrite4.close();
        result.getInstance().setOption(4);
        result.getInstance().WritingTimestamp();
    }
}
