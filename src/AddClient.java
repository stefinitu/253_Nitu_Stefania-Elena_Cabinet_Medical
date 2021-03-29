import Services.Reportable;

public class AddClient implements Reportable{
    private Client[] oldClients;
    private Client newClient;
    private int n;

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
}
