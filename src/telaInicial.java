import javax.swing.*;
import java.awt.*;
public class telaInicial extends JFrame {

    public static void main(String[] args) {
        telaInicial tela = new telaInicial();
        tela.exibir();
    }
    public void exibir(){
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
        tituloGasteimuito.setBounds(200,10,400,50);

        JPanel telaInicial = new JPanel();
        telaInicial.setLayout(null); // Layout vertical
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(150, 110 , 100 ,50);
        JTextField inputNome = new JTextField(0);
        inputNome.setBounds(150,150, 300,30);
        JLabel rendaLabel = new JLabel("Renda:");
        rendaLabel.setBounds(150 ,210 , 100 , 50);
        JTextField inputRenda = new JTextField();
        inputRenda.setBounds(150, 250, 300,30);
        JButton botaoEnviar = new JButton("Enviar");
        botaoEnviar.setBounds(200 , 350, 200 , 30);

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
    }
}

