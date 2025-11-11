package layers.api.dto;

import layers.api.models.AccountPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountPlansResponse {
    private List<AccountPlan> items;
    private int pageNumber;
    private int totalPages;
    private int totalCount;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
}
