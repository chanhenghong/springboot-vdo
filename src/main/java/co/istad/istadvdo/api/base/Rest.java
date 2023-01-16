package co.istad.istadvdo.api.base;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class Rest<T>{

    String message;
    Boolean status;
    Integer code;
    Timestamp timestamp;
    T data;
}
