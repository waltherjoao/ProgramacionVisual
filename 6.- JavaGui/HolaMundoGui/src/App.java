import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class App {

    // Declaración de la ventana
    private JFrame ventana;
    // Declaración del botón
    private JButton boton;
    // Declaración del botón
    private JButton botonLimpiar;
    // Declaración del campo de texto
    private JTextField campoTexto;

    public static void main(String[] args) throws Exception {
        new App();
    }

    /* Crear la ventana, inicializa todo los componentes y voy a su vez la pantalla*/
    public App()
    {
        // Nueva ventana.
        ventana = new JFrame("Primera Pantalla Visual");
        ventana.getContentPane().setLayout(new FlowLayout());

        // Se crea el botón y lo agrego a la ventana
        boton = new JButton("Clickeame!!!!");
        ventana.getContentPane().add(boton);

        campoTexto = new JTextField(20);
        ventana.getContentPane().add(campoTexto);

        botonLimpiar = new JButton("Limpiar");
        ventana.getContentPane().add(botonLimpiar);

        // Agregar comportamiento del botón de la ventana
        boton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                campoTexto.setText("Hola Mundo");
            }
        });

        // Agregar comportamiento del botón de la ventana
        botonLimpiar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                campoTexto.setText("");
            }
        });

        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //ventana.pack();
        //ventana.setMinimumSize(new Dimension(400,200));
        ventana.setSize(500,100);

        ventana.setVisible(true);
    }
}
