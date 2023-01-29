package pl.finansepal.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncomeDTO {

    private Long id;
    private BigDecimal amount;
    private String currency;
    private String name;
    private List<TagDTO> tags;
    private UserDTO user;

}
