import javax.swing.*;
import java.sql.*;

public class GUIOp25 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertAsistent = "INSERT INTO ASISTENT (cnp, NUME, PRENUME, SECTIE, ZI_ANGAJARE, LUNA_ANGAJARE, AN_ANGAJARE, SALARIU, NR_TELEFON, EMAIL, NR_SALOANE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertAsistent);

            String cnp=JOptionPane.showInputDialog("CNP");
            String nume=JOptionPane.showInputDialog("NUME");
            String prenume=JOptionPane.showInputDialog("PRENUME");
            String sectie=JOptionPane.showInputDialog("SECTIE");
            String ziAng=JOptionPane.showInputDialog("ZIUA ANGAJARII");
            int ziAngajare=Integer.parseInt(ziAng);
            String lunaAng=JOptionPane.showInputDialog("LUNA ANGAJARII");
            int lunaAngajare=Integer.parseInt(lunaAng);
            String anAng=JOptionPane.showInputDialog("ANUL ANGAJARII");
            int anAngajare=Integer.parseInt(anAng);
            String salString=JOptionPane.showInputDialog("SALARIUL");
            Double salariu=Double.parseDouble(salString);
            String nrTelefon=JOptionPane.showInputDialog("NR TELEFON");
            String email=JOptionPane.showInputDialog("EMAIL");
            String nrSaloane=JOptionPane.showInputDialog("NUMARUL DE SALOANE ATRIBUITE");
            int nrSal=Integer.parseInt(nrSaloane);

            ps.setString(1, cnp);
            ps.setString(2, nume);
            ps.setString(3, prenume);
            ps.setString(4, sectie);
            ps.setInt(5, ziAngajare);
            ps.setInt(6, lunaAngajare);
            ps.setInt(7, anAngajare);
            ps.setDouble(8, salariu);
            ps.setString(9, nrTelefon);
            ps.setString(10, email);
            ps.setInt(11, nrSal);
            int row = ps.executeUpdate();
            System.out.println("S-a inserat un nou asistent in baza de date!");
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }
}