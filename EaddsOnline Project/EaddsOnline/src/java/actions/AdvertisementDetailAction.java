/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import com.opensymphony.xwork2.ActionSupport;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.transaction.UserTransaction;
import model.Advertisement;
import model.BusinessManager;
import model.DataHandler;
import model.Users;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Dimuthu
 */
public class AdvertisementDetailAction extends ActionSupport{
    private long id;
    private Users user;
    private Advertisement advertisement;
    @Override
    public String execute(){
        advertisement=getBusinessManager().getAdvertisement(id);
        user = advertisement.getUser();
        return "Success";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public BusinessManager getBusinessManager() {
        ServletContext ctx = ServletActionContext.getServletContext();
        return new DataHandler((EntityManagerFactory) ctx.getAttribute("emf"), (UserTransaction) ctx.getAttribute("utx"));
    }

}
