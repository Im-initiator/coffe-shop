/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.banDAO;
import DAO.chiTietHDDAO;
import DAO.hoaDonDAO;
import DAO.nhanVienDAO;
import DAO.nuocUongDAO;
import POJO.ban;
import POJO.chiTietHD;
import POJO.hoaDon;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.hoTro;

/**
 *
 * @author HP
 */
public class QLHD extends javax.swing.JFrame {

    /**
     * Creates new form QLHD
     */
    ArrayList<hoaDon> ds;
    DefaultTableModel modelTBHD;
    DefaultTableModel modelTBCTHD;

    String tentk = "";
    float tongTien = 0;
    final int HEIGHT;
    final int WIDTH;

    public QLHD(String tentk) {
        initComponents();
        this.tentk = tentk;
        txtTuKhoa.requestFocus();
        setResizable(false);
        setLocationRelativeTo(null);
        modelTBHD = (DefaultTableModel) tbHD.getModel();
        modelTBCTHD = (DefaultTableModel) tbCTHD.getModel();
        loadData();
        lbThongBao.setText("");
        lbThongBao1.setText("");
        HEIGHT = getHeight();
        WIDTH = getWidth();
        this.setSize(WIDTH, 441);

    }

    void loadData() {
        tongTien = 0;
        ds = hoaDonDAO.getDSHD();
        modelTBHD.setRowCount(0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (hoaDon hd : ds) {
            Vector r = new Vector();
            r.add(hd.getMahd());
            r.add(df.format(hd.getNgayRaHD()));
            r.add(hd.getThanhToan());
            r.add(nhanVienDAO.timTenNVTheoMa(hd.getManv()));
            r.add(hd.getGiamGia());
            r.add(banDAO.layTenBanTheoMa(hd.getMaBan()));
            tongTien += hd.getThanhToan();
            modelTBHD.addRow(r);
        }
        txtTongTien.setText("" + tongTien);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("src//img//nen7.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }

        };
        txtTuKhoa = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        lbMa = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        lbThongBao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("src//img//nen7.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }

        };
        txtTuKhoa1 = new javax.swing.JTextField();
        btnTimKiem1 = new javax.swing.JButton();
        lbMa1 = new javax.swing.JLabel();
        lbThongBao1 = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCTHD = new javax.swing.JTable();
        btnLamMoi1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý hóa đơn");
        setResizable(false);

        txtTuKhoa.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtTuKhoa.setName("Từ khoá "); // NOI18N

        btnTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_a.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        lbMa.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbMa.setForeground(new java.awt.Color(255, 0, 0));
        lbMa.setText("TỪ KHOÁ");

        btnLamMoi.setBackground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(255, 255, 255));
        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btnThoat.setText("ĐÓNG");
        btnThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Tổng tiền:");

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        lbThongBao.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbThongBao.setForeground(new java.awt.Color(255, 0, 0));
        lbThongBao.setText("KẾT QUẢ TÌM KIẾM:0");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("DANH SÁCH HOÁ ĐƠN");

        tbHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hoá đơn", "Ngày lập", "Thanh toán", "Nhân Viên", "Giảm giá", "Tên bàn"
            }
        ));
        tbHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbHDMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbHDMouseReleased(evt);
            }
        });
        tbHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbHDKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbHD);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbMa)
                        .addGap(40, 40, 40)
                        .addComponent(txtTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addGap(83, 83, 83)
                        .addComponent(btnLamMoi)
                        .addGap(108, 108, 108)
                        .addComponent(btnXoa)
                        .addGap(60, 60, 60)
                        .addComponent(btnThoat))
                    .addComponent(lbThongBao))
                .addContainerGap(319, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLamMoi, btnThoat, btnTimKiem, btnXoa});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi)
                    .addComponent(btnTimKiem)
                    .addComponent(btnThoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbThongBao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLamMoi, btnThoat, btnTimKiem, btnXoa});

        txtTuKhoa1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtTuKhoa1.setName("Từ khoá "); // NOI18N

        btnTimKiem1.setBackground(new java.awt.Color(255, 255, 255));
        btnTimKiem1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnTimKiem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_a.png"))); // NOI18N
        btnTimKiem1.setText("Tìm kiếm");
        btnTimKiem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem1ActionPerformed(evt);
            }
        });

        lbMa1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbMa1.setForeground(new java.awt.Color(255, 0, 0));
        lbMa1.setText("TỪ KHOÁ");

        lbThongBao1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbThongBao1.setForeground(new java.awt.Color(255, 0, 0));
        lbThongBao1.setText("KẾT QUẢ TÌM KIẾM:0");

        lbTitle.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(51, 51, 255));
        lbTitle.setText("DANH SÁCH CHI TIẾT HOÁ ĐƠN");

        tbCTHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên nước", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tbCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbCTHDMouseReleased(evt);
            }
        });
        tbCTHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbCTHDKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbCTHD);

        btnLamMoi1.setBackground(new java.awt.Color(255, 255, 255));
        btnLamMoi1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLamMoi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        btnLamMoi1.setText("Làm mới");
        btnLamMoi1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoi1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbMa1)
                                .addGap(40, 40, 40)
                                .addComponent(txtTuKhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbThongBao1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnTimKiem1)
                                .addGap(67, 67, 67)
                                .addComponent(btnLamMoi1)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTuKhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMa1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbThongBao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem1)
                    .addComponent(btnLamMoi1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void xoaTrang() {
        txtTuKhoa.setText("");
        lbThongBao.setText("");
        lbThongBao1.setText("");
        txtTuKhoa.requestFocus();
        txtTuKhoa1.setText("");

        this.setSize(WIDTH, 441);
    }
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        xoaTrang();
        loadData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:     
        if (hoTro.ktraRong(txtTuKhoa)) {
            return;
        }
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        modelTBHD.setRowCount(0);
        tongTien = 0;
        ArrayList<hoaDon> dshd = hoaDonDAO.timKiem(txtTuKhoa.getText().trim());
        for (hoaDon hd : dshd) {
            Vector r = new Vector();
            r.add(hd.getMahd());
            r.add(df.format(hd.getNgayRaHD()));
            r.add(hd.getThanhToan());
            r.add(nhanVienDAO.timTenNVTheoMa(hd.getManv()));
            r.add(hd.getGiamGia());
            r.add(banDAO.layTenBanTheoMa(hd.getMaBan()));
            tongTien += hd.getThanhToan();
            modelTBHD.addRow(r);
        }
        txtTongTien.setText("" + tongTien);
        lbThongBao.setText("KẾT QUẢ TÌM KIẾM:" + dshd.size());
        lbThongBao1.setText("");
        txtTuKhoa1.setText("");
        setSize(WIDTH, 470);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tbHD.getSelectedRow();
        if (row >= 0) {
            if (JOptionPane.showConfirmDialog(null, "Bạn muốn xoá hoá đơn với mã " + modelTBHD.getValueAt(row, 0).toString() + "?", "Thông báo", JOptionPane.YES_NO_OPTION, 1) == JOptionPane.YES_OPTION) {
                int i = hoaDonDAO.xoaHD(modelTBHD.getValueAt(row, 0).toString().trim());
                if (i != -1) {
                    JOptionPane.showMessageDialog(null, "Xoá thành công", "Thông báo", 1);
                    loadData();
                    xoaTrang();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Mời bạn chọn hoá đơn để xoá!!!", "Thông báo", 1);
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        dispose();
        new quanly(tentk).setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem1ActionPerformed
        // TODO add your handling code here:
        if (hoTro.ktraRong(txtTuKhoa1)) {
            return;
        }
        modelTBCTHD.setRowCount(0);
        ArrayList<chiTietHD> dscthd = chiTietHDDAO.timKiem(txtTuKhoa1.getText(), modelTBHD.getValueAt(tbHD.getSelectedRow(), 0).toString());
        for (chiTietHD ct : dscthd) {
            Vector r = new Vector();
            r.add(nuocUongDAO.timTenNuocTheoMa(ct.getMaNuocUong()));
            r.add(ct.getSoLuong());
            r.add(ct.getDonGia());
            r.add(ct.getThanhTien());
            modelTBCTHD.addRow(r);
        }
        lbThongBao1.setText("KẾT QUẢ TÌM KIẾM:" + dscthd.size());
    }//GEN-LAST:event_btnTimKiem1ActionPerformed
    void loadCTHD(String tukhoa) {
        modelTBCTHD.setRowCount(0);
        ArrayList<chiTietHD> dscthd = chiTietHDDAO.timKiem(tukhoa);
        for (chiTietHD ct : dscthd) {
            Vector r = new Vector();
            r.add(nuocUongDAO.timTenNuocTheoMa(ct.getMaNuocUong()));
            r.add(ct.getSoLuong());
            r.add(ct.getDonGia());
            r.add(ct.getThanhTien());
            modelTBCTHD.addRow(r);
        }
    }
    private void tbHDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDMousePressed
        // TODO add your handling code here:

        int row = tbHD.getSelectedRow();
        if (row >= 0) {
            String mahd = modelTBHD.getValueAt(row, 0).toString().trim();
            this.setSize(WIDTH, HEIGHT);
            loadCTHD(mahd);
            lbTitle.setText("DANH SÁCH CHI TIẾT HOÁ ĐƠN:" + mahd);
        }

    }//GEN-LAST:event_tbHDMousePressed

    private void btnLamMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoi1ActionPerformed
        // TODO add your handling code here:
        int row = tbHD.getSelectedRow();
        String mahd = modelTBHD.getValueAt(row, 0).toString().trim();
        loadCTHD(mahd);
        lbThongBao1.setText("");
    }//GEN-LAST:event_btnLamMoi1ActionPerformed

    private void tbHDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDMouseReleased
        // TODO add your handling code here:
        hoTro.offEdittingTable(tbHD);
    }//GEN-LAST:event_tbHDMouseReleased

    private void tbCTHDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTHDMouseReleased
        // TODO add your handling code here:
        hoTro.offEdittingTable(tbCTHD);

    }//GEN-LAST:event_tbCTHDMouseReleased

    private void tbHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbHDKeyReleased
        // TODO add your handling code here:
        hoTro.offEdittingTable(tbHD);

    }//GEN-LAST:event_tbHDKeyReleased

    private void tbCTHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbCTHDKeyReleased
        // TODO add your handling code here:
        hoTro.offEdittingTable(tbCTHD);

    }//GEN-LAST:event_tbCTHDKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoi1;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiem1;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMa;
    private javax.swing.JLabel lbMa1;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JLabel lbThongBao1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTable tbCTHD;
    private javax.swing.JTable tbHD;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTuKhoa;
    private javax.swing.JTextField txtTuKhoa1;
    // End of variables declaration//GEN-END:variables
}
