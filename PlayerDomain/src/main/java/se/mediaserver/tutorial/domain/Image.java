/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ingimar
 */
@Entity
@Table(name = "IMAGE")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i"),
//    @NamedQuery(name = "Image.findByUuid", query = "SELECT i FROM Image i WHERE i.uuid = :uuid")})
public class Image extends Media implements Serializable {

    private static final long serialVersionUID = 1L;

    public Image() {
    }
}