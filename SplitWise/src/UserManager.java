import java.util.ArrayList;
import java.util.List;

public class UserManager {
    List<User> userList;
    public UserManager(){
        userList = new ArrayList<>();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public User getUser(String userId){
        return userList.stream().filter(user -> user.userId.equals(userId)).findFirst().orElse(null);
    }

    public List<User> getUserList(){
        return this.userList;
    }
}
