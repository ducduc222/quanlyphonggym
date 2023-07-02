/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package quanlyphonggym.UI.AdminUI.QuanLyPhongTapUI;

import quanlyphonggym.Bean.PhanHoiBean;
import quanlyphonggym.Controllers.AdminCtrl.QuanLyHoiVienCtrl.PhanHoiCtrl;
import quanlyphonggym.Models.PhanHoiCuaAdmin;

import javax.swing.*;
import java.sql.SQLException;

/**
 *
 * @author nguyenduc
 */
public class PhanHoiPhongTapJframe extends javax.swing.JFrame {
    private int idPhanHoi;
    private static PhanHoiBean phanHoiBean;

    /** Creates new form PhanHoiPhongTapJframe */

    public PhanHoiPhongTapJframe(int idPhanHoi) throws SQLException, ClassNotFoundException {
        this.idPhanHoi = idPhanHoi;
        initComponents();
        setLocationRelativeTo(null);
        loadData();
    }
    private void loadData() throws SQLException, ClassNotFoundException {

        PhanHoiCtrl phanHoiCtrl = new PhanHoiCtrl();
        phanHoiBean = phanHoiCtrl.getPhanHoiHoiVienById(idPhanHoi);

        jLabelIDNhanVien.setText(String.valueOf(phanHoiBean.getPhanHoiCuaHoiVien().getId()));
        jTextAreaYKien.setText(phanHoiBean.getPhanHoiCuaHoiVien().getNoiDung());
        jTextAreaYKien.setEditable(false);
        if (phanHoiBean.getPhanHoiCuaHoiVien().getIsDaPhanHoiLai())
        jTextAreaPhanHoi.setText(phanHoiBean.getPhanHoiCuaAdmin().getNoiDung());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaYKien = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabelIDNhanVien = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaPhanHoi = new javax.swing.JTextArea();
        jButtonGui = new javax.swing.JButton();
        jButtonHuy = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextAreaYKien.setColumns(20);
        jTextAreaYKien.setRows(5);
        jScrollPane1.setViewportView(jTextAreaYKien);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel1.setText("Ý kiến phản hồi về nhân viên có ID: ");

        jLabelIDNhanVien.setFont(new java.awt.Font("Liberation Sans", 1, 17)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 3, 16)); // NOI18N
        jLabel2.setText("=> Trả lời:");

        jTextAreaPhanHoi.setColumns(20);
        jTextAreaPhanHoi.setRows(5);
        jScrollPane2.setViewportView(jTextAreaPhanHoi);

        jButtonGui.setBackground(new java.awt.Color(255, 255, 102));
        jButtonGui.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jButtonGui.setText("Gửi");
        jButtonGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonGuiActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jButtonHuy.setBackground(new java.awt.Color(255, 255, 204));
        jButtonHuy.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jButtonHuy.setText("Hủy");
        jButtonHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelIDNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGui, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIDNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGui, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuiActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ClassNotFoundException {//GEN-FIRST:event_jButtonGuiActionPerformed
        // TODO add your handling code here:
        if (jTextAreaPhanHoi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập câu trả lời");
            return;
        }
        PhanHoiCuaAdmin phanHoiCuaAdmin = new PhanHoiCuaAdmin();
        phanHoiCuaAdmin.setNoiDung(jTextAreaPhanHoi.getText());
        phanHoiBean.setPhanHoiCuaAdmin(phanHoiCuaAdmin);
        PhanHoiCtrl phanHoiCtrl = new PhanHoiCtrl();
        if (phanHoiCtrl.traLoiPhanHoi(phanHoiBean)) {
            JOptionPane.showMessageDialog(null, "Đã trả lời");
            ThongTinChiTietPhongTapJframe.loadData();
            dispose();
        }
    }//GEN-LAST:event_jButtonGuiActionPerformed

    private void jButtonHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHuyActionPerformed
        // TODO add your handling code here:
        int confirmResult = JOptionPane.showConfirmDialog(null, "Xác nhận Thoát?", "Thoát", JOptionPane.YES_NO_OPTION);
        if (confirmResult == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButtonHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGui;
    private javax.swing.JButton jButtonHuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelIDNhanVien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaPhanHoi;
    private javax.swing.JTextArea jTextAreaYKien;
    // End of variables declaration//GEN-END:variables

}
