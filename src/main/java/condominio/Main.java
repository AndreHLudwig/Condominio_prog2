package condominio;

import java.sql.Connection;

import condominio.dao.*;
import condominio.dbConnection.DbConnection;
import condominio.service.Service;
import condominio.wrapper.Wrapper;
import condominio.screens.TelaInicial;

public class Main {
    public static void main(String[] args) {
        // Connection
        Connection connection = DbConnection.getConnection();
        // DAOs
        CondominioDAO condominioDao = new CondominioDAO(connection);
        BlocoDAO blocoDAO = new BlocoDAO(connection);
        ApartamentoDAO apartamentoDAO = new ApartamentoDAO(connection);
        PessoaDAO pessoaDAO = new PessoaDAO(connection);
        LocatarioDAO locatarioDAO = new LocatarioDAO(connection);
        AdministradorDAO adminDAO = new AdministradorDAO(connection);
        // Service
        Service service = new Service(condominioDao, blocoDAO, apartamentoDAO, pessoaDAO, locatarioDAO, adminDAO);
        // Wrapper
        Wrapper wrapper = new Wrapper(adminDAO, apartamentoDAO, blocoDAO, condominioDao, locatarioDAO, pessoaDAO, service);
        // Chamar Tela Inicial
        TelaInicial home = new TelaInicial(wrapper);
        // Registrar um ShutdownHook para fechar a conexão ao encerrar o programa
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Encerrando o programa. Fechando a conexão com o banco de dados.");
            DbConnection.closeConnection(connection);
        }));
    }
}