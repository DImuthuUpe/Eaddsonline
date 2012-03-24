/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.Date;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.transaction.UserTransaction;
import model.Advertisement;
import model.BusinessManager;
import model.DataHandler;
import model.Users;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Dimuthu
 */
public class AdvertisementAction extends ActionSupport implements SessionAware {

    private String title;
    private String description;
    private long category;
    private String priority;
    private int duration;
    private String method;
    private File image;

    @Override
    public String execute() {


        Advertisement add = new Advertisement();
        add.setCategory(getBusinessManager().getCategory(category));
        add.setDescription(description);
        add.setDuration(duration);
        add.setPriority(priority);
        Date currentDate = new Date();
        add.setPublishedDate(currentDate.toString());
        add.setTitle(title);


        Users user = (Users) session.get("user");
        add.setUser(user);
        long id= getBusinessManager().createAdvertisement(add, image);
        session.put("addId",id);

        return "Success";
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

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public BusinessManager getBusinessManager() {
        ServletContext ctx = ServletActionContext.getServletContext();
        return new DataHandler((EntityManagerFactory) ctx.getAttribute("emf"), (UserTransaction) ctx.getAttribute("utx"));
    }
    Map session;

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        System.out.println("image "+ image.getAbsolutePath());
        this.image = image;
    }
}
