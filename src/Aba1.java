import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Aba1 extends JFrame {
    public void exibir() {
        ArrayList<Object> infos = new ArrayList<>();
        // Criação da janela
        JFrame frame = new JFrame("GasteiMuito");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);

        // Criação dos componentes
        JLabel tituloGasteimuito = new JLabel("Gastei Muito");
        tituloGasteimuito.setFont(new Font("Arial", Font.BOLD, 35)); // Configura a fonte e tamanho do texto
        tituloGasteimuito.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza horizontalmente
        tituloGasteimuito.setForeground(Color.red);
        tituloGasteimuito.setBounds(200, 10, 400, 50);

        JPanel telaInicial = new JPanel();
        telaInicial.setLayout(null); // Layout vertical
        telaInicial.setBackground(new Color(255, 192, 203));
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(150, 110, 100, 50);
        JTextField inputNome = new JTextField(0);
        inputNome.setBounds(150, 150, 300, 30);
        JLabel rendaLabel = new JLabel("Renda:");
        rendaLabel.setBounds(150, 210, 100, 50);
        JTextField inputRenda = new JTextField();
        inputRenda.setBounds(150, 250, 300, 30);
        JButton botaoEnviar = new JButton("Enviar");
        botaoEnviar.setBounds(200, 350, 200, 30);

        // Adiciona os componentes ao painel
        telaInicial.add(tituloGasteimuito);
        telaInicial.add(Box.createRigidArea(new Dimension(0, 10)));
        telaInicial.add(nomeLabel);
        telaInicial.add(inputNome);
        telaInicial.add(rendaLabel);
        telaInicial.add(inputRenda);
        telaInicial.add(botaoEnviar);
        // Adiciona o painel à janela
        frame.getContentPane().add(telaInicial);

        // Exibe a janela
        frame.setVisible(true);

        botaoEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = inputNome.getText();
                try {
                    String renda = inputRenda.getText();
                    if (nome.length() != 0 && renda.length() != 0) {
                        float renda_fl = Float.parseFloat(renda);
                        infos.add(nome);
                        infos.add(renda_fl);
                        System.out.println(infos);

                        // Criar e exibir a próxima tela
                        Aba2 aba2 = new Aba2(nome, renda_fl);
                        aba2.exibir();

                        // Fechar a tela atual
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Os campos nome e renda são obrigatórios");
                    }
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "A renda tem que ser um número válido");
                }
            }
        });
    }
}