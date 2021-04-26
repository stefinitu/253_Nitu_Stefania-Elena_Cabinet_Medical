import Services.ReadCSV;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Read implements ReadCSV {
    private List<List<String>> clientimin=new ArrayList<>();
    private List<List<String>> clientimaj=new ArrayList<>();
    private List<List<String>> medici=new ArrayList<>();
    private List<List<String>> retete=new ArrayList<>();

    public List<List<String>> getRetete() {
        return retete;
    }

    public void setRetete(List<List<String>> retete) {
        this.retete = retete;
    }

    public List<List<String>> getMedici() {
        return medici;
    }

    public void setMedici(List<List<String>> medici) {
        this.medici = medici;
    }

    public void setClientimin(List<List<String>> clientimin) {
        this.clientimin = clientimin;
    }

    public List<List<String>> getClientimin() {
        return clientimin;
    }

    public List<List<String>> getClientimaj() {
        return clientimaj;
    }

    public void setClientimaj(List<List<String>> clientimaj) {
        this.clientimaj = clientimaj;
    }

    public void ReadingMedic() throws FileNotFoundException {
        SingletonResult res=new SingletonResult();
        Medic[] Med = new Medic[100];
        int i = 0;
        try (Scanner in = new Scanner(new File("src\\Medic.csv"))) {
            while (in.hasNextLine()) {
                List<String> medic=new ArrayList<>();
                String linie = in.nextLine();
                String[] cuv = linie.split(",", 14);
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
            try (Scanner inn = new Scanner(new File("src\\Asistent.csv"))) {
                while (inn.hasNextLine()) {
                    List<String> asistent=new ArrayList<>();
                    String line = inn.nextLine();
                    String[] cuv = line.split(",", 14);
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
        try (Scanner inn = new Scanner(new File("src\\Reteta.csv"))) {
            while (inn.hasNextLine()) {
                List<String> reteta=new ArrayList<>();
                String line = inn.nextLine();
                String[] cuv = line.split(",", 100);
                for(int j=0;j<cuv.length;j++)
                reteta.add(cuv[j]);
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
        List<String> age=new ArrayList<>();
        try (Scanner inn = new Scanner(new File("src\\ClientMaj.csv"))) {
            while (inn.hasNextLine()) {
                List<String> clientmaj=new ArrayList<>();
                String line = inn.nextLine();
                String[] cuv = line.split(",", 14);
                clientmaj.add(cuv[0]);
                String prefixAn;
                String sufixAn;
                int luna;
                int zi;
                int genInt = new Integer(cuv[0].substring(0,1));
                    if(genInt == 1 || genInt == 2) {
                        prefixAn = "19";
                    } else {
                        prefixAn = "20";
                    }
                    sufixAn = cuv[0].substring(1, 3);
                    luna = new Integer(cuv[0].substring(3, 5));
                    zi = new Integer(cuv[0].substring(5,7));
                    String lunaM = aflaLuna(luna);
                    String dataNasterii = Integer.toString(zi).concat(" ").concat(lunaM).concat(" ").concat(prefixAn).concat(sufixAn);
                    age.add(dataNasterii);
                    if(cuv.length>=8)
                    {clientmaj.add(cuv[1]);
                clientmaj.add(cuv[2]);
                clientmaj.add(cuv[3]);
                clientmaj.add(cuv[4]);
                clientmaj.add(cuv[5]);
                clientmaj.add(cuv[6]);
                clientmaj.add(cuv[7]);}
                clientimaj.add(clientmaj);
                i++;
            }
            SingletonResult.getInstance().setClmaj(clientimaj);
            SingletonResult.getInstance().setAge(age);
        }
    }

    public void ReadingClientMinor() throws FileNotFoundException {
        List<String> age=new ArrayList<>();
        int i = 0;
        String line;
        try (Scanner inn = new Scanner(new File("src\\ClientMin.csv"))) {
            while (inn.hasNextLine()) {
                List<String> clientmin=new ArrayList<>();
                line = inn.nextLine();
                String[] cuv = line.split(",", 10);
                clientmin.add(cuv[0]);
                String prefixAn;
                String sufixAn=" ";
                int luna=0;
                int zi=0;
                prefixAn="20";
                if(cuv[0].length()>=3) sufixAn = cuv[0].substring(1, 3);
                if(cuv[0].length()>=5) luna = new Integer(cuv[0].substring(3, 5));
                if(cuv[0].length()>=7) zi = new Integer(cuv[0].substring(5,7));
                String lunaM = aflaLuna(luna);
                String dataNasterii = Integer.toString(zi).concat(" ").concat(lunaM).concat(" ").concat(prefixAn).concat(sufixAn);
                age.add(dataNasterii);
                if(cuv.length>=9)
                {clientmin.add(cuv[1]);
                clientmin.add(cuv[2]);
                clientmin.add(cuv[3]);
                clientmin.add(cuv[4]);
                clientmin.add(cuv[5]);
                clientmin.add(cuv[6]);
                clientmin.add(cuv[7]);
                clientmin.add(cuv[8]);}
                clientimin.add(clientmin);
                i++;
            }
            SingletonResult.getInstance().setClmin(clientimin);
            SingletonResult.getInstance().setAge(age);
        }
    }
    public static String aflaLuna(int luna) {
        switch (luna) {
            case 1:
                return "Ianuarie";

            case 2:
                return "Februarie";

            case 3:
                return "Martie";

            case 4:
                return "Aprilie";

            case 5:
                return "Mai";

            case 6:
                return "Iunie";

            case 7:
                return "Iulie";

            case 8:
                return "August";

            case 9:
                return "Septembrie";

            case 10:
                return "Obtombrie";

            case 11:
                return "Noiembrie";

            case 12:
                return "Decembrie";

            default:
                return "Nu exista";
        }
    }
}
