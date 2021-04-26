import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TipClientAgeCSV {
    public void TipClCSV() throws IOException {
        SingletonCitire singletonCitire=new SingletonCitire();
        SingletonResult result=new SingletonResult();
        Scanner scanner5=new Scanner(System.in);
        String lines;
        System.out.println("Introduceti tipul de client (client minor/client major):");
        lines=scanner5.nextLine();
        switch(lines.toUpperCase()){
            case "CLIENT MINOR":
                singletonCitire.getInstanceRead().ReadingClientMinor();
                result.getInstance().WritingAge();
                break;
            case "CLIENT MAJOR":
                singletonCitire.getInstanceRead().ReadingClientMajor();
                result.getInstance().WritingAge();
                break;
            default:
                System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                break;
        }
    }
}
