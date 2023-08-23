/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio;

/**

 * @author 06985933599
 */
public class CalculadoraAluguel {

    public double calcularNovoAluguel(Condominio condominio, Apartamento apartamento) {
        double novoAluguel = (
                condominio.getTaxaMensalCondominio() +
                        ((apartamento.getMetragem() * condominio.getFatorMultiplicadorDeMetragem()) +
                                apartamento.getVagasDeGaragem() * condominio.getValorVagaGaragem())
        );
        return novoAluguel;
    }

}
