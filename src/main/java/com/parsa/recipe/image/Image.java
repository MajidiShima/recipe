package com.parsa.recipe.image;

import com.parsa.recipe.common.BaseEntity;
import com.parsa.recipe.recipe.Recipe;
import com.parsa.recipe.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "tbl_image")
@Data
@Audited
public class Image extends BaseEntity {

    @Column(name = "image")
    private String images;

    @ManyToOne()
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @OneToOne()
    @JoinColumn(name = "user-id")
    private User user;

}
