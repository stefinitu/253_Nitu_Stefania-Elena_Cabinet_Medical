import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIOp6 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertMin = "INSERT INTO ClientMinor (cnp, NUME, PRENUME, EMAIL, GEN, ADRESA, NUME_INSOTITOR, PRENUME_INSOTITOR, NR_TELEFON_INSOTITOR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMin);

            String cnp = JOptionPane.showInputDialog("CNP");
            String nume = JOptionPane.showInputDialog("NUME");
            String prenume = JOptionPane.showInputDialog("PRENUME");
            String email = JOptionPane.showInputDialog("EMAIL");
            String gen = JOptionPane.showInputDialog("GEN");
            String adresa = JOptionPane.showInputDialog("ADRESA");
            String numeInsotitor = JOptionPane.showInputDialog("NUME INSOTITOR");
            String prenumeInsotitor = JOptionPane.showInputDialog("PRENUME INSOTITOR");
            String nrTelefon = JOptionPane.showInputDialog("NR TELEFON INSOTITOR");

            ps.setString(1, cnp);
            ps.setString(2, nume);
            ps.setString(3, prenume);
            ps.setString(4, email);
            ps.setString(5, gen);
            ps.setString(6, adresa);
            ps.setString(7, numeInsotitor);
            ps.setString(8, prenumeInsotitor);
            ps.setString(9, nrTelefon);
            int row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "S-a inserat un nou client minor in baza de date!");
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
    }
}
