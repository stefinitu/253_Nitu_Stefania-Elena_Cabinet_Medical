import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Opt12 {
    public void Option12() throws IOException {
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
    }
}
