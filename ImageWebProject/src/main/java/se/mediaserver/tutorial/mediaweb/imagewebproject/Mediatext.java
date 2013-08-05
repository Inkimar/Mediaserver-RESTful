/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.mediaweb.imagewebproject;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ingimar
 */
@Entity
@Table(name = "MEDIATEXT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mediatext.findAll", query = "SELECT m FROM Mediatext m"),
    @NamedQuery(name = "Mediatext.findByUuid", query = "SELECT m FROM Mediatext m WHERE m.uuid = :uuid"),
    @NamedQuery(name = "Mediatext.findByLang", query = "SELECT m FROM Mediatext m WHERE m.lang = :lang"),
    @NamedQuery(name = "Mediatext.findByLegend", query = "SELECT m FROM Mediatext m WHERE m.legend = :legend")})
public class Mediatext implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UUID")
    private Long uuid;
    @Size(max = 255)
    @Column(name = "LANG")
    private String lang;
    @Size(max = 255)
    @Column(name = "LEGEND")
    private String legend;

    public Mediatext() {
    }

    public Mediatext(Long uuid) {
        this.uuid = uuid;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mediatext)) {
            return false;
        }
        Mediatext other = (Mediatext) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.mediaserver.tutorial.mediaweb.imagewebproject.Mediatext[ uuid=" + uuid + " ]";
    }
    
}
