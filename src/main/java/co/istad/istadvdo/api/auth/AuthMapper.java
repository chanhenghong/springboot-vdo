package co.istad.istadvdo.api.auth;

import co.istad.istadvdo.api.user.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthMapper {

    @InsertProvider(type = AuthProvider.class, method = "buildRegisterSql")
    void register(@Param("user") User user);

}
