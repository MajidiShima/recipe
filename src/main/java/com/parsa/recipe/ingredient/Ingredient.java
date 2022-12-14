package com.parsa.recipe.ingredient;


import com.parsa.recipe.common.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tbl_ingredient")

public class Ingredient extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private BigDecimal amount;




}
