package com.lp.start_demo_02.entity;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2023/6/5 9:45
 * @Version 1.0
 */
@Data
public class Archives2 {

    // 终端地址(BCD编码,当存在字母时字母大写)
    private String terminalAddr;

    // 终端规约(5代表376.1-09规约,6代表376.1-13规约,24代表698.45规约)
    private String protocolNo;

    // 操作类型(1:新装 2:变更  3:删除 4:即装即采)
    private Byte optType;
}
