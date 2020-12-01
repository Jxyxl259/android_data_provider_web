package com.jiang.android.web.filter;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
//    private static String[] filterChar = {"'", "\"", "\\\\", "#", "%3E", "%3e", ">", "u003e"};
//    private static String[] replaceChar = {"‘", "“", "＼", "＃", "＞", "＞", "＞", "＞"};
    private static String[] filterChar = {"\\\\", "#", "%3E", "%3e", ">", "u003e"};
    private static String[] replaceChar = {"＼", "＃", "＞", "＞", "＞", "＞"};
    private static String[] removeFliterChar = {
            "onchange",
            "ontoggle",
            "onclick",
            "ondblclick",
            "onerror",
            "onfocus",
            "onkeydown",
            "onkeypress",
            "onkeyup",
            "onblur",
            "onabort",
            "onload",
            "onmousedown",
            "onmousemove",
            "onmouseout",
            "onmouseover",
            "onmouseup",
            "onreset",
            "onresize",
            "onselect",
            "onsubmit",
            "onunload",
            "alert("
    };

    HttpServletRequest orgRequest = null;
    private static Logger logger = LoggerFactory.getLogger(XssHttpServletRequestWrapper.class);

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        orgRequest = request;
    }

    /**
     * 覆盖getParameter方法，将参数名和参数值都做xss过滤。<br/>
     * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取<br/>
     * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
     */
    @Override
    public String getParameter(String name) {
        String value = super.getParameter(xssEncode(name));
        if (value != null) {
            value = xssEncode(value);
        }
        return value;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> paramMap = super.getParameterMap();
        Set<String> keySet = paramMap.keySet();
        for (Iterator iterator = keySet.iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            String[] str = paramMap.get(key);
            for (int i = 0; i < str.length; i++) {
                str[i] = str[i] + "1";
                xssEncode(str[i]);
            }
        }
        return paramMap;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values != null) {
            int length = values.length;
            String[] escapseValues = new String[length];
            for (int i = 0; i < length; i++) {
                escapseValues[i] = xssEncode(values[i]);
            }
            return escapseValues;
        }
        return super.getParameterValues(name);
    }

    /**
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/>
     * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/> getHeaderNames 也可能需要覆盖
     */
    @Override
    public String getHeader(String name) {

        String value = super.getHeader(xssEncode(name));
        if (value != null) {
            value = xssEncode(value);
        }
        return value;
    }

    public static void main(String[] args) {
        String res = "<script>alert(document.cookie)</script>";
        res = xssEncode(res);
        System.out.println(res);
    }

    /**
     * 将容易引起xss漏洞的半角字符直接替换成全角字符
     *
     * @param s
     * @return
     */
    public static String xssEncode(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        for (int i = 0; i < filterChar.length; i++) {
            String fil = filterChar[i];
            s = s.replaceAll(fil, replaceChar[i]);
        }
        for (String rc : removeFliterChar) {
            if (s.toLowerCase().indexOf(rc) != -1) {
                return "";
            }
        }

        s = s.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        s = s.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
//        s = s.replaceAll("'", "&#39;");
        s = s.replaceAll("eval\\((.*)\\)", "");
        s = s.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        s = s.replaceAll("script", "");
        return s;
    }

    /**
     * 获取最原始的request
     *
     * @return
     */
    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }

    /**
     * 获取最原始的request的静态方法
     *
     * @return
     */
    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
        if (req instanceof XssHttpServletRequestWrapper) {
            return ((XssHttpServletRequestWrapper) req).getOrgRequest();
        }

        return req;
    }
}
