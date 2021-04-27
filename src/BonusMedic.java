import java.util.Calendar;
import java.util.List;

public class BonusMedic {


    public void AdaugareBonusMedic(Medic medic){
    int vechime;
    int anActual = Calendar.getInstance().get(Calendar.YEAR);
    vechime=anActual-medic.infoAngajare.getAnAngajare();
    if(vechime>=10) medic.SporuriMedic();
    }
    public void AdaugareBonusMedicCSV(List <List<String>> medici)
    {
        int vechime=0;
        int anActual=0;
        for(List <String> data:medici)
        { anActual = Calendar.getInstance().get(Calendar.YEAR);
            vechime=anActual-Integer.parseInt(data.get(6));
            if(vechime>=10) data.set(7,Double.toString(Double.parseDouble(data.get(7))+0.25*Double.parseDouble(data.get(7))));
        }
    }

}
