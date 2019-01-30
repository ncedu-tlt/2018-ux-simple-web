package ru.ncedu.simpleweb.repositories;

import ru.ncedu.simpleweb.models.Offering;
import ru.ncedu.simpleweb.models.OfferingId;
import ru.ncedu.simpleweb.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class OfferingsRepository implements Repository<Offering, OfferingId> {


    private static OfferingsRepository instance;

    private final List<Offering> offerings;

    private OfferingsRepository() {
        offerings = new ArrayList<>();
    }

    public static OfferingsRepository getInstance() {
        if (instance == null) {
            instance = new OfferingsRepository();
        }
        return instance;
    }


    @Override
    public List get() {
        List<Offering> offeringsList = new ArrayList<>();

        Connection connection = DBUtils.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM offering");

            while (resultSet.next()) {
                Offering offering = new Offering();
                offering.setOfficeId(resultSet.getLong("office_id"));
                offering.setProductId(resultSet.getLong("product_id"));
                offering.setOfferingPrice(resultSet.getDouble("offering_price"));

                offeringsList.add(offering);
            }
        } catch (SQLException e) {
            System.out.println();
            e.printStackTrace();
        }
        finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }
        return offeringsList;
    }

    @Override
    public Offering get(OfferingId id) {

        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM offering " +
                            "WHERE office_id= ?, product_id = ?");
            statement.setLong(1, id.getOfficeId());
            statement.setLong(2, id.getProductId());
            statement.execute();

            resultSet = statement.getResultSet();
            if (resultSet.next()) {
                Offering offering = new Offering();
                offering.setOfferingPrice(resultSet.getDouble("offering_price"));
                offering.setOfficeId(resultSet.getLong("office_id"));
                offering.setProductId(resultSet.getLong("product_id"));

                return offering;
            }
            else{
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
    public Offering add(Offering object) {

        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("INSERT INTO offering " +
                    "( offering_price, office_id, product_id )" +
                    " VALUES ( ?, ?, ?) ");
            statement.setDouble(1, object.getOfferingPrice());
            statement.setLong(2, object.getOfficeId());
            statement.setLong(3, object.getProductId());
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return object;
    }

    @Override
    public Offering update(Offering object) {

        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(
                    "UPDATE offering " +
                            "SET offering_price = ? " +
                            "WHERE product_id = ?, office_id = ? ");

            statement.setDouble(1, object.getOfferingPrice());
            statement.setLong(2, object.getProductId());
            statement.setLong(3, object.getOfficeId());
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(statement);
            DBUtils.close(connection);
        }
        return object;
    }

    @Override
    public boolean remove(Offering offering) {
        return removeById(new OfferingId(offering.getOfficeId(),offering.getProductId()));
    }

    @Override
    public boolean removeById(OfferingId id) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(
                    "DELETE FROM offering " +
                            "WHERE office_id = ?, product_id");

            statement.setLong(1, id.getOfficeId());
            statement.setLong(2, id.getProductId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(statement);
            DBUtils.close(connection);
        }

        return true;
    }
}
