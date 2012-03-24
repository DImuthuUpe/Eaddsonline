/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import model.Users;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Dimuthu
 */
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext ctx = ServletActionContext.getServletContext();
        session.setAttribute("servletContext", ctx);
        session.setMaxInactiveInterval(10);
        System.out.println("Session created");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        Users user = (Users) session.getAttribute("user");
        try {
            ServletContext ctx = (ServletContext) session.getAttribute("servletContext");
            Map chtMap = (HashMap) ctx.getAttribute("cht");
            HashSet chtList = (HashSet) chtMap.get("privateChatList");
            chtList.remove(user);
            chtMap.put("privateChatList", chtList);
            ctx.setAttribute("cht", chtMap);
            System.out.println("user removed");
        } catch (Exception ex) {
            System.out.println("Servlet Context Expired");
        }
        session.invalidate();
        System.out.println("Sessin Destroyed");
    }
}
