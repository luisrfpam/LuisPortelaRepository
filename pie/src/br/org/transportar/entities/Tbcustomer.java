/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tbcustomer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Tbcustomer.LISTAR_DESTAQUES, query = "SELECT t FROM Tbcustomer t"),
    @NamedQuery(name = Tbcustomer.LISTAR_PESSOA_FISICA, query = "SELECT t FROM Tbcustomer t WHERE t.cpf IS NOT NULL"),
    @NamedQuery(name = Tbcustomer.LISTAR_PESSOA_JURIDICA, query = "SELECT t FROM Tbcustomer t WHERE t.cnpj IS NOT NULL"),
    @NamedQuery(name = "Tbcustomer.findById", query = "SELECT t FROM Tbcustomer t WHERE t.id = :id"),
    @NamedQuery(name = "Tbcustomer.findByNomePF", query = "SELECT t FROM Tbcustomer t WHERE t.nomePF = :nomePF"),
    @NamedQuery(name = Tbcustomer.FIND_BY_CPF, query = "SELECT t FROM Tbcustomer t WHERE t.cpf = :cpf"),
    @NamedQuery(name = "Tbcustomer.findByRazaoSocial", query = "SELECT t FROM Tbcustomer t WHERE t.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Tbcustomer.findByNomeFantasia", query = "SELECT t FROM Tbcustomer t WHERE t.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = Tbcustomer.FIND_BY_CNPJ, query = "SELECT t FROM Tbcustomer t WHERE t.cnpj = :cnpj"),
    @NamedQuery(name = "Tbcustomer.findByDtCreated", query = "SELECT t FROM Tbcustomer t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbcustomer.findByDtModified", query = "SELECT t FROM Tbcustomer t WHERE t.dtModified = :dtModified")})
public class Tbcustomer implements Serializable {
    public static final String LISTAR_DESTAQUES = "Tbcustomer.findAll";
    public static final String LISTAR_PESSOA_FISICA = "Tbcustomer.findAllPessoaFisica";
    public static final String LISTAR_PESSOA_JURIDICA = "Tbcustomer.findAllPessoaJuridica";
    public static final String FIND_BY_CPF = "Tbcustomer.findByCpf";
    public static final String FIND_BY_CNPJ = "Tbcustomer.findByCnpj";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "nomePF")
    private String nomePF;
    @Size(max = 45)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 255)
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Size(max = 255)
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Size(max = 45)
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCustomer")
    private Set<Tbcontract> tbcontractSet;

    public Tbcustomer() {
    }

    public Tbcustomer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePF() {
        return nomePF;
    }

    public void setNomePF(String nomePF) {
        this.nomePF = nomePF;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public Date getDtModified() {
        return dtModified;
    }

    public void setDtModified(Date dtModified) {
        this.dtModified = dtModified;
    }

    @XmlTransient
    public Set<Tbcontract> getTbcontractSet() {
        return tbcontractSet;
    }

    public void setTbcontractSet(Set<Tbcontract> tbcontractSet) {
        this.tbcontractSet = tbcontractSet;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tbcustomer other = (Tbcustomer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbcustomer[ id=" + id + " ]";
    }
    
}
