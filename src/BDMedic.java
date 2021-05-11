import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class BDMedic {
    public void MedicSelect() {
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
                String salariu = rs.getString(8);
                medic.add(salariu);
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
            System.out.println(medici);
            conn.close();
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
    }

    public void MedicInsert() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertMin="INSERT INTO Medic (cnp, NUME, PRENUME, SECTIE, ZI_ANGAJARE, LUNA_ANGAJARE, AN_ANGAJARE, SALARIU, NR_TELEFON, EMAIL, COD_PARAFA, SPECIALIZARE, REZIDENT, GARDA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMin);
            InfoAngajare infoAng=new InfoAngajare(" ",0,0,0,0.0);
            Medic medic=new Medic(" "," "," ",infoAng," "," ",0.0," ",true,true);
            System.out.println("Citire medic nou:");
            medic.CitirePersonal();
            ps.setString(1, medic.getCnp());
            ps.setString(2, medic.getNume());
            ps.setString(3,medic.getPrenume());
            ps.setString(4,medic.getInfoAngajare().getSectie());
            ps.setInt(5,medic.getInfoAngajare().getZiAngajare());
            ps.setInt(6,medic.getInfoAngajare().getLunaAngajare());
            ps.setInt(7,medic.getInfoAngajare().getAnAngajare());
            ps.setDouble(8,medic.getInfoAngajare().getSalariu());
            ps.setString(9,medic.getNrTelefon());
            ps.setString(10,medic.getEmail());
            ps.setDouble(11,medic.getCodParafa());
            ps.setString(12,medic.getSpecializare());
            ps.setBoolean(13,medic.isRezident());
            ps.setBoolean(14,medic.isGarda());
            int row = ps.executeUpdate();
            System.out.println("S-a inserat un nou medic in baza de date!");
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }
}