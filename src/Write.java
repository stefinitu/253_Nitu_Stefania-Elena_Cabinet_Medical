import java.io.*;
import java.sql.Timestamp;

public class Write implements WriteCSV {
    public int option;

    public Write(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
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

}
