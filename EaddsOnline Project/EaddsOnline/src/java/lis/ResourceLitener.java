/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.transaction.UserTransaction;

/**
 *
 * @author Dimuthu
 */
public class ResourceLitener implements ServletContextListener{
@PersistenceUnit(unitName="EaddsOnlinePU")
    EntityManagerFactory emf;

    @Resource
    UserTransaction utx;
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext ctx=sce.getServletContext();
        ctx.setAttribute("emf", emf);
        ctx.setAttribute("utx", utx);
        Map chatMap = new HashMap();
        chatMap.put("publicChat", new ArrayList());
        chatMap.put("privateChatList", new HashSet());
        ctx.setAttribute("cht",chatMap);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
