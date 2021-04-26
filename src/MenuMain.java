import java.io.FileWriter;
import java.io.IOException;
import java.text.*;
import java.util.*;

import Services.SumaMedCSV;
import Services.SumaMedicamente;


public class MenuMain {
    public void menu()
    {System.out.println("CABINET MEDICAL - MENIU \n Alegeti din urmatoarele optiuni: \n1.Ordonarea crescatoare a clientilor (cititi) dupa numele de familie si verificarea corectitudinii datelor introduse\n2.Suma medicamentelor pentru fiecare reteta dintr-o lista data \n3.Sa se afiseze salariul minim, maxim si mediu dintr-o lista de angajati \n4.Generare ID consultatie \n5.Sa se afiseze data nasterii pentru clienti utilizand CNP-ul \n6.Sa se adauge un client nou in baza de date \n7.Sa se stearga un client dintr-un array dat dupa CNP-ul sau \n8.Pentru medicii cu vechime mai mare de 10 ani se acorda sporuri de 25% la salariul actual. Sa se afiseze noul salariu dupa bonus \n9.Persoanele peste 60 de ani beneficiaza de o reducere de 80% la pretul fiecarui medicament dintr-o reteta. Se afiseaza noua suma dupa aplicarea reducerii pentru un vector de consultatii. \n10.Sa se verifice pentru fiecare programare citita daca data planificata este in weekend. Daca este in weekend, se modifica data planificata pentru Luni (saptamana urmatoare). \n11.Sa se calculeze costul suplimentar platit de un client care necesita spitalizare (100 lei/zi pentru major, 80 lei/zi pentru minor) \n12.Citire si afisare obiecte din fisier csv");
    }
    public MenuMain() throws ParseException, IOException {
        Scanner in =new Scanner(System.in);
        SingletonResult result=new SingletonResult();
        SingletonCitire singletonCitire =new SingletonCitire();
        int opt;
        menu();
        switch(in.nextInt())
        {
            case 1:
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
                break;
            case 2:
                Opt2 opt2=new Opt2();
                opt2.Option2();
                break;
            case 3:
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
                break;
            case 4:
                Opt4 opt4=new Opt4();
                opt4.Option4();
                break;
            case 5:
                Opt5 opt5=new Opt5();
                opt5.Option5();
                break;
            case 6:
                Opt6 opt6=new Opt6();
                opt6.Opt6();
                break;
            case 7:
                Opt7 opt7=new Opt7();
                opt7.Option7();
                break;
            case 8:
                Opt8 opt8=new Opt8();
                opt8.Option8();
                break;
            case 9:
                Opt9 opt9=new Opt9();
                opt9.Option9();
                break;
            case 10:
                Opt10 opt10=new Opt10();
                opt10.Opt10();
                break;
            case 11:
                Opt11 opt11=new Opt11();
                opt11.Option11();
                break;
            case 12:
                Scanner scanner12=new Scanner(System.in);
                System.out.println("Introduceti tipul de obiect pe care doriti sa il cititi (medic/asistent/reteta/client major/client minor):");
                String aleg=scanner12.nextLine();
                switch(aleg.toUpperCase()){
                    case "MEDIC":
                        SingletonCitire.getInstanceRead().ReadingMedic();
                        SingletonResult.getInstance().WritingMedic();
                        break;
                    case "ASISTENT":
                        SingletonCitire.getInstanceRead().ReadingAsistent();
                        SingletonResult.getInstance().WritingAsistent();
                        break;
                    case "RETETA":
                        SingletonCitire.getInstanceRead().ReadingReteta();
                        SingletonResult.getInstance().WritingReteta();
                        break;
                    case "CLIENT MAJOR":
                        SingletonCitire.getInstanceRead().ReadingClientMajor();
                        SingletonResult.getInstance().WritingClientMajor();
                        break;
                    case "CLIENT MINOR":
                        SingletonCitire.getInstanceRead().ReadingClientMinor();
                        SingletonResult.getInstance().WritingClientMinor();
                        break;
                    default:
                        System.out.println("Optiune invalida!");
                        break;}
                break;
            default:
                System.err.println("Optiune invalida! Alegeti un numar intre 1-12!");
                break;
        }
    }
    public static void main(String[] args) throws Exception{
        new MenuMain();
    }
}
