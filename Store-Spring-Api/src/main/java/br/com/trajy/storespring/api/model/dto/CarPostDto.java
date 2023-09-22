package br.com.trajy.storespring.api.model.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;

@JsonInclude(NON_NULL)
@NoArgsConstructor
@Getter
@Setter
@Data
@SuperBuilder
public class CarPostDto {

    private String model;

    private String brand;

    private String description;

    private String engineVersion;

    private String city;

    private BigDecimal price;

    private Long ownerId;

    private String ownerName;

    private String contact;

}

