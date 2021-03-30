package Services;

public class VerificareDate implements DataVerifiable {
    private String cnp;
    private String email;

    public VerificareDate(String cnp, String email) {
        this.cnp = cnp;
        this.email = email;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@Override
    public boolean VerificareCNP()
    {
    return cnp.length()==13;
    }

@Override
    public boolean VerificareEmail()
    {
        return email.matches("^[a-zA-Z0-9_]+@[a-zA-Z]+[.]+[a-zA-Z]{2,3}$");
    }
}
