package condominio.model;

import java.util.ArrayList;

public class Bloco {
     private int idBloco;
     private ArrayList <Apartamento> apartamentos;
     private String nome;
     private int andares;
     private int vagasDeGaragem;

     public Bloco(String nome, int andares, int vagasDeGaragem) {
          this.idBloco = 0; //TODO Confirmar: precisamos de construtor onde passamos o id?
          this.apartamentos = new ArrayList<Apartamento>();
          this.nome = nome;
          this.andares = andares;
          this.vagasDeGaragem = vagasDeGaragem;
     }

    public Bloco() {
        this.apartamentos = new ArrayList<Apartamento>();
    }

     public int getIdBloco() {
          return idBloco;
     }

     public void setIdBloco(int idBloco) {
          this.idBloco = idBloco;
     }

     public ArrayList<Apartamento> getApartamentos() {
          return apartamentos;
     }

     public void setApartamentos(ArrayList<Apartamento> apartamentos) {
          this.apartamentos = apartamentos;
     }

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public int getAndares() {
          return andares;
     }

     public void setAndares(int andares) {
          this.andares = andares;
     }

     public int getVagasDeGaragem() {
          return vagasDeGaragem;
     }

     public void setVagasDeGaragem(int vagasDeGaragem) {
          this.vagasDeGaragem = vagasDeGaragem;
     }

    @Override
    public String toString() {
        return    nome + "\n" 
                + "Quant. de Andares: " + andares + "\n" 
                + "Vagas De Garagem: " + vagasDeGaragem + "\n" + "---------------" + "\n"
                + "Apartamentos" + apartamentos+ "\n";
    }
     
}
