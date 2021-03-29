package Services;

public class VerificareDate {
    public boolean VerificareCNP(String cnp)
    {
    return cnp.length()==13;
    }

    public boolean VerificareTelefon(String nr_tel)
    {
        return nr_tel.startsWith("07")&&nr_tel.length()==10;
    }
    public boolean VerificareEmail(String email)
    {
        return email.matches("^[a-zA-Z0-9_]+@[a-zA-Z]+[.]+[a-zA-Z]{2,3}$");
    }
}
