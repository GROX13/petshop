package me.giorgirokhadze.petshop

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@Configuration
@EnableJpaRepositories("me.giorgirokhadze.petshop")
internal class PetShopConfig {

	@Bean
	fun commonObjectMapper(): ObjectMapper {
		return jacksonObjectMapper()
			.registerModule(JavaTimeModule())
			.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
	}
}