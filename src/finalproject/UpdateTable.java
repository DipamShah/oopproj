/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paresh shah
 */
public class UpdateTable extends javax.swing.JFrame {

    /**
     * Creates new form UpdateTable
     * @throws java.sql.SQLException
     */
    String tablename;
    public UpdateTable(String tablename) throws SQLException
    {
        this.tablename=tablename;
     initComponents();
        int i = 0;
        int j = 0;
        //String a = new String[];
        Connection con = DbConnect.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM "+this.tablename+"");
        ResultSetMetaData md = resultSet.getMetaData();
        int columns = md.getColumnCount();
        String a[] = new String[columns];
        for(i=1;i<=columns;i++)
        {
            a[j]=md.getColumnName(i);
            j++;
        }
        
        DefaultTableModel model = new DefaultTableModel(a,0);
        if(columns ==4)
        {
            while(resultSet.next())
            {
                System.out.println("COnnected to database");
                String d= resultSet.getString(""+a[0]+"");
                System.out.println(d);
                String e = resultSet.getString(""+a[1]+"");
                System.out.println(e);
                String f1 = resultSet.getString(""+a[2]+"");
                String f = resultSet.getString(""+a[3]+"");
                model.addRow(new Object[]{d,e,f1,f});
            }
        }
        else
        {
            while(resultSet.next())
            {
                System.out.println("COnnected to database");
                String d= resultSet.getString(""+a[0]+"");
                System.out.println(d);
                String e = resultSet.getString(""+a[1]+"");
                System.out.println(e);
                String f1 = resultSet.getString(""+a[2]+"");
                model.addRow(new Object[]{d,e,f1});
            }
            }
        
        //obj.jTable1.repaint();
        jTable1.setModel(model);
        jTable1.repaint();   
    }
    public UpdateTable() throws SQLException {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        ADD = new javax.swing.JButton();
        REMOVE = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setMaximumSize(new java.awt.Dimension(1560, 1080));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.setPreferredSize(new java.awt.Dimension(1440, 1080));
        jPanel1.setLayout(null);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1230, 10, 55, 23);

        jScrollPane1.setBackground(new java.awt.Color(255, 153, 153));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1995-1996",  new Integer(54000)},
                {"1996-1997",  new Integer(102250)},
                {null, null}
            },
            new String [] {
                "year", "Total expenditure"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(780, 40, 540, 250);

        jPanel2.setBackground(new Color(0,0,0,200));

        ADD.setBackground(new java.awt.Color(255, 255, 255));
        ADD.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        ADD.setText("ADD");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        REMOVE.setBackground(new java.awt.Color(255, 255, 255));
        REMOVE.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        REMOVE.setText("REMOVE");
        REMOVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REMOVEActionPerformed(evt);
            }
        });

        UPDATE.setBackground(new java.awt.Color(255, 255, 255));
        UPDATE.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        UPDATE.setForeground(new java.awt.Color(51, 51, 51));
        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(REMOVE, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(ADD)
                .addGap(18, 18, 18)
                .addComponent(REMOVE)
                .addGap(18, 18, 18)
                .addComponent(UPDATE)
                .addContainerGap(265, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 502, 524);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1MouseClicked

   
    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        // TODO add your handling code here:
       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
       model.addRow(new Object[]{});
       jTable1.repaint();
      
    }//GEN-LAST:event_ADDActionPerformed

    private void REMOVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REMOVEActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int x=jTable1.getSelectedRow();
        model.removeRow(x);
        jTable1.repaint();
    }//GEN-LAST:event_REMOVEActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        // TODO add your handling code here:
        try {                                       
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            try {
                Connection conn = DbConnect.getConnection();
                Statement st  = conn.createStatement();
                st.execute("DELETE FROM "+this.tablename+"");
                System.out.println("CONNECTED");
            } catch (SQLException ex) {
                Logger.getLogger(UpdateTable.class.getName()).log(Level.SEVERE, null, ex);
            }
            int rows=model.getRowCount();
            int columns = model.getColumnCount();
            System.out.println(rows+" "+columns);
            int b =columns;
            Connection conn = DbConnect.getConnection();
            Statement st  = conn.createStatement();
            PreparedStatement pst;
            if(columns == 4)
            {
                for(int i =0;i<rows;i++)
                {
                    String queryco = "Insert into "+this.tablename+" values ('"+jTable1.getValueAt(i,0)+"','"+jTable1.getValueAt(i,1)+"','"+jTable1.getValueAt(i,2)+"','"+jTable1.getValueAt(i,3)+"')";
                    System.out.println(jTable1.getValueAt(i,3));
                    pst = conn.prepareStatement(queryco);
                    pst.execute();
                }
            }
            else
            {
                for(int i =0;i<rows;i++)
                {
                    String queryco = "Insert into "+this.tablename+" values ('"+jTable1.getValueAt(i,0)+"','"+jTable1.getValueAt(i,1)+"','"+jTable1.getValueAt(i,2)+"')";
                    pst = conn.prepareStatement(queryco);
                    pst.execute();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_UPDATEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Welcome().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UpdateTable().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton REMOVE;
    private javax.swing.JButton UPDATE;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
