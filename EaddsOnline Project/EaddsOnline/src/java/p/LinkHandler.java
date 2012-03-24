/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.transaction.UserTransaction;
import model.BusinessManager;
import model.BusinessType;
import model.Category;
import model.DataHandler;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author student
 */
public class LinkHandler implements SessionAware{
    private List<BusinessType> businessTypes;
    public String welcome() {
        List<Category> list =getBusinessManager().getMenuDetails();
        session.put("category", list);
        return "welcome";
    }

    public String header() {
        return "header";
    }

    public String selector() {
        return "selector";
    }

    public String menu() {
        return "menu";
    }

    public String chat() {
        return "chat";
    }

    public String content() {
        return "content";
    }

    public String home() {
        return "home";
    }
    public String businessDirectory() {
        businessTypes = getBusinessManager().getAllBusinessType();
       
        return "businessDirectory";
    }
    public String signup() {
        return "signup";
    }
    public String profile() {

        return "profile";
    }
    public String advertisement() {
        return "advertisement";
    }
    public String feedback() {
        return "feedback";
    }
    Map session;
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    public BusinessManager getBusinessManager(){
        ServletContext ctx= ServletActionContext.getServletContext();
        return new DataHandler((EntityManagerFactory)ctx.getAttribute("emf"),(UserTransaction)ctx.getAttribute("utx"));
    }

    public List<BusinessType> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<BusinessType> businessTypes) {
        this.businessTypes = businessTypes;
    }
}
