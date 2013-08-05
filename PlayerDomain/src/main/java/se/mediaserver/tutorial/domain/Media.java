/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ingimar
 */
@Entity
@Table(name = "MEDIA")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m"),
//    @NamedQuery(name = "Media.findByUuid", query = "SELECT m FROM Media m WHERE m.uuid = :uuid"),
//    @NamedQuery(name = "Media.findByDtype", query = "SELECT m FROM Media m WHERE m.dtype = :dtype"),
//    @NamedQuery(name = "Media.findByFilename", query = "SELECT m FROM Media m WHERE m.filename = :filename"),
//    @NamedQuery(name = "Media.findByMimeTye", query = "SELECT m FROM Media m WHERE m.mimeTye = :mimeTye"),
//    @NamedQuery(name = "Media.findByOwner", query = "SELECT m FROM Media m WHERE m.owner = :owner"),
//    @NamedQuery(name = "Media.findByVisibility", query = "SELECT m FROM Media m WHERE m.visibility = :visibility")})
public class Media implements Serializable {

    @Column(name = "OWNER", length = 255, table = "MEDIA")
    private String owner;

    @Column(name = "VISIBILITY", length = 50, table = "MEDIA")
    private String visibility;

    @Column(name = "ORIGINAL_FILENAME", length = 255, table = "MEDIA")
    private String filename;
    
    /**
     * AS in media_type ( enum ? )
     */
    @Column(name = "MIME_TYE", length = 50, table = "MEDIA")
    private String mimetype; // anv. Enum

    @Embedded
    private Mediatext mediaText;
    
    @Id
    @Column(name = "UUID", length = 36, table = "MEDIA")
    private String uuid;

    public Media() {
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public Mediatext getMediaText() {
        return mediaText;
    }

    public void setMediaText(Mediatext mediaText) {
        this.mediaText = mediaText;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.uuid);
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
        final Media other = (Media) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Media-class";
    }
}
