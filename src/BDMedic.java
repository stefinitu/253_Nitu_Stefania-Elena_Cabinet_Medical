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
            String sqlInsertMin = "INSERT INTO Medic (cnp, NUME, PRENUME, SECTIE, ZI_ANGAJARE, LUNA_ANGAJARE, AN_ANGAJARE, SALARIU, NR_TELEFON, EMAIL, COD_PARAFA, SPECIALIZARE, REZIDENT, GARDA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMin);
            InfoAngajare infoAng = new InfoAngajare(" ", 0, 0, 0, 0.0);
            Medic medic = new Medic(" ", " ", " ", infoAng, " ", " ", 0.0, " ", true, true);
            System.out.println("Citire medic nou:");
            medic.CitirePersonal();
            ps.setString(1, medic.getCnp());
            ps.setString(2, medic.getNume());
            ps.setString(3, medic.getPrenume());
            ps.setString(4, medic.getInfoAngajare().getSectie());
            ps.setInt(5, medic.getInfoAngajare().getZiAngajare());
            ps.setInt(6, medic.getInfoAngajare().getLunaAngajare());
            ps.setInt(7, medic.getInfoAngajare().getAnAngajare());
            ps.setDouble(8, medic.getInfoAngajare().getSalariu());
            ps.setString(9, medic.getNrTelefon());
            ps.setString(10, medic.getEmail());
            ps.setDouble(11, medic.getCodParafa());
            ps.setString(12, medic.getSpecializare());
            ps.setBoolean(13, medic.isRezident());
            ps.setBoolean(14, medic.isGarda());
            int row = ps.executeUpdate();
            System.out.println("S-a inserat un nou medic in baza de date!");
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void MedicUpdate() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduceti tipul de data pe care doriti sa o modificati (CNP/NUME/PRENUME/SECTIE/GEN/ZIUA ANGAJARII/LUNA ANGAJARII/ANUL ANGAJARII/SALARIU/NUMAR DE TELEFON/EMAIL/COD PARAFA/SPECIALIZARE/REZIDENT/GARDA)");
            String text = sc.nextLine();
            switch (text) {
                case "CNP":
                    String sqlUpdateMedicCnp = "UPDATE medic SET CNP=? WHERE CNP=?";
                    PreparedStatement ps1 = conn.prepareStatement(sqlUpdateMedicCnp);
                    System.out.println("Introduceti vechiul CNP:");
                    String cnpVechi = sc.nextLine();
                    System.out.println("Introduceti noul CNP:");
                    String cnpNou = sc.nextLine();
                    ps1.setString(1, cnpNou);
                    ps1.setString(2, cnpVechi);
                    int row1 = ps1.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row1);
                    break;

                case "NUME":
                    String sqlUpdateMedicNume = "UPDATE medic SET NUME=? WHERE NUME=?";
                    PreparedStatement ps2 = conn.prepareStatement(sqlUpdateMedicNume);
                    System.out.println("Introduceti vechiul nume:");
                    String numeVechi = sc.nextLine();
                    System.out.println("Introduceti noul nume:");
                    String numeNou = sc.nextLine();
                    ps2.setString(1, numeNou);
                    ps2.setString(2, numeVechi);
                    int row2 = ps2.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row2);
                    break;

                case "PRENUME":
                    String sqlUpdateMedicPrenume = "UPDATE medic SET PRENUME=? WHERE PRENUME=?";
                    PreparedStatement ps3 = conn.prepareStatement(sqlUpdateMedicPrenume);
                    System.out.println("Introduceti vechiul prenume:");
                    String prenumeVechi = sc.nextLine();
                    System.out.println("Introduceti noul prenume:");
                    String prenumeNou = sc.nextLine();
                    ps3.setString(1, prenumeNou);
                    ps3.setString(2, prenumeVechi);
                    int row3 = ps3.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row3);
                    break;

                case "SECTIE":
                    String sqlUpdateMedicSectie = "UPDATE medic SET SECTIE=? WHERE CNP=?";
                    PreparedStatement ps4 = conn.prepareStatement(sqlUpdateMedicSectie);
                    System.out.println("Introduceti CNP-ul medicului:");
                    String cnp4 = sc.nextLine();
                    System.out.println("Introduceti noua sectie:");
                    String sectieNoua = sc.nextLine();
                    ps4.setString(1, sectieNoua);
                    ps4.setString(2, cnp4);
                    int row4 = ps4.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row4);
                    break;

                case "ZIUA ANGAJARII":
                    String sqlUpdateMedicZi = "UPDATE medic SET ZI_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps5 = conn.prepareStatement(sqlUpdateMedicZi);
                    System.out.println("Introduceti CNP-ul medicului:");
                    String cnp5 = sc.nextLine();
                    System.out.println("Introduceti noua zi:");
                    int ziNoua = Integer.parseInt(sc.nextLine());
                    ps5.setInt(1, ziNoua);
                    ps5.setString(2, cnp5);
                    int row5 = ps5.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row5);
                    break;

                case "LUNA ANGAJARII":
                    String sqlUpdateMedicLuna = "UPDATE medic SET LUNA_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps6 = conn.prepareStatement(sqlUpdateMedicLuna);
                    System.out.println("Introduceti CNP-ul medicului:");
                    String cnp6 = sc.nextLine();
                    System.out.println("Introduceti noua luna:");
                    int lunaNoua = Integer.parseInt(sc.nextLine());
                    ps6.setInt(1, lunaNoua);
                    ps6.setString(2, cnp6);
                    int row6 = ps6.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row6);
                    break;

                case "ANUL ANGAJARII":
                    String sqlUpdateMedicAn = "UPDATE medic SET AN_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps7 = conn.prepareStatement(sqlUpdateMedicAn);
                    System.out.println("Introduceti CNP-ul medicului");
                    String cnp7 = sc.nextLine();
                    System.out.println("Introduceti noul an:");
                    int anNou = Integer.parseInt(sc.nextLine());
                    ps7.setInt(1, anNou);
                    ps7.setString(2, cnp7);
                    int row7 = ps7.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row7);
                    break;

                case "SALARIU":
                    String sqlUpdateMedicSalariu = "UPDATE medic SET SALARIU=? WHERE CNP=?";
                    PreparedStatement ps8 = conn.prepareStatement(sqlUpdateMedicSalariu);
                    System.out.println("Introduceti CNP-ul medicului");
                    String cnpM = sc.nextLine();
                    System.out.println("Introduceti noul salariu:");
                    Double salariuNou = Double.parseDouble(sc.nextLine());
                    ps8.setDouble(1, salariuNou);
                    ps8.setString(2, cnpM);
                    int row8 = ps8.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row8);
                    break;

                case "NUMAR DE TELEFON":
                    String sqlUpdateMedicTelefon = "UPDATE medic SET NR_TELEFON=? WHERE NR_TELEFON=?";
                    PreparedStatement ps9 = conn.prepareStatement(sqlUpdateMedicTelefon);
                    System.out.println("Introduceti vechiul numar de telefon:");
                    String telefonVechi = sc.nextLine();
                    System.out.println("Introduceti noul numar de telefon:");
                    String telefonNou = sc.nextLine();
                    ps9.setString(1, telefonNou);
                    ps9.setString(2, telefonVechi);
                    int row9 = ps9.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row9);
                    break;

                case "EMAIL":
                    String sqlUpdateMedicEmail = "UPDATE medic SET EMAIL=? WHERE EMAIL=?";
                    PreparedStatement ps10 = conn.prepareStatement(sqlUpdateMedicEmail);
                    System.out.println("Introduceti vechiul email:");
                    String emailVechi = sc.nextLine();
                    System.out.println("Introduceti noul email:");
                    String emailNou = sc.nextLine();
                    ps10.setString(1, emailNou);
                    ps10.setString(2, emailVechi);
                    int row10 = ps10.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row10);
                    break;

                case "COD PARAFA":
                    String sqlUpdateMedicCod = "UPDATE medic SET COD_PARAFA=? WHERE COD_PARAFA=?";
                    PreparedStatement ps11 = conn.prepareStatement(sqlUpdateMedicCod);
                    System.out.println("Introduceti vechiul cod:");
                    Double codVechi = Double.parseDouble(sc.nextLine());
                    System.out.println("Introduceti noul cod:");
                    Double codNou = Double.parseDouble(sc.nextLine());
                    ps11.setDouble(1, codNou);
                    ps11.setDouble(2, codVechi);
                    int row11 = ps11.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row11);
                    break;

                case "SPECIALIZARE":
                    String sqlUpdateMedicSp = "UPDATE medic SET SPECIALIZARE=? WHERE CNP=?";
                    PreparedStatement ps12 = conn.prepareStatement(sqlUpdateMedicSp);
                    System.out.println("Introduceti CNP-ul medicului:");
                    String cnpMedic = sc.nextLine();
                    System.out.println("Introduceti noua specializare:");
                    String specializareNoua = sc.nextLine();
                    ps12.setString(1, specializareNoua);
                    ps12.setString(2, cnpMedic);
                    int row12 = ps12.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row12);
                    break;

                case "REZIDENT":
                    String sqlUpdateMedicRez = "UPDATE medic SET REZIDENT=? WHERE CNP=?";
                    PreparedStatement ps13 = conn.prepareStatement(sqlUpdateMedicRez);
                    System.out.println("Introduceti CNP-ul medicului:");
                    String cnpMed = sc.nextLine();
                    System.out.println("Introduceti noua valoare:");
                    Boolean rezidentNou = Boolean.parseBoolean(sc.nextLine());
                    ps13.setBoolean(1, rezidentNou);
                    ps13.setString(2, cnpMed);
                    int row13 = ps13.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row13);
                    break;

                case "GARDA":
                    String sqlUpdateMedicGarda = "UPDATE medic SET GARDA=? WHERE CNP=?";
                    PreparedStatement ps14 = conn.prepareStatement(sqlUpdateMedicGarda);
                    System.out.println("Introduceti CNP-ul medicului:");
                    String cnp14 = sc.nextLine();
                    System.out.println("Introduceti noua valoare:");
                    Boolean gardaNou = Boolean.parseBoolean(sc.nextLine());
                    ps14.setBoolean(1, gardaNou);
                    ps14.setString(2, cnp14);
                    int row14 = ps14.executeUpdate();
                    System.out.println("S-a actualizat un medic din baza de date! Randul afectat a fost " + row14);
                    break;

                default:
                    System.out.println("OPTIUNE INVALIDA! ALEGETI DIN NOU!");
                    break;
            }
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void MedicDelete() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlDeleteMedic="DELETE FROM medic WHERE cnp=?";
            PreparedStatement ps = conn.prepareStatement(sqlDeleteMedic);
            Scanner sc=new Scanner(System.in);
            String cnpDel;
            System.out.println("Introduceti CNP-ul medicului pe care doriti sa il stergeti");
            cnpDel=sc.nextLine();
            ps.setString(1,cnpDel);
            int row=ps.executeUpdate();
            System.out.println("S-a sters un medic din baza de date! Randul afectat a fost "+row);
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void MedicInsertCSV() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertMedic = "INSERT IGNORE INTO medic (cnp, NUME, PRENUME, SECTIE, ZI_ANGAJARE, LUNA_ANGAJARE, AN_ANGAJARE, SALARIU,NR_TELEFON, EMAIL, COD_PARAFA, SPECIALIZARE, REZIDENT, GARDA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMedic);
            System.out.println("Citire din fisierul CSV Medic:");
            List<List<String>> medici = new ArrayList<>();
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
                if (row == 1) System.out.println("S-a inserat un nou medic in baza de date!");
            }

        } catch (SQLException | ClassNotFoundException | FileNotFoundException var10) {
            var10.printStackTrace();
        }
    }
}