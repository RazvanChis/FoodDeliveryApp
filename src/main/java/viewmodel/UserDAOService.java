package viewmodel;

import model.User;

public interface UserDAOService {
	
    public boolean addUser(User user);
    
    public void deleteUser(String userId);
    
    public User getUser(String userName, String password);
    
    public User getUserByUsername(String userName);
    
    public User getUserByEmail(String email);

}
