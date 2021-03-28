package work;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpServerWork {

    public static void main(String[] args) {
        doGet();
    }

    public static void doGet()  {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://localhost:8801");

        httpGet.addHeader("Accept","text/html, application/xhtml+xml, */*");
        httpGet.addHeader("Accept-Language","zh-CN,en-US;q=0.5");
        httpGet.addHeader("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
        httpGet.addHeader("Accept-Encoding","gzip, deflate");
        httpGet.addHeader("Connection","Keep-Alive");

        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            System.out.println("从服务器端获取的内容为：" + EntityUtils.toString(httpResponse.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
