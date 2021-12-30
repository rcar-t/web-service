package rcar.samples.springbootmvc.config

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import java.time.Duration

@ConfigurationProperties("es")
@ConstructorBinding
data class EsProperties(val url: String)

class DatabaseConfig(val properties: EsProperties): AbstractElasticsearchConfiguration() {

    override fun elasticsearchClient(): RestHighLevelClient =
        RestClients.create(
            ClientConfiguration
                .builder()
                .connectedTo(properties.url).build()
        ).rest()

}