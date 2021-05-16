import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMenu {
    public void GUI()
    {
        JFrame frame=new JFrame();
        JButton opt1=new JButton("SELECT CLIENTI MAJORI");
        JButton opt2=new JButton("INSERT CLIENTI MAJORI");
        JButton opt3=new JButton("DELETE CLIENTI MAJORI");
        JButton opt4=new JButton("UPDATE CLIENTI MAJORI");
        JButton opt5=new JButton("SELECT CLIENTI MINORI");
        JButton opt6=new JButton("INSERT CLIENTI MINORI");
        JButton opt7=new JButton("DELETE CLIENTI MINORI");
        JButton opt8=new JButton("UPDATE CLIENTI MINORI");
        JButton opt9=new JButton("INSERT CLIENTI MAJORI DIN CSV");
        JButton opt10=new JButton("INSERT CLIENTI MINORI DIN CSV");
        JButton opt11=new JButton("SELECT MEDICI");
        JButton opt12=new JButton("INSERT MEDICI");
        JButton opt13=new JButton("UPDATE MEDICI");
        JButton opt14=new JButton("INSERT MEDICI DIN CSV");
        JButton opt15=new JButton("DELETE MEDIC");
        JButton opt16=new JButton("SELECT PROGRAMARE CLIENT MAJOR");
        JButton opt17=new JButton("INSERT PROGRAMARE CLIENT MAJOR");
        JButton opt18=new JButton("UPDATE PROGRAMARE CLIENT MAJOR");
        JButton opt19=new JButton("DELETE PROGRAMARE CLIENT MAJOR");
        JButton opt20=new JButton("SELECT PROGRAMARE CLIENT MINOR");
        JButton opt21=new JButton("INSERT PROGRAMARE CLIENT MINOR");
        JButton opt22=new JButton("UPDATE PROGRAMARE CLIENT MINOR");
        JButton opt23=new JButton("DELETE PROGRAMARE CLIENT MINOR");
        JButton opt24=new JButton("SELECT ASISTENT");
        JButton opt25=new JButton("INSERT ASISTENT");
        JButton opt26=new JButton("UPDATE ASISTENT");
        JButton opt27=new JButton("DELETE ASISTENT");
        JButton opt28=new JButton("INSERT ASISTENT DIN CSV");

        opt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp1 guiOp1=new GUIOp1();
                guiOp1.GUI();
            }
        });

        opt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp2 guiOp2=new GUIOp2();
                guiOp2.GUI();
            }
        });

        opt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp3 guiOp3=new GUIOp3();
                guiOp3.GUI();
            }
        });

        opt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp4 guiOp4=new GUIOp4();
                guiOp4.GUI();
            }
        });

        opt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp5 guiOp5=new GUIOp5();
                guiOp5.GUI();
            }
        });

        opt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp6 guiOp6=new GUIOp6();
                guiOp6.GUI();
            }
        });

        opt7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp7 guiOp7=new GUIOp7();
                guiOp7.GUI();
            }
        });

        opt8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp8 guiOp8=new GUIOp8();
                guiOp8.GUI();
            }
        });

        opt9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp9 guiOp9=new GUIOp9();
                guiOp9.GUI();
            }
        });

        opt10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp10 guiOp10=new GUIOp10();
                guiOp10.GUI();
            }
        });

        opt11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp11 guiOp11=new GUIOp11();
                guiOp11.GUI();
            }
        });

        opt12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp12 guiOp12=new GUIOp12();
                guiOp12.GUI();
            }
        });

        opt13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp13 guiOp13=new GUIOp13();
                guiOp13.GUI();
            }
        });

        opt14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp14 guiOp14=new GUIOp14();
                guiOp14.GUI();
            }
        });

        opt15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp15 guiOp15=new GUIOp15();
                guiOp15.GUI();
            }
        });

        opt16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp16 guiOp16=new GUIOp16();
                guiOp16.GUI();
            }
        });

        opt17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp17 guiOp17=new GUIOp17();
                guiOp17.GUI();
            }
        });

        opt18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp18 guiOp18=new GUIOp18();
                guiOp18.GUI();
            }
        });

        opt19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp19 guiOp19=new GUIOp19();
                guiOp19.GUI();
            }
        });

        opt20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp20 guiOp20=new GUIOp20();
                guiOp20.GUI();
            }
        });


        opt21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp21 guiOp21=new GUIOp21();
                guiOp21.GUI();
            }
        });


        opt22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp22 guiOp22=new GUIOp22();
                guiOp22.GUI();
            }
        });


        opt23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp23 guiOp23=new GUIOp23();
                guiOp23.GUI();
            }
        });

        opt24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp24 guiOp24=new GUIOp24();
                guiOp24.GUI();
            }
        });

        opt25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp25 guiOp25=new GUIOp25();
                guiOp25.GUI();
            }
        });

        opt26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp26 guiOp26=new GUIOp26();
                guiOp26.GUI();
            }
        });

        opt27.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp27 guiOp27=new GUIOp27();
                guiOp27.GUI();
            }
        });

        opt28.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIOp28 guiOp28=new GUIOp28();
                guiOp28.GUI();
            }
        });


        JLabel label=new JLabel("Alegeti una din urmatoarele optiuni:");
        JPanel panel=new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        panel.setLayout(new GridLayout(0,1));

        panel.add(label);
        panel.add(opt1);
        panel.add(opt2);
        panel.add(opt3);
        panel.add(opt4);
        panel.add(opt5);
        panel.add(opt6);
        panel.add(opt7);
        panel.add(opt8);
        panel.add(opt9);
        panel.add(opt10);
        panel.add(opt11);
        panel.add(opt12);
        panel.add(opt13);
        panel.add(opt14);
        panel.add(opt15);
        panel.add(opt16);
        panel.add(opt17);
        panel.add(opt18);
        panel.add(opt19);
        panel.add(opt20);
        panel.add(opt21);
        panel.add(opt22);
        panel.add(opt23);
        panel.add(opt24);
        panel.add(opt25);
        panel.add(opt26);
        panel.add(opt27);
        panel.add(opt28);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CABINET MEDICAL - OPTIUNI");
        frame.pack();

        frame.setVisible(true);
    }
}
