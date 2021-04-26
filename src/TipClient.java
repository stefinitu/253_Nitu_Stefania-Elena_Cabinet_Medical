import java.util.Scanner;

public class TipClient {

    Client cl[] = new Client[100];
    int nrClienti;

    public TipClient(Client[] cl, int nrClienti) {
        this.cl = cl;
        this.nrClienti = nrClienti;
    }

    public void TipCl() {
        Scanner sc = new Scanner(System.in);
        String linie;
        for (int i = 0; i < nrClienti; i++) {
            System.out.println("Introduceti tipul de client (client minor/client major):");
            linie = sc.nextLine();
            switch (linie.toUpperCase()) {
                case "CLIENT MINOR":
                    cl[i] = new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
                    cl[i].CitireClienti();
                    break;
                case "CLIENT MAJOR":
                    cl[i] = new ClientMajor(" ", " ", " ", " ", " ", " ", 0, " ");
                    cl[i].CitireClienti();
                    break;
                default:
                    System.out.println("Optiune invalida! Alegeti dintre CLIENT MINOR sau CLIENT MAJOR!");
                    break;
            }


        }
    }
}
