import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIOp1 {
    public void GUI()
    {
        JPanel panel=new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            java.util.List<java.util.List<String>> clientiMaj=new ArrayList<>();
            String sql = "select * from ClientMajor";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                List<String> clientMaj=new ArrayList<>();
                String cnp = rs.getString(1);
                clientMaj.add(cnp);
                String nume = rs.getString(2);
                clientMaj.add(nume);
                String prenume = rs.getString(3);
                clientMaj.add(prenume);
                String email = rs.getString(4);
                clientMaj.add(email);
                String gen = rs.getString(5);
                clientMaj.add(gen);
                String adresa = rs.getString(6);
                clientMaj.add(adresa);
                Double idCardSanatate = rs.getDouble(7);
                clientMaj.add(idCardSanatate.toString());
                String nrTelefon = rs.getString(8);
                clientMaj.add(nrTelefon);
                clientiMaj.add(clientMaj);
            }

            dialog.setTitle("SELECT CLIENTI MAJORI");
            for(List<String> data:clientiMaj)
            {
                String out = data.toString();
                String output=out.concat("\n");
                JLabel outputLabel = new JLabel(output);
                panel.add(outputLabel);
                outputLabel.setVerticalAlignment(JLabel.TOP);
                Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
                dialog.add(panel);
                dialog.pack();
                dialog.setSize(DimMax);
                dialog.setVisible(true);
            }
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            conn.close();
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }
}
