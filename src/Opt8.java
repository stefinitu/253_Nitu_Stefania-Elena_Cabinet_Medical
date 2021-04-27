import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opt8 {
    public void Option8() throws IOException {
        SingletonCitire singletonCitire=new SingletonCitire();
        SingletonResult result=new SingletonResult();
        int opt;
        Scanner scanner8=new Scanner(System.in);
        int nrMed=0;
        Medic medic[] = new Medic[100];
        System.out.println("Cititi clientii din fisier? (DA/NU)");
        String str8=scanner8.nextLine();
        opt=1;
        BonusMedic bonusMedic=new BonusMedic();
        InfoAngajare info=new InfoAngajare(" ",0,0,0,0.0);
        if(str8.toUpperCase()=="NU")
        {System.out.println("Introduceti numarul de medici:");
            nrMed=Integer.parseInt(scanner8.nextLine());
            for(int i=0;i<nrMed;i++) {
                medic[i]=new Medic(" ", " ", " ", info, " "," ",0," ",true, true);
                medic[i].CitirePersonal();
                bonusMedic.AdaugareBonusMedic(medic[i]);
            }
            System.out.println("Afisare lista de medici dupa aplicarea bonusului:");
            for(int i=0;i<nrMed;i++)
                System.out.println("\nMedicul " + medic[i].getNume() +" " + medic[i].getPrenume() + " are salariul " + medic[i].infoAngajare.getSalariu());}
        else
        {
            List <List<String>> medici=new ArrayList<>();
            singletonCitire.getInstanceRead().ReadingMedic();
            medici.addAll(singletonCitire.getInstanceRead().getMedici());
            bonusMedic.AdaugareBonusMedicCSV(medici);
            result.getInstance().setM(medici);
            result.getInstance().WritingMedic();}

        result.getInstance().setOption(8);
        result.getInstance().WritingTimestamp();
    }
}
