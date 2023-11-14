package condominio.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 06985933599
 */
public abstract class Pessoa {
    private int idPessoa;
    private String nome;
    private String telefone;
    private String email;

    public Pessoa(String nome, String telefone, String email) {
        this.idPessoa = 0; //TODO Confirmar: precisamos de construtor onde passamos o id?
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" 
                + "Telefone: " + telefone + "\n" 
                + "E-mail: " + email;
    }
    
}
