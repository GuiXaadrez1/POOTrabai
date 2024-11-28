package view;

import controller.ReservaController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaReserva extends JFrame {
    private final JTextField txtDataReserva;
    private final JTextField txtIdUsuario;
    private final JButton btnSalvar;

    public TelaReserva() {
        setTitle("Cadastro de Reserva");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel lblDataReserva = new JLabel("Data da Reserva (YYYY-MM-DD):");
        txtDataReserva = new JTextField();

        JLabel lblIdUsuario = new JLabel("ID do Usuário:");
        txtIdUsuario = new JTextField();

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dataReserva = txtDataReserva.getText();
                try {
                    int idUsuario = Integer.parseInt(txtIdUsuario.getText());

                    ReservaController controller = new ReservaController();
                    boolean sucesso = controller.cadastrarReserva(dataReserva, idUsuario);

                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "Reserva cadastrada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar reserva.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O ID do usuário deve ser um número inteiro.");
                }
            }
        });

        add(lblDataReserva);
        add(txtDataReserva);
        add(lblIdUsuario);
        add(txtIdUsuario);
        add(new JLabel());
        add(btnSalvar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaReserva tela = new TelaReserva();
            tela.setVisible(true);
        });
    }
}
