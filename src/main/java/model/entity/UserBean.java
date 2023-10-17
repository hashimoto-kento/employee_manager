package model.entity;

import java.io.Serializable;

public class UserBean implements Serializable{

    private String userId;
    
    private String password;
    
    public UserBean() {
        
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
