package dao.employeeDao;

import model.Employee;
import java.util.List;

public interface EmployeeDAO {
    Employee findEmployeeById(Long id);

    void addEmployee(Employee employee) ;

    List<Employee> getAll() ;

    void update(Employee employee) ;

    void deleteById(Employee employee);
}
