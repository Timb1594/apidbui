package layers.api.dto.blacklist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

    public class AccountLockDto {
        private String accountNumber;
        private String lockType;  // было LockTypeDto, заменяем на String
        private String command;
    }


