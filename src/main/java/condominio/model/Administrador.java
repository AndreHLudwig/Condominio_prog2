package condominio.model;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Administrador extends Pessoa {
    private Condominio condominio;
    private String cnpj;

    public Administrador(String nome, String telefone, String email, Condominio condominio, String cnpj) {
        super(nome, telefone, email);
        this.condominio = condominio;
        this.cnpj = cnpj;
    }

    public Administrador(){
        super("","","");
        this.cnpj = "";
        this.condominio = new Condominio();
    }


    public double calcularNovoAluguel(Apartamento apartamento) {
        CalculadoraAluguel calculadoraAluguel = new CalculadoraAluguel();
        double novoAluguel = calculadoraAluguel.calcularNovoAluguel(this.condominio, apartamento);
        return novoAluguel;
    }

    public void calcularAluguelGeral() {
        CalculadoraAluguel calculadoraAluguel = new CalculadoraAluguel();
        ArrayList<Bloco> blocos = this.condominio.getBlocos();
        for (Bloco bloco : blocos) {
            for (Apartamento apartamento : bloco.getApartamentos()) {
                apartamento.setValorAluguel(calcularNovoAluguel(apartamento));
            }
        }
    }

    public void definirNovasTaxas() {
        double txMensal = this.condominio.getTaxaMensalCondominio();
        double multiplicador = this.condominio.getFatorMultiplicadorDeMetragem();
        double valorGaragem = this.condominio.getValorVagaGaragem();
        String opcao = "";

        do {
            opcao = JOptionPane.showInputDialog("1 - Aumentar Taxa Mensal do Condomínio em 5%\n" + "2 - Aumentar Fator Multiplicador de Metragem em R$ 1,00\n" + "3 - Aumentar Mensalidade de Vaga de Garagem em R$ 10,00\n" + "Qualquer outra tecla - Sair\n");
            if (opcao.equalsIgnoreCase("1")) {
                this.condominio.setTaxaMensalCondominio(txMensal * 1.05);
            }
            if (opcao.equalsIgnoreCase("2")) {
                this.condominio.setFatorMultiplicadorDeMetragem(multiplicador + 1);
            }
            if (opcao.equalsIgnoreCase("3")) {
                this.condominio.setValorVagaGaragem(valorGaragem + 10.0);
            }
        } while (opcao.equalsIgnoreCase("1") | opcao.equalsIgnoreCase("2") | opcao.equalsIgnoreCase("3"));
        calcularAluguelGeral();
        JOptionPane.showMessageDialog(null, "Valores reajustados com sucesso!");
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

    public void adicionarLocatario() {
        String numeroApartamento = "";
        Apartamento apartamento = new Apartamento();
        boolean apartamentoEncontrado = false;

        while (!apartamentoEncontrado) {
            numeroApartamento = JOptionPane.showInputDialog("Informe o número do Apartamento para cadastrar novo Morador ou FIM para sair!");
            if (numeroApartamento.equalsIgnoreCase("FIM")) {
                break;
            } else {
                for (Bloco blocoAtual : this.condominio.getBlocos()) {
                    for (Apartamento apartamentoAtual : blocoAtual.getApartamentos()) {
                        if (numeroApartamento.equals(apartamentoAtual.getNumero())) {
                            apartamento = apartamentoAtual;
                            apartamentoEncontrado = true;
                            break;
                        }
                    }
                }

                if (!apartamentoEncontrado) {
                    JOptionPane.showMessageDialog(null, "Apartamento não encontrado");
                }

                //Pegando dados do Locatário;
                String nome = JOptionPane.showInputDialog("Digite o nome do Locatário");
                String telefone = JOptionPane.showInputDialog("Digite o telefone do Locatário");
                String email = JOptionPane.showInputDialog("Informe o email do Locatário");
                String cpf = JOptionPane.showInputDialog("Informe o CPF do Locatário");
                Locatario locatario = new Locatario(nome, telefone, email, cpf);

                apartamento.setLocatario(locatario);

                locatario.setApartamento(apartamento);

                JOptionPane.showMessageDialog(null, "Locatário cadastrado com sucesso!");
            }
        }
    }

    @Override
    public String toString() {
        String pessoa = super.toString();
        return "Administrador:" + "\n" +
                pessoa + "\n"
                + "CNPJ: " + cnpj;
    }


}
