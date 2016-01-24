/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tblancamentoshoras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Tblancamentoshoras.LISTAR_DESTAQUES, query = "SELECT t FROM Tblancamentoshoras t"),
    @NamedQuery(name = "Tblancamentoshoras.findByQtdHorasAtividade", query = "SELECT t FROM Tblancamentoshoras t WHERE t.qtdHorasAtividade = :qtdHorasAtividade"),
    @NamedQuery(name = "Tblancamentoshoras.findById", query = "SELECT t FROM Tblancamentoshoras t WHERE t.id = :id"),
    @NamedQuery(name = "Tblancamentoshoras.findByDtAtividade", query = "SELECT t FROM Tblancamentoshoras t WHERE t.dtAtividade = :dtAtividade"),
    @NamedQuery(name = "Tblancamentoshoras.findByIsImport", query = "SELECT t FROM Tblancamentoshoras t WHERE t.isImport = :isImport")})
public class Tblancamentoshoras implements Serializable {
    public static final String LISTAR_DESTAQUES = "Tblancamentoshoras.findAll";
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qtdHorasAtividade")
    private BigDecimal qtdHorasAtividade;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "dtAtividade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAtividade;
    @Column(name = "isImport")
    private Boolean isImport;
    @JoinColumn(name = "idActivite", referencedColumnName = "id")
    @ManyToOne
    private Tbactivite idActivite;
    @JoinColumn(name = "idProject", referencedColumnName = "id")
    @ManyToOne
    private Tbproject idProject;
    @JoinColumn(name = "idShift", referencedColumnName = "id")
    @ManyToOne
    private Tbshift idShift;
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @ManyToOne
    private Tbuser idUsuario;

    public Tblancamentoshoras() {
    }

    public Tblancamentoshoras(Long id) {
        this.id = id;
    }

    public BigDecimal getQtdHorasAtividade() {
        return qtdHorasAtividade;
    }

    public void setQtdHorasAtividade(BigDecimal qtdHorasAtividade) {
        this.qtdHorasAtividade = qtdHorasAtividade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDtAtividade() {
        return dtAtividade;
    }

    public void setDtAtividade(Date dtAtividade) {
        this.dtAtividade = dtAtividade;
    }

    public Boolean getIsImport() {
        return isImport;
    }

    public void setIsImport(Boolean isImport) {
        this.isImport = isImport;
    }

    public Tbactivite getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(Tbactivite idActivite) {
        this.idActivite = idActivite;
    }

    public Tbproject getIdProject() {
        return idProject;
    }

    public void setIdProject(Tbproject idProject) {
        this.idProject = idProject;
    }

    public Tbshift getIdShift() {
        return idShift;
    }

    public void setIdShift(Tbshift idShift) {
        this.idShift = idShift;
    }

    public Tbuser getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Tbuser idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Tblancamentoshoras)) {
            return false;
        }
        Tblancamentoshoras other = (Tblancamentoshoras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tblancamentoshoras[ id=" + id + " ]";
    }
    
}
