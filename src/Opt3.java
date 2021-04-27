import java.util.Scanner;

public class Opt3 {
    public void Option3()
    {
        Scanner sca=new Scanner(System.in);
        int nrPers;
        System.out.println("Introduceti numarul de angajati:");
        nrPers=sca.nextInt();
        Personal p[] = new Personal[nrPers];
        String line;
        TipAngajat tipang=new TipAngajat(nrPers,p);
        tipang.AngajatTip();
        MaxMinAverage maxMinAverage = new MaxMinAverage(p,nrPers);
        double maxsal=maxMinAverage.Maxim();
        double minsal=maxMinAverage.Minim();
        double average=maxMinAverage.Average();
        System.out.println("Salariul maxim este:"+ maxsal + "\nSalariul minim este: "+ minsal + "\n" + "Salariul mediu este" + average);
    }
}
