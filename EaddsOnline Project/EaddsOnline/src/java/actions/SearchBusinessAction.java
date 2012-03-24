/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.transaction.UserTransaction;
import model.BusinessDirectory;
import model.BusinessManager;
import model.BusinessType;
import model.DataHandler;
import org.apache.struts2.ServletActionContext;

public class SearchBusinessAction extends ActionSupport {

    private String searchKey;
    private int selection;
    private List<BusinessDirectory> businessList;
    private List<BusinessType> businessTypes;

    @Override
    public String execute() {
        businessList = new ArrayList<BusinessDirectory>();
        List<BusinessDirectory> allBusiness = getBusinessManager().getAllBusinessDirectory();
        if (allBusiness != null) {
            for (BusinessDirectory business : allBusiness) {
                if (selection == 0) {
                    if (business.getBusinessName().matches(searchKey)) {
                        businessList.add(business);
                        //System.out.println("added 0");
                    }
                } else if (selection == 1) {
                    if (searchKey.matches(business.getAddress1()) || searchKey.matches(business.getAddress2()) || searchKey.matches(business.getAddress3())) {
                        businessList.add(business);
                        //System.out.println("added 1");
                    }
                } else if (selection == 2) {
                    if (searchKey.matches(business.getOwnerName()) || business.getOwnerName().matches(searchKey)) {
                        businessList.add(business);
                        //System.out.println("added 2");
                    }
                } else if (selection == 3) {
                    String businessType = business.getBusinessType().getTitle();
                    if (businessType.matches(searchKey) || searchKey.matches(businessType)) {
                        businessList.add(business);
                        //System.out.println("added 3");
                    }
                } else if (selection == 4) {
                    if (business.getLand1().matches(searchKey) || business.getLand2().matches(searchKey) || business.getMobile().matches(searchKey)) {
                        businessList.add(business);
                        //System.out.println("added 4");
                    }
                } else if (selection == 5) {
                    if (business.getEmail().matches(searchKey)) {
                        businessList.add(business);
                        //System.out.println("added 5");
                    }
                }
            }
        }
        businessTypes = getBusinessManager().getAllBusinessType();

        return "Success";
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public List<BusinessDirectory> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<BusinessDirectory> businessList) {
        this.businessList = businessList;
    }

    public List<BusinessType> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<BusinessType> businessTypes) {
        this.businessTypes = businessTypes;
    }
    
    public BusinessManager getBusinessManager() {
        ServletContext ctx = ServletActionContext.getServletContext();
        return new DataHandler((EntityManagerFactory) ctx.getAttribute("emf"), (UserTransaction) ctx.getAttribute("utx"));
    }
}
