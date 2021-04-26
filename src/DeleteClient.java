import Services.Reportable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteClient implements Reportable {
    private Client[] oldClients;
    private String id;
    private List<List<String>> clmin=new ArrayList<>();
    public List<List<String>> clmaj=new ArrayList<>();

    public DeleteClient(Client[] oldClients, String id) {
        this.oldClients = oldClients;
        this.id = id;
    }

    public List<List<String>> getClmin() {
        return clmin;
    }

    public void setClmin(List<List<String>> clmin) {
        this.clmin = clmin;
    }

    public List<List<String>> getClmaj() {
        return clmaj;
    }

    public void setClmaj(List<List<String>> clmaj) {
        this.clmaj = clmaj;
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

    public void StergereClientMinCSV() throws IOException {
        int i=0;
        int memorare=0;
        for(List<String> data:clmin)
        {for(String data1:data)
                if(data1.equals(id)) memorare=i;
                        i++;}
        clmin.remove(memorare);
        Write wr=new Write(0);
        wr.setClmin(clmin);
        wr.WritingClientMinor();
        System.out.println("Stergere client minor!");
    }


    public void StergereClientMajCSV() throws IOException {
        int i=0;
        int memorare=0;
        for(List<String> data:clmaj)
        {for(String data1:data)
            if(data1.equals(id)) memorare=i;
            i++;}
        System.out.println(memorare);
        clmaj.remove(memorare);
        Write wr=new Write(0);
        wr.setClmaj(clmaj);
        wr.WritingClientMajor();
        System.out.println("Stergere client major!");
    }

    @Override
    public String reportWarning()
    {
        return "S-a sters clientul cu ID-ul " + id + " din lista clientilor";
    }
}
