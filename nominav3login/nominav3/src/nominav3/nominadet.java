package nominav3;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *SELECT nominaencabezado.nomi_codigo,nominaencabezado.nomi_fechaini,nominaencabezado.nom_fechafin,empleados.emp_codigo, empleados.emp_nombre, concepto.con_codigo,concepto.con_nombre, nominadetalles.nomi_total FROM nominaencabezado,nominadetalles,empleados,concepto WHERE nominaencabezado.nomi_codigo=nominadetalles.con_codigo AND nominadetalles.emp_codigo=empleados.emp_codigo 
 * @author Ricardo Perez
 */
public class nominadet extends javax.swing.JFrame {
     String [][] matPrincipal= new String[25][10];
      String []stDepto=new String[15];
    double [] vectTotal= new double[15];
    public nominadet() {
        initComponents();
        grupo.add(rbtmod);grupo.add(rbtvis);//enlaze de mos radiobuttons
        //llamda de metodos necesarios
        nomostrar();
        llenardatos();
    }
      public void mostrarentabla(){
         //codigo utilizado para mostrar los datos en la tabla
        tbprincipal.setFont(new java.awt.Font("Dialog", 1, 18)); 
        tbprincipal.setModel(new javax.swing.table.DefaultTableModel(
            matPrincipal,
             new String [] {
                "No.", "Nombre empleado", "Sueldo", "Bonificacion", "Comision", "ISR", "Des. Judicial", "IGSS", "Sueldo liquido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
           //codigo utilizado para mostrar el vector de totales por departamentos
            tbtotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbtotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                 {stDepto[1],vectTotal[1]},
                {stDepto[2],vectTotal[2]},
                {stDepto[3],vectTotal[3]},
                {stDepto[4],vectTotal[4]},
                {stDepto[5],vectTotal[5]},
                {stDepto[6],vectTotal[6]},
                {stDepto[7],vectTotal[7]},
                {stDepto[8],vectTotal[8]},
                {stDepto[9],vectTotal[9]},
                {stDepto[10],vectTotal[10]},
                {stDepto[11],vectTotal[11]},
                {stDepto[12],vectTotal[12]},
                {stDepto[13],vectTotal[13]},
                {stDepto[14],vectTotal[14]}
            },
            new String [] {
                "Departamento", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
}
    public void nomostrar(){
        //se ocultan todos los objetos
    l1.setVisible(false);l3.setVisible(false);
    l2.setVisible(false);l4.setVisible(false);
    cmbCodFec.setVisible(false);cmbNomFec.setVisible(false);
    cmbCodEmp.setVisible(false);cmbNomEmp.setVisible(false);
    jstabla.setVisible(false);btnvis.setVisible(false);
    cmbCodCon.setVisible(false);cmbNomCon.setVisible(false);
    btnmod.setVisible(false);txtmonto.setVisible(false);jsTabla.setVisible(false);
    }
    public void llenardatos(){
        int x=0;
       //Codigo que permite ingresar datos a los listas, o combocox, todos hacen lo mismo
      this.cmbCodFec.removeAllItems();
      this.cmbNomFec.removeAllItems();
      this.cmbCodEmp.removeAllItems();
      this.cmbNomEmp.removeAllItems();
      this.cmbCodCon.removeAllItems();
      this.cmbNomCon.removeAllItems();
      try{
            //conexion de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM `empleados` ");
            ResultSet rs = pst.executeQuery();
            boolean r=rs.next();
            while(r){                
                if(rs.getString("emp_estatus").equals("2")){
                this.cmbNomEmp.addItem(rs.getString("emp_nombre"));
                this.cmbCodEmp.addItem(rs.getString("emp_codigo"));
                }
                r=rs.next();            
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Base de datos no enlazada");
        }
        try{
            //conexion de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM `nominaencabezado` ");
            ResultSet rs = pst.executeQuery();
            boolean r=rs.next();
            while(r){
                this.cmbNomFec.addItem("Del "+rs.getString("nomi_fechaini")+" al "+rs.getString("nom_fechafin"));
                this.cmbCodFec.addItem(rs.getString("nomi_codigo"));
                r=rs.next();            
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Base de datos no enlazada");
        }                
        try{
            //conexion de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM `concepto` ");
            ResultSet rs = pst.executeQuery();
            boolean r=rs.next();
            while(r){
                this.cmbNomCon.addItem(rs.getString("con_nombre"));
                this.cmbCodCon.addItem(rs.getString("con_codigo"));
                r=rs.next();            
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Base de datos no enlazada");
        }x=1;
        try{//
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM `departamentos`;");
            ResultSet rs = pst.executeQuery();
            boolean r=rs.next();
            while(r){                
                stDepto[x]=rs.getString("dep_nombre");                  
                r=rs.next();
                x++;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un Error fatal");
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
        l1 = new javax.swing.JLabel();
        rbtmod = new javax.swing.JRadioButton();
        rbtvis = new javax.swing.JRadioButton();
        cmbCodFec = new javax.swing.JComboBox<>();
        cmbNomFec = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        cmbCodEmp = new javax.swing.JComboBox<>();
        cmbNomEmp = new javax.swing.JComboBox<>();
        l3 = new javax.swing.JLabel();
        cmbCodCon = new javax.swing.JComboBox<>();
        cmbNomCon = new javax.swing.JComboBox<>();
        txtmonto = new javax.swing.JTextField();
        l4 = new javax.swing.JLabel();
        btnmod = new javax.swing.JButton();
        jstabla = new javax.swing.JScrollPane();
        tbprincipal = new javax.swing.JTable();
        btnvis = new javax.swing.JButton();
        jsTabla = new javax.swing.JScrollPane();
        tbtotal = new javax.swing.JTable();
        btnregresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1370, 619));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l1.setText("Seleccione fecha");
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        rbtmod.setText("Modificar");
        rbtmod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtmodActionPerformed(evt);
            }
        });
        getContentPane().add(rbtmod, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        rbtvis.setText("visualizar");
        rbtvis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtvisItemStateChanged(evt);
            }
        });
        rbtvis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtvisMouseClicked(evt);
            }
        });
        rbtvis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtvisActionPerformed(evt);
            }
        });
        getContentPane().add(rbtvis, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        cmbCodFec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbCodFec, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        cmbNomFec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNomFec.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNomFecItemStateChanged(evt);
            }
        });
        cmbNomFec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNomFecActionPerformed(evt);
            }
        });
        getContentPane().add(cmbNomFec, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 220, -1));

        jLabel2.setText("Nomina Detalle");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 27, -1, -1));

        l2.setText("Seleccione empleado");
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        cmbCodEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbCodEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        cmbNomEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNomEmp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNomEmpItemStateChanged(evt);
            }
        });
        cmbNomEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNomEmpActionPerformed(evt);
            }
        });
        getContentPane().add(cmbNomEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 220, -1));

        l3.setText("Monto");
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 170, -1, -1));

        cmbCodCon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbCodCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, -1, -1));

        cmbNomCon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNomCon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNomConItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbNomCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 220, -1));
        getContentPane().add(txtmonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 200, 290, -1));

        l4.setText("Seleccione concepto");
        getContentPane().add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, -1, -1));

        btnmod.setText("Modificar");
        btnmod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodActionPerformed(evt);
            }
        });
        getContentPane().add(btnmod, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 350, 50));

        tbprincipal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbprincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Seleccione"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jstabla.setViewportView(tbprincipal);

        getContentPane().add(jstabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 1090, 190));

        btnvis.setText("Visualizar");
        btnvis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisActionPerformed(evt);
            }
        });
        getContentPane().add(btnvis, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 360, 60));

        tbtotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbtotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Departamento", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jsTabla.setViewportView(tbtotal);

        getContentPane().add(jsTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 250, 160));

        btnregresar.setBackground(new java.awt.Color(255, 148, 42));
        btnregresar.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnregresar.setForeground(new java.awt.Color(190, 243, 85));
        btnregresar.setText("Regresar");
        btnregresar.setMinimumSize(new java.awt.Dimension(763, 439));
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 440, 290, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtmodActionPerformed
        nomostrar();    //se ocultan todos y solo se muestran los que se quieren
        l1.setVisible(true);l3.setVisible(true);
    l2.setVisible(true);l4.setVisible(true);
    cmbNomFec.setVisible(true);
    cmbNomEmp.setVisible(true);
    cmbNomCon.setVisible(true);
    txtmonto.setEnabled(false);
    btnmod.setVisible(true);txtmonto.setVisible(true);
    }//GEN-LAST:event_rbtmodActionPerformed

    private void cmbNomFecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNomFecActionPerformed
             try{ cmbCodFec.setSelectedIndex(cmbNomFec.getSelectedIndex());}// se cambia el indice del combo
        catch(Exception e){
        }
    }//GEN-LAST:event_cmbNomFecActionPerformed

    private void cmbNomEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNomEmpActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_cmbNomEmpActionPerformed

    private void cmbNomFecItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNomFecItemStateChanged
                 try{ cmbCodFec.setSelectedIndex(cmbNomFec.getSelectedIndex());}// se cambia el indice del combo
        catch(Exception e){
        }
    }//GEN-LAST:event_cmbNomFecItemStateChanged

    private void cmbNomEmpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNomEmpItemStateChanged
             try{ cmbCodEmp.setSelectedIndex(cmbNomEmp.getSelectedIndex());}// se cambia el indice del combo
        catch(Exception e){
        }
    }//GEN-LAST:event_cmbNomEmpItemStateChanged

    private void cmbNomConItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNomConItemStateChanged
             try{ cmbCodCon.setSelectedIndex(cmbNomCon.getSelectedIndex());}// se cambia el indice del combo
        catch(Exception e){
        }
              try{
            //conexion de datos llena el campo de monto al seleccionar 
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT `nomi_total` FROM `nominadetalles` WHERE nominadetalles.nomi_codigo='"+cmbCodFec.getSelectedItem()+"' AND nominadetalles.emp_codigo='"+cmbCodEmp.getSelectedItem()+"' AND nominadetalles.con_codigo='"+cmbCodCon.getSelectedItem()+"'  ");
            ResultSet rs = pst.executeQuery();
            boolean r=rs.next();
            if(r){                
               txtmonto.setText(rs.getString("nomi_total"));                       
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Base de datos no enlazada");
        }
              txtmonto.setEnabled(true);
              
    }//GEN-LAST:event_cmbNomConItemStateChanged

    private void btnmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodActionPerformed
           //codigos para guardar el nuevo dato en la tabla departamentos
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE `nominadetalles` SET `nomi_total`='"+txtmonto.getText().trim()+"' WHERE nominadetalles.nomi_codigo='"+cmbCodFec.getSelectedItem()+"' AND nominadetalles.emp_codigo='"+cmbCodEmp.getSelectedItem()+"' AND nominadetalles.con_codigo='"+cmbCodCon.getSelectedItem()+"'  ");
            pst.executeUpdate();
            txtmonto.setText("");
            JOptionPane.showMessageDialog(null,"Dato guardado con exito");
        }catch (Exception e){
          JOptionPane.showMessageDialog(null,"le dio un error "+e);
        }
    }//GEN-LAST:event_btnmodActionPerformed

    private void rbtvisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtvisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtvisActionPerformed

    private void rbtvisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtvisItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtvisItemStateChanged

    private void rbtvisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtvisMouseClicked
        nomostrar();//se ocultan todos y solo se muestran los que se quieren
        jstabla.setVisible(true);
        btnvis.setVisible(true);
        l1.setVisible(true);jsTabla.setVisible(true);
        cmbNomFec.setVisible(true);
    }//GEN-LAST:event_rbtvisMouseClicked

    private void btnvisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisActionPerformed
 for(int i=0;i<=24;i++){///se limpia la matriz
            for(int j=0;j<=9;j++){
                matPrincipal[i][j]="";
            }
        }
         for(int i=0;i<=14;i++){
            vectTotal[i]=0;//se limpia la matriz
        }   
        int x=0,j=0,j1=0,y=2,w=1;
        Double itTotal;
      try {//se obtiene la cantidad de elementos en concepto
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            Statement s=con.createStatement();
           String SQL="select count(*) from concepto ";
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
              x=0;
            j1=j1-1;
        try{//se obrtienen los datos en la matriz
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT nominadetalles.nomi_codigo, nominadetalles.emp_codigo, nominadetalles.con_codigo, nominadetalles.nomi_total, empleados.emp_nombre, empleados.dep_cod FROM `nominadetalles`, empleados WHERE nominadetalles.emp_codigo=empleados.emp_codigo AND   nomi_codigo='"+cmbCodFec.getSelectedItem()+"'");
            ResultSet rs = pst.executeQuery();
            boolean r=rs.next();
            while(r){                
                if(w<=j1){
                    //se ingresan en la matriz
                matPrincipal[x][y]=rs.getString("nomi_total");
                matPrincipal[x][0]=rs.getString("emp_codigo");
                matPrincipal[x][1]=rs.getString("emp_nombre");
                matPrincipal[x][9]=rs.getString("dep_cod");
                y++;
                w++;
                r=rs.next(); 
                } else{                    
                    y=2;x++;w=1;}               
                
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un Error fatal");
        }  
                for(int i=0;i<=24;i++){//se suman hacia los vectores, para luego ser mostrados
            if(((String.valueOf(matPrincipal[i][0])).equals(""))||((String.valueOf(matPrincipal[i][0])).equals("null"))){//verificacion que no esten vacios
            }else{
            itTotal=(Double.parseDouble(matPrincipal[i][2]))-(Double.parseDouble(matPrincipal[i][3]))+(Double.parseDouble(matPrincipal[i][4]))+(Double.parseDouble(matPrincipal[i][5]))-(Double.parseDouble(matPrincipal[i][6]))-(Double.parseDouble(matPrincipal[i][7]));
            matPrincipal[i][8]=String.valueOf(itTotal);
            if(Integer.parseInt(matPrincipal[i][9])==1){
                vectTotal[1]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[1]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==2){
                vectTotal[2]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[2]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==3){
                vectTotal[3]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[3]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==4){
                vectTotal[4]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[4]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==5){
                vectTotal[5]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[5]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==6){
                vectTotal[6]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[1]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==7){
                vectTotal[7]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[2]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==8){
                vectTotal[8]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[3]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==9){
                vectTotal[9]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[4]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==10){
                vectTotal[10]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[5]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==11){
                vectTotal[11]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[1]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==12){
                vectTotal[12]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[2]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==13){
                vectTotal[13]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[3]);
            }
            if(Integer.parseInt(matPrincipal[i][9])==14){
                vectTotal[14]=(double)(Double.parseDouble(matPrincipal[i][8])+vectTotal[4]);
            }            
        }}
        mostrarentabla();
    }//GEN-LAST:event_btnvisActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        //se regresa de pantalla
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
            java.util.logging.Logger.getLogger(nominadet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nominadet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nominadet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nominadet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nominadet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmod;
    private javax.swing.JButton btnregresar;
    private javax.swing.JButton btnvis;
    private javax.swing.JComboBox<String> cmbCodCon;
    private javax.swing.JComboBox<String> cmbCodEmp;
    private javax.swing.JComboBox<String> cmbCodFec;
    private javax.swing.JComboBox<String> cmbNomCon;
    private javax.swing.JComboBox<String> cmbNomEmp;
    private javax.swing.JComboBox<String> cmbNomFec;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jsTabla;
    private javax.swing.JScrollPane jstabla;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JRadioButton rbtmod;
    private javax.swing.JRadioButton rbtvis;
    private javax.swing.JTable tbprincipal;
    private javax.swing.JTable tbtotal;
    private javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables
}
