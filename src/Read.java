import Services.ReadCSV;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Read implements ReadCSV {
    public void ReadingMedic() throws FileNotFoundException {
        Medic[] Med = new Medic[100];
        int i = 0;
        try (Scanner in = new Scanner(new File("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\Medic.csv"))) {
            while (in.hasNextLine()) {
                String linie = in.nextLine();
                String[] cuv = linie.split(";", 14);
                Med[i] = new Medic(" ", " ", " ", " ", 0, 0, 0, 0, " ", " ", 0, " ", true, true);
                Med[i].cnp = cuv[0];
                Med[i].nume = cuv[1];
                Med[i].prenume = cuv[2];
                Med[i].sectie = cuv[3];
                Med[i].ziAngajare = Integer.parseInt(cuv[4]);
                Med[i].lunaAngajare = Integer.parseInt(cuv[5]);
                Med[i].anAngajare = Integer.parseInt(cuv[6]);
                Med[i].salariu = Double.parseDouble(cuv[7]);
                Med[i].nrTelefon = cuv[8];
                Med[i].email = cuv[9];
                Med[i].setCodParafa(Double.parseDouble(cuv[10]));
                Med[i].setSpecializare(cuv[11]);
                Med[i].setRezident(Boolean.parseBoolean(cuv[12]));
                Med[i].setGarda(Boolean.parseBoolean(cuv[13]));
                i++;
            }
            System.out.println("Medicii cititi sunt:");
            for (int j = 0; j < i; j++) {
                System.out.println("\nMedicul nr " + (j + 1) + ":");
                Med[j].AfisarePersonal();
            }
        }
    }
        public void ReadingAsistent() throws FileNotFoundException {
            Asistent[] Asist = new Asistent[100];
            int i = 0;
            try (Scanner inn = new Scanner(new File("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\Asistent.csv"))) {
                while (inn.hasNextLine()) {
                    String line = inn.nextLine();
                    String[] cuv = line.split(";", 14);
                    Asist[i] = new Asistent(" ", " ", " ", " ",0,0,0,0.0, " ", " ",0);
                    Asist[i].cnp = cuv[0];
                    Asist[i].nume = cuv[1];
                    Asist[i].prenume = cuv[2];
                    Asist[i].sectie = cuv[3];
                    Asist[i].ziAngajare = Integer.parseInt(cuv[4]);
                    Asist[i].lunaAngajare = Integer.parseInt(cuv[5]);
                    Asist[i].anAngajare = Integer.parseInt(cuv[6]);
                    Asist[i].salariu = Double.parseDouble(cuv[7]);
                    Asist[i].nrTelefon = cuv[8];
                    Asist[i].email = cuv[9];
                    Asist[i].setNrSaloaneAtribuite(Integer.parseInt(cuv[10]));
                    i++;
                }
                System.out.println("Asistentii cititi sunt:");
                for (int j = 0; j < i; j++)
                {
                    System.out.println("\nAsistentul nr "+ (j+1) + ":");
                    Asist[j].AfisarePersonal();
                }
            }
    }
}