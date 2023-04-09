import dao.cityDao.CityDao;
import dao.cityDao.CityDaoImpl;
import dao.employeeDao.EmployeeDAO;
import dao.employeeDao.EmployeeDAOImpl;
import exceptions.ListIsEmptyException;
import exceptions.NotFoundObjectException;
import model.City;
import model.Employee;

public class Application {
   private static CityDao cityDao = new CityDaoImpl();
   public static EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    //Операции с городами

    static void createCity(City city) {
        cityDao.createNewCity(city);

    }

    static Object findById(Long id) {
        try {
            return cityDao.findCityById(id);
        } catch (NotFoundObjectException e) {
            return e.getMessage();
        }
    }

    static void updateCity(City city) {
        cityDao.updateCityById(city);

    }

    static void deleteCity(City city) {
        cityDao.deleteCityById(city);

    }

    //Операции с работниками

    static void createNewEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);

    }

    static Object findEmployeeById(Long id) {
        try {
            return employeeDAO.findEmployeeById(id);
        } catch (NotFoundObjectException e) {
            return e.getMessage();
        }
    }

    static void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    static void deleteEmployee(Employee employee) {
        employeeDAO.deleteById(employee);

    }

    static void printEmployees() {
        try {
            for (Employee employee : employeeDAO.getAll()) {
                System.out.println(employee);
            }
        } catch (ListIsEmptyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        printEmployees();


    }
}



