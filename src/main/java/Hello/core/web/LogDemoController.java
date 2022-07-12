package Hello.core.web;

import Hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
//1    private final ObjectProvider<MyLogger> myLoggerProvider; // 찾을수 있는 디펜덴시 마이로거가 주입
    private final MyLogger myLogger; // 찾을수 있는 디펜덴시 마이로거가 주입

    @RequestMapping("log-demo")
    @ResponseBody // 문자를 그대로 보낼 수 있음
    public String logDemo(HttpServletRequest request) /*throws InterruptedException*/ {
//1        MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = request.getRequestURI().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
//        Thread.sleep(100);
        logDemoService.logic("testID");
        return "OK";
    }
}
