import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class BDClientMinor {
    public void ClMinSelect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            List<List<String>> clientiMin=new ArrayList<>();
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
            System.out.println(clientiMin);
            conn.close();
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
    }

    public void ClMinInsert() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertMin="INSERT INTO ClientMinor (cnp, NUME, PRENUME, EMAIL, GEN, ADRESA, NUME_INSOTITOR, PRENUME_INSOTITOR, NR_TELEFON_INSOTITOR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMin);
            ClientMinor clMin=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
            System.out.println("Citire pacient minor nou:");
            clMin.CitireClienti();
            ps.setString(1, clMin.getCnp());
            ps.setString(2, clMin.getNume());
            ps.setString(3,clMin.getPrenume());
            ps.setString(4,clMin.getEmail());
            ps.setString(5,clMin.getGen());
            ps.setString(6,clMin.getAdresa());
            ps.setString(7,clMin.getNumeInsotitor());
            ps.setString(8,clMin.getPrenumeInsotitor());
            ps.setString(9,clMin.getNrTelefonInsotitor());
            int row = ps.executeUpdate();
            System.out.println("S-a inserat un nou client minor in baza de date!");
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void ClMinDelete() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlDeleteMin="DELETE FROM ClientMinor WHERE cnp=?";
            PreparedStatement ps = conn.prepareStatement(sqlDeleteMin);
            Scanner sc=new Scanner(System.in);
            String cnpDel;
            System.out.println("Introduceti CNP-ul persoanei pe care doriti sa o stergeti");
            cnpDel=sc.nextLine();
            ps.setString(1,cnpDel);
            ps.execute();
            int row = ps.executeUpdate();
            System.out.println("S-a sters un client major din baza de date! Randul afectat a fost "+row);
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void ClMinUpdate() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            Scanner sc=new Scanner(System.in);
            System.out.println("Introduceti tipul de data pe care doriti sa o modificati (CNP/NUME/PRENUME/EMAIL/GEN/ADRESA/NUME INSOTITOR/PRENUME INSOTITOR/NUMAR DE TELEFON INSOTITOR)");
            String text=sc.nextLine();
            switch(text) {
                case "CNP":
                    String sqlUpdateMinCnp="UPDATE ClientMinor SET CNP=? WHERE CNP=?";
                    PreparedStatement ps1 = conn.prepareStatement(sqlUpdateMinCnp);
                    System.out.println("Introduceti vechiul CNP:");
                    String cnpVechi = sc.nextLine();
                    System.out.println("Introduceti noul CNP:");
                    String cnpNou = sc.nextLine();
                    ps1.setString(1, cnpNou);
                    ps1.setString(2, cnpVechi);
                    int row1 = ps1.executeUpdate();
                    System.out.println("S-a actualizat un client minor din baza de date! Randul afectat a fost "+row1);
                    break;

                case "NUME":
                    String sqlUpdateMinNume="UPDATE ClientMinor SET NUME=? WHERE NUME=?";
                    PreparedStatement ps2 = conn.prepareStatement(sqlUpdateMinNume);
                    System.out.println("Introduceti vechiul nume:");
                    String numeVechi = sc.nextLine();
                    System.out.println("Introduceti noul nume:");
                    String numeNou = sc.nextLine();
                    ps2.setString(1, numeNou);
                    ps2.setString(2, numeVechi);
                    int row2 = ps2.executeUpdate();
                    System.out.println("S-a actualizat un client minor din baza de date! Randul afectat a fost "+row2);
                    break;

                case "PRENUME":
                    String sqlUpdateMinPrenume="UPDATE ClientMinor SET PRENUME=? WHERE PRENUME=?";
                    PreparedStatement ps3 = conn.prepareStatement(sqlUpdateMinPrenume);
                    System.out.println("Introduceti vechiul prenume:");
                    String prenumeVechi = sc.nextLine();
                    System.out.println("Introduceti noul prenume:");
                    String prenumeNou = sc.nextLine();
                    ps3.setString(1, prenumeNou);
                    ps3.setString(2, prenumeVechi);
                    int row3 = ps3.executeUpdate();
                    System.out.println("S-a actualizat un client minor din baza de date! Randul afectat a fost "+row3);
                    break;

                case "EMAIL":
                    String sqlUpdateMinEmail="UPDATE ClientMinor SET EMAIL=? WHERE EMAIL=?";
                    PreparedStatement ps4 = conn.prepareStatement(sqlUpdateMinEmail);
                    System.out.println("Introduceti vechiul email:");
                    String emailVechi = sc.nextLine();
                    System.out.println("Introduceti noul email:");
                    String emailNou = sc.nextLine();
                    ps4.setString(1, emailNou);
                    ps4.setString(2, emailVechi);
                    int row4 = ps4.executeUpdate();
                    System.out.println("S-a actualizat un client minor din baza de date! Randul afectat a fost "+row4);
                    break;

                case "GEN":
                    String sqlUpdateMinGen="UPDATE ClientMinor SET GEN=? WHERE GEN=?";
                    PreparedStatement ps5 = conn.prepareStatement(sqlUpdateMinGen);
                    System.out.println("Introduceti vechiul gen:");
                    String genVechi = sc.nextLine();
                    System.out.println("Introduceti noul gen:");
                    String genNou = sc.nextLine();
                    ps5.setString(1, genNou);
                    ps5.setString(2, genVechi);
                    int row5 = ps5.executeUpdate();
                    System.out.println("S-a actualizat un client minor din baza de date! Randul afectat a fost "+row5);
                    break;

                case "ADRESA":
                    String sqlUpdateMinAdresa="UPDATE ClientMinor SET ADRESA=? WHERE ADRESA=?";
                    PreparedStatement ps6 = conn.prepareStatement(sqlUpdateMinAdresa);
                    System.out.println("Introduceti vechea adresa:");
                    String adresaVeche = sc.nextLine();
                    System.out.println("Introduceti noua adresa:");
                    String adresaNoua = sc.nextLine();
                    ps6.setString(1, adresaNoua);
                    ps6.setString(2, adresaVeche);
                    int row6 = ps6.executeUpdate();
                    System.out.println("S-a actualizat un client minor din baza de date! Randul afectat a fost "+row6);
                    break;

                case "NUME INSOTITOR":
                    String sqlUpdateMinNumeIn="UPDATE ClientMinor SET NUME_INSOTITOR=? WHERE NUME_INSOTITOR=?";
                    PreparedStatement ps7 = conn.prepareStatement(sqlUpdateMinNumeIn);
                    System.out.println("Introduceti vechiul nume:");
                    String numeInVechi = sc.nextLine();
                    System.out.println("Introduceti noul nume:");
                    String numeInNou = sc.nextLine();
                    ps7.setString(1, numeInNou);
                    ps7.setString(2, numeInVechi);
                    int row7 = ps7.executeUpdate();
                    System.out.println("S-a actualizat un client minor din baza de date! Randul afectat a fost "+row7);
                    break;

                case "PRENUME INSOTITOR":
                    String sqlUpdateMinPrenumeIn="UPDATE ClientMinor SET PRENUME_INSOTITOR=? WHERE PRENUME_INSOTITOR=?";
                    PreparedStatement ps8 = conn.prepareStatement(sqlUpdateMinPrenumeIn);
                    System.out.println("Introduceti vechiul prenume:");
                    String prenumeInVechi = sc.nextLine();
                    System.out.println("Introduceti noul prenume:");
                    String prenumeInNou = sc.nextLine();
                    ps8.setString(1, prenumeInNou);
                    ps8.setString(2, prenumeInVechi);
                    int row8 = ps8.executeUpdate();
                    System.out.println("S-a actualizat un client minor din baza de date! Randul afectat a fost "+row8);
                    break;

                case "NUMAR DE TELEFON INSOTITOR":
                    String sqlUpdateMinTelefonIn="UPDATE ClientMinor SET NR_TELEFON_INSOTITOR=? WHERE NR_TELEFON_INSOTITOR=?";
                    PreparedStatement ps9 = conn.prepareStatement(sqlUpdateMinTelefonIn);
                    System.out.println("Introduceti vechiul numar de telefon:");
                    String telefonVechi = sc.nextLine();
                    System.out.println("Introduceti noul numar de telefon:");
                    String telefonNou = sc.nextLine();
                    ps9.setString(1, telefonNou);
                    ps9.setString(2, telefonVechi);
                    int row9 = ps9.executeUpdate();
                    System.out.println("S-a actualizat un client minor din baza de date! Randul afectat a fost "+row9);
                    break;

                default:
                        System.out.println("OPTIUNE INVALIDA! ALEGETI DIN NOU!");
                        break;
            }
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void ClMinInsertCSV() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertMin="INSERT IGNORE INTO ClientMinor (cnp, NUME, PRENUME, EMAIL, GEN, ADRESA, NUME_INSOTITOR, PRENUME_INSOTITOR, NR_TELEFON_INSOTITOR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMin);
            ClientMinor clMin=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
            System.out.println("Citire din fisierul CSV ClientMin:");
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
                if(row==1) System.out.println("S-a inserat un nou client minor in baza de date!");
            }

        } catch (SQLException | ClassNotFoundException | FileNotFoundException var10) {
            var10.printStackTrace();
        }

    }
}