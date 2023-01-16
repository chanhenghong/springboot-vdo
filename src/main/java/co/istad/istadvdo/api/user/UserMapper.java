package co.istad.istadvdo.api.user;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserMapper {

    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @InsertProvider(type = UserProvider.class, method = "buildInsertSql")
    void insert(@Param("user") User user);

    @SelectProvider(type = UserProvider.class, method = "buildSelectByIdSql")
    Optional<User> selectById(@Param("id") Integer id);

    @SelectProvider(type = UserProvider.class, method = "buildSelectSql")
    @Results(id = "userResultMapper", value = {
            @Result(property = "familyName", column = "family_name"),
            @Result(property = "givenName", column = "given_name"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "roles", column = "id", many = @Many(select = "selectUserRoles"))

    })
    List<User> select(@Param("status") Boolean status);

    @SelectProvider(type = UserProvider.class, method = "buildSelectByUuidSql")
    @ResultMap(value = "userResultMapper")
    Optional<User> selectByUuid(@Param("uuid") String uuid);

    @Delete("DELETE FROM users WHERE uuid = #{uuid}")
    void deleteByUuid(@Param("uuid") String uuid);

    @SelectProvider(type = UserProvider.class, method = "buildSelectUserRoles")
    List<Role> selectUserRoles(@Param("id") Integer id);



}
