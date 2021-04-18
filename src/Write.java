import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class Write implements WriteCSV {
    public int option;
    public List<List<String>> m=new ArrayList<>();
    public List<List<String>> a=new ArrayList<>();
    public List<List<String>> r=new ArrayList<>();
    public List<List<String>> clmaj=new ArrayList<>();
    public List<List<String>> clmin=new ArrayList<>();

    public List<List<String>> getClmaj() {
        return clmaj;
    }

    public void setClmaj(List<List<String>> clmaj) {
        this.clmaj = clmaj;
    }

    public List<List<String>> getClmin() {
        return clmin;
    }

    public void setClmin(List<List<String>> clmin) {
        this.clmin = clmin;
    }

    public Write(List<List<String>> a) {
        this.a = a;
    }

    public List<List<String>> getA() {
        return a;
    }

    public void setA(List<List<String>> a) {
        this.a = a;
    }

    public Write(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    public Write(List<List<String>> m, List<List<String>> r) {
        this.m = m;
        this.r = r;
    }

    public List<List<String>> getM() {
        return m;
    }

    public void setM(List<List<String>> m) {
        this.m = m;
    }

    public List<List<String>> getR() {
        return r;
    }

    public void setR(List<List<String>> r) {
        this.r = r;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public void WritingTimestamp() throws IOException {
        FileOutputStream f = new FileOutputStream(new File("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\Rezultat.csv"));
        ObjectOutputStream o = new ObjectOutputStream(f);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        switch(option)
        {
            case 1:
                o.writeObject("S-au ordonat crescator clientii" + "," + timestamp + "\n");
                break;
            case 2:
                o.writeObject("Calculul sumei medicamentelor" + "," + timestamp + "\n");
                break;
            case 3:
                o.writeObject("Salariul minim, maxim si mediu" + "," + timestamp + "\n");
                break;
            case 4:
                o.writeObject("Generare ID Consultatie" + "," + timestamp + "\n");
                break;
            case 5:
                o.writeObject("Calculul datei nasterii" + "," + timestamp + "\n");
                break;
            case 6:
                o.writeObject("Adaugare client nou" + "," + timestamp + "\n");
                break;
            case 7:
                o.writeObject("Stergere client" + "," + timestamp + "\n");
                break;
            case 8:
                o.writeObject("Acordare sporuri medici" + "," + timestamp + "\n");
                break;
            case 9:
                o.writeObject("Acordare reducere persoanelor cu varsta peste 60 de ani" + "," + timestamp + "\n");
                break;
            case 10:
                o.writeObject("Verificare data planificarii weekend" + "," + timestamp + "\n");
                break;
            case 11:
                o.writeObject("Calculul costului spitalizarii" + "," + timestamp + "\n");
                break;
            default:
                o.writeObject("Eroare la scrierea in fisier! Optiune invalida");
        }
    }

    public void WritingAsistent() throws IOException
    {
        FileWriter csvWrite = new FileWriter("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\AsistentResult.csv");
        for(List <String> data:a)
        {
    csvWrite.append(String.join(",",data));
    csvWrite.append("\n");
        }
        csvWrite.flush();
        csvWrite.close();
        System.out.println("S-a scris in fisier!");
    }

    public void WritingMedic() throws IOException
    {
        FileWriter csvWrite = new FileWriter("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\MedicResult.csv");
        for(List <String> data:m)
        {
            csvWrite.append(String.join(",",data));
            csvWrite.append("\n");
        }
        csvWrite.flush();
        csvWrite.close();
        System.out.println("S-a scris in fisier!");
    }
    public void WritingReteta() throws IOException
    {
        FileWriter csvWrite = new FileWriter("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\RetetaResult.csv");
        for(List <String> data:r)
        {
            csvWrite.append(String.join(",",data));
            csvWrite.append("\n");
        }
        csvWrite.flush();
        csvWrite.close();
        System.out.println("S-a scris in fisier!");
    }

    public void WritingClientMajor() throws IOException
    {
        FileWriter csvWrite = new FileWriter("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\ClientMajResult.csv");
        for(List <String> data:a)
        {
            csvWrite.append(String.join(",",data));
            csvWrite.append("\n");
        }
        csvWrite.flush();
        csvWrite.close();
        System.out.println("S-a scris in fisier!");
    }

    public void WritingClientMinor() throws IOException
    {
        FileWriter csvWrite = new FileWriter("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\ClientMinResult.csv");
        for(List <String> data:a)
        {
            csvWrite.append(String.join(",",data));
            csvWrite.append("\n");
        }
        csvWrite.flush();
        csvWrite.close();
        System.out.println("S-a scris in fisier!");
    }
}
