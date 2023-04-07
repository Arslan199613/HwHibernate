package dao;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    Employee findEmployeeById(Integer id);

    void addEmployee(Employee employee) ;

    List<Employee> getAll() ;

    void update(Employee employee) throws SQLException;

    void deleteById(Employee employee);
}
