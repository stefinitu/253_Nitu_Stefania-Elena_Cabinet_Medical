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
        AddClient addClient=new AddClient(oldClients,newClient,n);
        oldClients[n]=newClient;
        WarningAdd warningAdd=new WarningAdd();
        warningAdd.warning(addClient);
    }
    public void AdaugareClientMajCSV() throws IOException {
        FileWriter csvWrite = new FileWriter("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\ClientMajResult.csv", true);
        String clnou[]=new String[15];
        clnou[0]=newClient.getCnp();
        clnou[1]=newClient.getNume();
        clnou[2]= newClient.getPrenume();
        clnou[3]=newClient.getEmail();
        clnou[4]=newClient.getGen();
        clnou[5]=newClient.getEmail();
        clnou[6]=newClient.getAdresa();
        clnou[7]=Double.toString(newClient.getIdCardSanatate());
        clnou[8]= newClient.getNrTelefon();
        clientNou.add(clnou[0]);
        clientNou.add(clnou[1]);
        clientNou.add(clnou[2]);
        clientNou.add(clnou[3]);
        clientNou.add(clnou[4]);
        clientNou.add(clnou[5]);
        clientNou.add(clnou[6]);
        clientNou.add(clnou[7]);
        clientNou.add(clnou[8]);
        for(String data:clientNou)
        {
            csvWrite.append(String.join(",",data));
        }
        csvWrite.flush();
        csvWrite.close();
        System.out.println("S-a scris in fisier!");
    }

    public void AdaugareClientMinCSV() throws IOException {
        FileWriter csvWrite = new FileWriter("C:\\Users\\nitug\\IdeaProjects\\253_Nitu_Stefania-Elena_Cabinet_Medical\\src\\ClientMinResult.csv", true);
        String clnou[]=new String[15];
        clnou[0]=newClient.getCnp();
        clnou[1]=newClient.getNume();
        clnou[2]= newClient.getPrenume();
        clnou[3]=newClient.getEmail();
        clnou[4]=newClient.getGen();
        clnou[5]=newClient.getEmail();
        clnou[6]=newClient.getAdresa();
        clnou[7]=newClient.getNumeInsotitor();
        clnou[8]= newClient.getPrenumeInsotitor();
        clnou[9]= newClient.getNrTelefonInsotitor();
        clientNou.add(clnou[0]);
        clientNou.add(clnou[1]);
        clientNou.add(clnou[2]);
        clientNou.add(clnou[3]);
        clientNou.add(clnou[4]);
        clientNou.add(clnou[5]);
        clientNou.add(clnou[6]);
        clientNou.add(clnou[7]);
        clientNou.add(clnou[8]);
        clientNou.add(clnou[9]);
        for(String data:clientNou)
        {
            csvWrite.append(String.join(",",data));
        }
        csvWrite.flush();
        csvWrite.close();
        System.out.println("S-a scris in fisier!");
    }
}
