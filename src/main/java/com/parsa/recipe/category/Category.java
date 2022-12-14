package com.parsa.recipe.category;


import com.parsa.recipe.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Audited
@Entity
@Table(name = "tbl_category")

public class Category extends BaseEntity {

@Column(name = "name")
private String name;


@Column(name="department")
private String department;


}
