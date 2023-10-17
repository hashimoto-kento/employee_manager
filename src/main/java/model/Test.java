package model;

import java.sql.SQLException;

import model.dao.UserDAO;
import model.entity.UserBean;

public class Test {

    public static void main(String[] args) {
//        try {
//            Connection con = ConnectionManager.getConnection();
//            System.out.println("成功");
//            
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            System.out.println("失敗");
//        }
        
//    	インスタンスに値をセット
        UserBean user = new UserBean();
        
//        UserBeanクラスのインスタンス生成
        UserBean user2 = new UserBean();
        
        user.setUserId("hara");
        user.setPassword("haraPass");
        
        System.out.println(user.getUserId());
        System.out.println(user.getPassword());
        
        UserDAO dao = new UserDAO();
        
        try {
            user = dao.checkLogin("user", "passwordddd");
            
            if(user != null) {
                System.out.println("ログイン成功");
            } else {
                System.out.println("ログイン失敗");
            }
            
            System.out.println(user.getUserId());
            System.out.println(user.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        

        
//        インスタンスの値を取得

    }

}
