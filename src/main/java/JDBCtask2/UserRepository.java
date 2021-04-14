package JDBCtask2;

import JDBCtask1.DatabaseUtilieties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final String SELECT_USER = "SELECT id, name, email, country FROM user WHERE name = ?";
    private static final String INSERT_USER = "INSERT INTO user (name, email, country) VALUES (?, ?, ?)";
    private static final String DELETE_USER = "DELETE FROM user WHERE id = ?";
    private static final String UPDATE_USER = "UPDATE user SET name = ?, email = ?, country = ? WHERE id = ?";


    private Connection connection;

    public UserRepository() throws SQLException {
        this.connection = DatabaseUtilieties.openConnection();
    }
    public void updateUser (User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getId());
            int upadateRows = preparedStatement.executeUpdate();
            System.out.println("Update operation returned: " + (upadateRows == 1 ? "Ok": "Nothing was updated"));

        }catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
    }

    public void deleteUser (int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, id);
            int deletedRows = preparedStatement.executeUpdate();
            System.out.println("Deleted operation returned: " + (deletedRows == 1 ? "Ok" : "Nothing was deleted"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void insertUser (User user){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_USER);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            int insertedRows = preparedStatement.executeUpdate();
            System.out.println("Insert operation returned: " + (insertedRows == 1 ? "Ok": "Nothing was inserted"));
            System.out.println("Inserted object was: " + user);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> findUsersByName (String name){
        List<User> users = new ArrayList<>();

        try {
            processUserResult(name, users);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    private void processUserResult(String name, List<User> users) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int userId = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            String userEmail = resultSet.getString("email");
            String userCountry = resultSet.getString("country");

            users.add(new User(userId, userName, userEmail, userCountry));
        }
    }
}
