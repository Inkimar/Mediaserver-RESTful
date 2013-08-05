/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.mediaweb.imagewebproject;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m"),
    @NamedQuery(name = "Media.findByUuid", query = "SELECT m FROM Media m WHERE m.uuid = :uuid"),
    @NamedQuery(name = "Media.findByDtype", query = "SELECT m FROM Media m WHERE m.dtype = :dtype"),
    @NamedQuery(name = "Media.findByFilename", query = "SELECT m FROM Media m WHERE m.filename = :filename"),
    @NamedQuery(name = "Media.findByMimeTye", query = "SELECT m FROM Media m WHERE m.mimeTye = :mimeTye"),
    @NamedQuery(name = "Media.findByOwner", query = "SELECT m FROM Media m WHERE m.owner = :owner"),
    @NamedQuery(name = "Media.findByVisibility", query = "SELECT m FROM Media m WHERE m.visibility = :visibility")})
public class Media implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UUID")
    private Long uuid;

    @Size(max = 31)
    @Column(name = "DTYPE")
    private String dtype;

    @Size(max = 255)
    @Column(name = "FILENAME")
    private String filename;

    @Size(max = 50)
    @Column(name = "MIME_TYE")
    private String mimeTye;

    @Size(max = 255)
    @Column(name = "OWNER")
    private String owner;

    @Size(max = 50)
    @Column(name = "VISIBILITY")
    private String visibility;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "media")
    private Image image;

    public Media() {
    }

    public Media(Long uuid) {
        this.uuid = uuid;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMimeTye() {
        return mimeTye;
    }

    public void setMimeTye(String mimeTye) {
        this.mimeTye = mimeTye;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.mediaserver.tutorial.mediaweb.imagewebproject.Media[ uuid=" + uuid + " ]";
    }
}
