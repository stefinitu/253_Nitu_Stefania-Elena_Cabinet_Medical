import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIOp10 {
    public void GUI()
    {
        JPanel panel=new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertMin="INSERT IGNORE INTO ClientMinor (cnp, NUME, PRENUME, EMAIL, GEN, ADRESA, NUME_INSOTITOR, PRENUME_INSOTITOR, NR_TELEFON_INSOTITOR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMin);
            ClientMinor clMin=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
            List<List<String>> clmin=new ArrayList<>();
            SingletonCitire.getInstanceRead().ReadingClientMinor();
            clmin.addAll(SingletonResult.getInstance().getClmin());
            for(List <String> data:clmin)
            {
                ps.setString(1, data.get(0));
                ps.setString(2, data.get(1));
                ps.setString(3,data.get(2));
                ps.setString(4,data.get(3));
                ps.setString(5,data.get(4));
                ps.setString(6,data.get(5));
                ps.setString(7,data.get(6));
                ps.setString(8,data.get(7));
                ps.setString(9,data.get(8));
                int row=ps.executeUpdate();
                if(row==1) JOptionPane.showMessageDialog(null,"S-a inserat un nou client minor in baza de date!");
            }

        } catch (SQLException | ClassNotFoundException | FileNotFoundException var10) {
            var10.printStackTrace();
        }

    }
}
