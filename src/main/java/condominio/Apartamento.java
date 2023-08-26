/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio;

/**
 *
 * @author 06985933599
 */
public class Apartamento {
    private String numero;
    private Locatario locatario;
    private double metragem;
    private int vagasDeGaragem;
    private double valorAluguel;

    public Apartamento(String numero, double metragem, int vagasDeGaragem) {
        this.numero = numero;
        this.metragem = metragem;
        this.vagasDeGaragem = vagasDeGaragem;
        this.valorAluguel = 0;
        this.locatario = new Locatario();
    }
    
    public Apartamento() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public double getMetragem() {
        return metragem;
    }

    public void setMetragem(double metragem) {
        this.metragem = metragem;
    }

    public int getVagasDeGaragem() {
        return vagasDeGaragem;
    }

    public void setVagasDeGaragem(int vagasDeGaragem) {
        this.vagasDeGaragem = vagasDeGaragem;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    @Override
    public String toString() {
        return "\n          Apto nº: " + numero + "\n" 
                + " Locatário: " + locatario.getNome() + "\t" + "    Metragem: " + metragem + "\n" 
                + " Vagas de Garagem: " + vagasDeGaragem + "\t" + "    Valor do Aluguel: " + valorAluguel + "\n";
    }

}
