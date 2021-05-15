import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GUIOp7 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlDeleteMin="DELETE FROM ClientMinor WHERE cnp=?";
            PreparedStatement ps = conn.prepareStatement(sqlDeleteMin);
            String cnpDel;
            cnpDel=JOptionPane.showInputDialog("CNP");
            ps.setString(1,cnpDel);
            ps.execute();
            int row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"S-a sters un client major din baza de date! Randul afectat a fost "+row);
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
    }
}
