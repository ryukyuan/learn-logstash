package naruto.kotlin.controller

import com.squareup.moshi.Moshi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author nozawa_soushi
 * @since 2016/10/31 12:03
 */
@RestController
open class EventController {

    val log: Logger = LoggerFactory.getLogger("FOLLOW");

    data class EventLog(val name: String, val value: Int, val reportDate: String)

    @RequestMapping(value = "/event", method = arrayOf(RequestMethod.GET))
    fun index(): String {
        log.info(getLog("event", 100))
        return "ok"
    }

    fun getLog(name: String, type: Int): String {
        return Moshi.Builder().build()
                .adapter(EventLog::class.java)
                .toJson(EventLog(name, type, SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())))
    }
}



