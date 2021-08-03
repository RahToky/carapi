package mg.rmahatoky.carapi.config;

import mg.rmahatoky.carapi.controller.CommentController;
import mg.rmahatoky.carapi.security.BearerTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Pour intercepter les requettes
 *
 * @author Mahatoky
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String[] PATH_PATTERNS = {
            "/cars/{carId}/comments"
    };

    @Autowired
    BearerTokenInterceptor bearerTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bearerTokenInterceptor).addPathPatterns(PATH_PATTERNS);
    }
}
