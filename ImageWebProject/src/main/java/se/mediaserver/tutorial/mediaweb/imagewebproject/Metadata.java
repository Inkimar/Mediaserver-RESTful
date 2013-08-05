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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ingimar
 */
@Entity
@Table(name = "METADATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metadata.findAll", query = "SELECT m FROM Metadata m"),
    @NamedQuery(name = "Metadata.findByUuid", query = "SELECT m FROM Metadata m WHERE m.uuid = :uuid")})
public class Metadata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UUID")
    private Long uuid;

    public Metadata() {
    }

    public Metadata(Long uuid) {
        this.uuid = uuid;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
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
        if (!(object instanceof Metadata)) {
            return false;
        }
        Metadata other = (Metadata) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.mediaserver.tutorial.mediaweb.imagewebproject.Metadata[ uuid=" + uuid + " ]";
    }
    
}
