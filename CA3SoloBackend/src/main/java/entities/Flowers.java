/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ckfol
 */
@Entity
@Table(name = "flowers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flowers.findAll", query = "SELECT f FROM Flowers f")})
public class Flowers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(max = 45)
    @Column(name = "flower")
    private String flower;
    
    @OneToMany(mappedBy = "flower", cascade = CascadeType.PERSIST)
    private List<User> userList;

    public Flowers() {
    }

    public Flowers(String flowerName) {
        this.flower = flowerName;
        userList = new ArrayList<>();
    }

    public String getFlower() {
        return flower;
    }

    public void setFlower(String flowerName) {
        this.flower = flowerName;
    }
    
    public void addUser(User user) {
        this.userList.add(user);
        if (user != null) {
            user.setFlower(this);
        }
    }

}
