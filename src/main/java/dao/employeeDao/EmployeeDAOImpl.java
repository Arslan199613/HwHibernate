package dao.employeeDao;

import connection.HibernateSessionFactoryUtill;
import dao.cityDao.CityDao;
import dao.cityDao.CityDaoImpl;
import dao.employeeDao.EmployeeDAO;
import exceptions.ListIsEmptyException;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    CityDao cityDao = new CityDaoImpl();


    @Override
    public Employee findEmployeeById(Long id) {
       return HibernateSessionFactoryUtill.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public void addEmployee(Employee employee) {

        try (Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            session.save(employee);
            transaction.commit();

        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = HibernateSessionFactoryUtill.getSessionFactory().openSession().
                createQuery("FROM Employee").list();
        if (employeeList.isEmpty()) throw new ListIsEmptyException("Список сотрудников пуст");
        else {
            return employeeList;
        }
    }

    @Override
    public void update(Employee employee) {
        try (Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }

    }


    @Override
    public void deleteById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
