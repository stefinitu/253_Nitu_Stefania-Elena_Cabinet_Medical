import Services.Weekend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class VerificarePlanifWeekend implements Weekend
{
    private Programare prog;

    public VerificarePlanifWeekend(Programare prog) {
        this.prog = prog;
    }

    public Programare getProg() {
        return prog;
    }

    public void setProg(Programare prog) {
        this.prog = prog;
    }

    @Override
    public void VerificarePlanificareWeekend() throws ParseException {
        String dataPlanif=Integer.toString(prog.getZi_planificare()).concat("/").concat(Integer.toString(prog.getLuna_planificare())).concat("/").concat(Integer.toString(prog.getAn_planificare()));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dataPlan=sdf.parse(dataPlanif);
        Calendar c = Calendar.getInstance();
        c.setTime(dataPlan);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek==1)  {
            System.out.println("\nZiua planificarii este duminica. Se modifica data planificarii! ");
            c.add(Calendar.DATE, 1);
            dataPlanif=sdf.format(c.getTime());}
        else if(dayOfWeek==7) {
            System.out.println("\nZiua planificarii este sambata. Se modifica data planificarii! ");
            c.add(Calendar.DATE, 2);
            dataPlanif=sdf.format(c.getTime());}
        int iend = dataPlanif.indexOf("/");
        prog.setZi_planificare(Integer.parseInt(dataPlanif.substring(0,iend)));
        dataPlanif=dataPlanif.replace(dataPlanif.substring(0,dataPlanif.substring(0,iend).length()+1),"");
        iend = dataPlanif.indexOf("/");
        prog.setLuna_planificare(Integer.parseInt(dataPlanif.substring(0,iend)));
        dataPlanif=dataPlanif.replace(dataPlanif.substring(0,dataPlanif.substring(0,iend).length()+1),"");
        prog.setAn_planificare(Integer.parseInt(dataPlanif.substring(0,4)));
    }
}
