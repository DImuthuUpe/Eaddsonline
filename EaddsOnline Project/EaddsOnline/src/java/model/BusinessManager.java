/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.File;
import java.util.List;

/**
 *
 * @author Dim
 */
public interface BusinessManager {
    public void createUser(Users user);
    public Users getUser(long userId);
    public Users getUser(String email);
    public List<Users> getAllUsers();
    public boolean isUserExists(String email);
    public void updateUser(Users user);
    public void deleteUser(Users user);
    public void deleteUser(String email);
    public void deleteUser(long userId);
    public List<Category> getMenuDetails();
    public long createAdvertisement(Advertisement advertisement,File image);
    public List<Advertisement> getAdvertisementsByCategory(long categoryId);
    public List<Advertisement> getAdvertisementsByUser(Users user);
    public Advertisement getAdvertisement(long addId);
    public Category getCategory(long categoryId);
    public void createFeedback(Feedback feedback);
    public List<BusinessType> getAllBusinessType();
    public BusinessType getBusinessType(long typeId);
    public void createBusiness(BusinessDirectory business,File image);
    public List<BusinessDirectory> getAllBusinessDirectory();
}
