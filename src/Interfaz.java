import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;

public class Interfaz extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JTextField fieldIPV4;
    private JTextField fieldIPV6;
    private JTextArea areaIPV4;
    private JTextArea areaIPV6;
    private JButton btnIpv4;
    private JButton btnIpv6;
    private JTextField fieldN;
    private JTextField fieldR;
    private JTextArea areaCombinacion;
    private JButton btnCombinacion;
    private JButton LIMPIARButton;
    private JButton LIMPIARButton1;
    private JButton LIMPIARButton2;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton btnAceptar;
    private JButton LIMPIARButton3;
    private JTextArea textArea1;
    private JComboBox comboBox2;
    private Conversion convertir = new Conversion();

    public Interfaz() {
        btnIpv4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String salida = convertir.ipv4ABinario(fieldIPV4.getText());
                String salida1 = convertir.ipv4AHexa(fieldIPV4.getText());
                areaIPV4.setText("FORMATO BINARIO: "+salida+"\nFORMATO HEXADECIMAL: "+salida1);
            }
        });
        btnIpv6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String salida2 = convertir.ipv6ABinario(fieldIPV6.getText());
                BigInteger salida3 = convertir.ipv6ADecimal(fieldIPV6.getText());
                areaIPV6.setText("FORMATO BINARIO: "+salida2+"\nVALOR DECIMAL: "+salida3);
            }
        });
        btnCombinacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBox2.getSelectedIndex()==0){
                    int resultado = convertir.calcularCombinacionSinRepeticion(Integer.parseInt(fieldN.getText()),
                            Integer.parseInt(fieldR.getText()));
                    areaCombinacion.setText("Combinaciones posibles: "+resultado);

                }else if (comboBox2.getSelectedIndex()==1){
                     int resultado2 = convertir.calcularCombinacionConRepeticion(Integer.parseInt(fieldN.getText()),
                            Integer.parseInt(fieldR.getText()));
                    areaCombinacion.setText("Combinaciones posibles: "+resultado2);

                }

            }

        });


        LIMPIARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldN.setText("");
                fieldR.setText("");
                areaCombinacion.setText("");
            }
        });
        LIMPIARButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldIPV6.setText("");
                areaIPV6.setText("");
            }
        });
        LIMPIARButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldIPV4.setText("");
                areaIPV4.setText("");
            }
        });
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedIndex()==1){
                    int permutacion = convertir.calculatePermutations(Integer.parseInt(textField1.getText()),
                            Integer.parseInt(textField2.getText()));
                    textArea1.setText("Permutaciones posibles: "+permutacion);

                }else if (comboBox1.getSelectedIndex()==0){
                    int permutacion2 = convertir.calculatePermutationsWithRepetition(Integer.parseInt(textField1.getText()),
                            Integer.parseInt(textField2.getText()));
                    textArea1.setText("Permutaciones posibbles: "+permutacion2);

                }
            }
        });
        LIMPIARButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textArea1.setText("");
            }
        });

        fieldIPV6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != ':' && !Character.isAlphabetic(c)) {
                    e.consume(); // No permite ingresar el carácter
                }
            }

        });


        fieldIPV4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume(); // No permite ingresar el carácter
                }
            }
        });

        fieldN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignora la tecla presionada si no es un dígito
                }
            }
        });
        fieldR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignora la tecla presionada si no es un dígito
                }
            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignora la tecla presionada si no es un dígito
                }
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignora la tecla presionada si no es un dígito
                }
            }
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}
