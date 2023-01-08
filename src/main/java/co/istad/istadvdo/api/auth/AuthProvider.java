package co.istad.istadvdo.api.auth;

import org.apache.ibatis.jdbc.SQL;

public class AuthProvider {

    public String buildRegisterSql() {
        return new SQL() {{
            INSERT_INTO("users");
            VALUES("uuid", "#{user.uuid}");
            VALUES("email", "#{user.email}");
            VALUES("family_name", "#{user.familyName}");
            VALUES("given_name", "#{user.givenName}");
            VALUES("gender", "#{user.gender}");
            VALUES("password", "#{user.password}");
            VALUES("created_at", "NOW()");
        }}.toString();
    }

}
