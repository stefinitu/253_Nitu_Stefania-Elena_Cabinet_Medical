import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIOp5 {
    public void GUI()
    {
        JPanel panel=new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            java.util.List<java.util.List<String>> clientiMin=new ArrayList<>();
            String sql = "select * from ClientMinor";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                List<String> clientMin=new ArrayList<>();
                String cnp = rs.getString(1);
                clientMin.add(cnp);
                String nume = rs.getString(2);
                clientMin.add(nume);
                String prenume = rs.getString(3);
                clientMin.add(prenume);
                String email = rs.getString(4);
                clientMin.add(email);
                String gen = rs.getString(5);
                clientMin.add(gen);
                String adresa = rs.getString(6);
                clientMin.add(adresa);
                String numeInsotitor = rs.getString(7);
                clientMin.add(numeInsotitor);
                String prenumeInsotitor = rs.getString(8);
                clientMin.add(prenumeInsotitor);
                String nrTelefonInsotitor = rs.getString(9);
                clientMin.add(nrTelefonInsotitor);
                clientiMin.add(clientMin);
            }

            dialog.setTitle("SELECT CLIENTI MINORI");
            for(List<String> data:clientiMin)
            {
                String out = data.toString();
                String output=out.concat("\n");
                JLabel outputLabel = new JLabel(output);
                panel.add(outputLabel);
                dialog.add(panel);
                dialog.pack();
                dialog.setVisible(true);
            }
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            conn.close();
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }
}
