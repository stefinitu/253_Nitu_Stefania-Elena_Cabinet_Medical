import java.util.*;
public class Menu_Main {
    public void menu()
    {System.out.println("Alegeti din urmatoarele optiuni: \n1.Ordonarea crescatoare a clientilor (cititi) dupa numele de familie \n2.Suma medicamentelor pentru fiecare reteta dintr-o lista data \n3.Sa se afiseze salariul minim, maxim si mediu dintr-o lista de angajati \n 4.");
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
                    cl[i]=new ClientMajor(0, " ", " ", " "," "," "," ",0, " ");
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
                {   r[i].CitireReteta();}
                for(int i=0;i<nr_retete;i++)
                {System.out.println("\nMedicamentul " + (i+1));
                    System.out.println(Double.toString(r[i].SumaMedicamente(r[i].getNr_medicamente(),r[i].getNr_bucati(), r[i].getPret())));}
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
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
