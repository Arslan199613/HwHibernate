package dao.cityDao;

import model.City;

public interface CityDao {
    City findCityById(Long id);


    void createNewCity(City city);

    void updateCityById(City city);

    void deleteCityById(City city);
}
