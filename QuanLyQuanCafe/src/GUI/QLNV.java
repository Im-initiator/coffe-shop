/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.nhanVienDAO;
import POJO.nhanVien;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.hoTro;

/**
 *
 * @author HP
 */
public class QLNV extends javax.swing.JFrame {

    /**
     * Creates new form QLVN
     */
    DefaultTableModel modelTable;
    ArrayList<nhanVien> listnv;
    String tentk = "";

    public QLNV(String tentk) {
        initComponents();
        this.tentk = tentk;
        setLocationRelativeTo(null);
        setResizable(false);
        modelTable = (DefaultTableModel) jTable1.getModel();
        loadData();
    }

    void loadData() {
        modelTable.setRowCount(0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        listnv = nhanVienDAO.getdsnv();
        for (nhanVien nv : listnv) {
            Vector r = new Vector();
            r.add(nv.getManv());
            r.add(nv.getTennv());
            r.add(nv.getGioiTinh());
            r.add(df.format(nv.getNamSinh()));
            r.add(df.format(nv.getNgayVL()));
            r.add(nv.getSdt());
            r.add(nv.getDiaChi());
            r.add("" + nv.getLuong());
            modelTable.addRow(r);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("src//img//nenmk.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        rdNu = new javax.swing.JRadioButton();
        rdNam = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        txtDienThoai = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtNgayVL = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPrePw = new javax.swing.JPasswordField();
        txtPW = new javax.swing.JPasswordField();
        txtDiaChi = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setText("BẢNG QUẢN LÝ NHÂN VIÊN");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "NGÀY VÀO LÀM", "SĐT", "ĐỊA CHỈ", "LƯƠNG"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("MÃ NHÂN VIÊN:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("MẬT KHẨU:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 51));
        jLabel5.setText("XÁC NHẬN MẬT KHẨU:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 51));
        jLabel6.setText("ĐỊA CHỈ:");

        txtMaNV.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtMaNV.setName("Mã nhân viên "); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("HỌ VÀ TÊN:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("GIỚI TÍNH:");

        txtHoTen.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtHoTen.setName("Họ và tên"); // NOI18N

        buttonGroup1.add(rdNu);
        rdNu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rdNu.setForeground(new java.awt.Color(255, 255, 255));
        rdNu.setSelected(true);
        rdNu.setText("Nữ");

        buttonGroup1.add(rdNam);
        rdNam.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rdNam.setForeground(new java.awt.Color(255, 255, 255));
        rdNam.setText("Nam");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 51));
        jLabel9.setText("NGÀY SINH:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 51));
        jLabel10.setText("SỐ ĐIỆN THOẠI:");

        txtNgaySinh.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtNgaySinh.setName("Ngày sinh "); // NOI18N

        txtDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtDienThoai.setName("Số diện thoại"); // NOI18N
        txtDienThoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLuongKeyTyped(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 255, 255));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hammer.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnDong.setBackground(new java.awt.Color(255, 255, 255));
        btnDong.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("NGÀY VÀO LÀM:");

        txtNgayVL.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtNgayVL.setName("Ngày vào làm"); // NOI18N

        txtLuong.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtLuong.setName("Lương "); // NOI18N
        txtLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLuongKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("LƯƠNG:");

        txtPrePw.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtPrePw.setName("Xác nhận mật khẩu"); // NOI18N

        txtPW.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtPW.setName("Mật khẩu "); // NOI18N
        txtPW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPWActionPerformed(evt);
            }
        });

        txtDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtDiaChi.setName("Địa chỉ"); // NOI18N

        btnReset.setBackground(new java.awt.Color(255, 255, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThem)
                        .addGap(81, 81, 81)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi)
                        .addGap(96, 96, 96)
                        .addComponent(btnSua)
                        .addGap(107, 107, 107)
                        .addComponent(btnXoa)
                        .addGap(96, 96, 96)
                        .addComponent(btnDong))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrePw, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPW, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(197, 197, 197)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdNu)
                                        .addGap(51, 51, 51)
                                        .addComponent(rdNam))
                                    .addComponent(txtNgaySinh)
                                    .addComponent(txtNgayVL, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtDienThoai)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1006, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2))
                    .addContainerGap(512, Short.MAX_VALUE)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, jLabel2, jLabel3, jLabel5, jLabel6});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtLuong, txtMaNV, txtPW, txtPrePw});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel7, jLabel8, jLabel9});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDienThoai, txtNgaySinh, txtNgayVL});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDong, btnLamMoi, btnSua, btnThem, btnXoa});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(rdNu)
                            .addComponent(rdNam))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrePw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtNgayVL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnLamMoi)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnDong)
                    .addComponent(btnReset))
                .addGap(66, 66, 66))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addGap(34, 34, 34)
                    .addComponent(jLabel3)
                    .addGap(28, 28, 28)
                    .addComponent(jLabel4)
                    .addGap(77, 77, 77)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(193, Short.MAX_VALUE)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDong, btnLamMoi, btnSua, btnThem, btnXoa});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(461, 461, 461))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            if (JOptionPane.showConfirmDialog(null, "Bạn muốn xoá nhân viên " + txtHoTen.getText().trim() + "?", "Thông báo", JOptionPane.YES_NO_OPTION, 1) == JOptionPane.YES_OPTION) {

                String manv = modelTable.getValueAt(row, 0).toString();
                int i = nhanVienDAO.xoa1NhanVien(manv);
                if (i == -1) {
                    JOptionPane.showMessageDialog(null, "Không thể xoá nhân viên", "Thông báo", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Xoá thành công", "Thông báo", 1);
                    loadData();
                    xoaTrang();
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Mời bạn chọn nhân viên để xoá!!!", "Thông báo", 1);
        }

    }//GEN-LAST:event_btnXoaActionPerformed
    void xoaTrang() {
        txtMaNV.setEditable(true);
        txtDienThoai.setText("");
        txtHoTen.setText("");
        txtLuong.setText("");
        txtMaNV.setText("");
        txtNgaySinh.setText("");
        txtPW.setText("");
        txtPrePw.setText("");
        txtDiaChi.setText("");
        txtNgayVL.setText("");
        rdNu.setSelected(true);
        txtMaNV.requestFocus();
        btnThem.setEnabled(true);
    }
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        xoaTrang();
        loadData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            btnThem.setEnabled(false);
            txtMaNV.setEditable(false);
            txtMaNV.setText(modelTable.getValueAt(row, 0).toString());
            txtHoTen.setText(modelTable.getValueAt(row, 1).toString());
            String gt = modelTable.getValueAt(row, 2).toString();
            if (gt.toLowerCase().equals("nam")) {
                rdNam.setSelected(true);
            } else {
                rdNu.setSelected(true);
            }
            txtNgaySinh.setText(modelTable.getValueAt(row, 3).toString());
            txtNgayVL.setText(modelTable.getValueAt(row, 4).toString());
            txtDienThoai.setText(modelTable.getValueAt(row, 5).toString());
            txtDiaChi.setText(modelTable.getValueAt(row, 6).toString());
            txtLuong.setText(modelTable.getValueAt(row, 7).toString());
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            if (hoTro.ktraRong(txtHoTen) || hoTro.ktraRong(txtDiaChi) || hoTro.ktraRong(txtLuong)) {
                return;
            }
            if (!hoTro.ktraNgay(txtNgaySinh) || !hoTro.ktraSDT(txtDienThoai) || !hoTro.ktraNgay(txtNgayVL)) {
                return;
            }
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date ngaySinh = df.parse(txtNgaySinh.getText().trim());
                Date ngayVL = df.parse(txtNgayVL.getText().trim());
                if (ngaySinh.compareTo(ngayVL) >= 0) {
                    JOptionPane.showMessageDialog(null, "Ngày sinh phải nhỏ hơn ngày vào làm", "Thông báo", 1);
                    txtNgayVL.setText("");
                    txtNgayVL.requestFocus();
                    return;
                }
            } catch (Exception e) {
            }
            if (JOptionPane.showConfirmDialog(null, "Bạn muốn sửa thông tin nhân viên này?", "Thông báo", JOptionPane.YES_NO_OPTION, 1) == JOptionPane.YES_OPTION) {

                String gioiTinh = "Nữ";
                if (rdNam.isSelected()) {
                    gioiTinh = "Nam";
                }
                int i = nhanVienDAO.suaNV(txtMaNV.getText().trim(), txtHoTen.getText().trim(), gioiTinh, txtDiaChi.getText().trim(), txtNgaySinh.getText().trim(), txtNgayVL.getText().trim(), txtDienThoai.getText().trim(), Float.parseFloat(txtLuong.getText().trim()));
                if (i != -1) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", 1);
                    xoaTrang();
                    loadData();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Mời bạn chọn nhân viên để sửa!!!", "Thông báo", 1);
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        new quanly(tentk).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (hoTro.ktraRong(txtMaNV) || hoTro.ktraRong(txtHoTen) || hoTro.ktraRong(txtPW) || hoTro.ktraRong(txtDiaChi) || hoTro.ktraRong(txtLuong)) {
            return;
        }
        if (!hoTro.ktraNgay(txtNgaySinh) || !hoTro.ktraSDT(txtDienThoai) || !hoTro.ktraNgay(txtNgayVL)) {
            return;
        }
        if (!txtPW.getText().equals(txtPrePw.getText())) {
            JOptionPane.showMessageDialog(null, "Password không trùng nhau", "Thông báo", 1);
            txtPrePw.setText("");
            txtPrePw.requestFocus();
            return;
        }
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date ngaySinh = df.parse(txtNgaySinh.getText().trim());
            Date ngayVL = df.parse(txtNgayVL.getText().trim());
            if (ngaySinh.compareTo(ngayVL) >= 0) {
                JOptionPane.showMessageDialog(null, "Ngày sinh phải nhỏ hơn ngày vào làm", "Thông báo", 1);
                txtNgayVL.setText("");
                txtNgayVL.requestFocus();
                return;
            }
        } catch (Exception e) {
        }

        if (JOptionPane.showConfirmDialog(null, "Bạn muốn thêm nhân viên " + txtHoTen.getText().trim() + "?", "Thông báo", JOptionPane.YES_NO_OPTION, 1) == JOptionPane.YES_OPTION) {
            String gioiTinh = "Nữ";
            if (rdNam.isSelected()) {
                gioiTinh = "Nam";
            }
            int i = nhanVienDAO.themNV(txtMaNV.getText().trim(), hoTro.md5(txtPW.getText().trim()), txtHoTen.getText().trim(), gioiTinh, txtDiaChi.getText().trim(), txtNgaySinh.getText().trim(), txtNgayVL.getText().trim(), txtDienThoai.getText().trim(), Float.parseFloat(txtLuong.getText().trim()));
            if (i != -1) {
                JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", 1);
                xoaTrang();
                loadData();
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void txtLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtLuongKeyTyped

    private void txtPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPWActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            if (JOptionPane.showConfirmDialog(null, "Bạn muốn reset password cho nhân viên " + txtHoTen.getText().trim() + "?", "Thông báo", JOptionPane.YES_NO_OPTION, 1) == JOptionPane.YES_OPTION) {
                int i = nhanVienDAO.resetPW(modelTable.getValueAt(row, 0).toString(), hoTro.md5("12345"));
                if (i != -1) {
                    JOptionPane.showMessageDialog(null, "Reset password thành công", "Thông báo", 1);
                    xoaTrang();
                    loadData();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Mời bạn chọn nhân viên để reset password", "Thông báo", 1);
        }

    }//GEN-LAST:event_btnResetActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        hoTro.offEdittingTable(jTable1);

    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        hoTro.offEdittingTable(jTable1);

    }//GEN-LAST:event_jTable1KeyReleased

  
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNgayVL;
    private javax.swing.JPasswordField txtPW;
    private javax.swing.JPasswordField txtPrePw;
    // End of variables declaration//GEN-END:variables
}
