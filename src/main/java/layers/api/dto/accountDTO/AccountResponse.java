package layers.api.dto.accountDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountResponse {
    private Long id;
    private String number;
    private Double balance;
    private Integer currency;
    private Integer status;
    private Integer accountPlanId;
    private AccountPlanResponse accountPlan;
    private AccountTransactionLimitDto accountTransactionLimit;
    private LocalDateTime createdDate;
}
