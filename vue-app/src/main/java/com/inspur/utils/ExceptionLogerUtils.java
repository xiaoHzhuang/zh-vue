/**
 * @Package: com.inspur.util
 * @author: zhuanghuan
 * @date: 2020年2月18日 下午5:10:02
 */


package com.inspur.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @ClassName: ExceptionExtractUtils
 * @Description: TODO
 * @author: zhuanghuan
 * @date: 2020年2月18日 下午5:10:02
 */
public class ExceptionLogerUtils {

    public static String getErrmessage(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        t.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.getBuffer().toString();
    }
}
