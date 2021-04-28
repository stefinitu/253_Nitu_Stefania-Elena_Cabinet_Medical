import Services.SumaMedicamente;

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
    public List<String> age=new ArrayList<>();

    public List<String> getAge() {
        return age;
    }

    public void setAge(List<String> age) {
        this.age = age;
    }

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
        FileOutputStream f = new FileOutputStream(new File("src\\Rezultat.csv"), true);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s=timestamp.toString();
        String comma=",";
        String endline="\n";
        byte[] time=s.getBytes();
        byte[] commabin=comma.getBytes();
        byte[] endbin=endline.getBytes();
        switch(option)
        {
            case 1:
                String text1="S-au ordonat crescator clientii";
                byte[] textbin=text1.getBytes();
                f.write(textbin);
                f.write(commabin);
                f.write(time);
                f.write(endbin);
                break;
            case 2:
                String text2="Calculul sumei medicamentelor";
                textbin=text2.getBytes();
                f.write(textbin);
                f.write(commabin);
                f.write(time);
                f.write(endbin);
                break;
            case 3:
                String text3="Salariul minim, maxim si mediu";
                textbin=text3.getBytes();
                f.write(textbin);
                f.write(commabin);
                f.write(time);
                f.write(endbin);
                break;
            case 4:
                String text4="Generare ID Consultatie";
                textbin=text4.getBytes();
                f.write(textbin);
                f.write(commabin);
                f.write(time);
                f.write(endbin);
                break;
            case 5:
                String text5="Calculul datei nasterii";
                textbin=text5.getBytes();
                f.write(textbin);
                f.write(commabin);
                f.write(time);
                f.write(endbin);
                break;
            case 6:
                String text6="Adaugare client nou";
                textbin=text6.getBytes();
                f.write(textbin);
                f.write(commabin);
                f.write(time);
                f.write(endbin);
                break;
            case 7:
                String text7="Stergere client";
                textbin=text7.getBytes();
                f.write(textbin);
                f.write(commabin);
                f.write(time);
                f.write(endbin);
                break;
            case 8:
                String text8="Acordare sporuri medici";
                textbin=text8.getBytes();
                f.write(textbin);
                f.write(commabin);
                f.write(time);
                f.write(endbin);
                break;
            case 9:
                String text9="Acordare reducere persoanelor cu varsta peste 60 de ani";
                textbin=text9.getBytes();
                f.write(textbin);
                f.write(commabin);
                f.write(time);
                f.write(endbin);
                break;
            case 10:
                String text10="Verificare data planificarii weekend";
                textbin=text10.getBytes();
                f.write(textbin);
                f.write(commabin);
                f.write(time);
                f.write(endbin);
                break;
            case 11:
                String text11="Calculul costului spitalizarii";
                textbin=text11.getBytes();
                f.write(textbin);
                f.write(commabin);
                f.write(time);
                f.write(endbin);
                break;
            default:
                String mesaj="Eroare la scrierea in fisier!";
                byte[] mesajbin=mesaj.getBytes();
                f.write(mesajbin);
        }
    }

    public void WritingAsistent() throws IOException
    {
        FileWriter csvWrite = new FileWriter("src\\AsistentResult.csv");
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
        FileWriter csvWrite = new FileWriter("src\\MedicResult.csv");
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
        FileWriter csvWrite = new FileWriter("src\\RetetaResult.csv");
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
        FileWriter csvWrite = new FileWriter("src\\ClientMajResult.csv");
        for(List <String> data:clmaj)
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
        FileWriter csvWrite = new FileWriter("src\\ClientMinResult.csv");
        for(List <String> data:clmin)
        {
            csvWrite.append(String.join(",",data));
            csvWrite.append("\n");
        }
        csvWrite.flush();
        csvWrite.close();
        System.out.println("S-a scris in fisier!");
    }
    public void WritingAge() throws IOException
    {
        FileWriter csvWrite = new FileWriter("src\\DataNasterii.csv",true);
        for(String data:age)
        {
            csvWrite.append(String.join(",",data));
            csvWrite.append("\n");
        }
        csvWrite.flush();
        csvWrite.close();
        System.out.println("S-a scris in fisier!");
    }
}
