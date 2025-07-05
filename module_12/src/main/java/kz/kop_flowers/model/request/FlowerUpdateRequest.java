package kz.kop_flowers.model.request;

import kz.kop_flowers.model.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlowerUpdateRequest {

    private String name;

    private String size;

    private BigDecimal price;

    private CategoryDto category;
}
