package com.georgievl.spring6restmvc.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BeerOrder {

    public BeerOrder(UUID id,
                     Long version,
                     String customerRef,
                     LocalDateTime createdDate,
                     LocalDateTime lastModifiedDate,
                     Customer customer,
                     Set<BeerOrderLine> beerOrderLines,
                     BeerOrderShipment beerOrderShipment) {
        this.id = id;
        this.version = version;
        this.customerRef = customerRef;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.setCustomer(customer);
        this.beerOrderLines = beerOrderLines;
        this.setBeerOrderShipment(beerOrderShipment);
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Long version;

    @Column(length = 255)
    private String customerRef;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

    public void setBeerOrderShipment(BeerOrderShipment beerOrderShipment) {
        this.beerOrderShipment = beerOrderShipment;
        beerOrderShipment.setBeerOrder(this);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.getBeerOrders().add(this);
    }

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "beerOrder")
    private Set<BeerOrderLine> beerOrderLines;

    @OneToOne(cascade = CascadeType.PERSIST)
    private BeerOrderShipment beerOrderShipment;
}
