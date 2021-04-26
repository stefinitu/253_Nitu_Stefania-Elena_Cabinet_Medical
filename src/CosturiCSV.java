import Services.CostSpitalizare;

import java.io.FileWriter;
import java.io.IOException;

public class CosturiCSV {
    private Consultatie cs;

    public CosturiCSV(Consultatie cs) {
        this.cs = cs;
    }

    public void CostsCSV() throws IOException {
        FileWriter csvWrite11 = new FileWriter("src\\CosturiPacienti.csv");
        if(cs.getNrZileSpitalizare()!=0)
        {
            if (cs.getProg().getClient() instanceof ClientMinor)
            {
                CostSpitalizare costs=new CostSpitalizare(cs.getNrZileSpitalizare());
                int costSpitalizareMinor=costs.CostClientMinor();
                System.out.println("\nPacientul "+ cs.getProg().getClient().getNume() + " " + cs.getProg().getClient().getPrenume() + " trebuie sa achite "+ costSpitalizareMinor + " lei.");
                csvWrite11.append("Pacientul ");
                csvWrite11.append(cs.getProg().getClient().getNume());
                csvWrite11.append(",");
                csvWrite11.append(Double.toString(costSpitalizareMinor));
                csvWrite11.append("\n");}
            else
            {   CostSpitalizare costs=new CostSpitalizare(cs.getNrZileSpitalizare());
                int costSpitalizareMajor=costs.CostClientMajor();
                System.out.println("\nPacientul "+ cs.getProg().getClient().getNume() + " " + cs.getProg().getClient().getPrenume() + " trebuie sa achite "+ costSpitalizareMajor + " lei.");
                csvWrite11.append("Pacientul ");
                csvWrite11.append(cs.getProg().getClient().getNume());
                csvWrite11.append(",");
                csvWrite11.append(Double.toString(costSpitalizareMajor));
                csvWrite11.append("\n");}
        }
        else {System.out.println("Pacientul " + cs.getProg().getClient().getNume() + " " + cs.getProg().getClient().getPrenume() + " nu trebuie sa achite nimic.");
            csvWrite11.append("Pacientul ");
            csvWrite11.append(cs.getProg().getClient().getNume());
            csvWrite11.append(",");
            csvWrite11.append("nu are de achitat");
            csvWrite11.append("\n");}
        csvWrite11.flush();
        csvWrite11.close();
    }
    }
