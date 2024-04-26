
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


//
public class NhanVienModify {

    public NhanVienModify(NhanVienFrame nhanvienFrame) {
    }
    
    public static List<NhanVien> findAll() { //lấy ra tất cả đối tượng trong danh sách
        List<NhanVien> nhanvienList = new ArrayList<>();
        
        Connection connection = null; //Tạo kết nối tới database
        
        Statement statement = null;
        
        try {
            //
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhanvien", "root", "");
            
            //Tạo truy vấn (query)
            String sql = "select * from nhanvien";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                //
                NhanVien nv = new NhanVien(resultSet.getInt("id"), 
                        resultSet.getString("fullname"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("phone_number"),
                        resultSet.getString("position"), resultSet.getString("age"),
                        resultSet.getInt("salary"), resultSet.getInt("bonus"));
                nhanvienList.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return nhanvienList;
    }
    
    public static void update(NhanVien nv) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhanvien", "root", "");
            
            //query
            String sql = "update nhanvien set fullname=?,gender=?,age=?,position=?,email=?,phone_number=?,salary=?,bonus=? where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, nv.getFullname());
            statement.setString(2, nv.getGender());
            statement.setString(3, nv.getAge());
            statement.setString(4, nv.getPosition());
            statement.setString(5, nv.getEmail());
            statement.setString(6, nv.getPhoneNumber());
            statement.setInt(7, nv.getSalary());
            statement.setInt(8, nv.getBonus());
            statement.setInt(9, nv.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void insert(NhanVien nv) { //hàm thêm 1 đối tượng vào danh sách
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhanvien", "root", "");
            
            String sql = "insert into nhanvien(fullname, gender, age, position, email, phone_number, salary, bonus) values(?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, nv.getFullname());
            statement.setString(2, nv.getGender());
            statement.setString(3, nv.getAge());
            statement.setString(4, nv.getPosition());
            statement.setString(5, nv.getEmail());
            statement.setString(6, nv.getPhoneNumber());
            statement.setInt(7, nv.getSalary());
            statement.setInt(8, nv.getBonus());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    
    
    public static void delete(int id) { //hàm xóa 1 đối tượng ra khỏi danh sách
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhanvien", "root", "");
            
            String sql = "delete from nhanvien where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<NhanVien> findByFullname(String fullname) { //hàm tìm đối tượng theo tên
        List<NhanVien> nhanvienList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhanvien", "root", "");
            
            String sql = "select * from nhanvien where fullname like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+fullname+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                NhanVien nv = new NhanVien(resultSet.getInt("id"), 
                        resultSet.getString("fullname"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("phone_number"),
                        resultSet.getString("position"), resultSet.getString("age"),
                        resultSet.getInt("salary"), resultSet.getInt("bonus"));
                nhanvienList.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return nhanvienList;
    }
}

