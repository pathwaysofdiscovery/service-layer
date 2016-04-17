package com.pods.db;

import com.pods.models.User;
import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by jshook on 4/16/16.
 */

@Test
public class TestUserDAO {

    @Test
    public void testBasicDAO() {
        CassandraContext ctx = new CassandraContext();
        UserDao ud = new UserDao(ctx.getSession());
        boolean applied = ud.putUser(new User("user12", "pass13"));
        System.out.println(applied);
    }
}
