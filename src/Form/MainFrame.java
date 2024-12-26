package Form;

import Config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

    private Connection conn;
     
    public MainFrame() {
        initComponents();
        conn = Koneksi.getConnection();
        populateComboBox();
        getData();
    }

private void populateComboBox() {
        try {
            String sql = "SELECT * FROM objek_wisata";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            // Mengosongkan ComboBox sebelumnya
            namaWisata.removeAllItems();
            
            // Menambah item ComboBox dengan nama objek wisata
            while (rs.next()) {
                String nama = rs.getString("nama");
                namaWisata.addItem(nama);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

private void getHargaTiket() {
        try {
            String selectedWisata = (String) namaWisata.getSelectedItem();
            String sql = "SELECT harga_tiket FROM objek_wisata WHERE nama = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, selectedWisata);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                int hargaTiket = rs.getInt("harga_tiket");
                totalHarga.setText(String.valueOf(hargaTiket));
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

private void getData() {
        DefaultTableModel model = (DefaultTableModel) tabelTiket.getModel();
        model.setRowCount(0); // Menghapus data lama

        try {
            String sql = "SELECT * FROM transaksi";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String id_objek_wisata = rs.getString("id_objek_wisata");
                int jumlah_tiket = rs.getInt("jumlah_tiket");
                int total_harga = rs.getInt("total_harga");

                Object[] rowData = {id, id_objek_wisata, jumlah_tiket,total_harga}; 
                model.addRow(rowData);
            }

            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namaWisata = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelTiket = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jumlahTiket = new javax.swing.JTextField();
        totalHarga = new javax.swing.JTextField();
        ProsesTiket = new javax.swing.JButton();
        BatalTiket = new javax.swing.JButton();
        MenuUtama = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Runalto", 1, 18)); // NOI18N
        jLabel1.setText("Tahura Sultan Adam");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText("Objek Wisata");

        jLabel3.setText("Wisata");

        namaWisata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        namaWisata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaWisataActionPerformed(evt);
            }
        });

        tabelTiket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Tiket", "Id Wisata", "Jumlah Tiket", "Total Harga"
            }
        ));
        tabelTiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTiketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelTiket);

        jLabel5.setText("Jumlah Tiket");

        jLabel6.setText("Harga Tiket");

        ProsesTiket.setText("PROSES");
        ProsesTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProsesTiketActionPerformed(evt);
            }
        });

        BatalTiket.setText("BATAL");
        BatalTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatalTiketActionPerformed(evt);
            }
        });

        MenuUtama.setText("Menu Utama");
        MenuUtama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUtamaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jumlahTiket)
                                    .addComponent(totalHarga)
                                    .addComponent(namaWisata, 0, 340, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(180, 180, 180)
                                    .addComponent(MenuUtama)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BatalTiket)
                        .addGap(131, 131, 131)
                        .addComponent(ProsesTiket)
                        .addGap(83, 83, 83)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namaWisata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jumlahTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BatalTiket)
                    .addComponent(ProsesTiket))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(MenuUtama))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ProsesTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProsesTiketActionPerformed
         try {
        // Mendapatkan nama objek wisata yang dipilih
        String selectedWisata = (String) namaWisata.getSelectedItem();
        int jumlah = Integer.parseInt(jumlahTiket.getText());  // Mengambil jumlah tiket
        int hargaTiket = Integer.parseInt(totalHarga.getText());  // Mengambil harga tiket yang ditampilkan
        int total = jumlah * hargaTiket;  // Menghitung total harga berdasarkan jumlah tiket dan harga tiket

        // Menyimpan transaksi ke dalam tabel transaksi
        String sql = "INSERT INTO transaksi (id_objek_wisata, jumlah_tiket, total_harga) VALUES (?, ?, ?)";
        PreparedStatement st = conn.prepareStatement(sql);

        // Mendapatkan ID objek wisata berdasarkan nama yang dipilih
        String sqlID = "SELECT id FROM objek_wisata WHERE nama = ?";
        PreparedStatement stID = conn.prepareStatement(sqlID);
        stID.setString(1, selectedWisata);
        ResultSet rsID = stID.executeQuery();
        int idObjekWisata = -1;
        if (rsID.next()) {
            idObjekWisata = rsID.getInt("id");
        }

        // Menyimpan data transaksi
        st.setInt(1, idObjekWisata);
        st.setInt(2, jumlah);
        st.setInt(3, total);
        st.executeUpdate();

        // Menampilkan pesan sukses
        JOptionPane.showMessageDialog(this, "Transaksi berhasil diproses!");

        // Memperbarui tabel untuk menampilkan transaksi yang baru
        getData();

        // Reset form setelah transaksi
        resetForm();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_ProsesTiketActionPerformed

    private void MenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUtamaActionPerformed
         Index menuutama = new Index();
        menuutama.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuUtamaActionPerformed

    private void BatalTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatalTiketActionPerformed
        resetForm();
    }//GEN-LAST:event_BatalTiketActionPerformed

    private void tabelTiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTiketMouseClicked
             
    }//GEN-LAST:event_tabelTiketMouseClicked

    private void namaWisataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaWisataActionPerformed
        getHargaTiket();
    }//GEN-LAST:event_namaWisataActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BatalTiket;
    private javax.swing.JButton MenuUtama;
    private javax.swing.JButton ProsesTiket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahTiket;
    private javax.swing.JComboBox<String> namaWisata;
    private javax.swing.JTable tabelTiket;
    private javax.swing.JTextField totalHarga;
    // End of variables declaration//GEN-END:variables
 private void resetForm() {
        namaWisata.setSelectedIndex(0);
        jumlahTiket.setText("");
        totalHarga.setText("");
    }
}

