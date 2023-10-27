package condominio;

import condominio.dao.CondominioDAO;
import condominio.dbConnection.DbConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Main {
    private static final Connection con = DbConnection.getConnection();
    public static void main(String[] args) {

//        try {
//            con = DbConnection.getConnection();
//        } catch (Exception e) {
//            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
//        }

        CondominioDAO condominioDao = new CondominioDAO(con);

        Condominio condominio = iniciaCondominio();
        Condominio condominio2 = iniciaCondominio();
//        dao.insert(con, condominio);
//        dao.insert(con, condominio2);
        System.out.println(condominioDao.findById(4));
        System.out.println(condominioDao.findAll());

//        Administrador administrador = new Administrador("Geraldo Varela", "47988165885", "geraldo.varela@udesc.br", condominio, "83.891.283/0001-36");
//        administrador.calcularAluguelGeral();
//
//        String continuar = "";
//        while(!continuar.equalsIgnoreCase("N")){
//            administrador.adicionarLocatario();
//
//            continuar = JOptionPane.showInputDialog("Dejesa continuar? S/N");
//
//        }
//
//        JOptionPane.showMessageDialog(null, condominio);
//
//        administrador.definirNovasTaxas();
//
//        JOptionPane.showMessageDialog(null, condominio);

        DbConnection.closeConnection(con);
    }
    
    //Métodos dev - serão excluídos assim que não forem mais necessários
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

        apartamentos(bloco1, ap11, ap12, ap13);

        Apartamento ap21 = new Apartamento("21", 80, 1);
        Apartamento ap22 = new Apartamento("22", 80, 1);
        Apartamento ap23 = new Apartamento("23", 90, 2);

        apartamentos(bloco2, ap21, ap22, ap23);

        condominio.setBlocos(blocos);

        return condominio;
    }

    private static void apartamentos(Bloco bloco, Apartamento ap1, Apartamento ap2, Apartamento ap3) {
        Apartamento[] apartamentosBloco1Array = {ap1, ap2, ap3};
        ArrayList<Apartamento> apartamentosBloco = new ArrayList<>(Arrays.asList(apartamentosBloco1Array));
        bloco.setApartamentos(apartamentosBloco);
    }

}