import Animacion.Animacion;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 * @author ricardo perez 1255
 */
public class menu extends javax.swing.JFrame {
    int itOpcion=0;//variable global para ver diferentes proyectos
     String stNomi[][]=new String[7][4];
    public menu() {
        initComponents();
        this.setResizable(false);
         desaparecer();       
        stNomi[1][1]="https://github.com/1Optimus/nomina/tree/master/src/nomina2";stNomi[1][2]="https://www.youtube.com/watch?v=5oA2E-FWAIw";stNomi[1][3]="ewe";
       stNomi[2][1]="https://github.com/1Optimus/nomina/tree/master/nominav3login";stNomi[2][2]="https://www.youtube.com/watch?v=s_IHOKj0R6A"; stNomi[2][3]="";
        stNomi[3][1]="https://github.com/1Optimus/nomina/tree/master/EstructuraLibros2/EstructuraLibros";stNomi[3][2]="https://www.youtube.com/watch?v=cwjSfC7p9lc&t=11s";stNomi[3][3]="";
       stNomi[4][1]="https://github.com/1Optimus/nomina/tree/master/Pilas";stNomi[4][2]="https://www.youtube.com/watch?v=SJBPyGH_ark";stNomi[4][3]="";
       stNomi[5][1]="https://github.com/1Optimus/nomina/tree/master/Colas";stNomi[5][2]="https://www.youtube.com/watch?v=eqcnbVLAHBQ";stNomi[5][3]="";
       stNomi[6][1]="https://github.com/1Optimus/nomina/tree/master/Torreshanoi";stNomi[6][2]="https://www.youtube.com/watch?v=3bTOUSrndnk&t=74s";stNomi[6][3]="";
       stNomi[7][1]="https://github.com/1Optimus/nomina/tree/master/ArbolBusqueda/ArbolBusqueda";stNomi[7][2]="https://youtu.be/Ng4EWNnQMkc";stNomi[7][3]="";
    }
    public void desaparecer(){
    lblgit.setVisible(false);
    lblyout.setVisible(false);
    lblcod.setVisible(false);
    btncod.setVisible(false);  
    btnyout.setVisible(false);
    lbltit.setVisible(false);
    btngit.setVisible(false);
    }
        public void aparecer(){
    lblgit.setVisible(true);
    lblyout.setVisible(true);
    lblcod.setVisible(true);
    lbltit.setVisible(true);
    btncod.setVisible(true);  
    btnyout.setVisible(true);
    btngit.setVisible(true);
    }
    
    public void bajarsubir(){
            int posicion = lb.getY();
if(posicion > 0){ //está abajo, ya bajó el menú, ahora hay que subirlo
    Animacion.subir(0,-410,2, 1, jp);    
     Animacion.subir(110,0,6, 1, lb);
      img_down();
}else{ // está arriba, no ha bajado el menú
     Animacion.bajar(-110, 0,6, 1, jp);        
     Animacion.bajar(0, 225,1, 1, lb);      
     img_up();
     desaparecer();
    
}
    }
    public void img_up(){
        ImageIcon img = new ImageIcon(getClass().getResource("subir.png"));
        lb.setIcon(img);
}
public void img_down(){
        ImageIcon img = new ImageIcon(getClass().getResource("bajar.png"));
        lb.setIcon(img);
}
public void abrirlinks(int x, int y){
        if(java.awt.Desktop.isDesktopSupported()){           
            java.awt.Desktop desk= java.awt.Desktop.getDesktop();
            if(desk.isSupported(java.awt.Desktop.Action.BROWSE)){                
                try {                    
                    java.net.URI url= new java.net.URI(String.valueOf(stNomi[x][y]));
                    desk.browse(url);
                } catch (URISyntaxException | IOException ev) {
                    JOptionPane.showMessageDialog(null,"no se logro ir debido a: "+ev);
                }
            } 
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpp = new javax.swing.JPanel();
        jp = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnnomina = new javax.swing.JButton();
        btnpilas = new javax.swing.JButton();
        btncolas = new javax.swing.JButton();
        btnlistas = new javax.swing.JButton();
        btnnominabd = new javax.swing.JButton();
        btnarboles = new javax.swing.JButton();
        btntorres = new javax.swing.JButton();
        lb = new javax.swing.JLabel();
        lblyout = new javax.swing.JLabel();
        lblgit = new javax.swing.JLabel();
        lblcod = new javax.swing.JLabel();
        btncod = new javax.swing.JButton();
        btnyout = new javax.swing.JButton();
        btngit = new javax.swing.JButton();
        lbltit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1334, 647));
        setMinimumSize(new java.awt.Dimension(1334, 647));

        jpp.setBackground(new java.awt.Color(209, 247, 151));
        jpp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp.setBackground(new java.awt.Color(255, 179, 86));
        jp.setMaximumSize(new java.awt.Dimension(1000, 323));
        jp.setPreferredSize(new java.awt.Dimension(1354, 323));
        jp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel2.setText("Ricardo Alejandro Perez Rodriguez 0901-17-1255");
        jp.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 290, -1, -1));

        btnnomina.setBackground(new java.awt.Color(212, 94, 28));
        btnnomina.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnnomina.setText("Nomina");
        btnnomina.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        btnnomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnominaActionPerformed(evt);
            }
        });
        jp.add(btnnomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 260, 70));

        btnpilas.setBackground(new java.awt.Color(212, 94, 28));
        btnpilas.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnpilas.setText("Pilas");
        btnpilas.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        btnpilas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpilasActionPerformed(evt);
            }
        });
        jp.add(btnpilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 190, 70));

        btncolas.setBackground(new java.awt.Color(212, 94, 28));
        btncolas.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btncolas.setText("Colas");
        btncolas.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        btncolas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncolasActionPerformed(evt);
            }
        });
        jp.add(btncolas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 130, 190, 70));

        btnlistas.setBackground(new java.awt.Color(212, 94, 28));
        btnlistas.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnlistas.setText("Listas");
        btnlistas.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        btnlistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlistasActionPerformed(evt);
            }
        });
        jp.add(btnlistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 190, 70));

        btnnominabd.setBackground(new java.awt.Color(212, 94, 28));
        btnnominabd.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnnominabd.setText("Nomina BD");
        btnnominabd.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        btnnominabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnominabdActionPerformed(evt);
            }
        });
        jp.add(btnnominabd, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 250, 70));

        btnarboles.setBackground(new java.awt.Color(212, 94, 28));
        btnarboles.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnarboles.setText("Arboles");
        btnarboles.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        btnarboles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnarbolesActionPerformed(evt);
            }
        });
        jp.add(btnarboles, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 590, 70));

        btntorres.setBackground(new java.awt.Color(212, 94, 28));
        btntorres.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btntorres.setText("Torres de hanoi");
        btntorres.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        btntorres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntorresActionPerformed(evt);
            }
        });
        jp.add(btntorres, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 190, 70));

        jpp.add(jp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1500, 220));

        lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/subir.png"))); // NOI18N
        lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbMouseReleased(evt);
            }
        });
        jpp.add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, -1, -1));

        lblyout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblyout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yt.png"))); // NOI18N
        jpp.add(lblyout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 400, 330));

        lblgit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblgit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/git.png"))); // NOI18N
        jpp.add(lblgit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 540, 250));

        lblcod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jav.png"))); // NOI18N
        jpp.add(lblcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 140, 460, 270));

        btncod.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btncod.setText("Ver codigo");
        btncod.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        btncod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncodActionPerformed(evt);
            }
        });
        jpp.add(btncod, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 450, 260, 70));

        btnyout.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnyout.setText("Ver video");
        btnyout.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        btnyout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnyoutActionPerformed(evt);
            }
        });
        jpp.add(btnyout, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 260, 70));

        btngit.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btngit.setText("Ver repositorio");
        btngit.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        btngit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngitActionPerformed(evt);
            }
        });
        jpp.add(btngit, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 260, 70));

        lbltit.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        lbltit.setText("jLabel1");
        jpp.add(lbltit, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 540, 450, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpp, javax.swing.GroupLayout.DEFAULT_SIZE, 1567, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMouseReleased
        bajarsubir();
    }//GEN-LAST:event_lbMouseReleased

    private void btnnominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnominaActionPerformed
        bajarsubir();
        aparecer();
        itOpcion=1;
        lbltit.setText("Nomina");
    }//GEN-LAST:event_btnnominaActionPerformed

    private void btnnominabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnominabdActionPerformed
        bajarsubir();
        aparecer();
        itOpcion=2;
        lbltit.setText("Nomina BD");
    }//GEN-LAST:event_btnnominabdActionPerformed

    private void btnlistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistasActionPerformed
        bajarsubir();
        aparecer();
        itOpcion=3;
        lbltit.setText("Listas enlazadas");
    }//GEN-LAST:event_btnlistasActionPerformed

    private void btnpilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpilasActionPerformed
         bajarsubir();
        aparecer();
        itOpcion=4;
        lbltit.setText("Pilas");
    }//GEN-LAST:event_btnpilasActionPerformed

    private void btnarbolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnarbolesActionPerformed
          bajarsubir();
        aparecer();
        itOpcion=1;
        lbltit.setText("Arboles");
    }//GEN-LAST:event_btnarbolesActionPerformed

    private void btntorresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntorresActionPerformed
         bajarsubir();
        aparecer();
        itOpcion=6;
        lbltit.setText("Torres de hanoi");
    }//GEN-LAST:event_btntorresActionPerformed

    private void btncolasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncolasActionPerformed
         bajarsubir();
        aparecer();
        itOpcion=5;
        lbltit.setText("Colas");
    }//GEN-LAST:event_btncolasActionPerformed

    private void btnyoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnyoutActionPerformed
        abrirlinks(itOpcion,2);
    }//GEN-LAST:event_btnyoutActionPerformed

    private void btngitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngitActionPerformed
        abrirlinks(itOpcion,1);
    }//GEN-LAST:event_btngitActionPerformed

    private void btncodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncodActionPerformed
            abrirlinks(itOpcion, 3);
    }//GEN-LAST:event_btncodActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnarboles;
    private javax.swing.JButton btncod;
    private javax.swing.JButton btncolas;
    private javax.swing.JButton btngit;
    private javax.swing.JButton btnlistas;
    private javax.swing.JButton btnnomina;
    private javax.swing.JButton btnnominabd;
    private javax.swing.JButton btnpilas;
    private javax.swing.JButton btntorres;
    private javax.swing.JButton btnyout;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jp;
    private javax.swing.JPanel jpp;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lblcod;
    private javax.swing.JLabel lblgit;
    private javax.swing.JLabel lbltit;
    private javax.swing.JLabel lblyout;
    // End of variables declaration//GEN-END:variables
}
