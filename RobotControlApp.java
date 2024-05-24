import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RobotControlApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Control de Robot");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            ControlRobotPanel panel = new ControlRobotPanel();
            frame.add(panel);

            frame.setVisible(true);
        });
    }
}

class ControlRobotPanel extends JPanel {
    private Robot robot;
    private JLabel estadoLabel;
    private JLabel direccionLabel;
    private JButton moverAdelanteButton;
    private JButton moverAtrasButton;
    private JButton girarIzquierdaButton;
    private JButton girarDerechaButton;
    private JButton guardarEstadoButton;
    private JButton cargarEstadoButton;

    public ControlRobotPanel() {
        robot = new Robot();
        setLayout(new BorderLayout());

        estadoLabel = new JLabel("Estado: " + robot.obtenerEstado(), SwingConstants.CENTER);
        add(estadoLabel, BorderLayout.NORTH);

        direccionLabel = new JLabel("Dirección: " + robot.obtenerDireccion(), SwingConstants.CENTER);
        add(direccionLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 2));

        // botones para mover el robot
        moverAdelanteButton = new JButton("Mover Adelante");
        moverAtrasButton = new JButton("Mover Atras");
        girarIzquierdaButton = new JButton("Girar Izquierda");
        girarDerechaButton = new JButton("Girar Derecha");

        // botones para guardar y cargar el estado del robot
        guardarEstadoButton = new JButton("Guardar Estado");
        cargarEstadoButton = new JButton("Cargar Estado");

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == moverAdelanteButton) {
                    robot.moverAdelante();
                    actualizarEstado();
                } else if (e.getSource() == moverAtrasButton) {
                    robot.moverAtras();
                    actualizarEstado();
                } else if (e.getSource() == girarIzquierdaButton) {
                    robot.girarIzquierda();
                    actualizarDireccion();
                } else if (e.getSource() == girarDerechaButton) {
                    robot.girarDerecha();
                    actualizarDireccion();
                } else if (e.getSource() == guardarEstadoButton) {
                    robot.guardarEstado("estado_robot.txt");
                } else if (e.getSource() == cargarEstadoButton) {
                    robot.cargarEstado("estado_robot.txt");
                    actualizarEstado();
                }
            }
        };

        moverAdelanteButton.addActionListener(listener);
        moverAtrasButton.addActionListener(listener);
        girarIzquierdaButton.addActionListener(listener);
        girarDerechaButton.addActionListener(listener);
        guardarEstadoButton.addActionListener(listener);
        cargarEstadoButton.addActionListener(listener);

        buttonPanel.add(moverAdelanteButton);
        buttonPanel.add(moverAtrasButton);
        buttonPanel.add(girarIzquierdaButton);
        buttonPanel.add(girarDerechaButton);
        buttonPanel.add(guardarEstadoButton);
        buttonPanel.add(cargarEstadoButton);

        add(buttonPanel, BorderLayout.CENTER);

        // actualizar el estado inicialmente
        actualizarEstado();
    }

    private void actualizarEstado() {
        estadoLabel.setText("Estado: " + robot.obtenerEstado());
    }

    private void actualizarDireccion() {
        direccionLabel.setText("Dirección: " + robot.obtenerDireccion());
    }
}

class Robot {
    private String estado;
    private String direccion;

    public Robot() {
        this.estado = "parado";
        this.direccion = "norte";
    }

    public String obtenerEstado() {
        return estado;
    }

    public void cambiarEstado(String estado) {
        this.estado = estado;
    }

    public String obtenerDireccion() {
        return direccion;
    }

    public void cambiarDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void moverAdelante() {
        if (estado.equals("parado")) {
            cambiarEstado("avanzando");
        } else if (estado.equals("avanzando")) {
            cambiarEstado("parado");
        }
    }

    public void moverAtras() {
        if (estado.equals("parado")) {
            cambiarEstado("retrocediendo");
        } else if (estado.equals("retrocediendo")) {
            cambiarEstado("parado");
        }
    }

    public void girarIzquierda() {
        switch (direccion) {
            case "norte":
                cambiarDireccion("oeste");
                break;
            case "sur":
                cambiarDireccion("este");
                break;
            case "este":
                cambiarDireccion("norte");
                break;
            case "oeste":
                cambiarDireccion("sur");
                break;
        }
    }

    public void girarDerecha() {
        switch (direccion) {
            case "norte":
                cambiarDireccion("este");
                break;
            case "sur":
                cambiarDireccion("oeste");
                break;
            case "este":
                cambiarDireccion("sur");
                break;
            case "oeste":
                cambiarDireccion("norte");
                break;
        }
    }

    public void guardarEstado(String filePath) {
        //código para guardar el estado del robot
        System.out.println("Guardando estado del robot...");
    }

    public void cargarEstado(String filePath) {
        // código para cargar el estado del robot
        System.out.println("Cargando estado del robot...");
    }
}