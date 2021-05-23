import javax.swing.*;
import java.sql.*;


public class GUIOp27 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlDeleteAsistent = "DELETE FROM asistent WHERE cnp=?";
            PreparedStatement ps = conn.prepareStatement(sqlDeleteAsistent);
            String cnpDel=JOptionPane.showInputDialog("CNP");
            ps.setString(1, cnpDel);
            int row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"S-a sters un asistent din baza de date! Randul afectat a fost " + row);
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
    }
}