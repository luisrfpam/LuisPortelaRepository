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
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tbproject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Tbproject.LISTAR_DESTAQUES, query = "SELECT t FROM Tbproject t"),
    @NamedQuery(name = Tbproject.LISTAR_POR_LIKE_NOME, query = "SELECT t FROM Tbproject t WHERE t.nomeProjeto LIKE :nomeProjeto"),
    @NamedQuery(name = "Tbproject.findById", query = "SELECT t FROM Tbproject t WHERE t.id = :id"),
    @NamedQuery(name = "Tbproject.findByDtInicio", query = "SELECT t FROM Tbproject t WHERE t.dtInicio = :dtInicio"),
    @NamedQuery(name = "Tbproject.findByDtFim", query = "SELECT t FROM Tbproject t WHERE t.dtFim = :dtFim"),
    @NamedQuery(name = "Tbproject.findByStatusProject", query = "SELECT t FROM Tbproject t WHERE t.statusProject = :statusProject"),
    @NamedQuery(name = "Tbproject.findByDtFimRevisada", query = "SELECT t FROM Tbproject t WHERE t.dtFimRevisada = :dtFimRevisada"),
    @NamedQuery(name = "Tbproject.findByNomeProjeto", query = "SELECT t FROM Tbproject t WHERE t.nomeProjeto = :nomeProjeto"),
    @NamedQuery(name = "Tbproject.findByDescricaoProjeto", query = "SELECT t FROM Tbproject t WHERE t.descricaoProjeto = :descricaoProjeto"),
    @NamedQuery(name = "Tbproject.findByDtCreated", query = "SELECT t FROM Tbproject t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbproject.findByDtModified", query = "SELECT t FROM Tbproject t WHERE t.dtModified = :dtModified")})
public class Tbproject implements Serializable {
    public static final String LISTAR_DESTAQUES = "Tbproject.findAll";
    public static final String LISTAR_POR_LIKE_NOME = "Tbproject.findByLikeNomeProjeto";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "dtInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInicio;
    @Column(name = "dtFim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFim;
    @Size(max = 45)
    @Column(name = "statusProject")
    private String statusProject;
    @Column(name = "dtFimRevisada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFimRevisada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomeProjeto")
    private String nomeProjeto;
    @Size(max = 255)
    @Column(name = "descricaoProjeto")
    private String descricaoProjeto;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @OneToMany(mappedBy = "idProject")
    private Set<Tblancamentoshoras> tblancamentoshorasSet;
    @OneToMany(mappedBy = "idProject")
    private Set<Tbplancuts> tbplancutsSet;
    @JoinColumn(name = "idContract", referencedColumnName = "id")
    @ManyToOne
    private Tbcontract idContract;
    @JoinColumn(name = "idShipType", referencedColumnName = "id")
    @ManyToOne
    private Tbshiptype idShipType;

    public Tbproject() {
    }

    public Tbproject(Long id) {
        this.id = id;
    }

    public Tbproject(Long id, String nomeProjeto) {
        this.id = id;
        this.nomeProjeto = nomeProjeto;
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

    public String getStatusProject() {
        return statusProject;
    }

    public void setStatusProject(String statusProject) {
        this.statusProject = statusProject;
    }

    public Date getDtFimRevisada() {
        return dtFimRevisada;
    }

    public void setDtFimRevisada(Date dtFimRevisada) {
        this.dtFimRevisada = dtFimRevisada;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricaoProjeto() {
        return descricaoProjeto;
    }

    public void setDescricaoProjeto(String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
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

    @XmlTransient
    public Set<Tbplancuts> getTbplancutsSet() {
        return tbplancutsSet;
    }

    public void setTbplancutsSet(Set<Tbplancuts> tbplancutsSet) {
        this.tbplancutsSet = tbplancutsSet;
    }

    public Tbcontract getIdContract() {
        return idContract;
    }

    public void setIdContract(Tbcontract idContract) {
        this.idContract = idContract;
    }

    public Tbshiptype getIdShipType() {
        return idShipType;
    }

    public void setIdShipType(Tbshiptype idShipType) {
        this.idShipType = idShipType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Tbproject other = (Tbproject) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbproject[ id=" + id + " ]";
    }
    
}
