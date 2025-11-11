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
public class AccountTransactionLimitDto {
    private boolean isPermanently;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private Double amount;
    private Long accountId;
}