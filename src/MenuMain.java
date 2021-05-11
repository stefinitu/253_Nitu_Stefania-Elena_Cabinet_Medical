import java.io.IOException;
import java.text.*;
import java.util.*;


public class MenuMain {
    public void menu()
    {System.out.println("CABINET MEDICAL - MENIU \n Alegeti din urmatoarele optiuni: \n1.SELECT CLIENT MAJOR \n2.INSERT IN CLIENT MAJOR \n3.DELETE IN CLIENT MAJOR \n4.UPDATE IN CLIENT MAJOR \n5. SELECT IN CLIENT MINOR \n6.INSERT IN CLIENT MINOR \n7.DELETE CLIENT MINOR \n8.UPDATE IN CLIENT MINOR \n9.INSERT CLIENTI MAJORI DIN FISIER CSV \n10.INSERT CLIENTI MINORI DIN FISIER CSV \n11.SELECT MEDIC \n12.INSERT IN MEDIC \n 13.DELETE DIN MEDIC \n 14.UPDATE IN MEDIC");
    }
    public MenuMain() throws ParseException, IOException {
        Scanner in =new Scanner(System.in);
        menu();
        SingletonBD.getInstanceMaj().ClMajInsertCSV();
        switch(in.nextInt())
        {
            case 1:
                SingletonBD.getInstanceMaj().ClMajSelect();
                break;
            case 2:
                SingletonBD.getInstanceMaj().ClMajInsert();
                break;
            case 3:
                SingletonBD.getInstanceMaj().ClMajDelete();
                break;
            case 4:
                SingletonBD.getInstanceMaj().ClMajUpdate();
                break;
            case 5:
                SingletonBD.getInstanceMin().ClMinSelect();
                break;
            case 6:
                SingletonBD.getInstanceMin().ClMinInsert();
                break;
            case 7:
                SingletonBD.getInstanceMin().ClMinDelete();
                break;
            case 8:
                SingletonBD.getInstanceMin().ClMinUpdate();
                break;
            case 9:
                SingletonBD.getInstanceMaj().ClMajInsertCSV();
                break;
            case 10:
                SingletonBD.getInstanceMin().ClMinInsertCSV();
                break;
            case 11:
                Opt11 opt11=new Opt11();
                opt11.Option11();
                break;
            case 12:
                Opt12 opt12=new Opt12();
                opt12.Option12();
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
