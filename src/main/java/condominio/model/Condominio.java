package condominio.model;

import java.util.ArrayList;

public class Condominio {
    private int idCondominio;
    private ArrayList <Bloco> blocos;
    private String nome;
    private String endereco;
    private double taxaMensalCondominio;
    private double fatorMultiplicadorDeMetragem;
    private double valorVagaGaragem;

    public Condominio(String nome, String endereco, double taxaMensalCondominio, double fatorMultiplicadorDeMetragem, double valorVagaGaragem) {
        this.idCondominio = 0; //TODO Confirmar: precisamos de construtor onde passamos o id?
        this.blocos = new ArrayList<Bloco>();
        this.nome = nome;
        this.endereco = endereco;
        this.taxaMensalCondominio = taxaMensalCondominio;
        this.fatorMultiplicadorDeMetragem = fatorMultiplicadorDeMetragem;
        this.valorVagaGaragem = valorVagaGaragem;
    }

    public Condominio() {
        this.blocos = new ArrayList<Bloco>();
    }

    public int getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(int idCondominio) {
        this.idCondominio = idCondominio;
    }

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

    @Override
    public String toString() {
        return "Condominio: "  + nome + "\n" 
                +  "Endereço: " + endereco + "\n"
                +  "Taxa de condomínio: R$ " + taxaMensalCondominio + "\n"
                +  "Valor/M²: R$ " + fatorMultiplicadorDeMetragem + "\n"
                +  "Mensalidade Vaga de Garagem: R$ " + valorVagaGaragem + "\n"
                + "--------" + "\n"
                + blocos;
    }

}
