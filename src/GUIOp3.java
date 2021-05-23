import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class GUIOp3 {
    public void GUI()
    {
        JPanel panel=new JPanel();
        JDialog dialog = new JDialog();
        JButton closeButton = new JButton("Close");

        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlDeleteMaj="DELETE FROM ClientMajor WHERE cnp=?";
            PreparedStatement ps = conn.prepareStatement(sqlDeleteMaj);
            String cnpDel=JOptionPane.showInputDialog("CNP");
            ps.setString(1,cnpDel);
            int row=ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"S-a sters un client major din baza de date! Randul afectat a fost "+row);
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
        dialog.add(closeButton, BorderLayout.SOUTH);
        closeButton.addActionListener(e -> dialog.setVisible(false));

    }
}
