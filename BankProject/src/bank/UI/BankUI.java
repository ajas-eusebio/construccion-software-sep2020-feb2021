package bank.UI;

import bank.controller.BankTextController;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BankUI extends JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();

    public BankUI() {
	initComponents();
	setVisible(true);
	setLocationRelativeTo(null);
	setTitle("Proyecto Banco");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBanco = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Banco");
        setMaximumSize(new java.awt.Dimension(530, 490));
        setMinimumSize(new java.awt.Dimension(530, 490));
        setPreferredSize(new java.awt.Dimension(530, 490));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 50));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jButton1, gridBagConstraints);

        jLabel2.setText("Llave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Llave = Nombre + Apellido (Separados por guión bajo)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jTextField1, gridBagConstraints);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        tablaBanco.setModel(modelo);
        jScrollPane1.setViewportView(tablaBanco);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Proyecto Banco");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo que corre al presionar el boton. Busca un elemento en un Hashtable,
    //y lo coloca en una tabla
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	// TODO add your handling code here:
	String key;
	key = jTextField1.getText();
	BankTextController control = new BankTextController();
	//Llama a la funcion de controller que busca el elemento en el HashTable
	String[][] table = control.getHashTable(key);
	//Si el elemento existe, lo coloca en la tabla
	if (table != null)
	    cargarModeloTabla(table);
	//Si el elemento no existe, crea una ventana mostrando que el elemento no existe
	else
	    JOptionPane.showMessageDialog(this, "Key not found", "Error", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    //Este metodo carga el modewlo la tabla
    public void cargarModeloTabla(String[][] lista) {
	/*
        Cuando un JScrollPane contiene a un JTable, se pueden configurar para
        que aparezcan las barras horizontal y vertical del scrollpane,
        sin embargo la barra horizontal no aparece en un primer momento debido
        a que la tabla tiene habilitada la opcion de autoresize. Deshabilitando
        esta opcion, aparecera sin problemas la barra horizontal.
	 */
	BankTextController control = new BankTextController();
	tablaBanco.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tablaBanco.doLayout();

	//obtener nombres
	String nombres[] = control.getHeader();
	modelo.addColumn(nombres[0]);
	modelo.addColumn(nombres[1]);
	modelo.addColumn(nombres[2]);

	//Funcion que retornara la matriz de strings para actualizar la matriz
	int numFilas = lista.length;
	int numcolumnas = 0;
	int valor;
	for (int i = 0; i < numFilas; i++) {
	    valor = lista[i].length;
	    if (valor > numcolumnas)
		numcolumnas = valor;
	}

	//Funcion Para agragar cuentas a las columnas de acuerdo a cuantas columnas se necesitaran
	int totalColumnas = numcolumnas - 3;//Num de columnas que faltan por nombrar
	for (int j = 1; j <= totalColumnas; j++)
	    modelo.addColumn(nombres[3]);
	//funcion para establecer el num de filas que abra en la tabla
	modelo.setNumRows(numFilas);
	//funcion para introducir los valores a la tabla
	numcolumnas = 0;
	for (int i = 0; i < numFilas; i++) {
	    numcolumnas = lista[i].length;
	    for (int j = 0; j < numcolumnas; j++)
		modelo.setValueAt(lista[i][j], i, j);
	}

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaBanco;
    // End of variables declaration//GEN-END:variables

}
