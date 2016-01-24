/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.controllers;

import br.org.transportar.entities.Tbcustomer;
import br.org.transportar.facade.CustomerFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LUISPORTELA
 */
@ManagedBean(name = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private final String BACK = "";
        
    private Tbcustomer cliente;
    
    private List<Tbcustomer> clientes;
    
    private List<Tbcustomer> clientesPessoasFisicas;
    
    private List<Tbcustomer> clientesPessoasJuridicas;
    
    private CustomerFacade facade;
    
    private String tipoCliente;
    
    @PostConstruct
    public void init() {
        this.facade = new CustomerFacade();
        this.cliente = new Tbcustomer();   
        this.tipoCliente = "F";
    }
    
    public void saveCustomer(Tbcustomer customer){
        
        boolean encontrou = false;
        
        switch (this.tipoCliente) {
            case "F":
                customer.setCnpj(null);
                customer.setNomeFantasia(null);
                customer.setRazaoSocial(null);
                encontrou = this.facade.hasCustomerPF(customer.getCpf());
                break;
            case "J":
                customer.setNomePF(null);
                customer.setCpf(null);
                encontrou = this.facade.hasCustomerPJ(customer.getCnpj());
                break;
        }     
        
        if (!encontrou) {
            facade.saveCustomer(customer);       
            this.cliente = new Tbcustomer();
        }       
        
    }
    
    public void findCustomer(Tbcustomer customer){
        //facade.findCustomer(customer);        
    }
    
    //public String removeCustomer(Tbcustomer customer){
        
    //}

    public Tbcustomer getCliente() {
        return cliente;
    }

    public void setCliente(Tbcustomer cliente) {
        this.cliente = cliente;
    }

    public List<Tbcustomer> getClientes() {
        return this.facade.listCustomers(this.tipoCliente);
    }

    public List<Tbcustomer> getClientesPessoasFisicas() {
        return this.facade.listCustomers("F");
    }

    public void setClientesPessoasFisicas(List<Tbcustomer> clientesPessoasFisicas) {
        this.clientesPessoasFisicas = clientesPessoasFisicas;
    }

    public List<Tbcustomer> getClientesPessoasJuridicas() {
        return this.facade.listCustomers("J");
    }

    public void setClientesPessoasJuridicas(List<Tbcustomer> clientesPessoasJuridicas) {
        this.clientesPessoasJuridicas = clientesPessoasJuridicas;
    }
    
    public void setClientes(List<Tbcustomer> clientes) {
        this.clientes = clientes;
    }

    public CustomerFacade getFacade() {
        return facade;
    }

    public void setFacade(CustomerFacade facade) {
        this.facade = facade;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

}
