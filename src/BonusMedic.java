import Services.Bonusable;

import java.util.Calendar;

public class BonusMedic implements Bonusable {
    private Medic medic;

    public BonusMedic(Medic medic) {
        this.medic = medic;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    @Override
    public void AdaugareBonusMedic(){
    int vechime;
    int anActual = Calendar.getInstance().get(Calendar.YEAR);
    vechime=anActual-medic.getAnAngajare();
    if(vechime>=10) medic.SporuriMedic();
    }
}
