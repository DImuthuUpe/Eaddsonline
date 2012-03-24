/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.servlet.ServletContext;
import model.Users;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Dimuthu
 */
public class LogOffAction extends ActionSupport implements SessionAware {

    Map session;

    @Override
    public String execute() {
        Users user =(Users)session.get("user");
        session.remove("email");
        session.remove("user");
        ServletContext ctx = ServletActionContext.getServletContext();
        Map chtMap = (HashMap) ctx.getAttribute("cht");
        HashSet chtList = (HashSet) chtMap.get("privateChatList");
        chtList.remove(user);
        chtMap.put("privateChatList", chtList);
        ctx.setAttribute("cht", chtMap);
        return "Success";
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
