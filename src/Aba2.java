import javax.swing.*;
import java.awt.*;

class Aba2 extends Aba1 {
    private String nome;
    private float renda;

    // Campos extras
    private JLabel despesaLabel;
    private JTextField inputDespesa;
    private JLabel gastoLabel;
    private JTextField inputGasto;
    private JLabel categoriaLabel;
    private JComboBox<String> categoriaComboBox;

    public Aba2(String nome, float renda) {
        this.nome = nome;
        this.renda = renda;

        // Inicialize os componentes extras
        despesaLabel = new JLabel("Nome da Despesa:");
        inputDespesa = new JTextField();
        gastoLabel = new JLabel("Valor Gasto:");
        inputGasto = new JTextField();
        categoriaLabel = new JLabel("Categoria:");
        String[] categorias = {"Alimentação", "Transporte", "Lazer", "Saúde", "Outros"};
        categoriaComboBox = new JComboBox<>(categorias);
    }

    public void exibir() {
        // Criação da janela da tela seguinte
        JFrame frame = new JFrame("GasteiMuito");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410, 600);
        frame.setLocationRelativeTo(null);

        // Criação dos componentes da tela seguinte
        JLabel nameLabel = new JLabel("Nome: " + nome);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setBounds(20, 50, 350, 50);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel rendaLabel = new JLabel("Renda " + renda);
        rendaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        rendaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rendaLabel.setBounds(20, 80, 350, 50);

        // Posicionamento dos componentes extras
        despesaLabel.setBounds(50, 150, 150, 30);
        inputDespesa.setBounds(50, 190, 300, 30);
        gastoLabel.setBounds(50, 230, 100, 30);
        inputGasto.setBounds(50, 270, 300, 30);
        categoriaLabel.setBounds(50, 310, 100, 30);
        categoriaComboBox.setBounds(50, 350, 300, 30);

        // Adicione os componentes extras ao painel
        JPanel telaSeguinte = new JPanel();
        telaSeguinte.setLayout(null); // Layout vertical
        telaSeguinte.add(nameLabel);
        telaSeguinte.add(rendaLabel);
        telaSeguinte.add(despesaLabel);
        telaSeguinte.add(inputDespesa);
        telaSeguinte.add(gastoLabel);
        telaSeguinte.add(inputGasto);
        telaSeguinte.add(categoriaLabel);
        telaSeguinte.add(categoriaComboBox);

        // Adiciona o componente à janela
        frame.getContentPane().add(telaSeguinte);

        // Exibe a janelax
        frame.setVisible(true);
    }
}