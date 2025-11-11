package layers.api.dto.accountDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountPageResponse {
    private List<AccountResponse> items;
    private int pageNumber;
    private int totalPages;
    private int totalCount;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
}