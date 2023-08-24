/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio;

/**
 *
 * @author 06985933599
 */
public class Locatario extends Pessoa{
    private Apartamento apartamento;
    private String cpf;

    public Locatario(String nome, String telefone, String email, Apartamento apartamento, String cpf) {
        super(nome, telefone, email);
        this.apartamento = apartamento;
        this.cpf = cpf;
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
}
