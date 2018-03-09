package com.magic.szh.util.number;

import android.text.TextUtils;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.util.number
 * file: NumberUtil
 * author: admin
 * date: 2018/3/9
 * description: 数字格式化工具类
 */

public class NumberUtil {
    public static int toInt(String string) {
        return Integer.parseInt(string);
    }

    /**
     * 格式化货币
     * @param number 需要格式化的金额
     * @return 格式化后的金额
     */
    public static String formatCurrency(double number) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumIntegerDigits(1);
        return numberFormat.format(number);
    }

    /**
     * 格式化货币
     * @param string 需要格式化的金额
     * @return 格式化后的金额 （如果不是数字 或小于0 返回null）
     */
    public static String formatCurrency(String string) {
        double number;
        try {
            number = Double.valueOf(string);
            if (number < 0) return null;
        } catch (NumberFormatException e) {
            number = -1;
        }
        if (number == -1) {
            return null;
        }
        return formatCurrency(number);
    }
}
