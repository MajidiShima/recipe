package com.parsa.recipe.common;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BaseDTO {
    @ApiModelProperty(required = true,hidden = true)
    private Long id;

    @ApiModelProperty(required = true,hidden = true)
    private Integer version;

    @ApiModelProperty(required = true,hidden = true)
    private Date createdDate;

    @ApiModelProperty(required = true,hidden = true)
    private String createdBy;

    @ApiModelProperty(required = true,hidden = true)
    private Date lastModifiedDate;

    @ApiModelProperty(required = true,hidden = true)
    private String lastModifiedBy;

}
