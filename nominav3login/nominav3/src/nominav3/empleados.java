package nominav3;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *redirecciona a los diferentes modulos de ingresos de datos
 * @author Ricardo Perez
 */
public class empleados extends javax.swing.JFrame {
    //creacion de variables y matrices necesarias para poder manejar los datos, 
    String stmtPrincipal[][]=new String[25][8];
    int j1,j;String stCod="";
    public empleados() {
        initComponents();
        //enlaze de mos radiobuttons
        grupo1.add(rbtingresar);
        grupo1.add(rbtmodificar);       
        grupo1.add(rbtbuscar);
        //llamda de metodos necesarios
        Nomostrar();
        llenarpuesto();
        llenardepto();
    }
    public void limpiar(){
        //limpia todo los datos
         txtnombre.setText("");
        txtdirec.setText("");
        txtsueldo.setText("");
        txtnit.setText("");
        cmbNomDep.setSelectedIndex(0);
        cmbNomPue.setSelectedIndex(0);
        chkestado.setSelected(false);
    }
    public void codigoauto(){
        //codigo para saber cuantas lineas hay en la base de datos y asi poder llenar el codigo sin ingresar
        j1=0;
        try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            Statement s=con.createStatement();
           String SQL="SELECT COUNT(*) FROM `empleados`";
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
        public void llenardepto(){
      //Codigo que permite ingresar datos a los listas
      this.cmbCodDep.removeAllItems();
      this.cmbNomDep.removeAllItems();
        try{
            //conexion de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM departamentos");
            ResultSet rs = pst.executeQuery();
            boolean r=rs.next();
            while(r){
                this.cmbNomDep.addItem(rs.getString("dep_nombre"));
                this.cmbCodDep.addItem(rs.getString("dep_codigo"));
                r=rs.next();            
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Base de datos no enlazada");
        }
    }
    public void llenarpuesto(){
      //Codigo que permite ingresar datos a los listas
      this.cmbCodpue.removeAllItems();
      this.cmbNomPue.removeAllItems();
        try{
            //conexion de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM puesto");
            ResultSet rs = pst.executeQuery();
            boolean r=rs.next();
            while(r){
                this.cmbNomPue.addItem(rs.getString("pues_nombre"));
                this.cmbCodpue.addItem(rs.getString("pues_codigo"));
                r=rs.next();            
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Base de datos no enlazada");
        }
    }
    public void Mostrar(){
        //se muestran todos los objetos
        ln.setVisible(true);
        lp.setVisible(true);
        lnit.setVisible(true);
        lsue.setVisible(true);
        les.setVisible(true);
        ld.setVisible(true);
        ldep.setVisible(true);        
        txtnombre.setVisible(true);
        txtdirec.setVisible(true);
        txtsueldo.setVisible(true);
        txtnit.setVisible(true);
        cmbNomDep.setVisible(true);
        cmbNomPue.setVisible(true);
        chkestado.setVisible(true);
        btnIngresar.setVisible(true);
   
    }
        public void Nomostrar(){
        jScrollPane1.setVisible(false);
        ln.setVisible(false);
        lp.setVisible(false);
        lnit.setVisible(false);
        lsue.setVisible(false);
        les.setVisible(false);
        ld.setVisible(false);
        ldep.setVisible(false);        
        txtnombre.setVisible(false);
        txtdirec.setVisible(false);
        txtsueldo.setVisible(false);
        txtnit.setVisible(false);
        cmbNomDep.setVisible(false);
        cmbCodDep.setVisible(false);
        cmbNomPue.setVisible(false);
        cmbCodpue.setVisible(false);
        chkestado.setVisible(false);
        btnIngresar.setVisible(false);
        cod.setVisible(false);
        txtCod.setVisible(false);
        btnbus.setVisible(false);
        btnlistado.setVisible(false);
        btnModificar.setVisible(false);
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo1 = new javax.swing.ButtonGroup();
        rbtingresar = new javax.swing.JRadioButton();
        rbtmodificar = new javax.swing.JRadioButton();
        rbtbuscar = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        les = new javax.swing.JLabel();
        ln = new javax.swing.JLabel();
        lnit = new javax.swing.JLabel();
        ld = new javax.swing.JLabel();
        ldep = new javax.swing.JLabel();
        lp = new javax.swing.JLabel();
        lsue = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtnit = new javax.swing.JTextField();
        txtdirec = new javax.swing.JTextField();
        txtsueldo = new javax.swing.JTextField();
        chkestado = new javax.swing.JCheckBox();
        cmbCodDep = new javax.swing.JComboBox<>();
        cmbNomPue = new javax.swing.JComboBox<>();
        cmbNomDep = new javax.swing.JComboBox<>();
        cmbCodpue = new javax.swing.JComboBox<>();
        btnIngresar = new javax.swing.JButton();
        txtCod = new javax.swing.JTextField();
        btnbus = new javax.swing.JButton();
        cod = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnlistado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnregresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 950));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbtingresar.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        rbtingresar.setText("Ingresar");
        rbtingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtingresarMouseClicked(evt);
            }
        });
        rbtingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtingresarActionPerformed(evt);
            }
        });
        getContentPane().add(rbtingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, -1, -1));

        rbtmodificar.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        rbtmodificar.setText("Modificar");
        rbtmodificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtmodificarMouseClicked(evt);
            }
        });
        rbtmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(rbtmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 170, -1, -1));

        rbtbuscar.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        rbtbuscar.setText("Buscar");
        rbtbuscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtbuscarItemStateChanged(evt);
            }
        });
        rbtbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtbuscarMouseClicked(evt);
            }
        });
        rbtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(rbtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, -1, -1));

        jLabel1.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        jLabel1.setText("Empleados                Seleccione;");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, -1, -1));

        les.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        les.setText("Estado");
        getContentPane().add(les, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 430, -1, -1));

        ln.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        ln.setText("Nombre");
        getContentPane().add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        lnit.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        lnit.setText("NIT");
        getContentPane().add(lnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, -1, -1));

        ld.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        ld.setText("Dirección");
        getContentPane().add(ld, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, -1, -1));

        ldep.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        ldep.setText("Departamento");
        getContentPane().add(ldep, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, -1, -1));

        lp.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        lp.setText("Puesto");
        getContentPane().add(lp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 310, -1, -1));

        lsue.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        lsue.setText("Sueldo");
        getContentPane().add(lsue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 550, -1, -1));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 190, -1));
        getContentPane().add(txtnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 620, 190, -1));
        getContentPane().add(txtdirec, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, 190, -1));
        getContentPane().add(txtsueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 620, 190, -1));
        getContentPane().add(chkestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 470, 50, 70));

        cmbCodDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCodDep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCodDepItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbCodDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 680, 210, -1));

        cmbNomPue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNomPue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNomPueItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbNomPue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 380, 210, -1));

        cmbNomDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNomDep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNomDepItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbNomDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 620, 210, -1));

        cmbCodpue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCodpue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCodpueItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbCodpue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 430, 210, -1));

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
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 780, 290, 60));
        getContentPane().add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 200, -1));

        btnbus.setBackground(new java.awt.Color(255, 148, 42));
        btnbus.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btnbus.setForeground(new java.awt.Color(190, 243, 85));
        btnbus.setText("Buscar");
        btnbus.setMinimumSize(new java.awt.Dimension(763, 439));
        btnbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusActionPerformed(evt);
            }
        });
        getContentPane().add(btnbus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 290, 60));

        cod.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        cod.setText("Ingrese codigo");
        getContentPane().add(cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, -1, -1));

        btnModificar.setBackground(new java.awt.Color(255, 148, 42));
        btnModificar.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(190, 243, 85));
        btnModificar.setText("Modificar");
        btnModificar.setMinimumSize(new java.awt.Dimension(763, 439));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 730, 290, 60));

        btnlistado.setBackground(new java.awt.Color(255, 148, 42));
        btnlistado.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btnlistado.setForeground(new java.awt.Color(190, 243, 85));
        btnlistado.setText("Buscar");
        btnlistado.setMinimumSize(new java.awt.Dimension(763, 439));
        btnlistado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlistadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnlistado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 580, 290, 60));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Nit", "Direccion", "Departamento", "Puesto", "Sueldo", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 1610, 230));

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
        getContentPane().add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 690, 290, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
               //Codigo que permite insertar registros en al base de datos
           codigoauto();
           int itEstado=0;
           if(chkestado.isSelected()==true){
           itEstado=2;
           }else{itEstado=1;}
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `empleados` (`emp_codigo`, `emp_nombre`, `emp_nit`, `emp_direccion`, `dep_cod`, `pues_codi`, `emp_sueldonom`, `emp_estatus`) VALUES ('"+j1+"', '"+txtnombre.getText()+"', '"+txtnit.getText()+"', '"+txtdirec.getText()+"', '"+cmbCodDep.getSelectedItem()+"', '"+cmbCodpue.getSelectedItem()+"', '"+txtsueldo.getText()+"', '"+itEstado+"');");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Dato guardado con exito");
        }catch (Exception e){
           System.out.println("le dio un error"+e);
        }
             limpiar();  
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void rbtingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtingresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtingresarActionPerformed

    private void rbtingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtingresarMouseClicked
        Nomostrar();
        Mostrar();
        //se ocultan todos y solo se muestran los que se quieren
         cod.setVisible(false);
        txtCod.setVisible(false);
        btnbus.setVisible(false);
    }//GEN-LAST:event_rbtingresarMouseClicked

    private void cmbNomPueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNomPueItemStateChanged
        try{ cmbCodpue.setSelectedIndex(cmbNomPue.getSelectedIndex());}// se cambia el indice del combo
        catch(Exception e){
        }
    }//GEN-LAST:event_cmbNomPueItemStateChanged

    private void cmbNomDepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNomDepItemStateChanged
        try{ cmbCodDep.setSelectedIndex(cmbNomDep.getSelectedIndex());}// se cambia el indice del combo
        catch(Exception e){
        }
    }//GEN-LAST:event_cmbNomDepItemStateChanged

    private void cmbCodpueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCodpueItemStateChanged
    }//GEN-LAST:event_cmbCodpueItemStateChanged

    private void cmbCodDepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCodDepItemStateChanged

    }//GEN-LAST:event_cmbCodDepItemStateChanged

    private void btnbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusActionPerformed
        Mostrar();
        btnIngresar.setVisible(false);
  //Codigo que permite traer registros de la base de datos
        int itEstado,itPuesto,itDepartamento;
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM `empleados` WHERE emp_codigo='"+txtCod.getText().trim()+"' ");                     
            ResultSet rs = pst.executeQuery();
            stCod=txtCod.getText().trim();
            txtCod.setText("");
            if(rs.next()){
                //los resgistros obtenidos se colocan en los campos correspondientes
           txtnombre.setText(rs.getString("emp_nombre"));txtnit.setText(rs.getString("emp_nit"));
           txtsueldo.setText(rs.getString("emp_sueldonom"));txtdirec.setText(rs.getString("emp_direccion"));
           itEstado=Integer.parseInt(rs.getString("emp_estatus"));
           itPuesto=Integer.parseInt(rs.getString("pues_codi"));
           itDepartamento=Integer.parseInt(rs.getString("dep_cod"));
           if(itEstado==2){
           chkestado.setSelected(true);
           }else{chkestado.setSelected(false);
           }
           cmbNomPue.setSelectedIndex(itPuesto-1);
           cmbNomDep.setSelectedIndex(itDepartamento-1);
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no registrado.");
            }
            
        }catch (Exception e){
            System.out.println("le dio un Error fatal");
        }
        btnModificar.setVisible(true);
    }//GEN-LAST:event_btnbusActionPerformed

    private void rbtmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtmodificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtmodificarActionPerformed

    private void rbtmodificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtmodificarMouseClicked
        //se ocultan todos y solo se muestran los que se quieren
        Nomostrar();cod.setVisible(true);
        txtCod.setVisible(true);
        btnbus.setVisible(true);        

    }//GEN-LAST:event_rbtmodificarMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int itEstado=0;
        //Codigo que permite actualizar registros en la base de datos
        try {
            if(chkestado.isSelected()){
            itEstado=2;}else{itEstado=1;}
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE `empleados` SET `emp_nombre`='"+txtnombre.getText().trim()+"',`emp_nit`='"+txtnit.getText().trim()+"',`emp_direccion`='"+txtdirec.getText().trim()+"',`dep_cod`='"+cmbCodDep.getSelectedItem()+"',`pues_codi`='"+cmbCodpue.getSelectedItem()+"',`emp_sueldonom`='"+txtsueldo.getText().trim()+"',`emp_estatus`='"+itEstado+"' WHERE emp_codigo='"+stCod+"'");
            pst.executeUpdate();      
            JOptionPane.showMessageDialog(null,"Datos modificados con exito");
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"le dio un Error fatal");
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void rbtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtbuscarActionPerformed

    private void rbtbuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtbuscarItemStateChanged
    }//GEN-LAST:event_rbtbuscarItemStateChanged

    private void btnlistadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistadoActionPerformed
           //Codigo que permite consultar registros en la base de datos
           int x=0,itEstado;//variable para la matriz    
           
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT `emp_codigo`, `emp_nombre`, `emp_nit`, `emp_direccion`, `dep_nombre`, `pues_nombre`, `emp_sueldonom`, `emp_estatus` FROM `empleados`,`departamentos`,`puesto` WHERE empleados.dep_cod=departamentos.dep_codigo AND empleados.pues_codi=puesto.pues_codigo AND departamentos.dep_codigo='"+cmbCodDep.getSelectedItem()+"' ");         
            ResultSet rs = pst.executeQuery();            
             boolean r=rs.next();
                while(r){
                    //se ingresan a la matriz
                   stmtPrincipal[x][0]=rs.getString("emp_codigo");
                   stmtPrincipal[x][1]=rs.getString("emp_nombre");
                   stmtPrincipal[x][2]=rs.getString("emp_nit");
                   stmtPrincipal[x][3]=rs.getString("emp_direccion");
                   stmtPrincipal[x][4]=rs.getString("dep_nombre");
                   stmtPrincipal[x][5]=rs.getString("pues_nombre");
                   stmtPrincipal[x][6]=rs.getString("emp_sueldonom");
                   itEstado=Integer.parseInt(rs.getString("emp_estatus"));
                   if(itEstado==2){stmtPrincipal[x][7]="Activo";}else{stmtPrincipal[x][7]="No activo";}              
                    r=rs.next();  
                    x++;
                }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un Error fatal");
        }
        //codigo para mostrarlo en la matriz
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            stmtPrincipal,
            new String [] {
                "Codigo", "Nombre", "Nit", "Direccion", "Departamento", "Puesto", "Sueldo", "Estado"
            }
        ));
        for(int i=0;i<=24;i++){
        for(int y=0;y<=7;y++){
           stmtPrincipal[i][y]=""; 
        }
        }
    }//GEN-LAST:event_btnlistadoActionPerformed

    private void rbtbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtbuscarMouseClicked
   //se ocultan todos y solo se muestran los que se quieren
        Nomostrar();
    jScrollPane1.setVisible(true);
    ldep.setVisible(true);
    btnlistado.setVisible(true);
    cmbNomDep.setVisible(true);
    cmbNomDep.setSelectedIndex(0);
    }//GEN-LAST:event_rbtbuscarMouseClicked

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        //se cambia de pantalla
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
            java.util.logging.Logger.getLogger(empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnbus;
    private javax.swing.JButton btnlistado;
    private javax.swing.JButton btnregresar;
    private javax.swing.JCheckBox chkestado;
    private javax.swing.JComboBox<String> cmbCodDep;
    private javax.swing.JComboBox<String> cmbCodpue;
    private javax.swing.JComboBox<String> cmbNomDep;
    private javax.swing.JComboBox<String> cmbNomPue;
    private javax.swing.JLabel cod;
    private javax.swing.ButtonGroup grupo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel ld;
    private javax.swing.JLabel ldep;
    private javax.swing.JLabel les;
    private javax.swing.JLabel ln;
    private javax.swing.JLabel lnit;
    private javax.swing.JLabel lp;
    private javax.swing.JLabel lsue;
    private javax.swing.JRadioButton rbtbuscar;
    private javax.swing.JRadioButton rbtingresar;
    private javax.swing.JRadioButton rbtmodificar;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtdirec;
    private javax.swing.JTextField txtnit;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsueldo;
    // End of variables declaration//GEN-END:variables
}
