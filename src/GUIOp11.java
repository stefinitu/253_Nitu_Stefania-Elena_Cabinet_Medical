import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIOp11 {
    public void GUI()
    {
        JPanel panel=new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            List<List<String>> medici = new ArrayList<>();
            String sql = "select * from medic";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                List<String> medic = new ArrayList<>();
                String cnp = rs.getString(1);
                medic.add(cnp);
                String nume = rs.getString(2);
                medic.add(nume);
                String prenume = rs.getString(3);
                medic.add(prenume);
                String sectie = rs.getString(4);
                medic.add(sectie);
                int ziAng = rs.getInt(5);
                medic.add(String.valueOf(ziAng));
                int lunaAng = rs.getInt(6);
                medic.add(String.valueOf(lunaAng));
                int anAng = rs.getInt(7);
                medic.add(String.valueOf(anAng));
                Double salariu = rs.getDouble(8);
                medic.add(salariu.toString());
                String nrTelefon = rs.getString(9);
                medic.add(nrTelefon);
                String email = rs.getString(10);
                medic.add(email);
                Double codParafa = rs.getDouble(11);
                medic.add(codParafa.toString());
                String specializare = rs.getString(12);
                medic.add(specializare);
                Boolean rezident = rs.getBoolean(13);
                medic.add(rezident.toString());
                Boolean garda = rs.getBoolean(14);
                medic.add(garda.toString());
                medici.add(medic);
            }
            dialog.setTitle("SELECT MEDICI");
            for(List<String> data:medici)
            {
                String out = data.toString();
                String output=out.concat("\n");
                JLabel outputLabel = new JLabel(output);
                Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
                panel.add(outputLabel);
                dialog.add(panel);
                dialog.pack();
                dialog.setSize(DimMax);
                dialog.setVisible(true);
            }
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            System.out.println(medici);
            conn.close();
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
    }
}
