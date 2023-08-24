package condominio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Condominio condominio = iniciaCondominio();
        Administrador administrador = new Administrador("Geraldo Varela", "47988165885", "geraldo.varela@udesc.br", condominio, "83.891.283/0001-36");
        administrador.calcularNovoAluguelGeral();
        adicionarLocatario(condominio);
    }
    
    public static void adicionarLocatario(Condominio condominio){
        
        String numeroApartamento = JOptionPane.showInputDialog("Informe o número do Apartamento para cadastrar novo Morador");
        //Pegando dados do Locatário;
        
        String nome = JOptionPane.showInputDialog("Digite o nome do Locatário");
        String telefone = JOptionPane.showInputDialog("Digite o telefone do Locatário");
        String email = JOptionPane.showInputDialog("Informe o email do Locatário");
        String cpf = JOptionPane.showInputDialog("Informe o CPF do Locatário");
        Locatario oLocatario = new Locatario(nome, telefone, email, cpf);
        
        //apartamento.setLocatario(oLocatario);
        
        //oLocatario.setApartamento(apartamento);
         
        String sucesso = JOptionPane.showInputDialog("Locatário cadastrado com sucesso!");
    }

    public static Condominio iniciaCondominio(){
        Condominio condominio = new Condominio("Condomínio UDESC", "Rua Dr. Getúlio Vargas, 2822, Bela Vista - Ibirama/SC", 200, 8, 100);
        Bloco bloco1 = new Bloco("Bloco das Camélias", 3, 6);
        Bloco bloco2 = new Bloco("Bloco dos Lírios", 3, 12);

        ArrayList<Bloco> blocos = new ArrayList<>();
        blocos.add(bloco1);
        blocos.add(bloco2);

        Apartamento ap11 = new Apartamento("11", 80, 1);
        Apartamento ap12 = new Apartamento("12", 80, 1);
        Apartamento ap13 = new Apartamento("13", 100, 1);
        Apartamento ap14 = new Apartamento("14", 100, 1);
        Apartamento ap15 = new Apartamento("15", 90, 1);
        Apartamento ap16 = new Apartamento("16", 110, 1);
        Apartamento[] apartamentosBloco1Array = {ap11, ap12, ap13, ap14, ap15, ap16};
        ArrayList<Apartamento> apartamentosBloco1 = new ArrayList<>();
        for(int i = 0; i < apartamentosBloco1Array.length; i++){
            apartamentosBloco1.add(apartamentosBloco1Array[i]);
        }
        bloco1.setApartamentos(apartamentosBloco1);

        Apartamento ap21 = new Apartamento("21", 80, 1);
        Apartamento ap22 = new Apartamento("22", 80, 1);
        Apartamento ap23 = new Apartamento("23", 90, 2);
        Apartamento ap24 = new Apartamento("24", 90, 2);
        Apartamento ap25 = new Apartamento("25", 100, 3);
        Apartamento ap26 = new Apartamento("26", 100, 3);
        Apartamento[] apartamentosBloco2Array = {ap21, ap22, ap23, ap24, ap25, ap26};
        ArrayList<Apartamento> apartamentosBloco2 = new ArrayList<>();
        for(int i = 0; i < apartamentosBloco2Array.length; i++){
            apartamentosBloco2.add(apartamentosBloco2Array[i]);
        }
        bloco2.setApartamentos(apartamentosBloco2);

        condominio.setBlocos(blocos);

        return condominio;
    }

}