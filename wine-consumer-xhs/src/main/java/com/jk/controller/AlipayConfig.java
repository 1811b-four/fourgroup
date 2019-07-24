package com.jk.controller;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101100657417";//例：2016082600317257

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC5fbwGCMzPW43O41pKK4aF81/1vEaVbTN44lA2KEV9zMor5SziGy91W8NPbbLs0R9Xtw4PC0vWZelm+M6GaOsBgK8hHsXou5vhKDsxF9Q7FuJo3RailPQYEq7jAGyg5JuFh2kNiRvCbP2zWnUliCwFwYbOTXkesxDQFxJspO52sIKRVp/y0wZf0K8ufymT4/amewtPsFIQuDbOl6MesJF0Q5tCf04i89635HGTvFO6FAauNIrCbLihX5fjlJZEDoBcEsrObCBSqxvKvtg4HBO0Z83fwMnVCq05ag5dTTFHiiduu0bhX02a8Bfrh/SLJVoaGXiVjtIb7es/x24kGmhDAgMBAAECggEBAJKfTO0IL70JBcMv+8L9PMzNYGECfljHhRRc8EKe+q9CHd0svpnMG2uNKYmzkOeZNklDrZ0+tKe4zxJSQg4FCR6a9dQcWxxokAMepgtcZqp+oGF7wdSqIXiV7CALydI0YqreKrBEXOkG9lO7gTY1uXajT0fr/X3C1dtnIW03wjeWW/lS8uLPQpPpA8BT4mfi3KY8kWKW2j+mq3/g4n7PgR4dEWTcvBcMbcH1GH4GTsg+eCl2yKIZEnKP7LGOrNmaD2N6CtLXA+iCv5CpRHc3kClk2Zq+nUuty4D4MY3CnxxPSCDc5jgRORTLUKxGcXcEKWsFo4KHMY5Q2nN0jqaSQ8ECgYEA9SiS7T9s3nY297kcq+OqYKBJOcTqVjIuHP/1guIJ5RK1zHdALgdzGa5MTu11C3C9DXcryUgT3hmf6J9wj4NU59aMfODhyxw7F9ePXmk2Z5e6pCBYIF4A8+C33sC73un1QbE6AL8B8skUcDUHafZZE1hgbpPAGBjWkxiYEGpb8AsCgYEAwbGrdoCMVqpFBHuxMFya5Tlxpb40mEWPPo+TRPIFfsBTM51qpbFQKLrACE4Be1Tgm5mEhnMpzlDxhTwPKRYffSMPHnGS1romhaSWpyuutDEhTE1VXo6k4LVTJ4l96AuOqzCzbUmaw7tmpeqIYVIYwIY6t3XEHIW86EqIcdo8c6kCgYEAjafAHe4EDhbodAM2GewWynZTWVn6vYuJMaCET/gkF4TUHyzYnMAZNcGMvh5e/xlJY7p0Rn2rXS4ZQ+S8uW/9Y2iJDK80SJQrYP9hDABnOzxkz+kQgsNOcZxrIf7jj05INIkfJsc3bP3bHWrGuedqWM88CSi+Wi4f7ibL1tBeBzkCgYBnoBwxm/h47UNbcKmNTB36gM8Scz5EMQK/36RUgH78HvzkYlWKK+DMyYyvZLxaNUCtPmauX7KAFMICG+2od5OFKVqPWQfMJW8ylKmc6jvfX2GHJuCDZCFFrvy77E0V9gjwAXAdCgHosbvrDBzGpFtltOp4+GJhOBOm2ylAcBdjcQKBgD4BwL9ztihdHJgfcz6kKOcPHeae7dGV5+W1TYdzn10l5db1ew0vHa9S1dj7AEi8fchXvRNdV3Lx7veOgT86nX+HUcEMbWpiO0kWzo73n543vyD2h9rXZ0/KoDmNE4e081z+RZPYJJGWcs/i3MbbiH++hJfVlZ2K4+RH39FkppD5";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
    // 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtCXqbdM5LtFCh4QEzevWZIugPR4JppJo1Rw5tikMR++Q7ZNzhBo0uXKGB13Mq1f0nfks1k7l3UHHRkTE8AUToFGpuxvbowgg1oklF4ro3Ro5FvDvwYCiCTiAO03WD5pC1ghjXhjhf17Imc/mjmKb486hVsiMeNrVLL5GbgTCtE6voD7Hm1EMakBfJSlUdoQoxOEIRkh9qcKxdsb97esAQcF5nO44eMggfqsnB3l/R+lW8wkbwPPTdy1vJ3j79rW14+gdIYME9TwzZg5L1O7toyvz4T+xuaNFEWbd9H5tQDOIR1FJANCXoGR4Gkkk2L7nzpYK7P6Nza9ydrMw2sZmRwIDAQAB";
    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    /**
     * 返回的时候此页面不会返回到用户页面，只会执行你写到控制器里的地址
     */
    //public static String notify_url = "http://192.168.1.126:8099/notify_url";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    /**
     * 此页面是同步返回用户页面，也就是用户支付后看到的页面，上面的notify_url是异步返回商家操作，谢谢
     * 要是看不懂就找度娘，或者多读几遍，或者去看支付宝第三方接口API，不看API直接拿去就用，遇坑不怪别人
     */
    //public static String return_url = "http://192.168.1.126:8099/return_url";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 日志地址
    public static String log_path = "G:/logs/";
    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord
     *            要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_"
                    + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
