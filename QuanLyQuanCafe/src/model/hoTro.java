/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static java.lang.Thread.sleep;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import javafx.scene.layout.Region;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Duong Duy
 */
public class hoTro {

    static SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static boolean ktraRong(JTextField txt) {
        if (txt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, txt.getName() + " không được rỗng", "Thông báo", 1);
            txt.requestFocus();
            return true;
        }
        return false;
    }

    public static void clock(JLabel lbTime) {
        Thread clock = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Date t = new Date();
                        lbTime.setText(ft.format(t));
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        System.out.println("hihih");
        clock.start();

    }

    public static boolean ktraNgay(JTextField txt) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
            df.parse(txt.getText().trim());
        } catch (Exception e) {
            txt.setText("");
            txt.requestFocus();
            JOptionPane.showMessageDialog(null, txt.getName() + " không được hợp lệ", "Thông báo", 1);
            return false;
        }
        return true;
    }

    public static boolean ktraSDT(JTextField txt) {
        String ktra = "0\\d{9,10}";
        if (!txt.getText().trim().matches(ktra)) {
            JOptionPane.showMessageDialog(null, txt.getName() + " không hợp lệ", "Thông báo", 1);
            txt.setText("");
            txt.requestFocus();
            return false;
        }
        return true;
    }

    public static int writeFile(String tenFile, String noiDungFile) {
        try {
            File file = new File("src\\file\\" + tenFile + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(noiDungFile);
            bw.close();
            fw.close();
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    public static void openFile(String tenFile) {
        try {
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "src\\file\\" + tenFile + ".txt");
            pb.start();
        } catch (IOException ex) {
        }
    }

    public static String md5(String passWord) {
        String str = "";
        try {
            MessageDigest msd = MessageDigest.getInstance("MD5");
            byte[] srcTextBytes = passWord.getBytes("UTF-8");
            byte[] enrTextBytes = msd.digest(srcTextBytes);
            BigInteger bigInt = new BigInteger(1, enrTextBytes);
            str = bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static int checkKey() {
        String value = "";
        value = JOptionPane.showInputDialog(null, "Nhập key", "Thông báo", 1);
        if (value == null) {

            return -1;
        }
        String key = "8e12386bc0dc8af130c65edd422b077d";
        while (true) {
            if (!key.equals(hoTro.md5(value))) {
                JOptionPane.showMessageDialog(null, "Lỗi key", "Thông báo", 1);
                value = JOptionPane.showInputDialog(null, "Nhập key", "Thông báo", 1);
                if (value == null) {
                    return -1;
                }
            } else {
                return 1;
            }
        }
    }

    public static void setImageButton(JButton button, String fileName) {
        try {
            BufferedImage image = ImageIO.read(new File(fileName));
            int w = button.getSize().width;
            int h = button.getSize().height;
            int iw = image.getWidth();
            int ih = image.getHeight();
            int dw = 0;
            int dh = 0;
            if (w / h > iw / ih) {
                dh = h;
                dw = dh * iw / ih;
            } else {
                dw = w;
                dh = dw * ih / iw;
            }
            ImageIcon icon = new ImageIcon(image.getScaledInstance(dw, dh,
                    Image.SCALE_SMOOTH));
            button.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setImageLabel(JLabel label, String fileName) {
        try {
            BufferedImage image = ImageIO.read(new File(fileName));
            int w = label.getSize().width;
            int h = label.getSize().height;
            int iw = image.getWidth();
            int ih = image.getHeight();
            int dw = 0;
            int dh = 0;
            if (w / h > iw / ih) {
                dh = h;
                dw = dh * iw / ih - 10;
            } else {
                dw = w;
                dh = dw * ih / iw - 10;
            }
            ImageIcon icon = new ImageIcon(image.getScaledInstance(dw, dh,
                    Image.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void offEdittingTable(JTable tb) {
        if (tb.isEditing()) {
            int row=tb.getSelectedRow();
            int col=tb.getSelectedColumn();
            tb.getCellEditor(row, col).cancelCellEditing();           
        }
    }
}
