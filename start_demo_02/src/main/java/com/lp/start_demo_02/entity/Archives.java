package com.lp.start_demo_02.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author lipeng
 * @Date 2023/6/5 9:42
 * @Version 1.0
 */
@Data
public class Archives implements Serializable {

    private static final long serialVersionUID = 8300918062248240220L;
    // 终端地址(BCD编码,当存在字母时字母大写)
    private String terminalAddr;
    // 终端资产号(BCD编码,当存在字母时字母大写)
    private String terminalAssetNo;
    // 终端规约(5代表376.1-09规约,6代表376.1-13规约,24代表698.45规约)
    private String protocolNo;
    // 终端通讯方式(02代表GPRS,4G5G等全网通均可以用02正常通信)
    private String collMode;
    // 操作类型(1:新装 2:变更  3:删除 4:即装即采)
    private Byte optType;

    @Override
    public String toString() {
        return "Archives{" +
                "terminalAddr='" + terminalAddr + '\'' +
                ", terminalAssetNo='" + terminalAssetNo + '\'' +
                ", protocolNo='" + protocolNo + '\'' +
                ", collMode='" + collMode + '\'' +
                ", optType=" + optType +
                '}';
    }
}
