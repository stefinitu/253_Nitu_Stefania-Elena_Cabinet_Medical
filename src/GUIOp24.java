import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIOp24 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            List<List<String>> asistenti = new ArrayList<>();
            String sql = "select * from asistent";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                List<String> asistent = new ArrayList<>();
                String cnp = rs.getString(1);
                asistent.add(cnp);
                String nume = rs.getString(2);
                asistent.add(nume);
                String prenume = rs.getString(3);
                asistent.add(prenume);
                String sectie = rs.getString(4);
                asistent.add(sectie);
                int ziAng = rs.getInt(5);
                asistent.add(String.valueOf(ziAng));
                int lunaAng = rs.getInt(6);
                asistent.add(String.valueOf(lunaAng));
                int anAng = rs.getInt(7);
                asistent.add(String.valueOf(anAng));
                Double salariu = rs.getDouble(8);
                asistent.add(salariu.toString());
                String nrTelefon = rs.getString(9);
                asistent.add(nrTelefon);
                String email = rs.getString(10);
                asistent.add(email);
                int nrSaloane=rs.getInt(11);
                asistent.add(String.valueOf(nrSaloane));
                asistenti.add(asistent);
            }
            dialog.setTitle("SELECT ASISTENTI");
            for(List<String> data:asistenti)
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