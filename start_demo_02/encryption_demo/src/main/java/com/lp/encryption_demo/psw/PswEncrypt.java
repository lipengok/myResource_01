package com.lp.encryption_demo.psw;

/**
 * 密码加密
 *
 * @Author lipeng
 * @Date 2023/2/1 16:49
 * @Version 1.0
 */
public class PswEncrypt {

    /**
     *
     * @param value 加密/解析密码
     * @param secret 加密字符
     * @return
     */
    public static String dealStr(String value, char secret)
    {
        byte[] bt=value.getBytes(); //将需要加密的内容转换为字节数组
        for(int i=0;i<bt.length;i++)
        {
            bt[i]=(byte)(bt[i]^(int)secret); //通过异或运算进行加密
        }
        String res=new String(bt,0,bt.length);
        return res;
    }

    public static void main(String[] args){
        String psw = "981021xx";
        System.out.println(psw);
        String enStr = dealStr(psw, 'a');
        System.out.println(enStr);
        String unStr = dealStr(enStr, 'a');
        System.out.println(unStr);
    }
}
