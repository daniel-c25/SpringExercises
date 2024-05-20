package interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class APILoggingInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(APILoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("User-Agent header contents: {}", request.getHeader("User-Agent"));
        return true;
    }
}