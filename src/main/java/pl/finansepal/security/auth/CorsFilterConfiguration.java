package pl.finansepal.security.auth;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import pl.finansepal.security.model.CorsFilterProperties;

@Configuration
@EnableConfigurationProperties(CorsFilterProperties.class)
@RequiredArgsConstructor
public class CorsFilterConfiguration {

    private final CorsFilterProperties corsFilterProperties;

//    @Bean("corsFilter")
//    public FilterRegistrationBean<CorsFilter> corsFilter() {
//        final CorsConfiguration config = buildCorsParameters();
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//        CorsFilter filter = new CorsFilter(source);
//        return new FilterRegistrationBean(filter);
//    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = buildCorsParameters();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    private CorsConfiguration buildCorsParameters() {
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.applyPermitDefaultValues();

        if(corsFilterProperties.getMaxAge() !=null){
            corsConfiguration.setMaxAge(corsFilterProperties.getMaxAge());
        }
        if(!CollectionUtils.isEmpty(corsFilterProperties.getAllowedMethods())){
            corsConfiguration.setAllowedMethods(corsFilterProperties.getAllowedMethods());
        }
        if(!CollectionUtils.isEmpty(corsFilterProperties.getAllowedHeaders())){
            corsConfiguration.setAllowedHeaders(corsFilterProperties.getAllowedHeaders());
        }
        if(!CollectionUtils.isEmpty(corsFilterProperties.getAllowedOrigins())){
            corsConfiguration.setAllowedOrigins(corsFilterProperties.getAllowedOrigins());
        }

        return corsConfiguration;


    }
}
