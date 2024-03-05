package condominio.model;

public class Apartamento {
    private int idApartamento;
    private String numero;
    private Locatario locatario;
    private double metragem;
    private int vagasDeGaragem;
    private double valorAluguel;

    public Apartamento(String numero, double metragem, int vagasDeGaragem) {
        this.idApartamento = 0; //TODO Confirmar: precisamos de construtor onde passamos o id?
        this.numero = numero;
        this.metragem = metragem;
        this.vagasDeGaragem = vagasDeGaragem;
        this.valorAluguel = 0;

    }
    
    public Apartamento() {

    }

    public int getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(int idApartamento) {
        this.idApartamento = idApartamento;
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
