/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.transaction.UserTransaction;
import model.BusinessManager;
import model.DataHandler;
import model.Users;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Dim
 */
public class SignUpAction extends ActionSupport implements ModelDriven<Users>{
    @Override
    public String execute(){        
        System.out.println(""+user.getEmail());
        getBusinessManager().createUser(user);
        return "Success";
    }

    private Users user = new Users();
    public Users getModel() {
        return user;
    }

    public BusinessManager getBusinessManager(){
        ServletContext ctx= ServletActionContext.getServletContext();
        return new DataHandler((EntityManagerFactory)ctx.getAttribute("emf"),(UserTransaction)ctx.getAttribute("utx"));
    }

    @Override
    public void validate(){
        //validation code
    }
}
