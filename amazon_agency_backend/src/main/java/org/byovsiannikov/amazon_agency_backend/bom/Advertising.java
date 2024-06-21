package org.byovsiannikov.amazon_agency_backend.bom;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Advertising {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Min(value = 0, message = "Performance should be greater than 0")
    private int performance;
}
