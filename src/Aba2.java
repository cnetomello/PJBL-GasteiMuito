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

        // criando labels e inputs
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
        // criando tela aba2
        JFrame frame = new JFrame("GasteiMuito");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410, 580);
        frame.setLocationRelativeTo(null);



        JLabel nameLabel = new JLabel("Nome: " + nome);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setBounds(20, 30, 350, 50);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel rendaLabel = new JLabel("Renda: " + renda);
        rendaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        rendaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rendaLabel.setBounds(20, 60, 350, 50);
        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 20));
        botaoSalvar.setForeground(Color.white);
        botaoSalvar.setBackground(Color.green);
        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setFont(new Font("Arial", Font.BOLD, 20));
        botaoContinuar.setForeground(Color.white);
        botaoContinuar.setBackground(Color.blue);
        // adicionando a menubar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Menu");
        JMenuItem editarInfos = new JMenuItem("Editar informações");
        JMenuItem editarCateg = new JMenuItem("Editar categorias");
        JMenuItem resetarInfos = new JMenuItem("Resetar informações");
        menu1.add(editarInfos);
        menu1.add(editarCateg);
        menu1.add(resetarInfos);
        menuBar.add(menu1);
        frame.setJMenuBar(menuBar);


        // posicionando labels e inputs
        despesaLabel.setBounds(50, 120, 150, 30);
        inputDespesa.setBounds(50, 150, 300, 30);
        gastoLabel.setBounds(50, 200, 100, 30);
        inputGasto.setBounds(50, 230, 300, 30);
        categoriaLabel.setBounds(50, 280, 100, 30);
        categoriaComboBox.setBounds(50, 310, 300, 30);
        data_gastoLabel.setBounds(50,360 , 150 ,30);
        data_gasto.setBounds(50, 390 , 300,30);
        botaoSalvar.setBounds(50,450,100,30);
        botaoContinuar.setBounds(200,450,150,30);

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
                        JOptionPane.showMessageDialog(null, "Informações salvas com sucesso.");
                        inputDespesa.setText("");
                        inputGasto.setText("");



                    } else {
                        JOptionPane.showMessageDialog(null, "Os campos devem estar preenchidos");
                    }
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "A renda deve ser um número válido");
                }
            }});

            // criando panel da aba2
                JPanel telaSeguinte = new JPanel();
        telaSeguinte.setBackground(new Color(255, 192, 203));
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


        frame.getContentPane().

            add(telaSeguinte);

            // exibindo a tela
        frame.setVisible(true);

    }
    }
