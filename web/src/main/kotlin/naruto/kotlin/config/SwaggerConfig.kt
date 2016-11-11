package naruto.kotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * @author nozawa_soushi
 * @since 2016/10/28 15:16
 */
@Configuration
@EnableSwagger2
open class SwaggerConfig {
    @Bean
    open fun document(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors.basePackage("naruto.kotlin.controller")
                )
                .paths(
                        regex("^/(?!error).*$")
                )
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .apiInfo(metadata())
    }

    @Bean
    open fun uiConfig(): UiConfiguration {
        return UiConfiguration.DEFAULT
    }


    private fun metadata(): ApiInfo {
        return ApiInfoBuilder().title("Naruto Kotlin API").version("1.0").build()
    }
}
