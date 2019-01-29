package ru.ncedu.simpleweb.repositories;

import ru.ncedu.simpleweb.models.Office;
import ru.ncedu.simpleweb.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfficesRepository implements Repository<Office>{

    private static OfficesRepository instance;

    private final List<Office> offices;

    private OfficesRepository(){
        offices = new ArrayList<>();
    }

    public static OfficesRepository getInstance(){
        if (instance==null){
            instance = new OfficesRepository();
        }
        return instance;
    }

    @Override
    public List<Office> get() {
        List<Office> officeList = new ArrayList<>();

        Connection connection = DBUtils.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM office");

            while (resultSet.next()){
                Office office = new Office();
                office.setId(resultSet.getLong("office_id"));
                office.setName(resultSet.getString("office_name"));
                office.setPhoneNumber(resultSet.getString("office_phone_number"));
                office.setCityId(resultSet.getLong("city_id"));

                officeList.add(office);
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return officeList;
    }

    @Override
    public Office get(long id) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM office WHERE office_id = ?");
            statement.setLong(1, id);
            statement.execute();
            resultSet = statement.getResultSet();

            if (resultSet.next()){
                Office office = new Office();
                office.setId(resultSet.getLong("office_id"));
                office.setName(resultSet.getString("office_name"));
                office.setPhoneNumber(resultSet.getString("office_phone_number"));
                office.setCityId(resultSet.getLong("city_id"));

                return office;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }
    }

    @Override
    public Office add(Office object) {
        Office office = new Office(object);

        Connection connection=DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("INSERT  INTO office (office_name, city_id, office_phone_number) VALUES (?,?,?) RETURNING office_id");
            statement.setString(1,office.getName());
            statement.setLong(2,office.getCityId());
            statement.setString(3,office.getPhoneNumber());
            statement.execute();

            resultSet = statement.getResultSet();

            if (resultSet.next()){
                office.setId(resultSet.getLong("office_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return office;
    }

    @Override
    public Office update(Office object) {
        Office office = new Office(object);

        Connection connection=DBUtils.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE  office SET office_name = ?, city_id = ?, office_phone_number = ? WHERE office_id = ?");
            statement.setString(1,object.getName());
            statement.setLong(2,object.getCityId());
            statement.setString(3,object.getPhoneNumber());
            statement.setLong(4, object.getId());
            statement.execute();
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        finally {
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return office;
    }

    @Override
    public boolean remove(Office object) {
        return remove(object.getId());
    }

    @Override
    public boolean remove(long id) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM office WHERE office_id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        finally {
            DBUtils.close(statement);
            DBUtils.close(connection);
        }
        return true;
    }
}
