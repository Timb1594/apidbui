package layers.api.dto;

import layers.api.models.AccountDto;
import lombok.Data;

@Data
public class TransactionItemDto {
    private int id;
    private String number;
    private AccountDto sourceAccount;
    private AccountDto destinationAccount;
    private double fee;
    private double amount;
    private String currency;
    private String status;
    private String created;
    private String lastModified;
}
