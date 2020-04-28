package cn.wandingkeji.common.http;

import cn.wandingkeji.common.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;

public class PayHelper {

    public static final BigDecimal AMOUNT_ZERO = new BigDecimal(0.00);
    public static final String loginShop = new String("loginShop");

    private static final Logger log = LoggerFactory.getLogger(PageRequestHelper.class);
    public PayHelper() {
        // TODO Auto-generated constructor stub
    }

    public static String getStringByInputStream(InputStream inputStream) {
        StringBuffer sb = new StringBuffer();
        String s;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(inputStream, Constant.DEFAULT_CHARSET));
            while ((s = in.readLine()) != null) {
                sb.append(s);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (in != null)
                    in.close();
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String sendGET(String getAccessTokenUrl) {
        StringBuffer openJsonStr = new StringBuffer();
        InputStream inputStream = null;
        BufferedReader in = null;
        try {
            HttpURLConnection httpURLConnection = HttpClientUtil.getHttpURLConnection(getAccessTokenUrl);
            inputStream = httpURLConnection.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream, Constant.DEFAULT_CHARSET));
            String lines = "";
            while ((lines = in.readLine()) != null) {
                openJsonStr.append(lines);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {


            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return openJsonStr.toString();
    }
}
