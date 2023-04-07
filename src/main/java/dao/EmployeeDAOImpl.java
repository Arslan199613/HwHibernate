package dao;

import connection.Connection;
import connection.HibernateSession;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    Connection connection = new Connection();


    @Override
    public Employee findEmployeeById(Integer id) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        Long id;

        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            id = (Long) session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public List<Employee> getAll() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee").list();
        }
    }

    @Override
    public void update(Employee employee) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }

    }


    @Override
    public void deleteById(Employee employee) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }
}
