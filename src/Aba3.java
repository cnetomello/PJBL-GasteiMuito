/*import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Aba3 extends tela {
    private ArrayList<ArrayList<Object>> informacoes;
    private String nome;
    private float renda;
    private float total;

    public Aba3(ArrayList<ArrayList<Object>> informacoes , String nome , float renda){
        this.informacoes = informacoes;
        this.nome = nome;
        this.renda = renda;
    }
    // [0]: Nome despesa , [1]: Categoria , [2]: Valor Gasto , [3] : Data_despesa

    public void exibir(){
        total =0;
        String [] colunas = new String[informacoes.size()+1];
        colunas[0]="Despesas/Data";
        for (int i=0 ; i< informacoes.size();i++){



            colunas[i+1]= informacoes.get(i).get(3)+ "";
            total +=  Float.parseFloat( informacoes.get(i).get(2)+"");

        }
        colunas= Arrays.stream(colunas).distinct().toArray(String[]::new);



        Object [][] dados = new String[informacoes.size()][colunas.length];
        for (int i=0; i< dados.length;i++){
            String[] c = new String[colunas.length];
            for (int j =0 ; j<colunas.length;j++){
                if (j==0){
                    c[j]= informacoes.get(i).get(0)+"";
                    continue;
                }

                else if(colunas[j].equals(informacoes.get(i).get(3))){
                    c[j] = informacoes.get(i).get(2)+"";
                }
                else {
                    c[j] = "";
                }
                System.out.println("Infos" + informacoes.get(i).get(3));
                System.out.println("Coluna" + colunas[j]);
                System.out.println(colunas[j].equals(informacoes.get(i).get(3)) );
            }
            dados[i]=c;

        }
        for (int i=0; i< dados.length;i++){

            for (int j =0 ; j<dados[i].length;j++){
                if(dados[i][j]==""){
                    System.out.print(" Vazio ");
                }
                System.out.print(dados[i][j]);
            }
        System.out.println();}

        JLabel Total = new JLabel("TOTAL GASTOS " + total);


        JTable table_despesa = new JTable(dados,colunas);

        JFrame frame = new JFrame("GasteiMuito");

        frame.add(new JScrollPane(table_despesa));
        frame.add(Total);
        frame.setSize(700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);







    }
}
*/
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Aba3 extends tela {
    private ArrayList<ArrayList<Object>> informacoes;
    private String nome;
    private float renda;
    private float total;

    public Aba3(ArrayList<ArrayList<Object>> informacoes, String nome, float renda) {
        this.informacoes = informacoes;
        this.nome = nome;
        this.renda = renda;
    }

    // [0]: Nome despesa, [1]: Categoria, [2]: Valor Gasto, [3]: Data_despesa

    public void exibir() {
        total = 0;
        String[] colunas = new String[informacoes.size() + 1];
        colunas[0] = "Despesas/Data";
        for (int i = 0; i < informacoes.size(); i++) {
            colunas[i + 1] = informacoes.get(i).get(3) + "";
            total += Float.parseFloat(informacoes.get(i).get(2) + "");
        }
        colunas = Arrays.stream(colunas).distinct().toArray(String[]::new);

        Object[][] dados = new String[informacoes.size()][colunas.length];
        for (int i = 0; i < dados.length; i++) {
            String[] c = new String[colunas.length];
            for (int j = 0; j < colunas.length; j++) {
                if (j == 0) {
                    c[j] = informacoes.get(i).get(0) + "";
                    continue;
                } else if (colunas[j].equals(informacoes.get(i).get(3))) {
                    c[j] = informacoes.get(i).get(2) + "";
                } else {
                    c[j] = "";
                }
                System.out.println("Infos" + informacoes.get(i).get(3));
                System.out.println("Coluna" + colunas[j]);
                System.out.println(colunas[j].equals(informacoes.get(i).get(3)));
            }
            dados[i] = c;
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String total_round = decimalFormat.format(total);
        String renda_round = decimalFormat.format(renda);
        String saldo = decimalFormat.format(renda-total);
        JLabel Total = new JLabel("   TOTAL GASTOS " + total_round);
        JLabel Saldo = new JLabel("                                         Saldo : R$ "+ saldo);
        JLabel nome_siu = new JLabel("Nome: " + nome + "                                 ");
        JLabel renda_siu = new JLabel("Renda : R$ " + renda_round);
        JPanel container = new JPanel(new BorderLayout());
        JPanel container_end = new JPanel(new BorderLayout());
        container.setSize(200,100);

        JTable table_despesa = new JTable(dados, colunas);


        JPanel panel = new JPanel(new BorderLayout());
        container_end.add(Total, BorderLayout.LINE_START);
        container_end.add(Saldo, BorderLayout.CENTER);
        panel.add(container_end , BorderLayout.PAGE_END);
        container.add(nome_siu, BorderLayout.LINE_START);
        container.add(renda_siu,BorderLayout.CENTER);
        panel.add(container ,BorderLayout.PAGE_START);
        panel.add(new JScrollPane(table_despesa), BorderLayout.CENTER);


        JFrame frame = new JFrame("GasteiMuito");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
