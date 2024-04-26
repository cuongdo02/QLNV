
package quanlynhanvien;

//khởi tạo đối tợng
public class NhanVien {
    int id;
    String fullname, gender, email, phoneNumber, position, age;
    int salary,bonus;
    
    public NhanVien() {
    }

    public NhanVien(int id, String fullname, String gender, String email, String phoneNumber, String position, String age, int salary, int bonus) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.age = age;
        this.salary = salary;
        this.bonus = bonus;
    }

    public NhanVien(String fullname, String gender, String email, String phoneNumber, String position, String age, int salary, int bonus) {
        this.fullname = fullname;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.age = age;
        this.salary = salary;
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}

