package co.istad.istadvdo.api.base;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ValidationError {
    private String field;
    private String detail;
}
