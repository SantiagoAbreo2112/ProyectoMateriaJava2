package Vista;
import Modelo.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class VentantaPrincipal extends JPanel{
    private JPanel panel;
    private JLabel lblIdPersona, lblNombre, lblApellido, lblDepRes, lblCanHijos, lblFecNacimiento, lblBuscar;
    private JTextField txtIdPersona, txtNombre, txtApellido, txtDepResidencia, txtCantHijos, txtFecNac;
    private JButton btnAgregar, btnCancelar, btnBuscar;
    private JTextArea txtArea1;
    private JComboBox cmbConsulta;
    private JMenu menuSalir;


    private int contadorID = 1;         // variable para control del incremento para el ID de las Personas

    class ImagenFondo extends JPanel{
        @Override
        public void paint (Graphics g){ //Graphics g
            ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/TrueLogo.jpeg")); //.getImage()
            g.drawImage(imagen.getImage(),0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }

    public VentantaPrincipal (){
        JFrame miVentana = new JFrame ("Control de Personas");    // constructor de la ventana, le definimos su título
        ImagenFondo fondo = new ImagenFondo();
        //panel = new ImagenFondo();
        miVentana.setContentPane(panel);                               // agregamos el panel principal a la ventanna
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // indicamos que se cerrará el programa al cliquear la cruz
                                    //miVentana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                                    //cerrar();


        miVentana.setBounds(0,0,700,768);
        //miVentana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //miVentana.pack();                    // pedimos ajustar el tamaño de la ventana a la distribución de los componentes que tengamos
        miVentana.setVisible(true);          // hacemos visible la ventana

        txtIdPersona.setText("1");           // colocamos el id en 1 para comenzár a registrar
        txtNombre.requestFocus();            // hacemos foco en en el JText Nombre
        cmbConsulta.addItem("");             // agregamos el primer lugar del combo vacío para poder mostrarlo así, para cuando contenga IDs
        ArrayList<Persona> guardoPersonas = new ArrayList<>();  // constructor del ArrayList del tipo Persona




        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {  //throws DateTimeParseException

                try {
                    int auxId = contadorID;
                    String  auxNombre = txtNombre.getText();
                    String auxApellido = txtApellido.getText();
                    String auxDepRes = txtDepResidencia.getText();

                    Byte auxCanHijos = Byte.parseByte(txtCantHijos.getText());     // parseamos el string a byt
                    LocalDate auxFechaNac = null;

                    if(formatearFecha(txtFecNac.getText()) != null) {      // Si el método de formatear la fecha nos arroja null cortamos la ejecución y pedimos se ingrese bien
                        auxFechaNac = formatearFecha(txtFecNac.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "La fecha no es válida.\nIngrésela con formato DD-MM-AAAA","ATENCIÓN", JOptionPane.QUESTION_MESSAGE);
                        txtFecNac.requestFocus();                   // hacemos foco en el JTextField
                        txtFecNac.setSelectionStart(0);             // ubicamos el cursor en el primer lugar
                        txtFecNac.setSelectionEnd(txtFecNac.getText().length());  // seleccionamos desde la posición hasta el total del lenght
                        return;
                    }


                    Persona miPersona = new Persona (auxId, auxNombre, auxApellido, auxDepRes, auxCanHijos, auxFechaNac, null);   // constructor, creamos una nueva instancia del tipo persona

                    miPersona.setIdPersona(auxId);       // mandamos
                    miPersona.setNombre(auxNombre);
                    miPersona.setApellido(auxApellido);
                    miPersona.setDptoResidencia(auxDepRes);
                    miPersona.setCantHijos(auxCanHijos);
                    miPersona.setFechaNac(auxFechaNac);

                    guardoPersonas.add(miPersona);


                    if(txtArea1.getText().equals("")) {     // el condicional sirve para mantener el texto del txtArea1 si contiene texto
                        txtArea1.setText(miPersona.toString());
                    } else {
                        txtArea1.setText(txtArea1.getText() + "\n " + miPersona.toString());   // se asigna lo que contenía txtArea1 y con el \n se hace un salto de línea, luego se agrega el nuevo registro
                    }


                    cmbConsulta.addItem(contadorID);                  // Agregamos el id al combo de consultas

                    contadorID++;          // incremento en 1 el contador id para asignar a un próximo registro

                    limpiarFormulario();     // llamamos al método para limpiar el formulario

                }catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println("Fallo al registrar la persona");
                }
            }
        });

        txtNombre.addKeyListener(new KeyAdapter() {    // CAJA NOMBRE
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER){                 // si doy Enter
                    if(!txtNombre.getText().equals("")) txtApellido.requestFocus();  // si no está vacío pasa el foco al otro text
                }
            }
        });
        txtApellido.addKeyListener(new KeyAdapter() {   // CAJA APELLIDO
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    if(!txtApellido.getText().equals("")) txtDepResidencia.requestFocus();
                }
            }
        });
        txtDepResidencia.addKeyListener(new KeyAdapter() {  // CAJA DEPARTAMENTO
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    if(!txtDepResidencia.getText().equals("")) txtCantHijos.requestFocus();
                }
            }
        });
        txtCantHijos.addKeyListener(new KeyAdapter() {    // CAJA  HIJOS
            @Override
            public void keyTyped(KeyEvent e)  {
                    super.keyTyped(e);
                    char tecla = e.getKeyChar();        //capturamos la tecla que se presionó
                    //if(txtCantHijos.getText().length()>2) { e.consume(); return;}    // si son más de dos digitos borra la entrada y sale de procedimiento
                    if (Character.isDigit(tecla) || tecla == KeyEvent.VK_BACK_SPACE || tecla == KeyEvent.VK_DELETE || tecla == KeyEvent.VK_ENTER) {
                        if (tecla == KeyEvent.VK_ENTER && !txtCantHijos.getText().equals(""))
                            txtFecNac.requestFocus();  // si se apretó enter y no está vacía se pasa a la Fecha
                    } else {
                        e.consume();                                     // borra el valor apretado por teclado
                        java.awt.Toolkit.getDefaultToolkit().beep();      // hace un beep si se ingresa algo no permitido
                    }


            }
        });

        btnCancelar.addActionListener(new ActionListener() {  // acción para el botón cancelar
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea1.setText("");
                for(int i = 0 ; i < guardoPersonas.size(); i++){
                    if(txtArea1.getText().equals("")) {     // el condicional sirve para mantener el texto del txtArea1 si contiene texto
                        txtArea1.setText(guardoPersonas.get(i).toString());
                    }else{
                        txtArea1.setText(txtArea1.getText() + "\n " + guardoPersonas.get(i).toString());   // se asigna lo que contenía txtArea1 y con el \n se hace un salto de línea, luego se agrega el nuevo registro
                    }
                }
                limpiarFormulario();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cmbConsulta.getSelectedIndex()>0) {
                    for(int i = 0 ; i < guardoPersonas.size(); i++){
                        if(guardoPersonas.get(i).getIdPersona() == cmbConsulta.getSelectedIndex() ){
                            txtArea1.setText("");
                            txtArea1.setText(guardoPersonas.get(i).toString());
                        }
                    }
                }
            }
        });
        txtFecNac.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int tecla = (int) e.getKeyChar();
                if (((tecla >= 48 && tecla <= 57) || (tecla == 45)) || tecla == KeyEvent.VK_BACK_SPACE
                        || tecla == KeyEvent.VK_DELETE || tecla == KeyEvent.VK_ENTER) {
                    if (tecla == KeyEvent.VK_ENTER && !txtFecNac.getText().equals(""))  btnAgregar.requestFocus();
                } else {
                    e.consume();
                    java.awt.Toolkit.getDefaultToolkit().beep();      // hace un beep si se ingresa algo no permitido
                }
            }
        });
        btnAgregar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER) btnAgregar.doClick();
            }
        });
        menuSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        menuSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                confirmarSalir();
            }
        });

    }

    public void confirmarSalir (){
        int boton = JOptionPane.showConfirmDialog(this,"Desea cerrar la aplicación?","CONFIRAMCIÓN",
                JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(boton==JOptionPane.YES_OPTION){
            System.exit(0);  // cerrar la aplicación
        }
    }
    public LocalDate formatearFecha (String fecha) {                  // método que usamos para darle formato a la fecha y contral su ingreso
        DateTimeFormatter miFormatFecha = new DateTimeFormatterBuilder().parseCaseInsensitive()
                .append(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toFormatter();
        try {
            LocalDate miFecha = LocalDate.parse(fecha, miFormatFecha);
            System.out.println(miFecha);
            return miFecha;
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public void limpiarFormulario () {        // método para limpiar el formulario
        txtIdPersona.setText(Integer.toString(contadorID));    // parseamos la variable del contador id para convertirla a String y la ingresamo al text
        txtNombre.setText("");
        txtApellido.setText("");
        txtDepResidencia.setText("");
        txtCantHijos.setText("");
        txtFecNac.setText("");
        txtNombre.requestFocus();
        cmbConsulta.setSelectedItem(0);
    }
}
