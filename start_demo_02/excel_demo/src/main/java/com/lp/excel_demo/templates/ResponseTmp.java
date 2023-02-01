package com.lp.excel_demo.templates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应
 *
 * @Author lipeng
 * @Date 2023/2/1 10:03
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTmp {

    private String msg;
    private String code;
    private Object data;
}
