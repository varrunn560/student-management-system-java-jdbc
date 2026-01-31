public class Student {

    private int rollNo;
    private String name;
    private int age;
    private String department;

    public Student(int rollNo, String name, int age, String department) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
