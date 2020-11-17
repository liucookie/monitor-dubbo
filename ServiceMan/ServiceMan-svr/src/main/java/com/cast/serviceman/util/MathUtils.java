package com.cast.serviceman.util;

import java.text.DecimalFormat;

public class MathUtils {

    /**
     * 四舍五入..不保留小数
     * @param value
     * @return
     */
    public static String get(double value){
        DecimalFormat df1 = new DecimalFormat("0.00");//格式化小数，不足的补0

        String gaver = df1.format((value));
        double d = Double.valueOf(gaver) * 100;
        DecimalFormat df = new DecimalFormat("0");
        return df.format(d);
    }
}
