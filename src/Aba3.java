import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Aba3 extends tela {
    private ArrayList<ArrayList<Object>> informacoes;
    private String nome;
    private float renda;

    public Aba3(ArrayList<ArrayList<Object>> informacoes , String nome , float renda){
        this.informacoes = informacoes;
        this.nome = nome;
        this.renda = renda;
    }
    // [0]: Nome despesa , [1]: Categoria , [2]: Valor Gasto , [3] : Data_despesa

    public void exibir(){

        String [] colunas = new String[informacoes.size()+1];
        colunas[0]="Despesas/Data";
        for (int i=0 ; i< informacoes.size();i++){



            colunas[i+1]= informacoes.get(i).get(3)+ "";

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


        JTable table_despesa = new JTable(dados,colunas);

        JFrame frame = new JFrame("GasteiMuito");

        frame.add(new JScrollPane(table_despesa));
        frame.setSize(700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);







    }
}
