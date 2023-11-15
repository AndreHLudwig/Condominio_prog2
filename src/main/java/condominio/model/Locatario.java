package condominio.model;

public class Locatario extends Pessoa{
    private Apartamento apartamento;
    private String cpf;

    public Locatario(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email);
        this.cpf = cpf;
        this.apartamento = new Apartamento();
    }
    
    public Locatario(){
        super("", "", "");
        this.cpf = "";

    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        String pessoa = super.toString();
        return "Locatario:" + "\n" +
                pessoa + "\n" +
                "CPF: " + cpf;
    }
    
}
