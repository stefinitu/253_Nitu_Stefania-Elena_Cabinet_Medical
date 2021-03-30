import Services.Deletable;
import Services.Reportable;

public class DeleteClient implements Reportable, Deletable {
    private Client[] oldClients;
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
    public void StergereClient()
    {
        int memorare=0;
        DeleteClient deleteClient=new DeleteClient(oldClients,id);
        for(int i=0;i< oldClients.length;i++)
            if(oldClients[i].getCnp().equals(id))  memorare=i;
        for(int i=memorare;i< oldClients.length-1;i++)
            oldClients[i]=oldClients[i+1];
        WarningAdd warningAdd=new WarningAdd();
        warningAdd.warning(deleteClient);
    }

    @Override
    public String reportWarning()
    {
        return "S-a sters clientul cu ID-ul " + id + " din lista clientilor";
    }
}
