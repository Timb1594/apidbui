package layers.api.dto.blacklist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountLocksResponse {
    private List<AccountLockDto> items;
    private int pageNumber;
    private int totalPages;
    private int totalCount;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
}
