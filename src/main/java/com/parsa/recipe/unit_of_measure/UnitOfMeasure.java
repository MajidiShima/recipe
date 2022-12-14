package com.parsa.recipe.unit_of_measure;

import com.parsa.recipe.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "tbl_unitOfMeasure")
@Audited

public class UnitOfMeasure extends BaseEntity {


}
