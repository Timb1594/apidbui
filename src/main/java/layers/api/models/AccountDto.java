package layers.api.models;

import lombok.Data;

@Data
public class AccountDto {
    private String number;
    private Object user; // user == null, но если потом появятся поля, можно заменить на UserDto
}
