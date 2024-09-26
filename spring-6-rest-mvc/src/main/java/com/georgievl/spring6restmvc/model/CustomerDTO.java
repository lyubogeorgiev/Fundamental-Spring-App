package com.georgievl.spring6restmvc.model;

import com.georgievl.spring6restmvc.entities.BeerOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Builder
@Data
public class CustomerDTO {
    private UUID id;

    @NotNull
    @NotBlank
    private String name;
    private String email;
    private int version;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    private Set<BeerOrder> beerOrders;
}
