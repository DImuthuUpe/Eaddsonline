/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.transaction.UserTransaction;
import model.BusinessManager;
import model.DataHandler;
import model.Users;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Dimuthu
 */
public class EditUserAction extends ActionSupport implements ModelDriven<Users>, SessionAware {

    private Map session;

    @Override
    public String execute() {
        ServletContext ctx = ServletActionContext.getServletContext();
        String email = (String) session.get("email");
        Users tempUser = getBusinessManager().getUser(email);
        user.setUserId(tempUser.getUserId());
        user.setEmail(tempUser.getEmail());
        getBusinessManager().updateUser(user);
        session.put("user",user);
        return "Success";
    }
    private Users user = new Users();

    public Users getModel() {
        return user;
    }

    public BusinessManager getBusinessManager() {
        ServletContext ctx = ServletActionContext.getServletContext();
        return new DataHandler((EntityManagerFactory) ctx.getAttribute("emf"), (UserTransaction) ctx.getAttribute("utx"));
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
