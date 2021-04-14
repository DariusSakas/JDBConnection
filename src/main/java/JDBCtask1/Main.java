package JDBCtask1;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();
        try {
            List<Department> departments = departmentRepository.getAllDepartment();
            for (Department department : departments) {
                System.out.println(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            System.out.println();
            System.out.println(departmentRepository.returnDepartentById());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
