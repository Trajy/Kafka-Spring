package br.com.trajy.storespring.api.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "owner_post")
@NoArgsConstructor
@Getter
@Setter
@Data
@SuperBuilder
public class OwnerPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "owner_name")
    private String name;

    @Column(name = "owner_type")
    private String type;

    @Column(name = "owner_contact_number")
    private String contactNumber;

}
