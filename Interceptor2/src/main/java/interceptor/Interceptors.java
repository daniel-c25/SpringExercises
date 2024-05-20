package interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Interceptors implements WebMvcConfigurer {

    private final MonthNumberInterceptor monthNumberInterceptor;

    public Interceptors(MonthNumberInterceptor monthNumberInterceptor) {
        this.monthNumberInterceptor = monthNumberInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(monthNumberInterceptor);
    }
}