package com.parsa.recipe.category;


import com.parsa.recipe.category_list.CategoryList;
import com.parsa.recipe.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Data
@Audited
@Entity
@Table(name = "tbl_category")

public class Category extends BaseEntity {

@Column(name = "title")
private String title;



@OneToMany(mappedBy = "category",fetch = FetchType.LAZY,cascade =CascadeType.ALL)
private List<CategoryList> categoryLists;




}
