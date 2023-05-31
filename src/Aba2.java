import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class Aba2 extends Aba1 {
    private String nome;
    private float renda;
    private ArrayList <ArrayList<Object>> informacoes = new ArrayList<>();



    // Campos extras
    private JLabel despesaLabel;
    private JTextField inputDespesa;
    private JLabel gastoLabel;
    private JTextField inputGasto;
    private JLabel categoriaLabel;
    private JComboBox<String> categoriaComboBox;
    private JLabel data_gastoLabel;
    private JFormattedTextField data_gasto;

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
        data_gastoLabel = new JLabel("Data do Gasto:");
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        data_gasto = new JFormattedTextField(df);

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
        JLabel rendaLabel = new JLabel("Renda: " + renda);
        rendaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        rendaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rendaLabel.setBounds(20, 80, 350, 50);
        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 20));
        botaoSalvar.setForeground(Color.white);
        botaoSalvar.setBackground(Color.green);
        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setFont(new Font("Arial", Font.BOLD, 20));
        botaoContinuar.setForeground(Color.white);
        botaoContinuar.setBackground(Color.blue);

        data_gastoLabel.setBounds(50,400 , 150 ,50);


        // Posicionamento dos componentes extras
        despesaLabel.setBounds(50, 150, 150, 30);
        inputDespesa.setBounds(50, 190, 300, 30);
        gastoLabel.setBounds(50, 230, 100, 30);
        inputGasto.setBounds(50, 270, 300, 30);
        categoriaLabel.setBounds(50, 310, 100, 30);
        categoriaComboBox.setBounds(50, 350, 300, 30);
        data_gasto.setBounds(50, 450 , 300,30);
        botaoSalvar.setBounds(30,500,100,30);
        botaoContinuar.setBounds(200,500,150,30);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = inputDespesa.getText();
                String categoria = (String) categoriaComboBox.getSelectedItem();
                ArrayList<Object> infos = new ArrayList<>();
                try {
                    String gasto = inputGasto.getText();
                    if (nome.length() != 0 && gasto.length() != 0) {

                        float gasto_fl = Float.parseFloat(gasto);
                        infos.add(nome);
                        infos.add(categoria);
                        infos.add(gasto);
                        informacoes.add(infos);
                        System.out.println(informacoes); // pra mostrar o armazenamento pra professora
                        JOptionPane.showMessageDialog(null, "Informacoes salvados com sucesso.");
                        inputDespesa.setText("");
                        inputGasto.setText("");



                    } else {
                        JOptionPane.showMessageDialog(null, "Os campos devem estar preenchidos");
                    }
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "A renda tem que ser um número válido");
                }
            }});

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
        telaSeguinte.add(botaoSalvar);
        telaSeguinte.add(botaoContinuar);
        telaSeguinte.add(data_gastoLabel);
        telaSeguinte.add(data_gasto);

            // Adiciona o componente à janela
        frame.getContentPane().

            add(telaSeguinte);

            // Exibe a janelax
        frame.setVisible(true);

    }
    }
