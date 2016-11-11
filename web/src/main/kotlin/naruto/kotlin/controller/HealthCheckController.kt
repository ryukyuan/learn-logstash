package naruto.kotlin.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import io.swagger.annotations.ApiOperation
import naruto.kotlin.model.Response
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * @author nozawa_soushi
 * @since 2016/10/28 11:37
 */

@RestController
@EnableAutoConfiguration
@Api(description = "ヘルスチェック用")
open class HealthCheckController {

//    @ApiModel
//    data class HealthCheck(
//            @ApiModelProperty(required = true, value = "結果", example = "true")
//            val result: Boolean
//    )

    class Test(val result: Boolean)

    @ApiOperation(value = "ヘルスチェック用")
    @RequestMapping(value = "/health_check", method = arrayOf(RequestMethod.GET))
    fun index(): Response<Test> {

        return Response(Test(true))
    }
}