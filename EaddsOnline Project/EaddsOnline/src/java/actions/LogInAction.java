/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
public class LogInAction extends ActionSupport implements SessionAware{

    private String password;
    private String email;
    private Map session;

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String execute(){
        
        return "Success";
    }
    @Override
    public void validate(){
        if(!getBusinessManager().isUserExists(getEmail().trim())){
            addFieldError("username", "Wrong User Name "+getEmail());
        }else{
            Users user = getBusinessManager().getUser(email);
            if(!user.getPassword().equals(getPassword())){
                addFieldError("password", "Wrong Password");
            }else{
                session.put("email", getEmail());
                session.put("user", user);
                ServletContext ctx= ServletActionContext.getServletContext();
                Map chtMap = (HashMap)ctx.getAttribute("cht");
                HashSet chtList = (HashSet) chtMap.get("privateChatList");

                chtList.add(user);
                chtMap.put("privateChatList", chtList);
                ctx.setAttribute("cht", chtMap);

            }
        }
    }
    public BusinessManager getBusinessManager(){
        ServletContext ctx= ServletActionContext.getServletContext();
        return new DataHandler((EntityManagerFactory)ctx.getAttribute("emf"),(UserTransaction)ctx.getAttribute("utx"));
    }

    public void setSession(Map<String, Object> session) {
        this.session=session;
    }
}
