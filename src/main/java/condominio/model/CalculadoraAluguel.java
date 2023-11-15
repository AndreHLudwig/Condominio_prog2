package condominio.model;

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
