package nomina2;
public class nomina2 extends javax.swing.JFrame {
        /*declaracion de todas mas matris a usarse, inlcuido matriz de totales
    *vectores nombre y apelido usados para generas nombres random, y el salario para obtenerlo random
    *el vector total es para el total de los departamentos
    */
      String [][] matPrincipal= new String[10][10];
    String [] vectNombre= new String[10];
    String [] vectApellido= new String[10];
    int [] vectSalario= new int[5];
    int [] vectTotal= new int[6];
    public nomina2() {
        initComponents();
         //declaracion de todos los posibles nombres a mostrar por random, en el boton random
        vectNombre[0]="ANTONIO";vectNombre[3]="MARIA CARMEN";vectNombre[6]="JOSEFA";vectNombre[9]="PEDRO";
        vectNombre[1]="JOSE";vectNombre[4]="FRANCISCO";vectNombre[7]="ISABEL";
        vectNombre[2]="MARIA";vectNombre[5]="JUAN";vectNombre[8]="MANUEL";
        vectApellido[0]="GARCIA";vectApellido[3]="SANCHEZ";vectApellido[6]="MORENO";vectApellido[9]="RODRIGUEZ";
        vectApellido[1]="MARTINEZ";vectApellido[4]="GONZALEZ";vectApellido[7]="JIMENEZ";
        vectApellido[2]="LOPEZ";vectApellido[5]="GOMEZ";vectApellido[8]="PEREZ";
        vectSalario[0]=3500;vectSalario[1]=4500;vectSalario[2]=5000;vectSalario[3]=7000;vectSalario[4]=7300;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbprincipal = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbtotal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnrandom = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbprincipal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbprincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Nombre empleado", "Sueldo", "IGSS", "Bonificacion", "Comision", "ISR", "Desc Judicial", "Sueldo liquido", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbprincipal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 1090, 190));

        tbtotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbtotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbtotal);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, 110));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Nomina");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 170, 60));

        btnrandom.setBackground(new java.awt.Color(255, 148, 42));
        btnrandom.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnrandom.setForeground(new java.awt.Color(190, 243, 85));
        btnrandom.setText("Random");
        btnrandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrandomActionPerformed(evt);
            }
        });
        getContentPane().add(btnrandom, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, -1, -1));

        btncalcular.setBackground(new java.awt.Color(255, 148, 42));
        btncalcular.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btncalcular.setForeground(new java.awt.Color(190, 243, 85));
        btncalcular.setText("Calcular");
        btncalcular.setToolTipText("");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });
        getContentPane().add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, -1, -1));

        jLabel2.setText("consejeros");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel3.setText("Administracion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel4.setText("Contabilidad");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel5.setText("Sistemas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel6.setText("Seguridad");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        btnlimpiar.setBackground(new java.awt.Color(255, 148, 42));
        btnlimpiar.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(190, 243, 85));
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnrandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrandomActionPerformed
        // por medio de variables se generan numeros random, para obtener datos, y obtener asi numeros a la azar para llenar la tabla
        int rmdNombre,rmdApellido,rmdSalario,rmdBoni,rmdDepto, rmdComi,rmdJudi,rmdIgss;
        for(int i=0;i<=9;i++){
            //numero random para el llenado de la tabla, tambien esta salario y el departamento al que pertenece
            rmdNombre=(int)(Math.random()*9);
            rmdApellido=(int)(Math.random()*9);
            matPrincipal[i][1]=vectNombre[rmdNombre]+" "+vectApellido[rmdApellido];
            matPrincipal[i][0]="#"+(i+1);
            rmdSalario=(int)(Math.random()*4);
            matPrincipal[i][2]=String.valueOf(vectSalario[rmdSalario]);
            rmdIgss=(int)(Integer.parseInt(matPrincipal[i][2])*0.12);
            matPrincipal[i][3]=String.valueOf((int)rmdIgss);
            rmdBoni=200+(int)(Math.random()*300);
            matPrincipal[i][4]=String.valueOf((int)rmdBoni);
           rmdComi=1+(int)(Math.random()*300);
            matPrincipal[i][5]=String.valueOf((int)rmdComi);
            rmdJudi=1+(int)(Math.random()*400);
            matPrincipal[i][7]=String.valueOf((int)rmdJudi);            
            rmdDepto=1+(int)(Math.random()*5);
            matPrincipal[i][9]=String.valueOf((int)rmdDepto);
        }
        //codigo utilizado para mostrar los datos en la tabla
          tbprincipal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbprincipal.setModel(new javax.swing.table.DefaultTableModel(
            matPrincipal,
            new String [] {
                "No.", "Nombre empleado", "Sueldo", "IGSS", "Bonificacion", "Comision", "ISR", "Desc Judicial", "Sueldo liquido", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }//GEN-LAST:event_btnrandomActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        //se hacen las suma del salario liquido y para los totales del departamento, obtiene los valores de la matriz hacia el vector total
        int itSal;
    int itImp,itTotal;
          for(int i=0;i<=9;i++){
          itSal=Integer.parseInt(matPrincipal[i][2])*12;
          if(itSal>30000){
              itImp=(int)(itSal*0.07)/12;
          }else{
          itImp=(int)(itSal*0.05)/12;
          }
          matPrincipal[i][6]=String.valueOf(itImp);
          }
        for(int i=0;i<=9;i++){
            itTotal=(Integer.parseInt(matPrincipal[i][2]))-(Integer.parseInt(matPrincipal[i][3]))+(Integer.parseInt(matPrincipal[i][4]))+(Integer.parseInt(matPrincipal[i][5]))-(Integer.parseInt(matPrincipal[i][6]))-(Integer.parseInt(matPrincipal[i][7]));
            matPrincipal[i][8]=String.valueOf(itTotal);
            if(Integer.parseInt(matPrincipal[i][9])==1){
                vectTotal[1]=Integer.parseInt(matPrincipal[i][8])+vectTotal[1];
            }
            if(Integer.parseInt(matPrincipal[i][9])==2){
                vectTotal[2]=Integer.parseInt(matPrincipal[i][8])+vectTotal[2];
            }
            if(Integer.parseInt(matPrincipal[i][9])==3){
                vectTotal[3]=Integer.parseInt(matPrincipal[i][8])+vectTotal[3];
            }
            if(Integer.parseInt(matPrincipal[i][9])==4){
                vectTotal[4]=Integer.parseInt(matPrincipal[i][8])+vectTotal[4];
            }
            if(Integer.parseInt(matPrincipal[i][9])==5){
                vectTotal[5]=Integer.parseInt(matPrincipal[i][8])+vectTotal[5];
            }
        }
        //codigo utilizado para mostrar los datos en la tabla
           tbprincipal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbprincipal.setModel(new javax.swing.table.DefaultTableModel(
            matPrincipal,
            new String [] {
                "No.", "Nombre empleado", "Sueldo", "IGSS", "Bonificacion", "Comision", "ISR", "Desc Judicial", "Sueldo liquido", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        //codigo utilizado para mostrar el vector de totales por departamentos
        tbtotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {vectTotal[1]},
                {vectTotal[2]},
                {vectTotal[3]},
                {vectTotal[4]},
                {vectTotal[5]}
            },
            new String [] {
                "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }//GEN-LAST:event_btncalcularActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // solo limpiamos los vectores y mostramos
        for(int i=0;i<=9;i++){
            for(int j=0;j<=6;j++){
                matPrincipal[i][j]="";
            }
        }
        for(int i=0;i<=5;i++){
            vectTotal[i]=0;
        }
        tbprincipal.setModel(new javax.swing.table.DefaultTableModel(
            matPrincipal,
            new String [] {
                "No.", "Nombre empleado", "Salario base", "Total deduciones", "Total perceptible", "Sueldo liquido", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        //codigo utilizado para mostrar el vector de totales por departamentos
        tbtotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {vectTotal[1]},
                {vectTotal[2]},
                {vectTotal[3]},
                {vectTotal[4]},
                {vectTotal[5]}
            },
            new String [] {
                "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }//GEN-LAST:event_btnlimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(nomina2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nomina2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nomina2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nomina2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nomina2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnrandom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbprincipal;
    private javax.swing.JTable tbtotal;
    // End of variables declaration//GEN-END:variables
}
