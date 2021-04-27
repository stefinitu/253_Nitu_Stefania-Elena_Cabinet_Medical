import java.util.Scanner;

public class TipAngajat {
    int nrPers;
    Personal[] p;

    public TipAngajat(int nrPers, Personal[] p) {
        this.nrPers = nrPers;
        this.p = p;
    }

    public void AngajatTip() {
        Scanner in = new Scanner(System.in);
        String line;
        InfoAngajare info=new InfoAngajare(" ",0,0,0,0.0);
        for (int i = 0; i < nrPers; i++) {
            System.out.println("Introduceti tipul de angajat (medic/asistent):");
            line = in.next();
            switch (line.toUpperCase()) {
                case "MEDIC":
                    p[i] = new Medic(" ", " ", " ", info, " ", " ", 0, " ", true, true);
                    p[i].CitirePersonal();
                    break;
                case "ASISTENT":
                    p[i] = new Asistent(" ", " ", " ", info, " ", " ", 0);
                    p[i].CitirePersonal();
                    break;
                default:
                    System.out.println("Optiune invalida! Alegeti dintre MEDIC sau ASISTENT!");
                    break;
            }
        }
    }
}
