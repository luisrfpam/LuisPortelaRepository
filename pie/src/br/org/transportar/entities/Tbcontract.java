/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tbcontract")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Tbcontract.LISTAR_DESTAQUES, query = "SELECT t FROM Tbcontract t"),
    @NamedQuery(name = "Tbcontract.findById", query = "SELECT t FROM Tbcontract t WHERE t.id = :id"),
    @NamedQuery(name = "Tbcontract.findByDtInicio", query = "SELECT t FROM Tbcontract t WHERE t.dtInicio = :dtInicio"),
    @NamedQuery(name = "Tbcontract.findByDtFim", query = "SELECT t FROM Tbcontract t WHERE t.dtFim = :dtFim"),
    @NamedQuery(name = "Tbcontract.findByValorContrato", query = "SELECT t FROM Tbcontract t WHERE t.valorContrato = :valorContrato"),
    @NamedQuery(name = "Tbcontract.findByDtCreated", query = "SELECT t FROM Tbcontract t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbcontract.findByDtModified", query = "SELECT t FROM Tbcontract t WHERE t.dtModified = :dtModified")})
public class Tbcontract implements Serializable {
    public static final String LISTAR_DESTAQUES = "Tbcontract.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtFim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFim;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorContrato")
    private BigDecimal valorContrato;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @JoinColumn(name = "idCustomer", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tbcustomer idCustomer;
    @OneToMany(mappedBy = "idContract", cascade = CascadeType.ALL)
    private Set<Tbproject> tbprojectSet;

    public Tbcontract() {
    }

    public Tbcontract(Long id) {
        this.id = id;
    }

    public Tbcontract(Long id, Date dtInicio, Date dtFim) {
        this.id = id;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public BigDecimal getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(BigDecimal valorContrato) {
        this.valorContrato = valorContrato;
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

    public Tbcustomer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Tbcustomer idCustomer) {
        this.idCustomer = idCustomer;
    }

    @XmlTransient
    public Set<Tbproject> getTbprojectSet() {
        if (this.tbprojectSet == null) {
            this.tbprojectSet = new HashSet<Tbproject>();
        }        
        return tbprojectSet;
    }

    public void setTbprojectSet(Set<Tbproject> tbprojectSet) {
        this.tbprojectSet = tbprojectSet;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Tbcontract other = (Tbcontract) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }    

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbcontract[ id=" + id + " ]";
    }
    
    public void adicionaProjetos(Tbproject project){   
        this.getTbprojectSet().add(project);
        project.setIdContract(this);
    }
    
    public void removeProjetos(Tbproject project){ 
        if (this.getTbprojectSet() != null) {
            if (!this.getTbprojectSet().isEmpty()) {
                this.getTbprojectSet().remove(project);
                project.setIdContract(null);        
            } 
        }               
    }
    
}
