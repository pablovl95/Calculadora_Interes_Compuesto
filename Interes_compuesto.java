import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraInteresCompuesto {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculadora de Interés Compuesto");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(5, 2));

            JLabel lblDineroInicial = new JLabel("Dinero Inicial:");
            JTextField txtDineroInicial = new JTextField();

            JLabel lblDineroExtraPorAnio = new JLabel("Dinero Extra por Año:");
            JTextField txtDineroExtraPorAnio = new JTextField();

            JLabel lblRentabilidadAnual = new JLabel("Rentabilidad Anual (%):");
            JTextField txtRentabilidadAnual = new JTextField();

            JLabel lblAniosALargoPlazo = new JLabel("Años a Largo Plazo:");
            JTextField txtAniosALargoPlazo = new JTextField();

            JButton btnCalcular = new JButton("Calcular");

            JLabel lblResultado = new JLabel("Dinero Final:");

            btnCalcular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double dineroInicial = Double.parseDouble(txtDineroInicial.getText());
                        double dineroExtraPorAnio = Double.parseDouble(txtDineroExtraPorAnio.getText());
                        double rentabilidadAnual = Double.parseDouble(txtRentabilidadAnual.getText());
                        int aniosALargoPlazo = Integer.parseInt(txtAniosALargoPlazo.getText());

                        double dineroFinal = calcularInteresCompuesto(dineroInicial, dineroExtraPorAnio, rentabilidadAnual, aniosALargoPlazo);

                        lblResultado.setText("Dinero Final: " + String.format("%.2f", dineroFinal));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Por favor, ingresa valores numéricos válidos.");
                    }
                }
            });

            frame.add(lblDineroInicial);
            frame.add(txtDineroInicial);
            frame.add(lblDineroExtraPorAnio);
            frame.add(txtDineroExtraPorAnio);
            frame.add(lblRentabilidadAnual);
            frame.add(txtRentabilidadAnual);
            frame.add(lblAniosALargoPlazo);
            frame.add(txtAniosALargoPlazo);
            frame.add(btnCalcular);
            frame.add(lblResultado);

            frame.pack();
            frame.setVisible(true);
        });
    }

    public static double calcularInteresCompuesto(double dineroInicial, double dineroExtraPorAnio, double rentabilidadAnual, int aniosALargoPlazo) {
        rentabilidadAnual /= 100; // Convertir el porcentaje a decimal
        double saldo = dineroInicial;

        for (int i = 1; i <= aniosALargoPlazo; i++) {
            saldo += dineroExtraPorAnio;
            saldo *= (1 + rentabilidadAnual);
        }

        return saldo;
    }
}
