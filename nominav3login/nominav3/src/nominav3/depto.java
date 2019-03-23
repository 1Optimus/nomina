package nominav3;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo perez
 */
public class depto extends javax.swing.JFrame {
int j1,j;
    String stmtPrincipal[][]=new String[15][2];
    public depto() {
        initComponents();
        //enlaze de mos radiobuttons
        grupo.add(rbtel);
        grupo.add(rbtvi);grupo.add(rbtin);
        //llamda de metodos necesarios
        nomostrar();
        llenardatos();
    }
public void nomostrar(){
    //se ocultan todos los objetos
cmbNom.setVisible(false);
cmbCod.setVisible(false);
txtnom.setVisible(false);
l1.setVisible(false);
btnin.setVisible(false);
btnvi.setVisible(false);
btnel.setVisible(false);
jScrollPane1.setVisible(false);
}
 public void codigoauto(){
        //codigo para saber cuantas lineas hay en la base de datos y asi poder llenar el codigo sin ingresar
        j1=0;
           try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            Statement s=con.createStatement();
           String SQL="select count(*) from departamentos";
           ResultSet rs=s.executeQuery(SQL);
           String jo="";
              if (rs.next()) {
                  jo=rs.getString(1);
                   j=Integer.parseInt(jo);
                   if (j==0) {
                      j1=1;
                  }else{
                  j1=j+1;
              }

              }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Conexión erronea"+e);
        }
    }
 public void llenardatos(){
   //Codigo que permite ingresar datos a los listas
      this.cmbCod.removeAllItems();
      this.cmbNom.removeAllItems();
        try{
            //conexion de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM departamentos");
            ResultSet rs = pst.executeQuery();
            boolean r=rs.next();
            while(r){
                this.cmbNom.addItem(rs.getString("dep_nombre"));
                this.cmbCod.addItem(rs.getString("dep_codigo"));
                r=rs.next();            
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Base de datos no enlazada");
        }
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        rbtin = new javax.swing.JRadioButton();
        rbtel = new javax.swing.JRadioButton();
        rbtvi = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btnin = new javax.swing.JButton();
        txtnom = new javax.swing.JTextField();
        l1 = new javax.swing.JLabel();
        cmbCod = new javax.swing.JComboBox<>();
        cmbNom = new javax.swing.JComboBox<>();
        btnel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnvi = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1109, 573));
        setPreferredSize(new java.awt.Dimension(1109, 573));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbtin.setText("Ingresar");
        rbtin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtinMouseClicked(evt);
            }
        });
        getContentPane().add(rbtin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        rbtel.setText("Eliminar");
        rbtel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtelMouseClicked(evt);
            }
        });
        getContentPane().add(rbtel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        rbtvi.setText("Visualizar");
        rbtvi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtviMouseClicked(evt);
            }
        });
        getContentPane().add(rbtvi, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, -1, -1));

        jLabel1.setText("Departamentos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        btnin.setText("Ingresar");
        btnin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninActionPerformed(evt);
            }
        });
        getContentPane().add(btnin, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 170, -1));
        getContentPane().add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 170, -1));

        l1.setText("Nombre");
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, -1, -1));

        cmbCod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 370, -1, -1));

        cmbNom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNomItemStateChanged(evt);
            }
        });
        cmbNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNomActionPerformed(evt);
            }
        });
        getContentPane().add(cmbNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 170, -1));

        btnel.setText("Eliminar");
        btnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelActionPerformed(evt);
            }
        });
        getContentPane().add(btnel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 170, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "codigo", "nombre"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 640, 140));

        btnvi.setText("Visualizar");
        btnvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviActionPerformed(evt);
            }
        });
        getContentPane().add(btnvi, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, 170, -1));

        btnregresar.setBackground(new java.awt.Color(255, 148, 42));
        btnregresar.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btnregresar.setForeground(new java.awt.Color(190, 243, 85));
        btnregresar.setText("Regresar");
        btnregresar.setMinimumSize(new java.awt.Dimension(763, 439));
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 490, 290, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtinMouseClicked
   //se ocultan todos y solo se muestran los que se quieren
        nomostrar();
        txtnom.setVisible(true);
    l1.setVisible(true);
    btnin.setVisible(true);              
    }//GEN-LAST:event_rbtinMouseClicked

    private void rbtelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtelMouseClicked
   //se ocultan todos y solo se muestran los que se quieren
        nomostrar();
   llenardatos();
   cmbNom.setVisible(true);
   btnel.setVisible(true);
   l1.setVisible(true);
         
    }//GEN-LAST:event_rbtelMouseClicked

    private void btninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninActionPerformed
        //codigos para guardar el nuevo dato en la tabla departamentos
        codigoauto();
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `departamentos` (`dep_codigo`, `dep_nombre`) VALUES ('"+j1+"', '"+txtnom.getText().trim()+"');");
            pst.executeUpdate();
                        txtnom.setText("");
            JOptionPane.showMessageDialog(null,"Dato guardado con exito");
        }catch (Exception e){
          JOptionPane.showMessageDialog(null,"le dio un error "+e);
        }
    }//GEN-LAST:event_btninActionPerformed

    private void btnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelActionPerformed
        //codigos para elimiar el dato en la tabla departamentos
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("DELETE FROM `departamentos` WHERE dep_codigo='"+cmbCod.getSelectedItem()+"'");
            pst.executeUpdate();
            cmbNom.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null,"Dato eliminado con exito");
        }catch (Exception e){
          JOptionPane.showMessageDialog(null,"le dio un error "+e);
        }
    }//GEN-LAST:event_btnelActionPerformed

    private void cmbNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNomActionPerformed

    private void cmbNomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNomItemStateChanged
         try{ cmbCod.setSelectedIndex(cmbNom.getSelectedIndex());}// se cambia el indice del combo
        catch(Exception e){
        }
    }//GEN-LAST:event_cmbNomItemStateChanged

    private void rbtviMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtviMouseClicked
        nomostrar();
        jScrollPane1.setVisible(true);
        btnvi.setVisible(true);
         for(int i=0;i<=14;i++){
            for(int y=0;y<=1;y++){
                stmtPrincipal[i][y]="";
            }
        }
          //codigo para mostrarlo en la matriz
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            stmtPrincipal,
            new String [] {
                "Codigo", "Nombre"
            }
        ));
    }//GEN-LAST:event_rbtviMouseClicked

    private void btnviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviActionPerformed
                //Codigo que permite consultar registros en la base de datos
        int x=0,itEstado;//variable para la matriz               
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM `departamentos`;");         
              ResultSet rs = pst.executeQuery();            
             boolean r=rs.next();
                while(r){
                   stmtPrincipal[x][0]=rs.getString("dep_codigo");
                   stmtPrincipal[x][1]=rs.getString("dep_nombre");                         
                    r=rs.next();  
                    x++;
                }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un Error fatal");
        }
        //codigo para mostrarlo en la matriz
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            stmtPrincipal,
            new String [] {
                "Codigo", "Nombre"
            }
        ));
        //limpiar la matriz
        for(int i=0;i<=14;i++){
        for(int y=0;y<=1;y++){
           stmtPrincipal[i][y]=""; 
        }
        }
    }//GEN-LAST:event_btnviActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        //regresa a otro modulo
        menu pantalla=new menu();
        pantalla.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnregresarActionPerformed

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
            java.util.logging.Logger.getLogger(depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new depto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnel;
    private javax.swing.JButton btnin;
    private javax.swing.JButton btnregresar;
    private javax.swing.JButton btnvi;
    private javax.swing.JComboBox<String> cmbCod;
    private javax.swing.JComboBox<String> cmbNom;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l1;
    private javax.swing.JRadioButton rbtel;
    private javax.swing.JRadioButton rbtin;
    private javax.swing.JRadioButton rbtvi;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtnom;
    // End of variables declaration//GEN-END:variables
}
