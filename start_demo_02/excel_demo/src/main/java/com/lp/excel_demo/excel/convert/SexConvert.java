package com.lp.excel_demo.excel.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

/**
 * excel性别转换器
 *
 * 1：男
 * 0：女
 * @Author lipeng
 * @Date 2023/2/1 9:28
 * @Version 1.0
 */
public class SexConvert implements Converter<Integer> {
    @Override
    public Class<?> supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里读的时候会调用，将Excel中的字段汉字转换成Java的Integer对象
     *
     * @param context context
     * @return Java中的Integer对象
     */
    @Override
    public Integer convertToJavaData(ReadConverterContext<?> context) {
        return context.getReadCellData().getStringValue().equals("男") ? 1 : 0;
    }

    /**
     * 这里是写的时候会调用，将Java的Integer对象转换成Excel中的字符串
     *
     * @return Excel中要存储的字符串
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<Integer> context) {
        String gender = context.getValue() == 1 ? "男" : "女";
        return new WriteCellData<String>(gender);
    }
}
