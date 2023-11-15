/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio.wrapper;

import condominio.dao.*;
import condominio.service.*;
/**
 *
 * @author andre
 */
public class Wrapper {
    public AdministradorDAO administradorDAO;
    public ApartamentoDAO apartamentoDAO;
    public BlocoDAO blocoDAO;
    public CondominioDAO condominioDAO;
    public LocatarioDAO locatarioDAO;
    public PessoaDAO pessoaDAO;
    public Service service;
    
    
    public Wrapper(AdministradorDAO administradorDAO, ApartamentoDAO apartamentoDAO, BlocoDAO blocoDAO, CondominioDAO condominioDAO, LocatarioDAO locatarioDAO, PessoaDAO pessoaDAO, Service service) {
        this.administradorDAO = administradorDAO;
        this.apartamentoDAO = apartamentoDAO;
        this.blocoDAO = blocoDAO;
        this.condominioDAO = condominioDAO;
        this.locatarioDAO = locatarioDAO;
        this.pessoaDAO = pessoaDAO;
        this.service = service;
    }

    public AdministradorDAO getAdministradorDAO() {
        return administradorDAO;
    }

    public void setAdministradorDAO(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    public ApartamentoDAO getApartamentoDAO() {
        return apartamentoDAO;
    }

    public void setApartamentoDAO(ApartamentoDAO apartamentoDAO) {
        this.apartamentoDAO = apartamentoDAO;
    }

    public BlocoDAO getBlocoDAO() {
        return blocoDAO;
    }

    public void setBlocoDAO(BlocoDAO blocoDAO) {
        this.blocoDAO = blocoDAO;
    }

    public CondominioDAO getCondominioDAO() {
        return condominioDAO;
    }

    public void setCondominioDAO(CondominioDAO condominioDAO) {
        this.condominioDAO = condominioDAO;
    }

    public LocatarioDAO getLocatarioDAO() {
        return locatarioDAO;
    }

    public void setLocatarioDAO(LocatarioDAO locatarioDAO) {
        this.locatarioDAO = locatarioDAO;
    }

    public PessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }

    public void setPessoaDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
    
}
