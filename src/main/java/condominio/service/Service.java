package condominio.service;

import condominio.dao.*;
import condominio.model.*;

import java.util.ArrayList;

public class Service {
    private CondominioDAO condominioDAO;
    private BlocoDAO blocoDAO;
    private ApartamentoDAO apartamentoDAO;
    private PessoaDAO pessoaDAO;
    private LocatarioDAO locatarioDAO;
    private AdministradorDAO adminDAO;

    public Service(CondominioDAO condominioDAO, BlocoDAO blocoDAO, ApartamentoDAO apartamentoDAO, PessoaDAO pessoaDAO, LocatarioDAO locatarioDAO, AdministradorDAO adminDAO) {
        this.condominioDAO = condominioDAO;
        this.blocoDAO = blocoDAO;
        this.apartamentoDAO = apartamentoDAO;
        this.pessoaDAO = pessoaDAO;
        this.locatarioDAO = locatarioDAO;
        this.adminDAO = adminDAO;
    }

    public Condominio getCondominioCompleto(int idCondominio) {
        Condominio condominio = condominioDAO.findById(idCondominio); // Encontra o Apartamento
        ArrayList<Bloco> blocos = blocoDAO.findByCondominio(condominio); // Encontra os blocos deste condomínio
        for (Bloco bloco : blocos) { // Para cada bloco na lista acima,

            ArrayList<Apartamento> apartamentos = apartamentoDAO.findByBloco(bloco); // (1.1) Encontra a lista de apartamentos

            for (Apartamento apartamento : apartamentos) { // (1.2) Para cada apartamento da lista acima, encontra o locatário
                apartamento.setLocatario(locatarioDAO.findByApartamento(apartamento)); // (1.2.1) vincula o locatário ao apartamento
                apartamento.getLocatario().setApartamento(apartamento); // (1.2.2) vincula o apartamento ao locatário
            }

            bloco.setApartamentos(apartamentos); //(1.3) Define a lista de apartamentos com seus locatários para cada bloco
        }
        condominio.setBlocos(blocos);
        return condominio;
    }

    public Locatario insertPessoaLocatario(Locatario locatario, Apartamento apartamento) {
        pessoaDAO.insert(locatario); // internamente seta idPessoa
        locatarioDAO.insert(locatario, apartamento);
        return locatario;
    }

    public Administrador insertPessoaAdministrador(Administrador administrador, Condominio condominio) {
        pessoaDAO.insert(administrador);
        adminDAO.insert(administrador, condominio);
        return administrador;
    }

}
