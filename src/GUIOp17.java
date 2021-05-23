import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class GUIOp17 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertPrMaj = "INSERT INTO programare_clientmajor (ID_PROGRAMARE, COD_BILET, CNP, ZI_PROGRAMARE, LUNA_PROGRAMARE, AN_PROGRAMARE, ZI_PLANIFICARE, LUNA_PLANIFICARE, AN_PLANIFICARE, SECTIE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertPrMaj);

            String idProgramare=JOptionPane.showInputDialog("ID PROGRAMARE");
            Double id=Double.parseDouble(idProgramare);
            String codBiletTrimitere=JOptionPane.showInputDialog("COD BILET TRIMITERE");
            Double cod=Double.parseDouble(codBiletTrimitere);
            String cnpClientMajor=JOptionPane.showInputDialog("CNP CLIENT MAJOR");
            String ziuaProgramarii=JOptionPane.showInputDialog("ZIUA PROGRAMARII");
            int ziProg=Integer.parseInt(ziuaProgramarii);
            String lunaProgramarii=JOptionPane.showInputDialog("LUNA PROGRAMARII");
            int lunaProg=Integer.parseInt(lunaProgramarii);
            String anulProgramarii=JOptionPane.showInputDialog("ANUL PROGRAMARII");
            int anProg=Integer.parseInt(anulProgramarii);
            String ziuaPlanificarii=JOptionPane.showInputDialog("ZIUA PLANIFICARII");
            int ziPlan=Integer.parseInt(ziuaPlanificarii);
            String lunaPlanificarii=JOptionPane.showInputDialog("LUNA PLANIFICARII");
            int lunaPlan=Integer.parseInt(lunaPlanificarii);
            String anulPlanificarii=JOptionPane.showInputDialog("ANUL PLANIFICARII");
            int anPlan=Integer.parseInt(anulPlanificarii);
            String sectia=JOptionPane.showInputDialog("SECTIA");

            ps.setDouble(1, id);
            ps.setDouble(2, cod);
            ps.setString(3, cnpClientMajor);
            ps.setInt(4, ziProg);
            ps.setInt(5, lunaProg);
            ps.setInt(6, anProg);
            ps.setInt(7, ziPlan);
            ps.setInt(8, lunaPlan);
            ps.setInt(9, anPlan);
            ps.setString(10, sectia);
            int row = ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"S-a inserat o noua programare in baza de date!");
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
    }
}