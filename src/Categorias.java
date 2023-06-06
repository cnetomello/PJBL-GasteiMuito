import java.util.*;
public class Categorias {
    private ArrayList<String> categorias;


    public Categorias(){
        categorias = new ArrayList<>();
        categorias.add("Alimentacao");
        categorias.add("Transporte");
        categorias.add("Lazer");
        categorias.add("Saude");
        categorias.add("Outros");
    }

    public ArrayList<String> getCategorias(){
        return categorias;
    }
    public void addCategorias(String nova_cat){
        categorias.add(nova_cat);
    }



}
