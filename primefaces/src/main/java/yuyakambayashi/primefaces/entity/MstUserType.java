/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuyakambayashi.primefaces.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author yuya-kambayashi
 */
@Entity
@Table(name = "MstUserType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstUserType.findAll", query = "SELECT m FROM MstUserType m")
    , @NamedQuery(name = "MstUserType.findById", query = "SELECT m FROM MstUserType m WHERE m.id = :id")
    , @NamedQuery(name = "MstUserType.findByNameJP", query = "SELECT m FROM MstUserType m WHERE m.nameJP = :nameJP")
    , @NamedQuery(name = "MstUserType.findByNameEN", query = "SELECT m FROM MstUserType m WHERE m.nameEN = :nameEN")})

public class MstUserType implements Serializable {

//    @OneToMany(mappedBy = "mstUserType")
    public enum Type{
        社内(1),
        代理店(2),
        ;
        public int id;
        Type(int nId)
        {
            id = nId;
        }
    }

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NameJP")
    private String nameJP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NameEN")
    private String nameEN;

    public MstUserType() {
    }

    public MstUserType(Integer id) {
        this.id = id;
    }

    public MstUserType(Integer id, String nameJP, String nameEN) {
        this.id = id;
        this.nameJP = nameJP;
        this.nameEN = nameEN;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameJP() {
        return nameJP;
    }

    public void setNameJP(String nameJP) {
        this.nameJP = nameJP;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
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
        if (!(object instanceof MstUserType)) {
            return false;
        }
        MstUserType other = (MstUserType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.kke.cpq.entity.MstUserType[ id=" + id + " ]";
    }

    /**
     * 社内ユーザかどうか
     * @return 
     */
    public boolean is社内ユーザ()
    {
        return id == Type.社内.id;
    }
    
}
