package naruto.kotlin.config

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.services.analytics.Analytics
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.analytics.AnalyticsScopes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File

/**
 * @author nozawa_soushi
 * @since 2016/10/28 17:23
 */
@Configuration
open class GoogleAnalyticsConfig {

    val applicationName = "googleAnalytics"
    val jsonFactory = JacksonFactory.getDefaultInstance()!!
    val serviceAccountEmail = "womancrowd-report-client@wc-report-1345.iam.gserviceaccount.com"
    val keyFileLocation = "/wc_google_report_api.p12"

    @Bean
    open fun analytics(): Analytics {
        val httpTransport = GoogleNetHttpTransport.newTrustedTransport()
        val credential = GoogleCredential.Builder()
                .setTransport(httpTransport)
                .setJsonFactory(jsonFactory)
                .setServiceAccountId(serviceAccountEmail)
                .setServiceAccountPrivateKeyFromP12File(
                        File(javaClass.getResource(keyFileLocation).path))
                .setServiceAccountScopes(AnalyticsScopes.all())
                .build();
        return Analytics.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName(applicationName).build();
    }
}
