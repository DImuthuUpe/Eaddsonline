/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.transaction.UserTransaction;
import model.Advertisement;
import model.BusinessManager;
import model.DataHandler;
import org.apache.struts2.ServletActionContext;

public class AdvertisementListAction extends ActionSupport{
    private Long id;
    private List<Advertisement> list;
    private int pager=1;
    private int selectedPage=0;
    private String serverPath;
    @Override
    public String execute(){
        list= getBusinessManager().getAdvertisementsByCategory(id);
        for(int i=0;i<list.size();i++){
            Date pubDate = new Date(list.get(i).getPublishedDate());
            Date dueDate = new Date(pubDate.getTime()+list.get(i).getDuration()*604800000l);
            Date currentDate = new Date();
            //System.out.println(pubDate+ " "+currentDate+" "+dueDate);
            if(currentDate.getTime()>dueDate.getTime()){
                list.remove(i);
                i--;
            }
        }
        pager = list.size()/9+1;
        if(list.size()>(selectedPage*9+9)){
        list= list.subList(selectedPage*9, selectedPage*9+9);
        }else{
            list= list.subList(selectedPage*9,list.size());
        }
        serverPath=ServletActionContext.getServletContext().getRealPath("/")+"images\\advetisement\\";
       return "Success";
    }

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }
    public BusinessManager getBusinessManager() {
        ServletContext ctx = ServletActionContext.getServletContext();
        return new DataHandler((EntityManagerFactory) ctx.getAttribute("emf"), (UserTransaction) ctx.getAttribute("utx"));
    }

    public List<Advertisement> getList() {
        return list;
    }

    public void setList(List<Advertisement> list) {
        this.list = list;
    }

    /**
     * @return the pages
     */
    public int getPager() {
        return pager;
    }

    /**
     * @param pages the pages to set
     */
    public void setPager(int pager) {
        this.pager = pager;
    }

    /**
     * @return the selectedPage
     */
    public int getSelectedPage() {
        return selectedPage;
    }

    /**
     * @param selectedPage the selectedPage to set
     */
    public void setSelectedPage(int selectedPage) {
        this.selectedPage = selectedPage;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }
}
