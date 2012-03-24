/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Dimuthu
 */
@Entity
public class BusinessType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long typeId;
    private String title;

    @OneToMany(mappedBy="businessType",cascade=CascadeType.ALL)
    private List<BusinessDirectory> businessDirectories;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessType)) {
            return false;
        }
        BusinessType other = (BusinessType) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BusinessType[id=" + typeId + "]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BusinessDirectory> getBusinessDirectories() {
        return businessDirectories;
    }

    public void setBusinessDirectories(List<BusinessDirectory> businessDirectories) {
        this.businessDirectories = businessDirectories;
    }

}
