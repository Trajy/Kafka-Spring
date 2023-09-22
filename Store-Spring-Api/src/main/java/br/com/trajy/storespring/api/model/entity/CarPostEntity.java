package br.com.trajy.storespring.api.model.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "car_post")
@NoArgsConstructor
@Getter
@Setter
@Data
@SuperBuilder
public class CarPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "car_model", nullable = false)
    private String model;

    @Column(name = "car_brand", nullable = false)
    private String brand;

    @Column(name = "car_description", nullable = false)
    private String description;

    @Column(name = "car_engine_version")
    private String engineVersion;

    @Column(name = "car_city", nullable = false)
    private String city;

    @Column(name = "car_price", nullable = false)
    private BigDecimal price;

    @ManyToOne(cascade = ALL, optional = false)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false, updatable = false)
    private OwnerPostEntity owner;

}

