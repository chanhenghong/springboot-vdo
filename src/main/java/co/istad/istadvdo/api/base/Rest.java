package co.istad.istadvdo.api.base;

import java.sql.Timestamp;

public record Rest<T>(
        String message,
        Boolean status,
        Integer code,
        Timestamp timestamp,
        T data
) {
}
