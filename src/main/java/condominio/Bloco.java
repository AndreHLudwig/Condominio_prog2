/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio;

import java.util.ArrayList;

/**
 *
 * @author 06985933599
 */
public class Bloco {
     private ArrayList <Apartamento> apartamentos;
     private String nome;
     private int andares;
     private int vagasDeGaragem;

     public Bloco(String nome, int andares, int vagasDeGaragem) {
          this.apartamentos = new ArrayList<Apartamento>();
          this.nome = nome;
          this.andares = andares;
          this.vagasDeGaragem = vagasDeGaragem;
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
