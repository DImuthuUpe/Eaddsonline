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
public class ChatAction extends ActionSupport implements SessionAware {

    private Map jsonData;
    private String chat;
    private Map session;
    private long targetId;

    public long getTargetId() {
        return targetId;
    }

    public void setTargetId(long targetId) {
        this.targetId = targetId;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public Map getJsonData() {
        return jsonData;
    }

    public void setJsonData(Map jsonData) {
        this.jsonData = jsonData;
    }

    public String addPublicChat() {
        ServletContext ctx = ServletActionContext.getServletContext();
        jsonData = (HashMap) ctx.getAttribute("cht");
        Users user = (Users) session.get("user");
        String entry[] = {user == null ? "Anonymous" : user.getFullName(), chat};
        ArrayList chtEntry = (ArrayList) jsonData.get("publicChat");
        chtEntry.add(entry);
        if (chtEntry.size() == 20) {
            chtEntry.remove(0);
        }
        jsonData.put("publicChat", chtEntry);
        ctx.setAttribute("cht", jsonData);

        return SUCCESS;
    }

    public String readPublicChat() {
        ServletContext ctx = ServletActionContext.getServletContext();
        jsonData = (HashMap) ((HashMap) ctx.getAttribute("cht")).clone();
        HashSet chtList = (HashSet) jsonData.get("privateChatList");
        Users u[] = new Users[chtList.size()];
        Users userList[] = (Users[]) chtList.toArray(u);
        for (Users us : userList) {
            System.out.println(us.getEmail());
        }
        //chtList.remove(session.get("user"));
        //jsonData.put("privateChatList", userList);
        return SUCCESS;
    }

    public String getPrivateChat() {
        Users user = (Users) session.get("user");
        ServletContext ctx = ServletActionContext.getServletContext();
        if(user!=null)
        jsonData = (HashMap)ctx.getAttribute(user.getUserId()+"Chat");
        return SUCCESS;
    }

    public String addPrivateChat() {
        jsonData = new HashMap();
        Users user = (Users) session.get("user");
        ServletContext ctx = ServletActionContext.getServletContext();
        if (user != null) {
            Map chtMap = (HashMap) ctx.getAttribute(user.getUserId() + "Chat");
            if (chtMap == null) {
                chtMap = new HashMap();
            }
            ArrayList arr = (ArrayList) chtMap.get(targetId + "");
            if (arr == null) {
                arr = new ArrayList();
            }
            String[] entry = {user.getFullName(), chat};
            arr.add(entry);
            jsonData.put("cht", arr);
            chtMap.put(targetId + "", arr);
            ctx.setAttribute(user.getUserId() + "Chat", chtMap);
            Users target = getBusinessManager().getUser(targetId);
            System.out.println(target.getFullName());
            if (true) {
                Map chtMap2 = (HashMap) ctx.getAttribute(target.getUserId() + "Chat");
                if (chtMap2 == null) {
                    chtMap2 = new HashMap();
                }
                //System.out.println("printing");
                ArrayList arr2 = (ArrayList) chtMap2.get(user.getUserId() + "");
                if (arr2 == null) {
                    arr2 = new ArrayList();
                }
                arr2.add(entry);

                chtMap2.put(target.getUserId() + "", arr2);
                ctx.setAttribute(target.getUserId() + "Chat", chtMap2);
            }
        }
        return SUCCESS;
    }

    public String session() {
        jsonData = new HashMap();
        jsonData.put("user", session.get("user"));
        jsonData.put("email", session.get("email"));
        return SUCCESS;
    }

    public void setSession(Map<String, Object> map) {
        session = map;
    }

    public BusinessManager getBusinessManager() {
        ServletContext ctx = ServletActionContext.getServletContext();
        return new DataHandler((EntityManagerFactory) ctx.getAttribute("emf"), (UserTransaction) ctx.getAttribute("utx"));
    }
}
