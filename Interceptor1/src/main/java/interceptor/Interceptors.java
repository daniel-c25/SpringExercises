package interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Interceptors implements WebMvcConfigurer {

    private final APILoggingInterceptor apiLoggingInterceptor;

    private final LegacyInterceptor legacyInterceptor;

    public Interceptors(APILoggingInterceptor apiLoggingInterceptor, LegacyInterceptor legacyInterceptor) {
        this.apiLoggingInterceptor = apiLoggingInterceptor;
        this.legacyInterceptor = legacyInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(legacyInterceptor);
    }
}