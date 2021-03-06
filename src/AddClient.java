import Services.Addable;
import Services.Reportable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddClient implements Reportable, Addable {
    private Client[] oldClients;
    private Client newClient;
    private int n;
    List<String> clientNou=new ArrayList<>();

    public AddClient(Client[] oldClients, Client newClient, int n) {
        this.oldClients = oldClients;
        this.newClient = newClient;
        this.n = n;
    }

    public Client[] getOldClients() {
        return oldClients;
    }

    public void setOldClients(Client[] oldClients) {
        this.oldClients = oldClients;
    }

    public Client getNewClient() {
        return newClient;
    }

    public void setNewClient(Client newClient) {
        this.newClient = newClient;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    @Override
    public String reportWarning()
    {
        return "S-a adaugat clientul " + newClient.getNume() + " " + newClient.getPrenume() + " la lista clientilor";
    }

    @Override
    public void AdaugareClient()
    {
        oldClients[n]=newClient;
    }
    public void AdaugareClientMajCSV() throws IOException {
        FileWriter csvWrite = new FileWriter("src\\ClientMajResult.csv", true);
        String clnou[]=new String[15];
        clnou[0]=newClient.getCnp();
        clnou[1]=newClient.getNume();
        clnou[2]= newClient.getPrenume();
        clnou[3]=newClient.getEmail();
        clnou[4]=newClient.getGen();
        clnou[5]=newClient.getAdresa();
        clnou[6]=Double.toString(newClient.getIdCardSanatate());
        clnou[7]= newClient.getNrTelefon();
        for(int i=0;i<8;i++)
        clientNou.add(clnou[i]);
        csvWrite.append("\n");
        int j=0;
        for(String data:clientNou)
        {
            csvWrite.append(data);
            if(j<7) csvWrite.append(",");
            j++;
        }
        csvWrite.flush();
        csvWrite.close();
        System.out.println("S-a scris in fisier!");
    }

    public void AdaugareClientMinCSV() throws IOException {
        FileWriter csvWrite = new FileWriter("src\\ClientMinResult.csv", true);
        String clnou[]=new String[15];
        clnou[0]=newClient.getCnp();
        clnou[1]=newClient.getNume();
        clnou[2]= newClient.getPrenume();
        clnou[3]=newClient.getEmail();
        clnou[4]=newClient.getGen();
        clnou[5]=newClient.getAdresa();
        clnou[6]=newClient.getNumeInsotitor();
        clnou[7]= newClient.getPrenumeInsotitor();
        clnou[8]= newClient.getNrTelefonInsotitor();
        for(int i=0;i<9;i++)
        clientNou.add(clnou[i]);
        csvWrite.append("\n");
        int j=0;
        for(String data:clientNou)
        {
            csvWrite.append(data);
            if(j<8) csvWrite.append(",");
            j++;
        }
        csvWrite.flush();
        csvWrite.close();
        System.out.println("S-a scris in fisier!");
    }
}
