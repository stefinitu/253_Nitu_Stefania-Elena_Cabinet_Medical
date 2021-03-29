import Services.Reportable;

public class DeleteClient implements Reportable {
    private Client[] oldClients;
    private Client delClient;
    private String id;

    public DeleteClient(Client[] oldClients, String id) {
        this.oldClients = oldClients;
        this.id = id;
    }

    public Client[] getOldClients() {
        return oldClients;
    }

    public void setOldClients(Client[] oldClients) {
        this.oldClients = oldClients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String reportWarning()
    {
        return "S-a sters clientul cu ID-ul " + id + " din lista clientilor";
    }
}
