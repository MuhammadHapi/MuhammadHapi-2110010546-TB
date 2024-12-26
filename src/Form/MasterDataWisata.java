package Form;

import Config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MasterDataWisata extends javax.swing.JFrame {
    
    private Connection conn;
    
    public MasterDataWisata() {
        initComponents();
        conn = Koneksi.getConnection();
        getData();
        nonAktifButton();
        aktifButton();
    }

    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tabelWisata.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM objek_wisata";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String lokasi = rs.getString("lokasi");
                int harga_tiket = rs.getInt("harga_tiket");
                
                Object[] rowData = {id,nama,lokasi,harga_tiket};
                model.addRow(rowData);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelWisata = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tambahWisata = new javax.swing.JButton();
        editWisata = new javax.swing.JButton();
        hapusWisata = new javax.swing.JButton();
        namaWisata = new javax.swing.JTextField();
        lokasiWisata = new javax.swing.JTextField();
        hargaTiket = new javax.swing.JTextField();
        menuUtama = new javax.swing.JButton();
        batalWisata = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MASTER DATA WISATA");

        tabelWisata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama Wisata", "Lokasi", "Harga Tiket"
            }
        ));
        tabelWisata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelWisataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelWisata);

        jLabel1.setText("MASTER DATA WISATA");

        jLabel2.setText("Nama");

        jLabel3.setText("Lokasi");

        jLabel4.setText("Harga Tiket");

        tambahWisata.setText("Tambah");
        tambahWisata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahWisataActionPerformed(evt);
            }
        });

        editWisata.setText("Edit");
        editWisata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editWisataActionPerformed(evt);
            }
        });

        hapusWisata.setText("Hapus");
        hapusWisata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusWisataActionPerformed(evt);
            }
        });

        menuUtama.setText("Menu Utama");
        menuUtama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUtamaActionPerformed(evt);
            }
        });

        batalWisata.setText("Batal");
        batalWisata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalWisataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(tambahWisata)))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editWisata)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hapusWisata)
                                .addGap(68, 68, 68)
                                .addComponent(batalWisata)
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(namaWisata)
                                    .addComponent(lokasiWisata)
                                    .addComponent(hargaTiket, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(menuUtama)
                        .addGap(227, 227, 227))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(210, 210, 210))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaWisata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lokasiWisata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(hargaTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahWisata)
                    .addComponent(editWisata)
                    .addComponent(hapusWisata)
                    .addComponent(batalWisata))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(menuUtama)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tambahWisataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahWisataActionPerformed
      String nama = namaWisata.getText();
      String lokasi = lokasiWisata.getText();
      String harga_tiket = hargaTiket.getText();
      
      if(nama.isEmpty() || lokasi.isEmpty() || harga_tiket.isEmpty()){
          JOptionPane.showMessageDialog(this,"Semua Kolom harus di isi !","Validasi", JOptionPane.ERROR_MESSAGE);
          return;
      }
      try {
          String sql = "INSERT INTO objek_wisata (nama,lokasi,harga_tiket) VALUES (?,?,?)";
          PreparedStatement st = conn.prepareStatement(sql);
          st.setString(1,nama);
          st.setString(2,lokasi);
          st.setString(3,harga_tiket);
          
          int rowInserted = st.executeUpdate();
          if(rowInserted > 0) {
              JOptionPane.showMessageDialog(this,"Data berhasil ditambah");
              resetForm();
              getData();
          }
          st.close();
      } catch (Exception e) {
          JOptionPane.showMessageDialog(this,"Cek kembali data ada yg tidak benar !");
      }
    }//GEN-LAST:event_tambahWisataActionPerformed

    private void menuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUtamaActionPerformed
        Index menuutama = new Index();
        menuutama.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuUtamaActionPerformed

    private void tabelWisataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelWisataMouseClicked
       int selectedRow = tabelWisata.getSelectedRow();
       if(selectedRow != -1) { 
       
       String nama = tabelWisata.getValueAt(selectedRow,1).toString();
       String lokasi = tabelWisata.getValueAt(selectedRow,2).toString();
       String harga_tiket = tabelWisata.getValueAt(selectedRow,3).toString();
       
       namaWisata.setText(nama);
       lokasiWisata.setText(lokasi);
       hargaTiket.setText(harga_tiket);
       }
       tambahWisata.setEnabled(false);
       editWisata.setEnabled(true);
       hapusWisata.setEnabled(true);
    }//GEN-LAST:event_tabelWisataMouseClicked

    private void editWisataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editWisataActionPerformed
       int selectedRow = tabelWisata.getSelectedRow();
       if(selectedRow == -1) {
           JOptionPane.showMessageDialog(this,"pilih kolom yang akan di edit");
           return;
       }
       
       String id = tabelWisata.getValueAt(selectedRow,0).toString();
       String nama = namaWisata.getText();
       String lokasi = lokasiWisata.getText();
       String harga_tiket = hargaTiket.getText();
       
       if(nama.isEmpty() || lokasi.isEmpty() || harga_tiket.isEmpty()){
          JOptionPane.showMessageDialog(this,"Semua Kolom harus di isi !","Validasi", JOptionPane.ERROR_MESSAGE);
          return;
       }
        try {
          String sql = "UPDATE objek_wisata SET nama=?,lokasi=?,harga_tiket=? WHERE id=?";
          PreparedStatement st = conn.prepareStatement(sql);
          st.setString(1,nama);
          st.setString(2,lokasi);
          st.setString(3,harga_tiket);
          st.setString(4,id);
          
          int rowUpdate = st.executeUpdate();
          if(rowUpdate > 0) {
              JOptionPane.showMessageDialog(this,"Data berhasil di ubah");
              resetForm();
              getData();
          }
          st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Cek kembali data ada yg tidak benar !");
        }
    }//GEN-LAST:event_editWisataActionPerformed

    private void hapusWisataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusWisataActionPerformed
       int selectedRow = tabelWisata.getSelectedRow();
       if(selectedRow == -1) {
           JOptionPane.showMessageDialog(this,"pilih kolom yang akan di hapus");
           return;
       }
       
       int confirm = JOptionPane.showConfirmDialog(this,"Apakah anda yakin ingin menghapus data ini?","KONFIRMASI",JOptionPane.YES_NO_OPTION);
       if(confirm == JOptionPane.YES_OPTION){
           String id = tabelWisata.getValueAt(selectedRow, 0).toString();
           
           try {
               String sql = "DELETE FROM objek_wisata WHERE id=?";
               PreparedStatement st = conn.prepareStatement(sql);
               st.setString(1, id);
               
               int rowDelete = st.executeUpdate();
               if(rowDelete > 0){
                   JOptionPane.showMessageDialog(this,"Data Berhasil di Hapus");
               }
               st.close();
           } catch (Exception e) {
           }
       }
       resetForm();
       getData();
       nonAktifButton();
       aktifButton();
       
    }//GEN-LAST:event_hapusWisataActionPerformed

    private void batalWisataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalWisataActionPerformed
        resetForm();
        nonAktifButton();
        aktifButton();
    }//GEN-LAST:event_batalWisataActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MasterDataWisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterDataWisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterDataWisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterDataWisata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterDataWisata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalWisata;
    private javax.swing.JButton editWisata;
    private javax.swing.JButton hapusWisata;
    private javax.swing.JTextField hargaTiket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lokasiWisata;
    private javax.swing.JButton menuUtama;
    private javax.swing.JTextField namaWisata;
    private javax.swing.JTable tabelWisata;
    private javax.swing.JButton tambahWisata;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        namaWisata.setText("");
        lokasiWisata.setText("");
        hargaTiket.setText("");
    }

    private void nonAktifButton() {
        editWisata.setEnabled(false);
        hapusWisata.setEnabled(false);
    }

    private void aktifButton() {
        tambahWisata.setEnabled(true);
        batalWisata.setEnabled(true);
    }


}
