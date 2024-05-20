package interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.List;

public class LegacyInterceptor implements HandlerInterceptor {

    private PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!excludePaths(request)) return true;
        response.sendError(410, "Gone");
        return false;
    }

    private boolean excludePaths(HttpServletRequest request) {
        List<String> paths = new ArrayList<>(){{
            add("/legacy/**");
        }};
        for (String path: paths) {
            if (pathMatcher.match(path, request.getRequestURI())){
                return true;
            }
        }
        return false;
    }
}