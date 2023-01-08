package co.istad.istadvdo.api.user;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String buildInsertSql() {
        return new SQL(){{
            INSERT_INTO("users");
            VALUES("uuid", "#{user.uuid}");
            VALUES("username", "#{user.username}");
            VALUES("email", "#{user.email}");
            VALUES("family_name", "#{user.familyName}");
            VALUES("given_name", "#{user.givenName}");
            VALUES("phone", "#{user.phone}");
            VALUES("biography", "#{user.biography}");
            VALUES("password", "#{user.password}");
        }}.toString();
    }

}
