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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "tbuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Tbuser.LISTAR_DESTAQUES, query = "SELECT t FROM Tbuser t"),
    @NamedQuery(name = Tbuser.LISTAR_FUNCIONARIOS, query = "SELECT t FROM Tbuser t WHERE t.isFuncionario = :isFuncionario"),
    @NamedQuery(name = "Tbuser.findById", query = "SELECT t FROM Tbuser t WHERE t.id = :id"),
    @NamedQuery(name = Tbuser.FIND_BY_CPF, query = "SELECT t FROM Tbuser t WHERE t.cpf = :cpf"),
    @NamedQuery(name = "Tbuser.findByIsFuncionario", query = "SELECT t FROM Tbuser t WHERE t.isFuncionario = :isFuncionario"),
    @NamedQuery(name = "Tbuser.findByNumeroTelefone", query = "SELECT t FROM Tbuser t WHERE t.numeroTelefone = :numeroTelefone"),
    @NamedQuery(name = "Tbuser.findByNumeroCelular", query = "SELECT t FROM Tbuser t WHERE t.numeroCelular = :numeroCelular"),
    @NamedQuery(name = "Tbuser.findByEmail", query = "SELECT t FROM Tbuser t WHERE t.email = :email"),
    @NamedQuery(name = "Tbuser.findByUserStatus", query = "SELECT t FROM Tbuser t WHERE t.userStatus = :userStatus"),
    @NamedQuery(name = Tbuser.FIND_POR_LOGIN, query = "SELECT t FROM Tbuser t WHERE t.userLogin = :userLogin"),
    @NamedQuery(name = "Tbuser.findByUserPass", query = "SELECT t FROM Tbuser t WHERE t.userPass = :userPass"),
    @NamedQuery(name = "Tbuser.findByUserRegistered", query = "SELECT t FROM Tbuser t WHERE t.userRegistered = :userRegistered"),
    @NamedQuery(name = "Tbuser.findByNomeUsuario", query = "SELECT t FROM Tbuser t WHERE t.nomeUsuario = :nomeUsuario"),
    @NamedQuery(name = Tbuser.FIND_BY_MATRICULA, query = "SELECT t FROM Tbuser t WHERE t.matricula = :matricula"),
    @NamedQuery(name = "Tbuser.findByDtCreate", query = "SELECT t FROM Tbuser t WHERE t.dtCreate = :dtCreate"),
    @NamedQuery(name = "Tbuser.findByDtModified", query = "SELECT t FROM Tbuser t WHERE t.dtModified = :dtModified")})
public class Tbuser implements Serializable {
    public static final String LISTAR_DESTAQUES = "Tbuser.findAll";
    public static final String FIND_POR_LOGIN = "Tbuser.findByUserLogin";
    public static final String LISTAR_FUNCIONARIOS = "Tbuser.findWorkers";
    public static final String FIND_BY_CPF = "Tbuser.findByCpf";
    public static final String FIND_BY_MATRICULA = "Tbuser.findByMatricula";    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 45)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isFuncionario")
    private boolean isFuncionario;
    @Size(max = 45)
    @Column(name = "numeroTelefone")
    private String numeroTelefone;
    @Size(max = 45)
    @Column(name = "numeroCelular")
    private String numeroCelular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userStatus")
    private boolean userStatus;
    @Size(max = 60)
    @Column(name = "userLogin")
    private String userLogin;
    @Size(max = 64)
    @Column(name = "userPass")
    private String userPass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userRegistered;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomeUsuario")
    private String nomeUsuario;
    @Size(max = 45)
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "dtCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreate;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @ManyToMany(mappedBy = "tbuserSet")
    private Set<Tbprofile> tbprofileSet;
    @OneToMany(mappedBy = "idUsuario")
    private Set<Tblancamentoshoras> tblancamentoshorasSet;
    @JoinColumn(name = "idRole", referencedColumnName = "id")
    @ManyToOne
    private Tbrole idRole;

    public Tbuser() {
    }

    public Tbuser(Long id) {
        this.id = id;
    }

    public Tbuser(Long id, boolean isFuncionario, boolean userStatus, Date userRegistered, String nomeUsuario) {
        this.id = id;
        this.isFuncionario = isFuncionario;
        this.userStatus = userStatus;
        this.userRegistered = userRegistered;
        this.nomeUsuario = nomeUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean getIsFuncionario() {
        return isFuncionario;
    }

    public void setIsFuncionario(boolean isFuncionario) {
        this.isFuncionario = isFuncionario;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Date getUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(Date userRegistered) {
        this.userRegistered = userRegistered;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Date dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Date getDtModified() {
        return dtModified;
    }

    public void setDtModified(Date dtModified) {
        this.dtModified = dtModified;
    }

    @XmlTransient
    public Set<Tbprofile> getTbprofileSet() {
        return tbprofileSet;
    }

    public void setTbprofileSet(Set<Tbprofile> tbprofileSet) {
        this.tbprofileSet = tbprofileSet;
    }

    @XmlTransient
    public Set<Tblancamentoshoras> getTblancamentoshorasSet() {
        return tblancamentoshorasSet;
    }

    public void setTblancamentoshorasSet(Set<Tblancamentoshoras> tblancamentoshorasSet) {
        this.tblancamentoshorasSet = tblancamentoshorasSet;
    }

    public Tbrole getIdRole() {
        return idRole;
    }

    public void setIdRole(Tbrole idRole) {
        this.idRole = idRole;
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
        if (!(object instanceof Tbuser)) {
            return false;
        }
        Tbuser other = (Tbuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbuser[ id=" + id + " ]";
    }

}
