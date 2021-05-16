import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GUIOp20 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            List<List<String>> programariMin = new ArrayList<>();
            String sql = "select * from programare_clientminor";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                List<String> progr = new ArrayList<>();
                Double idProg = rs.getDouble(1);
                progr.add(idProg.toString());
                Double codBilet = rs.getDouble(2);
                progr.add(codBilet.toString());
                String cnpClient = rs.getString(3);
                progr.add(cnpClient);
                int ziProg = rs.getInt(4);
                progr.add(String.valueOf(ziProg));
                int lunaProg = rs.getInt(5);
                progr.add(String.valueOf(lunaProg));
                int anProg = rs.getInt(6);
                progr.add(String.valueOf(anProg));
                int ziPlan = rs.getInt(7);
                progr.add(String.valueOf(ziPlan));
                int lunaPlan = rs.getInt(8);
                progr.add(String.valueOf(lunaPlan));
                int anPlan = rs.getInt(9);
                progr.add(String.valueOf(anPlan));
                String sectie = rs.getString(10);
                progr.add(sectie);
                programariMin.add(progr);
            }
            dialog.setTitle("SELECT PROGRAMARI CLIENTI minori");
            for(List<String> data:programariMin)
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