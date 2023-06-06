import javax.swing.*;
import java.util.ArrayList;

public class Aba3 extends tela {
    private ArrayList<ArrayList<Object>> informacoes;
    private String nome;
    private float renda;

    public Aba3(ArrayList<ArrayList<Object>> informacoes , String nome , float renda){
        this.informacoes = informacoes;
        this.nome = nome;
        this.renda = renda;
    }

    public void exibir(){
        JFrame frame = new JFrame("GasteiMuito");
    }
}
