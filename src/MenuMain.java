import java.io.IOException;
import java.text.*;
import java.util.*;


public class MenuMain {
    public void menu()
    {System.out.println("CABINET MEDICAL - MENIU \n Alegeti din urmatoarele optiuni: \n1.SELECT CLIENT MAJOR \n2.INSERT IN CLIENT MAJOR \n3.DELETE IN CLIENT MAJOR \n4.UPDATE IN CLIENT MAJOR \n5.SELECT IN CLIENT MINOR \n6.INSERT IN CLIENT MINOR \n7.DELETE CLIENT MINOR \n8.UPDATE IN CLIENT MINOR \n9.INSERT CLIENTI MAJORI DIN FISIER CSV \n10.INSERT CLIENTI MINORI DIN FISIER CSV \n11.SELECT MEDIC \n12.INSERT IN MEDIC \n13.UPDATE IN MEDIC \n14.INSERT MEDICI DIN FISIER CSV \n15.DELETE MEDIC \n16.PROGRAMARE CLIENT MAJOR SELECT \n17.PROGRAMARE CLIENT MAJOR INSERT \n18.PROGRAMARE CLIENT MAJOR UPDATE \n19.PROGRAMARE CLIENT MAJOR DELETE \n20.PROGRAMARE CLIENT MINOR SELECT \n21.PROGRAMARE CLIENT MINOR INSERT \n22.PROGRAMARE CLIENT MINOR UPDATE \n23.PROGRAMARE CLIENT MINOR DELETE");
    }
    public MenuMain() throws ParseException, IOException {
        Scanner in =new Scanner(System.in);
        menu();
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
                SingletonBD.getInstanceMed().MedicSelect();
                break;
            case 12:
                SingletonBD.getInstanceMed().MedicInsert();
                break;
            case 13:
                SingletonBD.getInstanceMed().MedicUpdate();
                break;
            case 14:
                SingletonBD.getInstanceMed().MedicInsertCSV();
                break;
            case 15:
                SingletonBD.getInstanceMed().MedicDelete();
                break;
            case 16:
                SingletonBD.getInstancePrMaj().PrMajSelect();
                break;
            case 17:
                SingletonBD.getInstancePrMaj().ProgMajInsert();
                break;
            case 18:
                SingletonBD.getInstancePrMaj().PrMajUpdate();
                break;
            case 19:
                SingletonBD.getInstancePrMaj().PrMajDelete();
                break;
            case 20:
                SingletonBD.getInstancePrMin().PrMinSelect();
                break;
            case 21:
                SingletonBD.getInstancePrMin().ProgMinInsert();
                break;
            case 22:
                SingletonBD.getInstancePrMin().PrMinUpdate();
                break;
            case 23:
                SingletonBD.getInstancePrMin().PrMinDelete();
                break;
            default:
                System.err.println("Optiune invalida! Alegeti un numar intre 1-15!");
                break;
        }
    }
    public static void main(String[] args) throws Exception{
        new MenuMain();
    }
}
