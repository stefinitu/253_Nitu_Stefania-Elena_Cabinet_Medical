import java.util.*;
public class Menu_Main {
    public void menu()
    {System.out.println("Alegeti din urmatoarele optiuni: \n1.Ordonarea crescatoare a clientilor (cititi) dupa numele de familie \n2.Suma medicamentelor pentru fiecare reteta dintr-o lista data \n3.Sa se afiseze salariul minim, maxim si mediu dintr-o lista de angajati \n4.Generare ID consultatie \n5.Sa se afiseze data nasterii pentru clienti utilizand CNP-ul \n6.Sa se adauge un client nou in baza de date \n7.Sa se stearga o programare dintr-o lista de programari data dupa id-ul sau");
    }
    public Menu_Main()
    {
        Scanner in =new Scanner(System.in);
        menu();
        switch(in.nextInt())
        {
            case 1:
                Scanner sc=new Scanner(System.in);
                int nr_clienti;
                System.out.println("Introduceti numarul de clienti:");
                nr_clienti=sc.nextInt();
                Client cl[] = new Client[nr_clienti];
                String linie;
                for(int i=0;i<nr_clienti;i++)
            {
                System.out.println("Introduceti tipul de client:");
                linie=in.next();
                switch(linie.toUpperCase()){
                case "CLIENT MINOR":
                    cl[i]=new ClientMinor(0, " ", " ", " ", " ", " ", " ", " ", " ");
                    cl[i].CitireClienti();
                    break;
                case "CLIENT MAJOR":
                    cl[i]=new ClientMajor(0, " ", " ", " "," "," ",0," ");
                    cl[i].CitireClienti();
                    break;
                default:
                    System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                    break;
            }
            }
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
                            p[i]=new Medic(0, " ", " ", " ", 0, 0, 0, 0.0, " "," ",0," ",true, true);
                            p[i].CitirePersonal();
                            break;
                        case "ASISTENT":
                            p[i]=new Asistent(0, " ", " ", " ",0,0,0,0.0, " ", " ",0);
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
                        cli=new ClientMinor(0, " ", " ", " ", " ", " ", " ", " ", " ");
                        cli.CitireClienti();
                        break;
                    case "CLIENT MAJOR":
                        cli=new ClientMajor(0, " ", " ", " "," "," ",0," ");
                        cli.CitireClienti();
                        break;
                    default:
                        cli=new ClientMinor(0, " ", " ", " ", " ", " ", " ", " ", " ");
                        break;
                }
                Programare progr=new Programare(0,0,cli,0,0,0,0,0,0,"");
                String[] denum={"a","b"};
                double[] pret={1.7,2.6};
                int[] bucati={5,6};
                Reteta re=new Reteta(0,2,denum,pret,bucati);
                Medic med=new Medic(0, " ", " ", " ", 0, 0, 0, 0.0, " "," ",0," ",true, true);
                Consultatie cons=new Consultatie("",progr,0,0,0," ",re,med,0);
                cons=new Consultatie();
                //cons.CitireConsultatie();
                System.out.println("ID-ul consultatiei generat automat este: " + cons.getId_consultatie());
                break;
            case 5:
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
                            c[i]=new ClientMinor(0, " ", " ", " ", " ", " ", " ", " ", " ");
                            c[i].CitireClienti();
                            break;
                        case "CLIENT MAJOR":
                            c[i]=new ClientMajor(0, " ", " ", " "," "," ",0," ");
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
                        c[nr_cl]=new ClientMinor(0, " ", " ", " ", " ", " ", " ", " ", " ");
                        c[nr_cl].CitireClienti();
                        break;
                    case "CLIENT MAJOR":
                        c[nr_cl]=new ClientMajor(0, " ", " ", " "," "," ",0," ");
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
              clie = new ClientMinor(0, " ", " ", " ", " ", " ", " ", " ", " ");
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
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                System.err.println("Optiune invalida! Alegeti un numar intre 1-10!");
                break;
        }
    }
    public static void main(String[] args) {
        new Menu_Main();
    }
}
