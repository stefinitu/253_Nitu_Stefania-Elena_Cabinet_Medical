import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class GUIOp2 {
    public void GUI()
    {
        JPanel panel=new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertMaj="INSERT INTO ClientMajor (cnp, NUME, PRENUME, EMAIL, GEN, ADRESA, ID_CARDSANATATE, NR_TELEFON) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMaj);

            String cnp=JOptionPane.showInputDialog("CNP");
            String nume=JOptionPane.showInputDialog("NUME");
            String prenume=JOptionPane.showInputDialog("PRENUME");
            String email=JOptionPane.showInputDialog("EMAIL");
            String gen=JOptionPane.showInputDialog("GEN");
            String adresa=JOptionPane.showInputDialog("ADRESA");
            String idCard=JOptionPane.showInputDialog("ID CARD SANATATE");
            Double idCardSanatate=Double.parseDouble(idCard);
            String nrTelefon=JOptionPane.showInputDialog("NR TELEFON");

            ps.setString(1, cnp);
            ps.setString(2, nume);
            ps.setString(3,prenume);
            ps.setString(4,email);
            ps.setString(5,gen);
            ps.setString(6,adresa);
            ps.setDouble(7,idCardSanatate);
            ps.setString(8,nrTelefon);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"S-a inserat un nou client major in baza de date!");
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }
}
