package naruto.kotlin.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @author nozawa_soushi
 * @since 2016/10/28 15:58
 */
@ApiModel
class Response<T>(t: T) {
    @ApiModelProperty(required = true, value = "結果", example = "true")
    var value = t;
}

