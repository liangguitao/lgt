package com.gt.project.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Account implements Serializable {

    private static final long serialVersionUID = -649664918162008044L;

    //数量
    private BigDecimal amount;

    //姓名
    private String name;

}
