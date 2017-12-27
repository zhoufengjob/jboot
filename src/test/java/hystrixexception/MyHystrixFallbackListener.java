package hystrixexception;

import io.jboot.component.hystrix.JbootHystrixCommand;
import io.jboot.core.rpc.JbootrpcHystrixFallbackListener;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Michael Yang 杨福海 （fuhai999@gmail.com）
 * @version V1.0
 * @Title: (请输入文件名称)
 * @Description: (用一句话描述该文件做什么)
 * @Package hystrixexception
 */
public class MyHystrixFallbackListener implements JbootrpcHystrixFallbackListener {


    @Override
    public Object onFallback(Object proxy, Method method, Object[] args, JbootHystrixCommand command, Throwable exception) {

        System.err.println("MyHystrixFallbackListener fallback!!!!!");
        System.err.println("proxy:" + proxy);
        System.err.println("method:" + method);
        System.err.println("args:" + Arrays.toString(args));
        System.err.println("command:" + command);
        System.err.println("exception:" + exception);

        return null;
    }
}
