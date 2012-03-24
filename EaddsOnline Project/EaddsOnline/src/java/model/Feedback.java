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
 * @author INDIKA
 */
@Entity
public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedbackId;
    private String description;


    @ManyToOne()
    @PrimaryKeyJoinColumn(referencedColumnName="userId")
    private Users user;
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return getFeedbackId();
    }

    public void setId(Long id) {
        this.setFeedbackId(id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getFeedbackId() != null ? getFeedbackId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.getFeedbackId() == null && other.getFeedbackId() != null) || (this.getFeedbackId() != null && !this.feedbackId.equals(other.feedbackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Feedback[id=" + getFeedbackId() + "]";
    }

    /**
     * @return the feedbackId
     */
    public Long getFeedbackId() {
        return feedbackId;
    }

    /**
     * @param feedbackId the feedbackId to set
     */
    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }

}
