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
public class Administrador extends Pessoa{
    private Condominio condominio;
    private String cnpj;

    public Administrador(String nome, String telefone, String email, Condominio condominio, String cnpj) {
        super(nome, telefone, email);
        this.condominio = condominio;
        this.cnpj = cnpj;
    }

    public double calcularNovoAluguel(Apartamento apartamento){
        CalculadoraAluguel calculadoraAluguel = new CalculadoraAluguel();
        double novoAluguel = calculadoraAluguel.calcularNovoAluguel(this.condominio, apartamento);
        return novoAluguel;
    }

    public void calcularNovoAluguelGeral(){
        CalculadoraAluguel calculadoraAluguel = new CalculadoraAluguel();
        ArrayList<Bloco> blocos = this.condominio.getBlocos();
        for(Bloco bloco : blocos){
            for(Apartamento apartamento : bloco.getApartamentos()){
                apartamento.setValorAluguel(calcularNovoAluguel(apartamento));
            }
        }
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
