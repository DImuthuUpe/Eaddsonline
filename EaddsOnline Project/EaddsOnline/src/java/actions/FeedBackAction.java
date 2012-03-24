/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.transaction.UserTransaction;
import model.BusinessManager;
import model.DataHandler;
import model.Feedback;
import model.Users;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Dimuthu
 */

public class FeedBackAction extends ActionSupport implements SessionAware{
    private String description;
    @Override
    public String execute(){
        Feedback feedback = new Feedback();
        feedback.setUser((Users)session.get("user"));
        feedback.setDescription(description);
        getBusinessManager().createFeedback(feedback);
        return "Success";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    Map session;

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    public BusinessManager getBusinessManager() {
        ServletContext ctx = ServletActionContext.getServletContext();
        return new DataHandler((EntityManagerFactory) ctx.getAttribute("emf"), (UserTransaction) ctx.getAttribute("utx"));
    }
}
