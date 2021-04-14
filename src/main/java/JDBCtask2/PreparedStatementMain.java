package JDBCtask2;

import java.sql.SQLException;
import java.util.List;

public class PreparedStatementMain {
    public static void main(String[] args) {

        try {
            UserRepository userRepository = new UserRepository();
            List<User> users = userRepository.findUsersByName("Danny");

            users.forEach(System.out::println);

            User user = new User();
            user.setName("David");
            user.setEmail("fafaf@gmail.com");
            user.setCountry("Latvia");

            userRepository.insertUser(user);

            userRepository.deleteUser(1);

            User userHaroldTheEmigrant = new User(2, "Harold", "harrrrrr@gmail.com", "Estonia");
            userRepository.updateUser(userHaroldTheEmigrant);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
