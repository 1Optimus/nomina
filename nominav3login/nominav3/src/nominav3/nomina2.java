package nominav3;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 * @author Ricardo perez
 */
public class nomina2 extends javax.swing.JFrame {
 /*declaracion de todas mas matris a usarse, inlcuido matriz de totales*/
    int tam,j1,j;
    double dbTotal=0.0;
    String [][] matPrincipal= new String[25][10];
    String []stDepto=new String[15];
    double [] vectTotal= new double[15];
    public nomina2() {
        initComponents();  
        banco();
        cmbBamCod.setVisible(false);
    }
        public int numerorandom(int n1,int n2){
        //se optienen dos valores para retornar el random
        int rmd;
        rmd=n1+(int)(Math.random()*n2);
        return rmd;
    }
    public void banco(){
        // se obtienen los datos para ingresarlos a los combos
        int x=0;
        this.cmbBamCod.removeAllItems();
        this.cmbBamNom.removeAllItems();
    try{//obtencion de datos
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM `bancos`;");
            ResultSet rs = pst.executeQuery();
            boolean r=rs.next();
            while(r){                
                cmbBamNom.addItem(rs.getString("ban_nombre")+" "+rs.getString("ban_cuenta"));
                cmbBamCod.addItem(rs.getString("ban_codigo"));
                r=rs.next();
                x++;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un Error fatal");
        }
    }
    public void departamentos(){
        // se obtienen los datos para ingresarlos a los combos
        int x=1;
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
    public void codigoauto(){
        //se obtiene el mayor dato para sumarle uno y poder ingresar uno nuevo
      try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            Statement s=con.createStatement();
           String SQL="select count(*) from nominaencabezado";
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
     public void mostrarentabla(){
         //codigo utilizado para mostrar los datos en la tabla,
        tbprincipal.setFont(new java.awt.Font("Dialog", 1, 18)); 
        tbprincipal.setModel(new javax.swing.table.DefaultTableModel(
            matPrincipal,
             new String [] {
                "No.", "Nombre empleado", "Sueldo", "IGSS", "Bonificacion", "Comision", "ISR", "Desc Judicial", "Sueldo liquido", "Departamento"
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
    public void limpiar(){
         // solo limpiamos los vectores y mostramos
        for(int i=0;i<=9;i++){
            for(int j=0;j<=9;j++){
                matPrincipal[i][j]="";
            }
        }
        for(int i=0;i<=5;i++){
            vectTotal[i]=0;
        }       
        //se llama al metodo mostrar
        mostrarentabla();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbprincipal = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbtotal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btninsertar = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btnguar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdtini = new datechooser.beans.DateChooserPanel();
        jdtfin = new datechooser.beans.DateChooserPanel();
        btnregresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbBamCod = new javax.swing.JComboBox<>();
        cmbBamNom = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1535, 616));
        setPreferredSize(new java.awt.Dimension(1535, 616));
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
                false, false, false, false, false, true, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbprincipal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 1090, 190));

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
        jScrollPane2.setViewportView(tbtotal);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 260, 110));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Nomina");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 170, 60));

        btninsertar.setBackground(new java.awt.Color(255, 148, 42));
        btninsertar.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btninsertar.setForeground(new java.awt.Color(190, 243, 85));
        btninsertar.setText("Insertar");
        btninsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btninsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

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
        getContentPane().add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        btnlimpiar.setBackground(new java.awt.Color(255, 148, 42));
        btnlimpiar.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(190, 243, 85));
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, -1));

        btnguar.setBackground(new java.awt.Color(255, 148, 42));
        btnguar.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnguar.setForeground(new java.awt.Color(190, 243, 85));
        btnguar.setText("Guardar");
        btnguar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel7.setText("Fecha  final");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 370, -1, -1));

        jLabel8.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel8.setText("Fecha incio");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, -1, -1));

        jdtini.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(255, 255, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(255, 255, 255),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(255, 255, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(255, 255, 255),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    getContentPane().add(jdtini, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 390, 260));
    getContentPane().add(jdtfin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 260, 390, 260));

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
    getContentPane().add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 290, 60));

    jLabel2.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
    jLabel2.setText("Banco");
    getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, -1, -1));

    cmbBamCod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    getContentPane().add(cmbBamCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 550, -1, -1));

    cmbBamNom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cmbBamNom.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            cmbBamNomItemStateChanged(evt);
        }
    });
    getContentPane().add(cmbBamNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 550, 210, -1));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btninsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarActionPerformed
       // por medio de variables se generan numeros random, para obtener datos, y obtener asi numeros a la azar para llenar la tabla
       limpiar();
        //Codigo que permite consultar registros en la base de datos
        int x=0;//variable para la matriz
       double dbIgss,dbSalario,dbIsr=0.0;
        try{//
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM `empleados`;");
            ResultSet rs = pst.executeQuery();
            boolean r=rs.next();
            while(r){
                if(rs.getString("emp_estatus").equals("2")){
                matPrincipal[x][0]=rs.getString("emp_codigo");
                matPrincipal[x][1]=rs.getString("emp_nombre");
                matPrincipal[x][2]=rs.getString("emp_sueldonom");
                dbIgss=(Double.parseDouble(matPrincipal[x][2]))*0.0483;//calcula el igss
                matPrincipal[x][3]=String.valueOf(dbIgss);
                dbSalario=(Double.parseDouble(matPrincipal[x][2]))*12;//calculo de isr
                if(dbSalario>30000){
                   dbIsr=(dbSalario*0.07)/12;
                 }else{
                    dbIsr=(dbSalario*0.05)/12;
                 }
                   matPrincipal[x][4]=String.valueOf(numerorandom(100,300));
                   matPrincipal[x][5]=String.valueOf(numerorandom(200,300));
                   matPrincipal[x][7]=String.valueOf(numerorandom(50,250));
                 matPrincipal[x][6]=String.valueOf(dbIsr);//se guarda el isr en la matriz
                 matPrincipal[x][9]=rs.getString("dep_cod");
                 x++;}
                r=rs.next();               
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un Error fatal");
        }
         mostrarentabla();
                 departamentos();
    }//GEN-LAST:event_btninsertarActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
          //se hacen las suma del salario liquido y para los totales del departamento, obtiene los valores de la matriz hacia el vector total
        //dependiendo del salario que gana al anio se le saca el porcentaje de isr
        double itSal,itImp,itTotal;
        String datoIg;
        if((matPrincipal[0][1])==null){
        }else{  
          for (int i=0;i<=24;i++){
             if(((String.valueOf(matPrincipal[i][0])).equals(""))||((String.valueOf(matPrincipal[i][0])).equals("null"))){
            }else{
             matPrincipal[i][4]=(String)tbprincipal.getValueAt(i,4);
             matPrincipal[i][5]=(String)tbprincipal.getValueAt(i,5);
             matPrincipal[i][7]=(String)tbprincipal.getValueAt(i,7);  
             }
          }
          //codigo para hacer las sumas de los totales y del vector de totales por departamento
        for(int i=0;i<=24;i++){
            if(((String.valueOf(matPrincipal[i][0])).equals(""))||((String.valueOf(matPrincipal[i][0])).equals("null"))){
            }else{
            itTotal=(Double.parseDouble(matPrincipal[i][2]))-(Double.parseDouble(matPrincipal[i][3]))+(Double.parseDouble(matPrincipal[i][4]))+(Double.parseDouble(matPrincipal[i][5]))-(Double.parseDouble(matPrincipal[i][6]))-(Double.parseDouble(matPrincipal[i][7]));
            matPrincipal[i][8]=String.valueOf(itTotal);
            //suma de los datos por vectores
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
            //suma de todo, para un total
            dbTotal=itTotal+dbTotal;
        }}
      mostrarentabla();              
        }
    }//GEN-LAST:event_btncalcularActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        //se llama al metodo de limpiar tablas, lo cual borra las matrices y limpa la tabla
        limpiar();        
        codigoauto();
        
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnguarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguarActionPerformed
            codigoauto();//codigo para ver cual es el ultimo codigo ingresado
            int itError=1;
            double dbTotales=0.0;
        for(int i=0;i<=14;i++){//verificacion que no este vacio
          if(((String.valueOf(vectTotal[i])).equals(""))||((String.valueOf(vectTotal[i])).equals("null"))||((String.valueOf(vectTotal[i])).equals("0.0"))){
            }else{   
              dbTotales=dbTotales+vectTotal[i];//suma de totales
          }
        }//todas las consultas par aguardar en nomina de talle
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `nominaencabezado` (`nomi_codigo`, `nomi_fechaini`, `nom_fechafin`, `nomi_monto`, `ban_codigo`) VALUES ('"+j1+"', '"+jdtini.getSelection()+"', '"+jdtfin.getSelection()+"', '"+dbTotales+"', '"+cmbBamCod.getSelectedItem()+"');");
            pst.executeUpdate();
            itError=2;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un error "+e);
        }
        for(int i=0;i<=24;i++){
             if(((String.valueOf(matPrincipal[i][0])).equals(""))||((String.valueOf(matPrincipal[i][0])).equals("null"))){
            }else{                 
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");            
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `nominadetalles` (`nomi_codigo`, `emp_codigo`, `con_codigo`, `nomi_total`) VALUES ('"+(j1)+"', '"+(String.valueOf(matPrincipal[i][0]))+"', '1', '"+(String.valueOf(matPrincipal[i][2]))+"');");
            pst.executeUpdate(); 
            itError=2;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un error 1 "+e);
        }
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");            
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `nominadetalles` (`nomi_codigo`, `emp_codigo`, `con_codigo`, `nomi_total`) VALUES ('"+(j1)+"', '"+(String.valueOf(matPrincipal[i][0]))+"', '6', '"+(String.valueOf(matPrincipal[i][3]))+"');");
            pst.executeUpdate();  
            itError=2;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un error 2 "+e);
        }
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");            
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `nominadetalles` (`nomi_codigo`, `emp_codigo`, `con_codigo`, `nomi_total`) VALUES ('"+(j1)+"', '"+(String.valueOf(matPrincipal[i][0]))+"', '2', '"+(String.valueOf(matPrincipal[i][4]))+"');");
            pst.executeUpdate(); 
            itError=2;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un error 3 "+e);
        }
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");            
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `nominadetalles` (`nomi_codigo`, `emp_codigo`, `con_codigo`, `nomi_total`) VALUES ('"+(j1)+"', '"+(String.valueOf(matPrincipal[i][0]))+"', '3', '"+(String.valueOf(matPrincipal[i][5]))+"');");
            pst.executeUpdate(); 
            itError=2;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un error 4 "+e);
        }
         try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");            
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `nominadetalles` (`nomi_codigo`, `emp_codigo`, `con_codigo`, `nomi_total`) VALUES ('"+(j1)+"', '"+(String.valueOf(matPrincipal[i][0]))+"', '4', '"+(String.valueOf(matPrincipal[i][6]))+"');");
            pst.executeUpdate(); 
            itError=2;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un error 5 "+e);
        }
             try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");            
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `nominadetalles` (`nomi_codigo`, `emp_codigo`, `con_codigo`, `nomi_total`) VALUES ('"+(j1)+"', '"+(String.valueOf(matPrincipal[i][0]))+"', '5', '"+(String.valueOf(matPrincipal[i][7]))+"');");
            pst.executeUpdate(); 
            itError=2;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un error 6 "+e);
        }
              try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");            
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `nominadetalles` (`nomi_codigo`, `emp_codigo`, `con_codigo`, `nomi_total`) VALUES ('"+(j1)+"', '"+(String.valueOf(matPrincipal[i][0]))+"', '7', '"+(String.valueOf(matPrincipal[i][8]))+"');");
            pst.executeUpdate();  
            itError=2;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"le dio un error 7 "+e);
        }
             if(itError==1){
             JOptionPane.showMessageDialog(null,"Guardado con exito");
             }
             }             
             
        }
    }//GEN-LAST:event_btnguarActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        //se muestra otra pantalla
        menu pantalla=new menu();
        pantalla.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnregresarActionPerformed

    private void cmbBamNomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBamNomItemStateChanged
                try{ cmbBamCod.setSelectedIndex(cmbBamNom.getSelectedIndex());}
        catch(Exception e){
        }
    }//GEN-LAST:event_cmbBamNomItemStateChanged

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
    private javax.swing.JButton btnguar;
    private javax.swing.JButton btninsertar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JComboBox<String> cmbBamCod;
    private javax.swing.JComboBox<String> cmbBamNom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private datechooser.beans.DateChooserPanel jdtfin;
    private datechooser.beans.DateChooserPanel jdtini;
    private javax.swing.JTable tbprincipal;
    private javax.swing.JTable tbtotal;
    // End of variables declaration//GEN-END:variables
}
