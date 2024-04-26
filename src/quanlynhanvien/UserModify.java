
package quanlynhanvien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class UserModify {
    public UserModify(UserController userController){
    }
    
    public static List<User> findAll(){
        List<User> userList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        try {
            //
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhanvien", "root", "");
            String sql = "select * from taikhoan";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                User user = new User(resultSet.getString("username"), resultSet.getString("pass"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return userList;
    }
    public static void update(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhanvien", "root", "");
            
            //query
            String sql = "update taikhoan set pass=? where username = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getUsername());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void insert(User user) { //hàm thêm 1 đối tượng vào danh sách
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhanvien", "root", "");
            
            String sql = "insert into taikhoan(username, pass) values(?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void delete(String username) { //hàm xóa 1 đối tượng ra khỏi danh sách
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhanvien", "root", "");
            
            String sql = "delete from taikhoan where username = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, username);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<User> findByUserName(String username) { //hàm tìm đối tượng theo tên
        List<User> userList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhanvien", "root", "");
            
            String sql = "select * from taikhoan where username like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+username+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                User user = new User(resultSet.getString("username"), resultSet.getString("pass") );
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return userList;
    }
}
