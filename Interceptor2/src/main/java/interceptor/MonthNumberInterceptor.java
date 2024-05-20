package interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.List;

public class MonthNumberInterceptor implements HandlerInterceptor {

    private PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!excludePath(request)) return true;
        if (excludePath(request) && handle(request)) return true;
        response.sendError(400, "Bad request");
        return false;
    }

    private boolean handle(HttpServletRequest request) {
        List<Month> months = new ArrayList<>(){{
            add(Month.MonthBuilder.aMonth()
                    .withMothNumber(1)
                    .withEnglishName("January")
                    .withItalianName("Gennaio")
                    .build());
            add(Month.MonthBuilder.aMonth()
                    .withMothNumber(2)
                    .withEnglishName("February")
                    .withItalianName("Febbraio")
                    .build());
            add(Month.MonthBuilder.aMonth()
                    .withMothNumber(3)
                    .withEnglishName("March")
                    .withItalianName("Marzo")
                    .build());
            add(Month.MonthBuilder.aMonth()
                    .withMothNumber(4)
                    .withEnglishName("April")
                    .withItalianName("Aprile")
                    .build());
            add(Month.MonthBuilder.aMonth()
                    .withMothNumber(5)
                    .withEnglishName("May")
                    .withItalianName("Maggio")
                    .build());
            add(Month.MonthBuilder.aMonth()
                    .withMothNumber(6)
                    .withEnglishName("June")
                    .withItalianName("Giugno")
                    .build());
        }};
        int monthNumber = Integer.parseInt(request.getHeader("monthNumber"));
        for (Month month: months) {
            if (month.getMothNumber() == monthNumber) {
                request.setAttribute("Moth", month);
                return true;
            }
        }
        request.setAttribute("Month", Month.MonthBuilder.aMonth().withMothNumber(0).withEnglishName("nope").withItalianName("nope").withGermanName("nope"));
        return true;
    }

    private boolean excludePath(HttpServletRequest request) {
        List<String> paths = new ArrayList<>(){{
            add("/month/**");
        }};
        for (String pattern: paths) {
            if (pathMatcher.match(pattern, request.getRequestURI())) return true;
        }
        return false;
    }
}