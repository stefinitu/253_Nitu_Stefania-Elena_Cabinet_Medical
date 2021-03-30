import java.text.*;
import java.util.*;

import Services.SumaMedicamente;
import Services.CostSpitalizare;
import Services.VerificareDate;
public class MenuMain {
    public void menu()
    {System.out.println("CABINET MEDICAL - MENIU \n Alegeti din urmatoarele optiuni: \n1.Ordonarea crescatoare a clientilor (cititi) dupa numele de familie si verificarea corectitudinii datelor introduse\n2.Suma medicamentelor pentru fiecare reteta dintr-o lista data \n3.Sa se afiseze salariul minim, maxim si mediu dintr-o lista de angajati \n4.Generare ID consultatie \n5.Sa se afiseze data nasterii pentru clienti utilizand CNP-ul \n6.Sa se adauge un client nou in baza de date \n7.Sa se stearga un client dintr-un array dat dupa CNP-ul sau \n8.Pentru medicii cu vechime mai mare de 10 ani se acorda sporuri de 25% la salariul actual. Sa se afiseze noul salariu dupa bonus \n9.Persoanele peste 60 de ani beneficiaza de o reducere de 80% la pretul fiecarui medicament dintr-o reteta. Se afiseaza noua suma dupa aplicarea reducerii pentru un vector de consultatii. \n10.Sa se verifice pentru fiecare programare citita daca data planificata este in weekend. Daca este in weekend, se modifica data planificata pentru Luni (saptamana urmatoare). \n11.Sa se calculeze costul suplimentar platit de un client care necesita spitalizare (100 lei/zi pentru major, 80 lei/zi pentru minor)");
    }
    public MenuMain() throws ParseException {
        Scanner in =new Scanner(System.in);
        menu();
        switch(in.nextInt())
        {
            case 1:
                Scanner sc=new Scanner(System.in);
                int nrClienti;
                System.out.println("Introduceti numarul de clienti:");
                nrClienti=Integer.parseInt(sc.nextLine());
                Client cl[] = new Client[nrClienti];
                String linie;
                for(int i=0;i<nrClienti;i++)
            {
                System.out.println("Introduceti tipul de client:");
                linie=sc.nextLine();
                switch(linie.toUpperCase()){
                case "CLIENT MINOR":
                    cl[i]=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                    cl[i].CitireClienti();
                    VerificareDate verif=new VerificareDate(cl[i].getCnp(),cl[i].getEmail());
                    if(verif.VerificareCNP()==false) System.out.println("CNP invalid!");
                    if(verif.VerificareEmail()==false) System.out.println("Email invalid!");
                    break;
                case "CLIENT MAJOR":
                    cl[i]=new ClientMajor(" ", " ", " ", " "," "," ",0," ");
                    cl[i].CitireClienti();
                    VerificareDate verific=new VerificareDate(cl[i].getCnp(),cl[i].getEmail());
                    if(verific.VerificareCNP()==false) System.out.println("CNP invalid!");
                    if(verific.VerificareEmail()==false) System.out.println("Email invalid!");
                    break;
                default:
                    System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                    break;
            }
            }
                Arrays.sort(cl);
                for(int i=0;i<nrClienti;i++)
                {
                    System.out.println("\nClientul nr "+(i+1));
                    cl[i].AfisareClienti();
                }
                break;
            case 2:
                Scanner scn=new Scanner(System.in);
                int nrRetete;
                System.out.println("Introduceti numarul de retete:");
                nrRetete=scn.nextInt();
                Reteta[] r=new Reteta[nrRetete];
                for(int i=0;i<nrRetete;i++)
                {   String[] den={"a","b"};
                    double[] pr={1.7,2.6};
                    int[] bu={5,6};
                    r[i]=new Reteta(0,2,den,pr,bu);
                }
                for(int i=0;i<nrRetete;i++)
                {r[i].CitireReteta();}
                for(int i=0;i<nrRetete;i++)
                {
                    SumaMedicamente sum = new SumaMedicamente(r[i].getNr_medicamente(),r[i].getNr_bucati(), r[i].getPret());
                    double calc =sum.CalculSumaMed();
                    System.out.println("\nSuma medicamentelor de pe reteta "+(i+1)+" este "+calc);
                }
                break;
            case 3:
                Scanner sca=new Scanner(System.in);
                int nrPers;
                System.out.println("Introduceti numarul de angajati:");
                nrPers=sca.nextInt();
                Personal p[] = new Personal[nrPers];
                String line;
                for(int i=0;i<nrPers;i++)
                {
                    System.out.println("Introduceti tipul de angajat (medic/asistent):");
                    line=in.next();
                    switch(line.toUpperCase()){
                        case "MEDIC":
                            p[i]=new Medic(" ", " ", " ", " ", 0, 0, 0, 0," "," ",0," ", true, true);
                            p[i].CitirePersonal();
                            break;
                        case "ASISTENT":
                            p[i]=new Asistent(" ", " ", " ", " ",0,0,0,0.0, " ", " ",0);
                            p[i].CitirePersonal();
                            break;
                        default:
                            System.out.println("Optiune invalida! Alegeti dintre MEDIC sau ASISTENT!");
                            break;
                    }
                }
                for(int i=0;i<nrPers;i++)
                {
                    System.out.println("\nPersonalul nr "+(i+1));
                    p[i].AfisarePersonal();
                }
                MaxMinAverage maxMinAverage = new MaxMinAverage(p,nrPers);
                double maxsal=maxMinAverage.Maxim();
                double minsal=maxMinAverage.Minim();
                double average=maxMinAverage.Average();
                System.out.println("Salariul maxim este:"+ maxsal + "\nSalariul minim este: "+ minsal + "\n" + "\nSalariul mediu este" + average);
                break;
            case 4:
                System.out.println("Datele consultatiei (Datele programarii, datele pacientului, datele retetei si datele medicului care efectueaza consultatia!)");
                Client cli=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");;
                Programare progr=new Programare(0,0,cli,0,0,0,0,0,0,"");
                String[] denum={"a","b"};
                double[] pret={1.7,2.6};
                int[] bucati={5,6};
                Reteta re=new Reteta(0,2,denum,pret,bucati);
                Medic med=new Medic(" ", " ", " ", " ", 0, 0, 0, 0.0, " "," ",0," ",true, true);
                Consultatie cons=new Consultatie("",progr,0,0,0," ",re,med,0);
                cons.CitireConsultatie();
                System.out.println("ID-ul consultatiei pacientului " + cons.getProg().getClient().getNume() + " " + cons.getProg().getClient().getPrenume() + " generat automat este: " + cons.getIdConsultatie());
                break;
            case 5:
                Scanner scanner5=new Scanner(System.in);
                int nClients;
                System.out.println("Introduceti numarul de clienti:");
                nClients=Integer.parseInt(scanner5.nextLine());
                Client persoana[] = new Client[nClients];
                String lines;
                for(int i=0;i<nClients;i++)
                {
                    System.out.println("Introduceti tipul de client (client minor/client major):");
                    lines=scanner5.nextLine();
                    switch(lines.toUpperCase()){
                        case "CLIENT MINOR":
                            persoana[i]=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                            persoana[i].CitireClienti();
                            break;
                        case "CLIENT MAJOR":
                            persoana[i]=new ClientMajor(" ", " ", " ", " "," "," ",0," ");
                            persoana[i].CitireClienti();
                            break;
                        default:
                            System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                            break;
                    }
                }
                for(int i=0;i<nClients;i++)
                 persoana[i].CalculVarsta();
                break;
            case 6:
                Scanner scc=new Scanner(System.in);
                int nrCl;
                System.out.println("Introduceti numarul de clienti:");
                nrCl=Integer.parseInt(scc.nextLine());
                Client[] c = new Client[nrCl+1];
                String l;
                for(int i=0;i<nrCl;i++)
                {
                    System.out.println("Introduceti tipul de client (client minor/client major):");
                    l=scc.nextLine();
                    switch(l.toUpperCase()){
                        case "CLIENT MINOR":
                            c[i]=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                            c[i].CitireClienti();
                            break;
                        case "CLIENT MAJOR":
                            c[i]=new ClientMajor(" ", " ", " ", " "," "," ",0," ");
                            c[i].CitireClienti();
                            break;
                        default:
                            System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                            break;
                    }
                }
                System.out.println("Afisam clientii din baza de date:");
                for(int i=0;i<nrCl;i++) {
                    System.out.println("\nClientul nr " + (i + 1));
                    c[i].AfisareClienti();
                }
                System.out.println("Noul client");
                System.out.println("\nIntroduceti tipul de client (client minor/client major):");
                l=scc.nextLine();
                Client pacientNou;
                switch(l.toUpperCase()){
                    case "CLIENT MINOR":
                        pacientNou=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                        pacientNou.CitireClienti();
                        AddClient add=new AddClient(c,pacientNou,nrCl);
                        add.AdaugareClient();
                        break;
                    case "CLIENT MAJOR":
                        pacientNou=new ClientMajor(" ", " ", " ", " "," "," ",0," ");
                        pacientNou.CitireClienti();
                        AddClient addc=new AddClient(c,pacientNou,nrCl);
                        addc.AdaugareClient();
                        break;
                    default:
                        System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                        break;
                }
                System.out.println("Dupa adaugare avem: ");
                for(int i=0;i<=nrCl;i++) {
                    System.out.println("\nClientul nr " + (i + 1));
                    c[i].AfisareClienti();
                }
                break;
            case 7:
                Scanner s=new Scanner(System.in);
                System.out.println("Introduceti numarul de pacienti din baza de date:");
                int nrPacienti=Integer.parseInt(s.nextLine());;
                Client[] clie=new Client[nrPacienti];
                String st;
                for(int i=0;i<nrPacienti;i++)
                {
                    System.out.println("Introduceti tipul de client (client minor/client major):");
                    st=s.nextLine();
                    switch(st.toUpperCase()){
                        case "CLIENT MINOR":
                            clie[i]=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                            clie[i].CitireClienti();
                            break;
                        case "CLIENT MAJOR":
                            clie[i]=new ClientMajor(" ", " ", " ", " "," "," ",0," ");
                            clie[i].CitireClienti();
                            break;
                        default:
                            System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                            break;
                    }
                }
                String alegere=" ";
                System.out.println("Introduceti CNP-ul persoanei pe care doriti sa o stergeti:");
                alegere=s.nextLine();
                DeleteClient del=new DeleteClient(clie,alegere);
                del.StergereClient();
                System.out.println("Afisam pacientii ramasi:");
                for(int i=0;i<nrPacienti-1;i++)
                    clie[i].AfisareClienti();
                break;
            case 8:
                Scanner scanner8=new Scanner(System.in);
                int nrMed=0;
                System.out.println("Introduceti numarul de medici:");
                nrMed=Integer.parseInt(scanner8.nextLine());
                Medic medic[] = new Medic[nrMed];
                for(int i=0;i<nrMed;i++) {
                    medic[i]=new Medic(" ", " ", " ", " ", 0, 0, 0, 0.0, " "," ",0," ",true, true);
                    medic[i].CitirePersonal();
                }
                for(int i=0;i<nrMed;i++)
                {
                    BonusMedic bonusMedic=new BonusMedic(medic[i]);
                    bonusMedic.AdaugareBonusMedic();
                }
                System.out.println("Afisare lista de medici dupa aplicarea bonusului:");
                for(int i=0;i<nrMed;i++)
                    System.out.println("\nMedicul " + medic[i].getNume() +" " + medic[i].getPrenume() + " are salariul " + medic[i].getSalariu());
                break;
            case 9:
                Scanner inp=new Scanner(System.in);
                System.out.println("Introduceti datele consultatiei:");
                System.out.println("Introduceti numarul de consultatii:");
                int nrcons=Integer.parseInt(inp.nextLine());
                Consultatie[] consult=new Consultatie[nrcons];
                Client clientInit=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                Programare pro=new Programare(0,0,clientInit,0,0,0,0,0,0," ");
                String[] name={"a","b"};
                double[] price={1.7,2.6};
                int[] nrbuc={5,6};
                Reteta ret=new Reteta(0,2,name,price,nrbuc);
                Medic doc=new Medic(" ", " ", " ", " ", 0, 0, 0, 0.0, " "," ",0," ",true, true);
                for(int i=0;i<nrcons;i++)
                {consult[i]=new Consultatie(" ",pro,0,0,0," ",ret,doc,0);
                consult[i].CitireConsultatie();
                Reducere red=new Reducere(consult[i]);
                red.ReducereClienti();
                }
                break;
            case 10:
                Scanner sc10=new Scanner(System.in);
                Client pac;
                int nrPr=0;
                String dataPlanif="05/05/2020";
                String dataProg="04/06/2020";
                pac = new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                System.out.println("Introduceti numarul de programari:");
                nrPr= Integer.parseInt(sc10.nextLine());
                Programare[] programare=new Programare[nrPr];
                SimpleDateFormat sdf;
                Date dataPlan,dataPr;
                Calendar calendar = Calendar.getInstance();
                for(int i=0;i<nrPr;i++)
                {programare[i]=new Programare(0,0,pac,0,0,0,0,0,0,"");
                    programare[i].CitireProg();
                    VerificarePlanifWeekend verificareWeekend =new VerificarePlanifWeekend(programare[i]);
                    verificareWeekend.VerificarePlanificareWeekend();
                }
                System.out.println("Noile date planificate sunt:");
                for(int i=0;i<nrPr;i++)
                {
                    System.out.println("Pentru programarea "+(i+1)+ " avem: "+ programare[i].getZi_planificare()+"/"+programare[i].getLuna_planificare()+"/"+programare[i].getAn_planificare());
                }
                break;
            case 11:
                Scanner scan11=new Scanner(System.in);
                int numarConsultatii=0;
                System.out.println("Introduceti numarul de consultatii:");
                numarConsultatii=Integer.parseInt(scan11.nextLine());
                Consultatie[] cs = new Consultatie[numarConsultatii];
                Client client_initial=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                Programare program=new Programare(0,0,client_initial,0,0,0,0,0,0," ");
                String[] namemed={"a","b"};
                double[] pricemed={1.7,2.6};
                int[] nrbucmed={5,6};
                Reteta reteta=new Reteta(0,2,namemed,pricemed,nrbucmed);
                Medic doctor=new Medic(" ", " ", " ", " ", 0, 0, 0, 0.0, " "," ",0," ",true, true);
                for(int i=0;i<numarConsultatii;i++)
                {cs[i]=new Consultatie(" ",program,0,0,0," ",reteta,doctor,0);
                cs[i].CitireConsultatie();
                if(cs[i].getNrZileSpitalizare()!=0)
                {
                    if (cs[i].getProg().getClient() instanceof ClientMinor)
                    {CostSpitalizare costs=new CostSpitalizare(cs[i].getNrZileSpitalizare());
                    int costSpitalizareMinor=costs.CostClientMinor();
                    System.out.println("\nPacientul "+ cs[i].getProg().getClient().getNume() + " " + cs[i].getProg().getClient().getPrenume() + " trebuie sa achite "+ costSpitalizareMinor + " lei.");}
                    else
                    {   CostSpitalizare costs=new CostSpitalizare(cs[i].getNrZileSpitalizare());
                        int costSpitalizareMajor=costs.CostClientMajor();
                        System.out.println("\nPacientul "+ cs[i].getProg().getClient().getNume() + " " + cs[i].getProg().getClient().getPrenume() + " trebuie sa achite "+ costSpitalizareMajor + " lei.");}
                }
                else System.out.println("Pacientul " + cs[i].getProg().getClient().getNume() + " " + cs[i].getProg().getClient().getPrenume() + " nu trebuie sa achite nimic.");
                }
                break;
            default:
                System.err.println("Optiune invalida! Alegeti un numar intre 1-11!");
                break;
        }
    }
    public static void main(String[] args) throws Exception{
        new MenuMain();
    }
}
