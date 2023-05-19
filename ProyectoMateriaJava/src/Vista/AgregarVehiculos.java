package Vista;

import Modelo.Avion;
import Modelo.Barco;
import Modelo.Persona;
import Modelo.Vehiculo;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AgregarVehiculos {
    private JPanel panel1;
    private JTextField txtID;
    private JTextField txtColor;
    private JTextField txtLongitud;
    private JButton btnBuscar;
    private JTextArea textArea1;
    private JButton btnCancelar;
    private JComboBox cmbConsulta;
    private JButton btnAgregar;
    private JTextField txtNombre;
    private JTextField txtQtPasajeros;
    private JTextField txtEslora;
    private JTextField txtManga;
    private JComboBox comboBox1;

    private int contadorBarcoID = 1; // variable for controlling the increment for the Barco ID
    private int contadorAvionID = 1; // variable for controlling the increment for the Avion ID

    public AgregarVehiculos() {
        JFrame miVentana = new JFrame("Control de Autos");
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.setContentPane();
        miVentana.setBounds(0, 0, 700, 768);
        miVentana.setVisible(true);

        txtID.setText("1");
        txtNombre.requestFocus();
        cmbConsulta.addItem("");

        ArrayList<Vehiculo> guardoAvion = new ArrayList<>();
        ArrayList<Vehiculo> guardoBarco = new ArrayList<>();

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int auxId = contadorAvionID;
                    String auxNombre = txtNombre.getText();
                    String auxColor = txtColor.getText();
                    int auxLongitud = Integer.parseInt(txtLongitud.getText());
                    int auxQtPasajeros = Integer.parseInt(txtQtPasajeros.getText());

                    Avion miAvion = new Avion(auxId, auxNombre, auxColor, auxLongitud, auxQtPasajeros);
                    guardoAvion.add(miAvion);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Failed to register Avion");
                }

                try {
                    int auxId = contadorBarcoID;
                    String auxNombre = txtNombre.getText();
                    String auxColor = txtColor.getText();
                    double auxEslora = Double.parseDouble(txtEslora.getText());
                    double auxManga = Double.parseDouble(txtManga.getText());

                    Barco miBarco = new Barco(auxId, auxNombre, auxColor, auxEslora, auxManga);
                    guardoBarco.add(miBarco);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Failed to register Barco");
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbConsulta.getSelectedIndex() > 0) {
                    for (int i = 0; i < guardoAvion.size(); i++) {
                        if (guardoAvion.get(i).getIdVehiculo() == cmbConsulta.getSelectedIndex()) {
                            textArea1.setText("");
                            textArea1.setText(guardoAvion.get(i).toString());
                        }
                    }
                    for (int i = 0; i < guardoBarco.size(); i++) {
                        if (guardoBarco.get(i).getIdVehiculo() == cmbConsulta.getSelectedIndex()) {
                            textArea1.setText("");
                            textArea1.setText(guardoBarco.get(i).toString());
                        }
                    }
                }
            }
        });

        btnAgregar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    btnAgregar.doClick();
            }
        });
    }

    public void confirmarSalir() {
        int boton = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la aplicación?", "CONFIRMACIÓN",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (boton == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void limpiarFormulario() {
        txtID.setText(Integer.toString(contadorBarcoID));
        txtNombre.setText("");
        txtColor.setText("");
        txtLongitud.setText("");
        txtQtPasajeros.setText("");
        txtEslora.setText("");
        txtManga.requestFocus();
        cmbConsulta.setSelectedIndex(0);
    }
}