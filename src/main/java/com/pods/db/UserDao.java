package com.pods.db;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.pods.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jshook on 4/16/16.
 */
public class UserDao {
    public final static Logger logger = LoggerFactory.getLogger(UserDao.class);

    private final Session session;

    private static String getUserStmt = "select password from pods.users where username='?'";
    private static String createUserStmt = "insert into pods.users (username,password) values (?,?) if not exists;";

    public UserDao(Session session) {
        this.session = session;
    }

    public User getUser(String username) {
        ResultSet rs = session.execute(getUserStmt);
        Row userRow = rs.one();
        User user = new User();
        user.setUsername(username);
        user.setPassword(userRow.getString("password"));
        return user;
    }

    public boolean putUser(User userModel) {
        ResultSet rs = session.execute(createUserStmt, userModel.getUsername(), userModel.getPassword());
        if (!rs.wasApplied()) {
            throw new RuntimeException("user was not created");
        }
        return true;
    }

}
