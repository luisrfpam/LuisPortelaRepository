/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tbshift")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Tbshift.LISTAR_DESTAQUES , query = "SELECT t FROM Tbshift t"),
    @NamedQuery(name = "Tbshift.findById", query = "SELECT t FROM Tbshift t WHERE t.id = :id"),
    @NamedQuery(name = Tbshift.FIND_BY_DESCRIPTION, query = "SELECT t FROM Tbshift t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Tbshift.findByHrInicio", query = "SELECT t FROM Tbshift t WHERE t.hrInicio = :hrInicio"),
    @NamedQuery(name = "Tbshift.findByHrFim", query = "SELECT t FROM Tbshift t WHERE t.hrFim = :hrFim"),
    @NamedQuery(name = "Tbshift.findByQtdMinutosParadas", query = "SELECT t FROM Tbshift t WHERE t.qtdMinutosParadas = :qtdMinutosParadas"),
    @NamedQuery(name = "Tbshift.findByDtCreated", query = "SELECT t FROM Tbshift t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbshift.findByDtModified", query = "SELECT t FROM Tbshift t WHERE t.dtModified = :dtModified")})
public class Tbshift implements Serializable {
    public static final String LISTAR_DESTAQUES = "Tbshift.findAll";
    public static final String FIND_BY_DESCRIPTION = "Tbshift.findByDescricao";
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "hrInicio")
    @Temporal(TemporalType.TIME)
    private Date hrInicio;
    @Column(name = "hrFim")
    @Temporal(TemporalType.TIME)
    private Date hrFim;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qtdMinutosParadas")
    private BigDecimal qtdMinutosParadas;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @OneToMany(mappedBy = "idShift")
    private Set<Tblancamentoshoras> tblancamentoshorasSet;

    public Tbshift() {
    }

    public Tbshift(Long id) {
        this.id = id;
    }

    public Tbshift(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getHrInicio() {
        return hrInicio;
    }

    public void setHrInicio(Date hrInicio) {
        this.hrInicio = hrInicio;
    }

    public Date getHrFim() {
        return hrFim;
    }

    public void setHrFim(Date hrFim) {
        this.hrFim = hrFim;
    }

    public BigDecimal getQtdMinutosParadas() {
        return qtdMinutosParadas;
    }

    public void setQtdMinutosParadas(BigDecimal qtdMinutosParadas) {
        this.qtdMinutosParadas = qtdMinutosParadas;
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
    public Set<Tblancamentoshoras> getTblancamentoshorasSet() {
        return tblancamentoshorasSet;
    }

    public void setTblancamentoshorasSet(Set<Tblancamentoshoras> tblancamentoshorasSet) {
        this.tblancamentoshorasSet = tblancamentoshorasSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbshift)) {
            return false;
        }
        Tbshift other = (Tbshift) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbshift[ id=" + id + " ]";
    }
    
}
