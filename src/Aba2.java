import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;

class Aba2 extends tela {
    private String nome;
    private float renda;
    private ArrayList <ArrayList<Object>> informacoes = new ArrayList<>();
    private Date date = new Date();
    private SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
    private float total_gastos =0;



    private JLabel despesaLabel;
    private JTextField inputDespesa;
    private JLabel gastoLabel;
    private JTextField inputGasto;
    private JLabel categoriaLabel;
    private JComboBox<String> categoriaComboBox;
    private JLabel data_gastoLabel;
    private JFormattedTextField data_gasto;
    static Categorias c = new Categorias();

    public Aba2(String nome, float renda) {
        this.nome = nome;
        this.renda = renda;

        // criando labels e inputs
        despesaLabel = new JLabel("Nome da Despesa:");
        inputDespesa = new JTextField();
        gastoLabel = new JLabel("Valor Gasto:");
        inputGasto = new JTextField();
        categoriaLabel = new JLabel("Categoria:");
        ;
        data_gastoLabel = new JLabel("Data do Gasto:");
        data_gasto = new JFormattedTextField("dd/MM/yyyy");

    }

    public void exibir() {
        // criando tela aba2
        JFrame frame = new JFrame("GasteiMuito");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410, 580);
        frame.setLocationRelativeTo(null);



        String[] categorias = Arrays.stream(c.getCategorias().toArray())
                .map(Object::toString)
                .toArray(String[]::new);
        categoriaComboBox = new JComboBox<>(categorias);
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
        JMenuItem editarCateg = new JMenuItem("Adicionar categorias");
        menu1.add(editarCateg);
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


        editarCateg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JFrame frame = new JFrame("GasteiMuito");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(410, 580);
                frame.setLocationRelativeTo(null);
                JLabel nova_categoria = new JLabel("Nova Categoria :");
                nova_categoria.setBounds(50,250 , 200 ,30);
                JTextField nova_cat = new JTextField();
                nova_cat.setBounds(50,290,300,30);
                JButton Adicionar = new JButton("Adicionar");
                Adicionar.setFont(new Font("Arial", Font.BOLD, 15));
                Adicionar.setForeground(Color.white);
                Adicionar.setBackground(Color.green);
                Adicionar.setBounds(30 , 340 , 150 , 20);
                JButton Voltar = new JButton("Voltar");
                Voltar.setFont(new Font("Arial", Font.BOLD, 15));
                Voltar.setForeground(Color.white);
                Voltar.setBackground(Color.red);
                Voltar.setBounds(190 , 340 , 150 , 20);

                Adicionar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(nova_cat.getText().length() ==0){
                            JOptionPane.showMessageDialog(null, "O campo nao pode ser vazio.");
                        }
                        else{
                            c.addCategorias(nova_cat.getText());
                            System.out.println(c.getCategorias());
                            frame.dispose();
                            Aba2 aba2 = new Aba2(nome,renda);
                            aba2.exibir();
                        }





                    }});

                Voltar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       frame.dispose();
                        Aba2 aba2 = new Aba2(nome,renda);
                        aba2.exibir();






                    }});


                JPanel addCategoria = new JPanel();
                addCategoria.setLayout(null);
                addCategoria.add(nova_categoria);
                addCategoria.add(nova_cat);
                addCategoria.add(Adicionar);
                addCategoria.add(Voltar);
                frame.getContentPane().

                        add(addCategoria);

                // exibindo a tela
                frame.setVisible(true);






            }
        });

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = inputDespesa.getText();
                String categoria = (String) categoriaComboBox.getSelectedItem();
                ArrayList<Object> infos = new ArrayList<>();






                try {

                    date = formatar.parse(data_gasto.getText());
                    String gasto = inputGasto.getText();
                    total_gastos += Float.parseFloat(gasto);
                    System.out.println("Gastos Total =" + total_gastos);
                    if (nome.length() != 0 && gasto.length() != 0 && renda >= Float.parseFloat(gasto) && total_gastos<=renda) {

                        float gasto_fl = Float.parseFloat(gasto);
                        infos.add(nome);
                        infos.add(categoria);
                        infos.add(gasto);
                        infos.add(formatar.format(date));
                        informacoes.add(infos);
                        System.out.println(informacoes); // pra mostrar o armazenamento pra professora
                        JOptionPane.showMessageDialog(null, "Informações salvas com sucesso.");
                        inputDespesa.setText("");
                        inputGasto.setText("");
                        data_gasto.setText("dd/MM/yyyy");



                    }
                    else if(renda < Float.parseFloat(gasto)){
                        JOptionPane.showMessageDialog(null, "O gasto nao pode ser maior do que a renda.");
                        total_gastos -= Float.parseFloat(gasto);
                    }
                    else if(total_gastos > renda){
                        JOptionPane.showMessageDialog(null, "O total de gastos nao podem ser maior do que a renda. Total Gastos = " +total_gastos);
                        total_gastos -= Float.parseFloat(gasto);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Os campos devem estar preenchidos");
                        total_gastos -= Float.parseFloat(gasto);
                    }
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "A renda deve ser um número válido");
                }
                catch (ParseException data_error){
                    JOptionPane.showMessageDialog(null, "Data errada (dd/MM/yyyy)");
                }
            }});

        botaoContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if(informacoes.size() == 0){
                     try {
                         throw new myException();
                     }
                catch (myException c) {
                    JOptionPane.showMessageDialog(null, "Voce deve lancar no minimo uma despesa");
                }}
                else{
                    Aba3 aba3 = new Aba3(informacoes , nome ,renda);
                    aba3.exibir();
                    frame.dispose();
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
