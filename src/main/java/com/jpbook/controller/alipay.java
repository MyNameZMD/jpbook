package com.jpbook.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jpbook.service.PersonalService;
import com.jpbook.util.Gs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.alipay.api.AlipayConstants.*;

@Controller
public class alipay {

    @Autowired
    PersonalService ps;

    @RequestMapping("pay")
    public void pay(int money,HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {

        String app_id = "2016091300504060";
        String sign_type = "RSA2";
        String charset = "utf-8";
        String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
        String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCOC0vsbkC3FM5YLX64711IMnxqDVrShhmErU5Lb2lOccHb7zyAwo7IdCewbJVyHm8bZtO9Uh6hfAJ9E5HNM5Az3aWRkn2ZTxYsM3uxTOnelgfVbYFWZBzxf+pK3qzYGzGC+1zfq4PbepBDndwafsr6KcfnyNJ/6KhHfk2qv3PJA0Mbu3f1wFFR55LD7DMalRfgZQqn1cLFSm4+X9noBxwYVW7YEkE22i6B33xG66a1DeP51eiR03pAXNNnLwAwl30ejXExNBD0FtPSyOHMW4/Ny/4EthTZB3Z4nWMYjEf8LwRWivsCgaUEOWy6Ipvm3/CIAQ5F9Edo+hh3dh/kA/S3AgMBAAECggEAYPVHExFDLXWPUFNlv9jsJL8Je9630yJkQtOFsSpQiJJQEM+hzgaALkZTXTMRY/9wOhUbjYyDihk7HaOBD8AVu8GdJdwHzeFVMkDGOwVUUnK40C/abF0UAKkfBZIwC6esSUtJXwgVjniABxe3SYKpDM/+O7IyNctbKsoFO/tJjriTYNmhak6uQvJfz0tI+yh1vgVTQhlQJqEThczJwQXog9wIpem7rG/PAwOdZ4qA9hi+pXMdXl7AzWhXrrJ/osPPGBPvK7i+qC1+kse6GdmX9Dpu5Ya8Pn3Y8C1/GMs0wscNZYds5uUz6zwz5wm9K0DwE9iNl+I6rBfhXql4y9TDkQKBgQD9ePP1eoVQX49g63EERfAO2vbrk5gCisSsmalLjuLsWzCsMu7mq5+3nbvNVaM3F3Ekeay4j7+NVANnW1m+tr8Y2w5vvYRnGfFXh23bQCU/53fQW5eS+ZM2oqdKP1xSU6olpRZK8UzBbKYnJ2QjkSVBh6Ki3q8k+7JVmqperaxhyQKBgQCPdeWjOfPOQ4nnCrapdRv35vZ0augTm2eUkTnVtEl12PyP3PWzhIe6bh/kgsHlIxT4O7bhPs+btRRoOSqVWD7TqQPBwXfU7S9C2XUJEWygVmLm4M7LACKhn4xnrl0M6MSBC6CuOQMnsyhPYV8f9Iww/ztt2xuS6IHjemcTGczifwKBgQCLa4xE6i+KFgX3eYmgoBd7FFXdHkHupAWqKptEREPtXftXvGxL1Pr1NH2oZAJyuyIwvfyTR/5E7oEwyL6EeGCEe3llXQkG7O4jBwsWHiJfFCKDKN4mqcCfvLfnzxIo9nwQWM36St+9RNXfk3sxVRT5BnIew/3yib999qTfjwfSgQKBgBwCrP+dxRi03ywZT2ju0LMqiVxZs06AvUyovl4XgXBdGZMNVXvjmIyyC9AWJ72Rh/qfzilUljyUspNW9hWK0VmKWo1uNPOCDARFaTCIEmmL9GuX4UiJkjl0aXmk9c4bdKKtnoXl49PQi0JUhLo8iVLXwsbETTH168Z6k72LABIJAoGBAKUlxt6Qm1oJ800HdSywCy9ySor27OCyNU7IC5ihSf02ZSGlC4RGWRVUYKdNA2tQfeH5ltvwOqzkC5ty4k+qzfM4nqhZx0m+VNMLNoU7EDxWVXznkrkIFYbP7sfdnz86Cl3zvk6YUt3Klneh4kF9p/Dy2na0PU5rOC8EYWUHcI4F";
        String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzCYEHoGEAAb8DWbF6N88AkATRYtBkvbFHT9azWz2syvhEWzCVFnhQAE1nX4qUDFMP8jeYljJTbaBFZON31EIc9zvwK/WKUeMdlJWfLa282FkPXgwROxjR1PIhl8xNDZ+9BXrpAAz0mruSK00XMNPkS9rT9FmRf4P3LU1VmiBa+toWLUk9gqP7/wcM7RDQmtXE4uLteVEXet5IjFjHuGuKMU0ndLbk3bBpJY+Fqb0Fc3U5xZbuWMCckuAnKb16e4pBW8K2J83RxAMwYycJzbrDVLsVuf0LqDNyOEIIS5faRDY5t3Ps1GzAqbuqtCfoFPpnpgh8stfeDPnT4wY0vapdwIDAQAB";

        //httpRequest.getServletContext().setAttribute("uuid",1);

        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, app_id, merchant_private_key, "", charset, alipay_public_key, sign_type); // 获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
        alipayRequest.setReturnUrl("http://localhost:8080/jpbook/success?money="+money+"&uuid="+Gs.getsession(httpRequest.getSession()));
        alipayRequest.setNotifyUrl("http://localhost:8080/jpbook/index.html");// 在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" + "    \"out_trade_no\":\"2015032001010100" + (int) (Math.random() * 1000) + "\","
                + "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + "    \"total_amount\":" + money + ","
                + "    \"subject\":\"充值书币\"," + "    \"body\":\"充值书币\","
                + "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","
                + "    \"extend_params\":{" + "    \"sys_service_provider_id\":\"2088511833207846\"" + "    }" + "  }");// 填充业务参数
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + charset);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @RequestMapping("success")
    public String success(int money,int uuid,HttpSession session) {

        ps.buy(uuid,money);
        ps.editmoney(money*100,uuid);

        return "redirect:/close";
    }

}
