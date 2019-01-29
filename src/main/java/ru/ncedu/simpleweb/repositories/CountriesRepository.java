package ru.ncedu.simpleweb.repositories;

import ru.ncedu.simpleweb.models.Country;
import ru.ncedu.simpleweb.utils.DBUtils;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class CountriesRepository implements Repository<Country, Long> {

    private static CountriesRepository instance;

    private CountriesRepository() {

    }

    public static CountriesRepository getInstance() {
        if (instance == null) {
            instance = new CountriesRepository();
        }
        return instance;
    }

    public List<Country> get() {
        List<Country> countries = new ArrayList<>();

        Connection connection = DBUtils.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT country_id, country_name, phone_extension, flag FROM country");

            while (resultSet.next()) {
                Country country = new Country();

                country.setId(resultSet.getLong("country_id"));
                country.setName(resultSet.getString("country_name"));
                country.setPhoneExtension(resultSet.getString("phone_extension"));
                country.setFlag(resultSet.getString("flag"));

                countries.add(country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return countries;
    }

    @Override
    public Country get(Long id) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM country WHERE country_id=(?)");
            statement.setLong(1, id);
            statement.execute();
            resultSet = statement.getResultSet();

            if (resultSet.next()) {
                Country country = new Country();

                country.setId(resultSet.getLong("country_id"));
                country.setName(resultSet.getString("country_name"));
                country.setPhoneExtension(resultSet.getString("phone_extension"));
                country.setFlag(resultSet.getString("flag"));

                return country;
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

    public Country add(Country obj) {
        Country country = new Country(obj);

        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("INSERT INTO country (country_name, phone_extension, flag) VALUES (?, ?, ?) RETURNING country_id");
            statement.setString(1, country.getName());
            statement.setString(2, country.getPhoneExtension());
            statement.setString(3, country.getFlag());

            statement.execute();
            resultSet = statement.getResultSet();

            if (resultSet.next()) {
                country.setId(resultSet.getLong("country_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return country;
    }

    public Country update(Country obj) {
        Country country = new Country(obj);

        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE country SET (country_name, phone_extension, flag) = (?, ?, ?) WHERE country_id=(?)");
            statement.setString(1, country.getName());
            statement.setString(2, country.getPhoneExtension());
            statement.setString(3, country.getFlag());
            statement.setLong(4, country.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return country;
    }

    @Override
    public boolean remove(Country country) {
        return removeById(country.getId());
    }

    @Override
    public boolean removeById(Long id) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM country WHERE country_id=(?)");
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
