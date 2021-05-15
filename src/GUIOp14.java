import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIOp14 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertMedic = "INSERT IGNORE INTO medic (cnp, NUME, PRENUME, SECTIE, ZI_ANGAJARE, LUNA_ANGAJARE, AN_ANGAJARE, SALARIU,NR_TELEFON, EMAIL, COD_PARAFA, SPECIALIZARE, REZIDENT, GARDA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMedic);
            java.util.List<java.util.List<String>> medici = new ArrayList<>();
            SingletonCitire.getInstanceRead().ReadingMedic();
            medici.addAll(SingletonResult.getInstance().getM());
            for (List<String> data : medici) {
                ps.setString(1, data.get(0));
                ps.setString(2, data.get(1));
                ps.setString(3, data.get(2));
                ps.setString(4, data.get(3));
                ps.setInt(5, Integer.parseInt(data.get(4)));
                ps.setInt(6, Integer.parseInt(data.get(5)));
                ps.setInt(7, Integer.parseInt(data.get(6)));
                ps.setDouble(8, Double.parseDouble(data.get(7)));
                ps.setString(9, data.get(8));
                ps.setString(10, data.get(9));
                ps.setDouble(11, Double.parseDouble(data.get(10)));
                ps.setString(12, data.get(11));
                ps.setBoolean(13, Boolean.parseBoolean(data.get(12)));
                ps.setBoolean(14, Boolean.parseBoolean(data.get(13)));
                int row = ps.executeUpdate();
                if (row == 1) JOptionPane.showMessageDialog(null,"S-a inserat un nou medic in baza de date!");
            }

        } catch (SQLException | ClassNotFoundException | FileNotFoundException var10) {
            var10.printStackTrace();
        }
    }
}
