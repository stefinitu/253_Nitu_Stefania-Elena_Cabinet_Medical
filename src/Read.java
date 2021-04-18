import Services.ReadCSV;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Read implements ReadCSV {
    public void ReadingMedic() throws FileNotFoundException {
        SingletonResult res=new SingletonResult();
        List<List<String>> medici=new ArrayList<>();
        Medic[] Med = new Medic[100];
        int i = 0;
        try (Scanner in = new Scanner(new File("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\Medic.csv"))) {
            while (in.hasNextLine()) {
                List<String> medic=new ArrayList<>();
                String linie = in.nextLine();
                String[] cuv = linie.split(";", 14);
                Med[i] = new Medic(" ", " ", " ", " ", 0, 0, 0, 0, " ", " ", 0, " ", true, true);
                Med[i].cnp = cuv[0];
                medic.add(cuv[0]);
                Med[i].nume = cuv[1];
                medic.add(cuv[1]);
                Med[i].prenume = cuv[2];
                medic.add(cuv[2]);
                Med[i].sectie = cuv[3];
                medic.add(cuv[3]);
                Med[i].ziAngajare = Integer.parseInt(cuv[4]);
                medic.add(cuv[4]);
                Med[i].lunaAngajare = Integer.parseInt(cuv[5]);
                medic.add(cuv[5]);
                Med[i].anAngajare = Integer.parseInt(cuv[6]);
                medic.add(cuv[6]);
                Med[i].salariu = Double.parseDouble(cuv[7]);
                medic.add(cuv[7]);
                Med[i].nrTelefon = cuv[8];
                medic.add(cuv[8]);
                Med[i].email = cuv[9];
                medic.add(cuv[9]);
                Med[i].setCodParafa(Double.parseDouble(cuv[10]));
                medic.add(cuv[10]);
                Med[i].setSpecializare(cuv[11]);
                medic.add(cuv[11]);
                Med[i].setRezident(Boolean.parseBoolean(cuv[12]));
                medic.add(cuv[12]);
                Med[i].setGarda(Boolean.parseBoolean(cuv[13]));
                medic.add(cuv[13]);
                medici.add(medic);
                i++;
            }
            SingletonResult.getInstance().setM(medici);
        }
    }
        public void ReadingAsistent() throws FileNotFoundException {
            Asistent[] Asist = new Asistent[100];
            int i = 0;
            List<List<String>> asistenti=new ArrayList<>();
            try (Scanner inn = new Scanner(new File("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\Asistent.csv"))) {
                while (inn.hasNextLine()) {
                    List<String> asistent=new ArrayList<>();
                    String line = inn.nextLine();
                    String[] cuv = line.split(";", 14);
                    Asist[i] = new Asistent(" ", " ", " ", " ",0,0,0,0.0, " ", " ",0);
                    Asist[i].cnp = cuv[0];
                    asistent.add(cuv[0]);
                    Asist[i].nume = cuv[1];
                    asistent.add(cuv[1]);
                    Asist[i].prenume = cuv[2];
                    asistent.add(cuv[2]);
                    Asist[i].sectie = cuv[3];
                    asistent.add(cuv[3]);
                    Asist[i].ziAngajare = Integer.parseInt(cuv[4]);
                    asistent.add(cuv[4]);
                    Asist[i].lunaAngajare = Integer.parseInt(cuv[5]);
                    asistent.add(cuv[5]);
                    Asist[i].anAngajare = Integer.parseInt(cuv[6]);
                    asistent.add(cuv[6]);
                    Asist[i].salariu = Double.parseDouble(cuv[7]);
                    asistent.add(cuv[7]);
                    Asist[i].nrTelefon = cuv[8];
                    asistent.add(cuv[8]);
                    Asist[i].email = cuv[9];
                    asistent.add(cuv[9]);
                    Asist[i].setNrSaloaneAtribuite(Integer.parseInt(cuv[10]));
                    asistent.add(cuv[10]);
                    asistenti.add(asistent);
                    i++;
                }
                System.out.println("Asistentii cititi sunt:");
                for (i=0;i<asistenti.size();i++)
                {
                    System.out.println("\nAsistentul nr "+ (i+1) + ":"+asistenti.get(i));
                }
                SingletonResult.getInstance().setA(asistenti);
            }
    }

    public void ReadingReteta() throws FileNotFoundException {
        int i = 0;
        List<List<String>> retete=new ArrayList<>();
        try (Scanner inn = new Scanner(new File("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\Reteta.csv"))) {
            while (inn.hasNextLine()) {
                List<String> reteta=new ArrayList<>();
                String line = inn.nextLine();
                String[] cuv = line.split(";", 14);
                reteta.add(cuv[0]);
                reteta.add(cuv[1]);
                reteta.add(cuv[2]);
                reteta.add(cuv[3]);
                reteta.add(cuv[4]);
                retete.add(reteta);
                i++;
            }
            System.out.println("Retetele citite sunt:");
            for (i=0;i<retete.size();i++)
            {
                System.out.println("\nReteta nr "+ (i+1) + ":"+retete.get(i));
            }
            SingletonResult.getInstance().setR(retete);
        }
    }

    public void ReadingClientMajor() throws FileNotFoundException {
        int i = 0;
        List<List<String>> clientimaj=new ArrayList<>();
        try (Scanner inn = new Scanner(new File("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\ClientMaj.csv"))) {
            while (inn.hasNextLine()) {
                List<String> clientmaj=new ArrayList<>();
                String line = inn.nextLine();
                String[] cuv = line.split(";", 14);
                clientmaj.add(cuv[0]);
                clientmaj.add(cuv[1]);
                clientmaj.add(cuv[2]);
                clientmaj.add(cuv[3]);
                clientmaj.add(cuv[4]);
                clientimaj.add(clientmaj);
                i++;
            }
            System.out.println("Clientii cititi sunt:");
            for (i=0;i<clientimaj.size();i++)
            {
                System.out.println("\nReteta nr "+ (i+1) + ":"+clientimaj.get(i));
            }
            SingletonResult.getInstance().setClmaj(clientimaj);
        }
    }

    public void ReadingClientMinor() throws FileNotFoundException {
        int i = 0;
        List<List<String>> clientimin=new ArrayList<>();
        try (Scanner inn = new Scanner(new File("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\ClientMin.csv"))) {
            while (inn.hasNextLine()) {
                List<String> clientmin=new ArrayList<>();
                String line = inn.nextLine();
                String[] cuv = line.split(";", 14);
                clientmin.add(cuv[0]);
                clientmin.add(cuv[1]);
                clientmin.add(cuv[2]);
                clientmin.add(cuv[3]);
                clientmin.add(cuv[4]);
                clientimin.add(clientmin);
                i++;
            }
            System.out.println("Clientii cititi sunt:");
            for (i=0;i<clientimin.size();i++)
            {
                System.out.println("\nReteta nr "+ (i+1) + ":"+clientimin.get(i));
            }
            SingletonResult.getInstance().setClmaj(clientimin);
        }
    }
}
