package condominio;

import condominio.dao.*;
import condominio.dbConnection.DbConnection;
import condominio.model.Apartamento;
import condominio.model.Bloco;
import condominio.model.Condominio;
import condominio.model.Locatario;
import condominio.service.Service;
import condominio.wrapper.Wrapper;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import screens.TelaInicial;

public class Main {
    public static void main(String[] args) {

//        try {
//            con = DbConnection.getConnection();
//        } catch (Exception e) {
//            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
//        }

        Connection connection = DbConnection.getConnection();

        //DAOs
        CondominioDAO condominioDao = new CondominioDAO(connection);
        BlocoDAO blocoDAO = new BlocoDAO(connection);
        ApartamentoDAO apartamentoDAO = new ApartamentoDAO(connection);
        PessoaDAO pessoaDAO = new PessoaDAO(connection);
        LocatarioDAO locatarioDAO = new LocatarioDAO(connection);
        AdministradorDAO adminDAO = new AdministradorDAO(connection);

        //Service
        Service service = new Service(condominioDao, blocoDAO, apartamentoDAO, pessoaDAO, locatarioDAO, adminDAO);
        
        //Wrapper
        Wrapper wrapper = new Wrapper(adminDAO, apartamentoDAO, blocoDAO, condominioDao, locatarioDAO, pessoaDAO, service);
        
        //TODO Chamar Tela Inicial
        TelaInicial home = new TelaInicial(wrapper);
        
//        Condominio condominio = iniciaCondominio();
//        Bloco bloco = condominio.getBlocos().get(0);
//        condominio.setIdCondominio(2);
//        bloco.setIdBloco(1);
////        ArrayList<Apartamento> apartamentos = bloco.getApartamentos();
////        apartamentoDAO.insert(apartamentos.get(0), bloco);
////        Condominio condominio2 = iniciaCondominio();
//        condominio = service.getCondominioCompleto(2);
////        Condominio condominio2 = service.getCondominioCompleto(2);
////        System.out.println(condominio);
////        System.out.println(condominio2);
//        Locatario locatario = condominio.getBlocos().get(0).getApartamentos().get(0).getLocatario();
//        Apartamento apartamento = condominio.getBlocos().get(0).getApartamentos().get(0);
//
//        service.insertPessoaLocatario(locatario, apartamento);
//        System.out.println(locatario);

//        condominioDao.insert(condominio, null);
//        condominioDao.insert(condominio2, null);
//        Condominio condominio = condominioDao.findById(1);
//        Condominio condominio2 = condominioDao.findById(2);
//        condominio.setIdCondominio(1);
//        condominio.setIdCondominio(2);
//
//        for (Bloco bloco : condominio.getBlocos()) {
//            blocoDAO.insert(bloco, condominio);
//        }
//        for (Bloco bloco : condominio2.getBlocos()) {
//            blocoDAO.insert(bloco, condominio);
//        }

//        System.out.println(condominioDao.findById(4));
//        System.out.println(condominioDao.findAll());

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

//        DbConnection.closeConnection(connection);
    }
    
    //Métodos dev - serão excluídos assim que não forem mais necessários
//    public static Condominio iniciaCondominio(){
//        Condominio condominio = new Condominio("Condomínio UDESC", "Rua Dr. Getúlio Vargas, 2822, Bela Vista - Ibirama/SC", 200, 8, 100);
//        Bloco bloco1 = new Bloco("Bloco das Camélias", 3, 6);
//        Bloco bloco2 = new Bloco("Bloco dos Lírios", 3, 12);
//
//        ArrayList<Bloco> blocos = new ArrayList<>();
//        blocos.add(bloco1);
//        blocos.add(bloco2);
//
//        Apartamento ap11 = new Apartamento("11", 80, 1);
//        Apartamento ap12 = new Apartamento("12", 80, 1);
//        Apartamento ap13 = new Apartamento("13", 100, 1);
//
//        apartamentos(bloco1, ap11, ap12, ap13);
//
//        Apartamento ap21 = new Apartamento("21", 80, 1);
//        Apartamento ap22 = new Apartamento("22", 80, 1);
//        Apartamento ap23 = new Apartamento("23", 90, 2);
//
//        apartamentos(bloco2, ap21, ap22, ap23);
//
//        condominio.setBlocos(blocos);
//
//        return condominio;
//    }

//    private static void apartamentos(Bloco bloco, Apartamento ap1, Apartamento ap2, Apartamento ap3) {
//        Apartamento[] apartamentosBloco1Array = {ap1, ap2, ap3};
//        ArrayList<Apartamento> apartamentosBloco = new ArrayList<>(Arrays.asList(apartamentosBloco1Array));
//        bloco.setApartamentos(apartamentosBloco);
//    }

}