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
public class Condominio {
    private ArrayList <Bloco> blocos = new ArrayList();
    private String nome;
    private String endereco;
    private double taxaMensalCondominio;
    private double fatorMultiplicadorDeMetragem;
    private double valorVagaGaragem;

    public ArrayList<Bloco> getBlocos() {
        return blocos;
    }

    public void setBlocos(ArrayList<Bloco> blocos) {
        this.blocos = blocos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getTaxaMensalCondominio() {
        return taxaMensalCondominio;
    }

    public void setTaxaMensalCondominio(double taxaMensalCondominio) {
        this.taxaMensalCondominio = taxaMensalCondominio;
    }

    public double getFatorMultiplicadorDeMetragem() {
        return fatorMultiplicadorDeMetragem;
    }

    public void setFatorMultiplicadorDeMetragem(double fatorMultiplicadorDeMetragem) {
        this.fatorMultiplicadorDeMetragem = fatorMultiplicadorDeMetragem;
    }

    public double getValorVagaGaragem() {
        return valorVagaGaragem;
    }

    public void setValorVagaGaragem(double valorVagaGaragem) {
        this.valorVagaGaragem = valorVagaGaragem;
    }
}
