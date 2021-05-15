import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIOp12 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertMed = "INSERT INTO Medic (cnp, NUME, PRENUME, SECTIE, ZI_ANGAJARE, LUNA_ANGAJARE, AN_ANGAJARE, SALARIU, NR_TELEFON, EMAIL, COD_PARAFA, SPECIALIZARE, REZIDENT, GARDA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMed);
            String cnp = JOptionPane.showInputDialog("CNP");
            String nume = JOptionPane.showInputDialog("NUME");
            String prenume = JOptionPane.showInputDialog("PRENUME");
            String sectie = JOptionPane.showInputDialog("SECTIA");
            String ziAngString = JOptionPane.showInputDialog("ZIUA ANGAJARII");
            int ziAng = Integer.parseInt(ziAngString);
            String lunaAngString = JOptionPane.showInputDialog("LUNA ANGAJARII");
            int lunaAng = Integer.parseInt(lunaAngString);
            String anAngString = JOptionPane.showInputDialog("ANUL ANGAJARII");
            int anAng = Integer.parseInt(anAngString);
            String salariu = JOptionPane.showInputDialog("SALARIUL");
            Double sal = Double.parseDouble(salariu);
            String nrTelefon = JOptionPane.showInputDialog("NR TELEFON");
            String email = JOptionPane.showInputDialog("EMAIL");
            String codParafaString = JOptionPane.showInputDialog("COD PARAFA");
            Double codParafa = Double.parseDouble(codParafaString);
            String specializarea = JOptionPane.showInputDialog("SPECIALIZAREA");
            String rezident = JOptionPane.showInputDialog("REZIDENT (TRUE/FALSE)?");
            Boolean rez = Boolean.parseBoolean(rezident);
            String garda = JOptionPane.showInputDialog("MEDIC DE GARDA (TRUE/FALSE)?");
            Boolean gardaBool = Boolean.parseBoolean(garda);

            ps.setString(1, cnp);
            ps.setString(2, nume);
            ps.setString(3, prenume);
            ps.setString(4, sectie);
            ps.setInt(5, ziAng);
            ps.setInt(6, lunaAng);
            ps.setInt(7, anAng);
            ps.setDouble(8, sal);
            ps.setString(9, nrTelefon);
            ps.setString(10, email);
            ps.setDouble(11, codParafa);
            ps.setString(12, specializarea);
            ps.setBoolean(13, rez);
            ps.setBoolean(14, gardaBool);
            int row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"S-a inserat un nou medic in baza de date!");
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
    }
}
