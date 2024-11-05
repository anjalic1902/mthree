

public class P3Employee {
    public String name;
    public int age;
    public String city;
    public double salary;
    public String companyName;
    public String employeeId;
    public String department;
    public String designation;

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
        System.out.println("Salary: " + salary);
        System.out.println("Company Name: " + companyName);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
    }

    public void setDetails(String name, int age, String city, double salary, String companyName, String employeeId, String department, String designation) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.salary = salary;
        this.companyName = companyName;
        this.employeeId = employeeId;
        this.department = department;
        this.designation = designation;
    }
    public P3Employee() {
        name = "Anjali Chauhan";
        age = 22;
        city = "Rawatbhata";
        salary = 100000;
        companyName = "mthree";
        employeeId = "0810CA221024";
        department = "IT";
        designation = "Software Developer Trainee";
        printDetails();
    }
   public P3Employee(String name, int age, String city, double salary, String companyName, String employeeId, String department, String designation) {
    this.name = name;
    this.age = age;
    this.city = city;
    this.salary = salary;
    this.companyName = companyName;
    this.employeeId = employeeId;
    this.department = department;
    this.designation = designation;
    printDetails();
   }


    public static void main(String[] args) {
        P3Employee obj = new P3Employee();
        obj.setDetails("Jasa", 30, "New York", 100000, "ABC Company", "1234567890", "IT", "Software Engineer");
        obj.printDetails();
        P3Employee obj2 = new P3Employee("Jasa", 30, "New York", 100000, "ABC Company", "1234567890", "IT", "Software Engineer");
        obj2.printDetails();
}}