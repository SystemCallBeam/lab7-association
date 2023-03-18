import pack7Association.*;

public class TestPack7 {
    public static void main(String[] args) {
        Product p = new Product("Kayan");
        Company c = new Company();
        c.setTitle("CS");
        c.setSpecialty(p);
        Employee yindee = new Employee("Yindee");
        Employee preeda = new Employee("Preeda");
        Employee pramote = new Employee("Pramote");
        Employee haha = new Employee("HaHa ^.^");
        c.hire(yindee);
        c.hire(preeda);
        c.hire(pramote);
        c.hire(haha);
        haha.setSupervisee(yindee);
        haha.setSupervisee(preeda);
        haha.setSupervisee(pramote);

        c.showEmployees();
        haha.showSupervisee();
        System.out.println(yindee.getSupervisorName());
    }
}
