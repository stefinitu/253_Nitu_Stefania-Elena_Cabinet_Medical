import Services.Reducible;

import java.util.Calendar;

public class Reducere implements Reducible {
    private Consultatie consult;

    public Reducere(Consultatie consult) {
        this.consult = consult;
    }

    public Consultatie getConsult() {
        return consult;
    }

    public void setConsult(Consultatie consult) {
        this.consult = consult;
    }

    @Override
    public void ReducereClienti()
    {
        String prefAn=" ";
        String sufAn=" ";
        int genInt = Integer.parseInt(consult.getProg().getClient().cnp.substring(0,1));
        if(genInt == 1 || genInt == 2) {
            prefAn = "19";
        } else {
            prefAn = "20";
        }
        sufAn = consult.getProg().getClient().cnp.substring(1, 3);
        String anNasterii = prefAn.concat(sufAn);
        System.out.println("\nAnul nasterii este:".concat(anNasterii));
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int age=year-Integer.parseInt(anNasterii);
        if(age>=60) {consult.getReteta().ReducereMedicamente();
        System.out.println("Pentru pacientul cu varsta de "+age+" noua suma dupa reducere este " + consult.getReteta().SumaMed(consult.getReteta().getNr_medicamente(), consult.getReteta().getNr_bucati(), consult.getReteta().getPret()));
    }}
}
