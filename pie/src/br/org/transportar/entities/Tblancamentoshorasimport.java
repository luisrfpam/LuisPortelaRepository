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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tblancamentoshorasimport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblancamentoshorasimport.findAll", query = "SELECT t FROM Tblancamentoshorasimport t"),
    @NamedQuery(name = "Tblancamentoshorasimport.findByQtdHorasAtividade", query = "SELECT t FROM Tblancamentoshorasimport t WHERE t.qtdHorasAtividade = :qtdHorasAtividade"),
    @NamedQuery(name = "Tblancamentoshorasimport.findByIdAtividade", query = "SELECT t FROM Tblancamentoshorasimport t WHERE t.idAtividade = :idAtividade"),
    @NamedQuery(name = "Tblancamentoshorasimport.findByDtAtividade", query = "SELECT t FROM Tblancamentoshorasimport t WHERE t.dtAtividade = :dtAtividade"),
    @NamedQuery(name = "Tblancamentoshorasimport.findByIsImport", query = "SELECT t FROM Tblancamentoshorasimport t WHERE t.isImport = :isImport"),
    @NamedQuery(name = "Tblancamentoshorasimport.findByIdUsuario", query = "SELECT t FROM Tblancamentoshorasimport t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "Tblancamentoshorasimport.findByIdActivite", query = "SELECT t FROM Tblancamentoshorasimport t WHERE t.idActivite = :idActivite"),
    @NamedQuery(name = "Tblancamentoshorasimport.findByIdProject", query = "SELECT t FROM Tblancamentoshorasimport t WHERE t.idProject = :idProject")})
public class Tblancamentoshorasimport implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qtdHorasAtividade")
    private BigDecimal qtdHorasAtividade;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAtividade")
    private Long idAtividade;
    @Column(name = "dtAtividade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAtividade;
    @Column(name = "isImport")
    private Boolean isImport;
    @Size(max = 255)
    @Column(name = "idUsuario")
    private String idUsuario;
    @Size(max = 255)
    @Column(name = "idActivite")
    private String idActivite;
    @Size(max = 255)
    @Column(name = "idProject")
    private String idProject;

    public Tblancamentoshorasimport() {
    }

    public Tblancamentoshorasimport(Long idAtividade) {
        this.idAtividade = idAtividade;
    }

    public BigDecimal getQtdHorasAtividade() {
        return qtdHorasAtividade;
    }

    public void setQtdHorasAtividade(BigDecimal qtdHorasAtividade) {
        this.qtdHorasAtividade = qtdHorasAtividade;
    }

    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Long idAtividade) {
        this.idAtividade = idAtividade;
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(String idActivite) {
        this.idActivite = idActivite;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtividade != null ? idAtividade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblancamentoshorasimport)) {
            return false;
        }
        Tblancamentoshorasimport other = (Tblancamentoshorasimport) object;
        if ((this.idAtividade == null && other.idAtividade != null) || (this.idAtividade != null && !this.idAtividade.equals(other.idAtividade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tblancamentoshorasimport[ idAtividade=" + idAtividade + " ]";
    }
    
}
