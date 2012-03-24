/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.transaction.UserTransaction;
import model.BusinessDirectory;
import model.BusinessManager;
import model.DataHandler;
import model.Users;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Dimuthu
 */
public class AddBusinessAction extends ActionSupport implements SessionAware{

    private Long businessId;
    private String businessName;
    private String ownerName;
    private long businessType;
    private String description;
    private File photo;
    private String address1;
    private String address2;
    private String address3;
    private String mobile;
    private String land1;
    private String land2;
    private String fax;
    private String email;
    private String site;

    @Override
    public String execute() {
        BusinessDirectory businessDirectory = new BusinessDirectory();
        businessDirectory.setBusinessName(businessName);
        businessDirectory.setAddress1(address1);
        businessDirectory.setAddress2(address2);
        businessDirectory.setAddress3(address3);
        businessDirectory.setDescription(description);
        businessDirectory.setEmail(email);
        businessDirectory.setFax(fax);
        businessDirectory.setLand1(land1);
        businessDirectory.setLand2(land2);
        businessDirectory.setMobile(mobile);
        businessDirectory.setOwnerName(ownerName);        
        businessDirectory.setSite(site);
        businessDirectory.setBusinessType(getBusinessManager().getBusinessType(businessType));
        businessDirectory.setUser((Users)session.get("user"));
        getBusinessManager().createBusiness(businessDirectory, photo);
        return "Success";

    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getBusinessType() {
        return businessType;
    }

    public void setBusinessType(long businessType) {
        this.businessType = businessType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLand1() {
        return land1;
    }

    public void setLand1(String land1) {
        this.land1 = land1;
    }

    public String getLand2() {
        return land2;
    }

    public void setLand2(String land2) {
        this.land2 = land2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
       
        this.photo = photo;
    }
    public BusinessManager getBusinessManager() {
        ServletContext ctx = ServletActionContext.getServletContext();
        return new DataHandler((EntityManagerFactory) ctx.getAttribute("emf"), (UserTransaction) ctx.getAttribute("utx"));
    }
    Map session;
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
