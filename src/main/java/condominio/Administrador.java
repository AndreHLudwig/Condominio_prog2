/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio;

/**
 *
 * @author 06985933599
 */
public class Administrador {
    private Condominio condominio;
    private String cnpj;

    public double nomeDoMetodo(Apartamento apartamento){
        CalculadoraAluguel calculadoraAluguel = new CalculadoraAluguel();
        double novoAluguel = calculadoraAluguel.calcularNovoAluguel(this.condominio, apartamento);
        return novoAluguel;
    }

}
