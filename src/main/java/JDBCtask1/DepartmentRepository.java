package JDBCtask1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {
    private Connection connection;

    public List<Department> getAllDepartment () throws SQLException{
        connection = DatabaseUtilieties.openConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * FROM department";
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        List<Department> departments = new ArrayList<>();
        while (resultSet.next()) {
            int departmentId = resultSet.getInt("id");
            String name = resultSet.getString("department_name");
            Department department = new Department(departmentId, name);
            departments.add(department);
        }
        return departments;
    }
    public Department returnDepartentById() throws SQLException{
        int deparmentId;
        Department department = null;
        connection = DatabaseUtilieties.openConnection();
        Statement statement = connection.createStatement();
        deparmentId = 3;
        String sqlQuery = String.format("SELECT * FROM department WHERE id = %d",deparmentId );
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            int departmentId = resultSet.getInt("id");
            String name = resultSet.getString("department_name");
             department = new Department(departmentId, name);
        }

        return department;
    }
}
