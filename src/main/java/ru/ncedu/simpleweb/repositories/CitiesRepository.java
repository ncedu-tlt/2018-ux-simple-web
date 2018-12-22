package ru.ncedu.simpleweb.repositories;

import ru.ncedu.simpleweb.models.City;
import ru.ncedu.simpleweb.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitiesRepository implements Repository<City> {

    private static CitiesRepository instance;

    private CitiesRepository() {
        cities = new ArrayList<>();
    }

    public static CitiesRepository getInstance() {
        if (instance == null) {
            instance = new CitiesRepository();
        }
        return instance;
    }

    public List<City> get() {
        
        Connection connection = DBUtils.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM city");
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getLong("city_id"));
                city.setName(resultSet.getString("city_name"));
                city.setPhoneExtension(resultSet.getString("city_phone_extension"));
                city.setDescription(resultSet.getString("city_description"));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return cities;
    }

    @Override
    public City get(long id) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM city WHERE city_id=?");
            statement.setLong(1, id);
            statement.execute();
            resultSet = statement.getResultSet();

            if (resultSet.next()) {
                City city = new City();

                city.setId(resultSet.getLong("city_id"));
                city.setName(resultSet.getString("city_name"));
                city.setPhoneExtension(resultSet.getString("city_phone_extension"));
                city.setDescription(resultSet.getString("city_description"));

                return city;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }
    }

    public City add(City object) {
        City city = new City(object);

        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(
                    "INSERT INTO city (city_name, city_phone_extension, city_description) " +
                            "VALUES (?, ?, ?) RETURNING city_id");
            statement.setString(1, city.getName());
            statement.setString(2, city.getPhoneExtension());
            statement.setString(3, city.getDescription());
            statement.execute();

            resultSet = statement.getResultSet();
            if (resultSet.next()) {
                city.setId(resultSet.getLong("city_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return city;
    }

    public City update(City object) {
        City city = new City(object);

        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(
                    "UPDATE city SET (city_name, city_phone_extension, city_description) = (?, ?, ?) " +
                            "WHERE city_id=(?)");
            statement.setString(1, city.getName());
            statement.setString(2, city.getPhoneExtension());
            statement.setString(3, city.getDescription());
            statement.setLong(4, city.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return city;
    }

    public boolean remove(City city) {
        return remove(city.getId());
    }

    @Override
    public boolean remove(long id) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM city WHERE city_id=(?)");
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return true;
    }
}