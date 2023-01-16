package co.istad.istadvdo.api.user;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String buildInsertSql() {
        return new SQL(){{
            INSERT_INTO("users");
            VALUES("uuid", "#{user.uuid}");
            VALUES("username", "#{user.username}");
            VALUES("family_name", "#{user.familyName}");
            VALUES("given_name", "#{user.givenName}");
            VALUES("gender", "#{user.gender}");
            VALUES("dob", "#{user.dob}");
            VALUES("phone", "#{user.phone}");
            VALUES("biography", "#{user.biography}");
            VALUES("created_at", "NOW()");
            VALUES("status", "#{user.status}");
        }}.toString();
    }
    public String buildSelectByIdSql(){
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("id = #{id}");
        }}.toString();
    }
    public String buildSelectSql(){
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("status = #{status}");
            ORDER_BY("id DESC");

        }}.toString();
    }
    public String buildSelectByUuidSql(){
        return new SQL() {{
            SELECT("*");
            FROM("users");
            WHERE("uuid = #{uuid}");
        }}.toString();
    }
    public String buildSelectUserRoles() {
        return new SQL() {{
            SELECT("*");
            FROM("roles r");
            INNER_JOIN("users_roles ur ON ur.role_id = r.id");
            WHERE("ur.user_id = #{id}");
        }}.toString();
    }


}
