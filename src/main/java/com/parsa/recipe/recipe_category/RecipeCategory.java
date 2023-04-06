package com.parsa.recipe.recipe_category;

import com.parsa.recipe.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Audited
@Entity
@Table(name = "tbl_recipeCategory")


public class
RecipeCategory extends BaseEntity {




}
