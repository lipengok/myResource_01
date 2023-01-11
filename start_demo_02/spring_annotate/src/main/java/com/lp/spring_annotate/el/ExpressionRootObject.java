package com.lp.spring_annotate.el;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author lipeng
 * @Date 2023/1/11 9:43
 * @Version 1.0
 */
@Getter
@ToString
@AllArgsConstructor
public class ExpressionRootObject {
    private final Object object;
    private final Object[] args;
}
