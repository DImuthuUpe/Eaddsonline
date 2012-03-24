/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import org.apache.struts2.ServletActionContext;

public class DataHandler implements BusinessManager{

    EntityManagerFactory emf;
    UserTransaction utx;

    public DataHandler(EntityManagerFactory emf, UserTransaction utx) {
        this.emf = emf;
        this.utx = utx;
    }

    public List<Category> getMenuDetails(){
        try{
            EntityManager em = emf.createEntityManager();
            utx.begin();
            Query query = em.createQuery("SELECT c FROM Category c");
            List<Category> list = query.getResultList();
            utx.commit();
            return list;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void createUser(Users user) {
        try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            em.persist(user);
            utx.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public Users getUser(long userId) {
        Users user = null;
        try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            Query query = em.createQuery("SELECT u FROM Users u WHERE u.userId=" + userId + "");
            List list = query.getResultList();
            utx.commit();
            if (!list.isEmpty()) {
                user = (Users) list.get(0);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public Users getUser(String email) {
        Users user = null;
        try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            Query query = em.createQuery("SELECT u FROM Users u WHERE u.email='" + email + "'");
            List list = query.getResultList();
            utx.commit();
            if (!list.isEmpty()) {
                user = (Users) list.get(0);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public List<Users> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isUserExists(String email) {
        try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            Query query = em.createQuery("SELECT u FROM Users u WHERE u.email='" + email + "'");
            List list = query.getResultList();
            utx.commit();
            if (!list.isEmpty()) {
                return true;
            }else{
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public void updateUser(Users user) {
        try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            em.merge(user);
            utx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteUser(Users user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteUser(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteUser(long userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public long createAdvertisement(Advertisement advertisement,File image) {
        EntityManager em = emf.createEntityManager();
        Long id=0l;
        FileInputStream is = null;
        FileOutputStream os = null;
        try{
        utx.begin();
        em.persist(advertisement);


        utx.commit();
        utx.begin();
        Query query = em.createQuery("SELECT a FROM Advertisement a");
        List list = query.getResultList();
        id = ((Advertisement)list.get(list.size()-1)).getAddId();
        utx.commit();
            System.out.println(""+id);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        try{
        String serverPath = ServletActionContext.getServletContext().getRealPath("/");
        is = new FileInputStream(image);
            os = new FileOutputStream(new File(serverPath+"images\\advetisement\\",id+".jpg"));
            int val;
            while((val=is.read())!=-1){
                os.write(val);
            }
            os.flush();
        }catch (FileNotFoundException ex) {
            System.out.println("Image file not found");
        }catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return id;
    }
    public Advertisement getAdvertisement(long addId) {
        List<Advertisement> list = null;
        try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            Query query = em.createQuery("SELECT a FROM Advertisement a WHERE a.addId="+addId);
            list = query.getResultList();
            utx.commit();
            return list.get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Advertisement> getAdvertisementsByCategory(long categoryId) {
        List<Advertisement> list = null;
        try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            Query query = em.createQuery("SELECT a FROM Advertisement a WHERE a.category.categoryId='"+categoryId+"'");
            list = query.getResultList();
            utx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Advertisement> getAdvertisementsByUser(Users user) {
        List<Advertisement> list = null;
        try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            Query query = em.createQuery("SELECT a FROM Advertisement a WHERE a.user.userId='"+user.getUserId()+"'");
            list = query.getResultList();
            utx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }



    public Category getCategory(long categoryId){
        List<Category> list = null;
        Category cat = null;
        try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            Query query = em.createQuery("SELECT c FROM Category c WHERE c.categoryId="+categoryId);
            list = query.getResultList();
            utx.commit();
            if(list!=null){
                cat = list.get(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cat;
    }

    public void createFeedback(Feedback feedback) {
       try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            em.persist(feedback);
            utx.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<BusinessType> getAllBusinessType() {
       try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            Query query  = em.createQuery("SELECT t FROM BusinessType t");
            List<BusinessType> list = query.getResultList();
            utx.commit();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public BusinessType getBusinessType(long typeId) {
       try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            Query query  = em.createQuery("SELECT t FROM BusinessType t WHERE t.typeId="+typeId);
            List<BusinessType> list = query.getResultList();
            utx.commit();
            return list.get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void createBusiness(BusinessDirectory business, File image) {
         System.out.println("Helooo    "+image.getName()+ " fsae");
        EntityManager em = emf.createEntityManager();
        Long id=0l;
        FileInputStream is = null;
        FileOutputStream os = null;
        try{
        utx.begin();
        em.persist(business);


        utx.commit();
        utx.begin();
        Query query = em.createQuery("SELECT b FROM BusinessDirectory b");
        List list = query.getResultList();
        id = ((BusinessDirectory)list.get(list.size()-1)).getBusinessId();
        utx.commit();
            System.out.println(""+id);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        try{
        String serverPath = ServletActionContext.getServletContext().getRealPath("/");
        is = new FileInputStream(image);
            os = new FileOutputStream(new File(serverPath+"images\\business\\"+id+".jpg"));
            int val;
            while((val=is.read())!=-1){
                os.write(val);
            }
            os.flush();
        }catch (FileNotFoundException ex) {
            System.out.println("Image file not found");
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public List<BusinessDirectory> getAllBusinessDirectory() {
        try {
            EntityManager em = emf.createEntityManager();
            utx.begin();
            Query query  = em.createQuery("SELECT d FROM BusinessDirectory d");
            List<BusinessDirectory> list = query.getResultList();
            utx.commit();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    


}
