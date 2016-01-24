/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tbactivite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Tbactivite.LISTAR_DESTAQUES, query = "SELECT t FROM Tbactivite t"),
    @NamedQuery(name = "Tbactivite.findById", query = "SELECT t FROM Tbactivite t WHERE t.id = :id"),
    @NamedQuery(name = "Tbactivite.findByDescricao", query = "SELECT t FROM Tbactivite t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Tbactivite.findByDtCreated", query = "SELECT t FROM Tbactivite t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbactivite.findByDtModified", query = "SELECT t FROM Tbactivite t WHERE t.dtModified = :dtModified")})
public class Tbactivite implements Serializable {
    public static final String LISTAR_DESTAQUES = "Tbactivite.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @OneToMany(mappedBy = "idActivite")
    private Set<Tblancamentoshoras> tblancamentoshorasSet;

    public Tbactivite() {
    }

    public Tbactivite(Long id) {
        this.id = id;
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
        if (!(object instanceof Tbactivite)) {
            return false;
        }
        Tbactivite other = (Tbactivite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbactivite[ id=" + id + " ]";
    }
    
}
