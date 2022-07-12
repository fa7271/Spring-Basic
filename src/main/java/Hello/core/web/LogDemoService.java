package Hello.core.web;

import Hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
//1    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;
    public void logic(String id) {
//1        MyLogger myLogger = myLoggerProvider.getObject();
//1        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " +id );
    }
}
