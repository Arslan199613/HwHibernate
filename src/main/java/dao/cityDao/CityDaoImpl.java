package dao.cityDao;

import connection.HibernateSessionFactoryUtill;
import exceptions.NotFoundObjectException;
import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CityDaoImpl implements CityDao {

    @Override
    public City findCityById(Long id) {
        City city = HibernateSessionFactoryUtill.getSessionFactory().openSession().get(City.class, id);
        if (city == null) {
            throw new NotFoundObjectException("Город не найден в базе данных");
        } else {
            return city;
        }
    }

    @Override
    public void createNewCity(City city) {
        try (Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public void updateCityById(City city) {
        try (Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }
    @Override
    public void deleteCityById(City city) {
        try (Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
