/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Dimuthu
 */
@Entity
public class Advertisement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addId;

    @ManyToOne()
    @PrimaryKeyJoinColumn(name="userId")
    private Users user;
    private String title;
    private String description;
    
    @ManyToOne()
    @PrimaryKeyJoinColumn(name="categoryId")
    private Category category;
    private String priority;
    private String publishedDate;
    private int duration;
    
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addId != null ? addId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the addId fields are not set
        if (!(object instanceof Advertisement)) {
            return false;
        }
        Advertisement other = (Advertisement) object;
        if ((this.addId == null && other.addId != null) || (this.addId != null && !this.addId.equals(other.addId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Advertisement[addId=" + addId + "]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
