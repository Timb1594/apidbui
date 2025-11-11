package layers.api.dto;

import lombok.Data;
import java.util.List;

@Data
public class TransactionsResponse {
    private List<TransactionItemDto> items;
    private int pageNumber;
    private int totalPages;
    private int totalCount;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
}
