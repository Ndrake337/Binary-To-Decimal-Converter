package com.binaryconversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    private JPanel panelMain;
    private JFormattedTextField DecimalNumber;
    private JFormattedTextField BinaryNumber;
    private JLabel DecimalLaber;
    private JLabel BinaryLabel;
    private JTextPane Title;

    public App() {
        DecimalNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        DecimalNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DecimalNumber.setEditable(true);
                int Decimal = Integer.parseInt(DecimalNumber.getText());
                ArrayList<String> BinaryCode = new ArrayList();
                while (Decimal > 0) {
                    // storing remainder in binary array
                    int resto = Decimal % 2;
                    Integer x = new Integer(resto);
                    String value = x.toString();
                    BinaryCode.add(value);
                    Decimal = Decimal / 2;
                }
                Collections.reverse(BinaryCode);
                StringBuffer sb = new StringBuffer();
                for (String s : BinaryCode) {
                    sb.append(s);
                }
                BinaryNumber.setValue(sb);
            }
        });
        BinaryNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Binary = BinaryNumber.getText();
                int dec_value = 0;

                // Initializing base value to 1,
                // i.e 2^0
                int base = 1;

                int len = Binary.length();
                for (int i = len - 1; i >= 0; i--) {
                    if (Binary.charAt(i) == '1')
                        dec_value += base;
                    base = base * 2;
                }
                DecimalNumber.setValue(dec_value);
            }
        });
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Snow Tech Binary To Decimal");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
    }

}
