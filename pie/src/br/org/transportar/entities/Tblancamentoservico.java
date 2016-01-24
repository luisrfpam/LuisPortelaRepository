/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tblancamentoservico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblancamentoservico.findAll", query = "SELECT t FROM Tblancamentoservico t"),
    @NamedQuery(name = "Tblancamentoservico.findByIdLancamentoServico", query = "SELECT t FROM Tblancamentoservico t WHERE t.idLancamentoServico = :idLancamentoServico"),
    @NamedQuery(name = "Tblancamentoservico.findByDescricaoCaverna", query = "SELECT t FROM Tblancamentoservico t WHERE t.descricaoCaverna = :descricaoCaverna"),
    @NamedQuery(name = "Tblancamentoservico.findByDescricaoBloco", query = "SELECT t FROM Tblancamentoservico t WHERE t.descricaoBloco = :descricaoBloco"),
    @NamedQuery(name = "Tblancamentoservico.findByValorComprimento", query = "SELECT t FROM Tblancamentoservico t WHERE t.valorComprimento = :valorComprimento"),
    @NamedQuery(name = "Tblancamentoservico.findByQtdUtilizado", query = "SELECT t FROM Tblancamentoservico t WHERE t.qtdUtilizado = :qtdUtilizado"),
    @NamedQuery(name = "Tblancamentoservico.findByIsImport", query = "SELECT t FROM Tblancamentoservico t WHERE t.isImport = :isImport")})
public class Tblancamentoservico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLancamentoServico")
    private Long idLancamentoServico;
    @Size(max = 255)
    @Column(name = "descricaoCaverna")
    private String descricaoCaverna;
    @Size(max = 255)
    @Column(name = "descricaoBloco")
    private String descricaoBloco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorComprimento")
    private BigDecimal valorComprimento;
    @Column(name = "qtdUtilizado")
    private Integer qtdUtilizado;
    @Column(name = "isImport")
    private Boolean isImport;
    @JoinColumn(name = "idEspaco", referencedColumnName = "id")
    @ManyToOne
    private Tbespaco idEspaco;
    @JoinColumn(name = "idPosicao", referencedColumnName = "id")
    @ManyToOne
    private Tbposicao idPosicao;
    @JoinColumn(name = "idRegiao", referencedColumnName = "id")
    @ManyToOne
    private Tbregiao idRegiao;
    @JoinColumn(name = "idServico", referencedColumnName = "id")
    @ManyToOne
    private Tbservico idServico;
    @JoinColumn(name = "idBordo", referencedColumnName = "id")
    @ManyToOne
    private Tbside idBordo;
    @JoinColumn(name = "idTipoSolda", referencedColumnName = "id")
    @ManyToOne
    private Tbtiposolda idTipoSolda;

    public Tblancamentoservico() {
    }

    public Tblancamentoservico(Long idLancamentoServico) {
        this.idLancamentoServico = idLancamentoServico;
    }

    public Long getIdLancamentoServico() {
        return idLancamentoServico;
    }

    public void setIdLancamentoServico(Long idLancamentoServico) {
        this.idLancamentoServico = idLancamentoServico;
    }

    public String getDescricaoCaverna() {
        return descricaoCaverna;
    }

    public void setDescricaoCaverna(String descricaoCaverna) {
        this.descricaoCaverna = descricaoCaverna;
    }

    public String getDescricaoBloco() {
        return descricaoBloco;
    }

    public void setDescricaoBloco(String descricaoBloco) {
        this.descricaoBloco = descricaoBloco;
    }

    public BigDecimal getValorComprimento() {
        return valorComprimento;
    }

    public void setValorComprimento(BigDecimal valorComprimento) {
        this.valorComprimento = valorComprimento;
    }

    public Integer getQtdUtilizado() {
        return qtdUtilizado;
    }

    public void setQtdUtilizado(Integer qtdUtilizado) {
        this.qtdUtilizado = qtdUtilizado;
    }

    public Boolean getIsImport() {
        return isImport;
    }

    public void setIsImport(Boolean isImport) {
        this.isImport = isImport;
    }

    public Tbespaco getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(Tbespaco idEspaco) {
        this.idEspaco = idEspaco;
    }

    public Tbposicao getIdPosicao() {
        return idPosicao;
    }

    public void setIdPosicao(Tbposicao idPosicao) {
        this.idPosicao = idPosicao;
    }

    public Tbregiao getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(Tbregiao idRegiao) {
        this.idRegiao = idRegiao;
    }

    public Tbservico getIdServico() {
        return idServico;
    }

    public void setIdServico(Tbservico idServico) {
        this.idServico = idServico;
    }

    public Tbside getIdBordo() {
        return idBordo;
    }

    public void setIdBordo(Tbside idBordo) {
        this.idBordo = idBordo;
    }

    public Tbtiposolda getIdTipoSolda() {
        return idTipoSolda;
    }

    public void setIdTipoSolda(Tbtiposolda idTipoSolda) {
        this.idTipoSolda = idTipoSolda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLancamentoServico != null ? idLancamentoServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblancamentoservico)) {
            return false;
        }
        Tblancamentoservico other = (Tblancamentoservico) object;
        if ((this.idLancamentoServico == null && other.idLancamentoServico != null) || (this.idLancamentoServico != null && !this.idLancamentoServico.equals(other.idLancamentoServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tblancamentoservico[ idLancamentoServico=" + idLancamentoServico + " ]";
    }
    
}
