package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {
     
        public UserBean checkLogin(String id, String password) throws ClassNotFoundException, SQLException {
            UserBean user = null;
            
            String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";
            
            try(Connection con = ConnectionManager.getConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql)) {
                
                pstmt.setString(1, id);
                pstmt.setString(2, password);
                
                ResultSet res = pstmt.executeQuery();
                
                if(res.next()) {
                    user = new UserBean();
                    user.setUserId(res.getString("user_id"));
                    user.setPassword(res.getString("password"));
                }
            }
            return user;
        }
        
    }