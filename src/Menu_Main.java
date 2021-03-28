import java.text.*;
import java.util.*;
public class Menu_Main {
    public void menu()
    {System.out.println("CABINET MEDICAL - MENIU \n Alegeti din urmatoarele optiuni: \n1.Ordonarea crescatoare a clientilor (cititi) dupa numele de familie \n2.Suma medicamentelor pentru fiecare reteta dintr-o lista data \n3.Sa se afiseze salariul minim, maxim si mediu dintr-o lista de angajati \n4.Generare ID consultatie \n5.Sa se afiseze data nasterii pentru clienti utilizand CNP-ul \n6.Sa se adauge un client nou in baza de date \n7.Sa se stearga o programare dintr-o lista de programari data dupa id-ul sau \n8.Pentru medicii cu vechime mai mare de 10 ani se acorda sporuri de 25% la salariul actual. Sa se afiseze noul salariu dupa bonus \n9.Persoanele peste 60 de ani beneficiaza de o reducere de 80% la pretul fiecarui medicament dintr-o reteta. Se afiseaza noua suma dupa aplicarea reducerii pentru un vector de consultatii. \n10.Sa se verifice pentru fiecare programare citita daca data planificata este in weekend. Daca este in weekend, se modifica data planificata pentru Luni (saptamana urmatoare). ");
    }
    public Menu_Main() throws ParseException {
        Scanner in =new Scanner(System.in);
        menu();
        switch(in.nextInt())
        {
            case 1:
                Scanner sc=new Scanner(System.in);
                int nr_clienti;
                System.out.println("Introduceti numarul de clienti:");
                nr_clienti=Integer.parseInt(sc.nextLine());
                Client cl[] = new Client[nr_clienti];
                String linie;
                for(int i=0;i<nr_clienti;i++)
            {
                System.out.println("Introduceti tipul de client:");
                linie=sc.nextLine();
                switch(linie.toUpperCase()){
                case "CLIENT MINOR":
                    cl[i]=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                    cl[i].CitireClienti();
                    break;
                case "CLIENT MAJOR":
                    cl[i]=new ClientMajor(" ", " ", " ", " "," "," ",0," ");
                    cl[i].CitireClienti();
                    break;
                default:
                    System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                    break;
            }
            }
                Arrays.sort(cl);
                for(int i=0;i<nr_clienti;i++)
                {
                    System.out.println("\nClientul nr "+(i+1));
                    cl[i].AfisareClienti();
                }
                break;
            case 2:
                Scanner scn=new Scanner(System.in);
                int nr_retete;
                System.out.println("Introduceti numarul de retete:");
                nr_retete=scn.nextInt();
                Reteta[] r=new Reteta[nr_retete];
                for(int i=0;i<nr_retete;i++)
                {   String[] den={"a","b"};
                    double[] pr={1.7,2.6};
                    int[] bu={5,6};
                    r[i]=new Reteta(0,2,den,pr,bu);
                }
                for(int i=0;i<nr_retete;i++)
                {r[i].CitireReteta();
                    System.out.println("citit");}
                for(int i=0;i<nr_retete;i++)
                {System.out.println("\nMedicamentul " + (i+1));
                    System.out.println(Double.toString(r[i].SumaMedicamente(r[i].getNr_medicamente(),r[i].getNr_bucati(), r[i].getPret())));}
                break;
            case 3:
                Scanner sca=new Scanner(System.in);
                int nr_pers;
                System.out.println("Introduceti numarul de angajati:");
                nr_pers=sca.nextInt();
                Personal p[] = new Personal[nr_pers];
                String line;
                for(int i=0;i<nr_pers;i++)
                {
                    System.out.println("Introduceti tipul de angajat:");
                    linie=in.next();
                    switch(linie.toUpperCase()){
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
                for(int i=0;i<nr_pers;i++)
                {
                    System.out.println("\nPersonalul nr "+(i+1));
                    p[i].AfisarePersonal();
                }
                double maxsal=0.0;
                double sumsal=0.0;
                double minsal=0.0;
                for(int i=0;i<nr_pers;i++)
                {
                    minsal=p[i].getSalariu();
                    if(maxsal<p[i].getSalariu()) maxsal=p[i].getSalariu();
                    if(minsal>p[i].getSalariu()) minsal=p[i].getSalariu();
                    sumsal=sumsal+p[i].getSalariu();
                }
                double mediu=sumsal/nr_pers;
                System.out.println("Salariul maxim este:"+ maxsal + "\nSalariul minim este: "+ minsal + "\n" + "\nSalariul mediu este" + mediu);
                break;
            case 4:
                Scanner input=new Scanner(System.in);
                System.out.println("Introduceti datele consultatiei:");
                System.out.println("Introduceti tipul de client (client minor/client major):");
                String lin=input.next();
                Client cli;
                switch(lin.toUpperCase()){
                    case "CLIENT MINOR":
                        cli=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                        cli.CitireClienti();
                        break;
                    case "CLIENT MAJOR":
                        cli=new ClientMajor(" ", " ", " ", " "," "," ",0," ");
                        cli.CitireClienti();
                        break;
                    default:
                        cli=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                        break;
                }
                Programare progr=new Programare(0,0,cli,0,0,0,0,0,0,"");
                String[] denum={"a","b"};
                double[] pret={1.7,2.6};
                int[] bucati={5,6};
                Reteta re=new Reteta(0,2,denum,pret,bucati);
                Medic med=new Medic(" ", " ", " ", " ", 0, 0, 0, 0.0, " "," ",0," ",true, true);
                Consultatie cons=new Consultatie("",progr,0,0,0," ",re,med,0);
                cons=new Consultatie();
                //cons.CitireConsultatie();
                System.out.println("ID-ul consultatiei generat automat este: " + cons.getId_consultatie());
                break;
            case 5:
                Scanner scanner5=new Scanner(System.in);
                int n_clients;
                System.out.println("Introduceti numarul de clienti:");
                n_clients=Integer.parseInt(scanner5.nextLine());
                Client persoana[] = new Client[n_clients];
                String lines;
                for(int i=0;i<n_clients;i++)
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
                for(int i=0;i<n_clients;i++)
                 persoana[i].CalculVarsta();
                break;
            case 6:
                Scanner scc=new Scanner(System.in);
                int nr_cl;
                System.out.println("Introduceti numarul de clienti:");
                nr_cl=Integer.parseInt(scc.nextLine());
                Client[] c = new Client[nr_cl+1];
                String l;
                for(int i=0;i<nr_cl;i++)
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
                for(int i=0;i<nr_cl;i++) {
                    System.out.println("\nClientul nr " + (i + 1));
                    c[i].AfisareClienti();
                }
                System.out.println("Noul client");
                System.out.println("\nIntroduceti tipul de client:");
                l=scc.nextLine();
                switch(l.toUpperCase()){
                    case "CLIENT MINOR":
                        c[nr_cl]=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                        c[nr_cl].CitireClienti();
                        break;
                    case "CLIENT MAJOR":
                        c[nr_cl]=new ClientMajor(" ", " ", " ", " "," "," ",0," ");
                        c[nr_cl].CitireClienti();
                        break;
                    default:
                        System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                        break;
                }
                System.out.println("Dupa adaugare avem: ");
                for(int i=0;i<=nr_cl;i++) {
                    System.out.println("\nClientul nr " + (i + 1));
                    c[i].AfisareClienti();
                }
                break;
            case 7:
                Scanner s=new Scanner(System.in);
                Client clie;
                int nr_progr=0;
              clie = new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                System.out.println("Introduceti numarul de programari:");
                nr_progr= Integer.parseInt(s.nextLine());
                Programare[] pr=new Programare[nr_progr];
                for(int i=0;i<nr_progr;i++)
                {pr[i]=new Programare(0,0,clie,0,0,0,0,0,0,"");
                pr[i].CitireProg();}
                double alegere=0;
                System.out.println("Introduceti ID-ul programarii pe care doriti sa o stergeti:");
                alegere=Double.parseDouble(s.nextLine());
                int mem=0;
                for(int i=0;i<nr_progr;i++)
                {if (pr[i].getId_programare()==alegere) mem=i;}
                for(int i=mem;i<nr_progr-1;i++)
                {pr[i]=pr[i+1];}
                System.out.println("Afisam programarile ramase:");
                for(int i=0;i<nr_progr-1;i++)
                    pr[i].AfisareProgramare();
                break;
            case 8:
                Scanner scanner8=new Scanner(System.in);
                int nr_med=0;
                System.out.println("Introduceti numarul de medici:");
                nr_med=Integer.parseInt(scanner8.nextLine());
                Medic medic[] = new Medic[nr_med];
                int vechime=0;
                int an_actual = Calendar.getInstance().get(Calendar.YEAR);
                for(int i=0;i<nr_med;i++) {
                    medic[i]=new Medic(" ", " ", " ", " ", 0, 0, 0, 0.0, " "," ",0," ",true, true);
                    medic[i].CitirePersonal();
                }
                for(int i=0;i<nr_med;i++)
                {
                    vechime=an_actual-medic[i].getAn_angajare();
                    if(vechime>=10) medic[i].SporuriMedic();
                }
                System.out.println("Afisare lista de medici dupa aplicarea bonusului:");
                for(int i=0;i<nr_med;i++)
                    System.out.println("\nMedicul " + medic[i].getNume() +" " + medic[i].getPrenume() + " are salariul " + medic[i].getSalariu());
                break;
            case 9:
                Scanner inp=new Scanner(System.in);
                System.out.println("Introduceti datele consultatiei:");
                System.out.println("Introduceti numarul de consultatii:");
                int nrcons=Integer.parseInt(inp.nextLine());
                Consultatie[] consult=new Consultatie[nrcons];
                Client client_init=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                Programare pro=new Programare(0,0,client_init,0,0,0,0,0,0," ");
                String[] name={"a","b"};
                double[] price={1.7,2.6};
                int[] nrbuc={5,6};
                Reteta ret=new Reteta(0,2,name,price,nrbuc);
                Medic doc=new Medic(" ", " ", " ", " ", 0, 0, 0, 0.0, " "," ",0," ",true, true);
                for(int i=0;i<nrcons;i++)
                {consult[i]=new Consultatie(" ",pro,0,0,0," ",ret,doc,0);
                //consult[i]=new Consultatie();
                consult[i].CitireConsultatie();
                String prefAn=" ";
                String sufAn=" ";
                int genInt = new Integer(consult[i].getProg().getClient().cnp.substring(0,1));
                if(genInt == 1 || genInt == 2) {
                    prefAn = "19";
                } else {
                    prefAn = "20";
                }
                sufAn = consult[i].getProg().getClient().cnp.substring(1, 3);
                String anNasterii = prefAn.concat(sufAn);
                System.out.println("\nAnul nasterii este:".concat(anNasterii));
                int year = Calendar.getInstance().get(Calendar.YEAR);
                int age=year-Integer.parseInt(anNasterii);
                if(age>=60) consult[i].getReteta().ReducereMedicamente();
                    System.out.println("Pentru pacientul "+ (i+1) + " noua suma dupa reducere este " + consult[i].getReteta().SumaMedicamente(consult[i].getReteta().getNr_medicamente(), consult[i].getReteta().getNr_bucati(), consult[i].getReteta().getPret()));
        }
                break;
            case 10:
                Scanner sc10=new Scanner(System.in);
                Client pac;
                int nr_pr=0;
                String dataPlanif="05/05/2020";
                String dataProg="04/06/2020";
                pac = new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                System.out.println("Introduceti numarul de programari:");
                nr_pr= Integer.parseInt(sc10.nextLine());
                Programare[] programare=new Programare[nr_pr];
                SimpleDateFormat sdf;
                Date dataPlan,dataPr;
                Calendar calendar = Calendar.getInstance();
                for(int i=0;i<nr_pr;i++)
                {programare[i]=new Programare(0,0,pac,0,0,0,0,0,0,"");
                    programare[i].CitireProg();
                    programare[i].VerificarePlanificareWeekend();
                }
                System.out.println("Noile date planificate sunt:");
                for(int i=0;i<nr_pr;i++)
                {
                    System.out.println("Pentru programarea "+(i+1)+ " avem: "+ programare[i].getZi_planificare()+"/"+programare[i].getLuna_planificare()+"/"+programare[i].getAn_planificare());
                }
                break;
            default:
                System.err.println("Optiune invalida! Alegeti un numar intre 1-10!");
                break;
        }
    }
    public static void main(String[] args) throws Exception{
        new Menu_Main();
    }
}
