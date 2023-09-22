package br.com.trajy.storespring.api.model.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@JsonInclude(NON_NULL)
@NoArgsConstructor
@Getter
@Setter
@Data
@SuperBuilder
public class OwnerPostDto {

    private String name;

    private String type;

    private String contactNumber;

}
