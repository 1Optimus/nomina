package nominav3;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 * @author ricardo perez 1255
 * es el login del programa, con base de datos
 */
public class login extends javax.swing.JFrame {

      public login() {
        initComponents();
        //hacemos invisible el mensaje de error
        lblError.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(763, 439));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresar.setBackground(new java.awt.Color(255, 148, 42));
        btnIngresar.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(190, 243, 85));
        btnIngresar.setText("Ingresar");
        btnIngresar.setMinimumSize(new java.awt.Dimension(763, 439));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("CONTRASEÑA");
        jLabel1.setMinimumSize(new java.awt.Dimension(763, 439));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("USUARIO");
        jLabel2.setMinimumSize(new java.awt.Dimension(763, 439));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        txtUsuario.setMinimumSize(new java.awt.Dimension(763, 439));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 210, -1));

        txtContra.setMinimumSize(new java.awt.Dimension(763, 439));
        getContentPane().add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 210, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("LOGIN");
        jLabel3.setMinimumSize(new java.awt.Dimension(763, 439));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        lblError.setBackground(new java.awt.Color(255, 0, 0));
        lblError.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setText("Usuario/Contraseña estan incorrectos");
        lblError.setMinimumSize(new java.awt.Dimension(763, 439));
        getContentPane().add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        //Codigo que permite consultar registros en la base de datos
        String stEstado="", stContra="";
        try{
            //conexion de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM `usuario` where us_nombre ='"+txtUsuario.getText().trim()+"'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                //lecturade datos
                stEstado=(rs.getString("us_estadousuario"));
                stContra=(rs.getString("us_clave"));
            }
            if((stContra.equals(txtContra.getText())&&(stEstado.equals("2")))){
                    menu pantalla=new menu();
                    pantalla.setVisible(true);
                    dispose();
            }else{
                //se muestra el error
                lblError.setVisible(true);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Base de datos no enlazada");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblError;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
