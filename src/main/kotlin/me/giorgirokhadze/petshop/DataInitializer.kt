package me.giorgirokhadze.petshop

import me.giorgirokhadze.petshop.security.Authority
import me.giorgirokhadze.petshop.user.UserRepository
import me.giorgirokhadze.petshop.user.model.User
import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
internal class DataInitializer(
	private val userRepository: UserRepository,
	private val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

	private val logger = KotlinLogging.logger { }

	override fun run(vararg args: String?) {
		val users = listOf(
			User(
				username = "admin",
				email = "admin@example.com",
				encodedPassword = passwordEncoder.encode("Pass!3"),
				authorities = setOf(Authority.ADMIN)
			),
			User(
				username = "user",
				email = "user@example.com",
				encodedPassword = passwordEncoder.encode("Pass!3"),
				authorities = setOf(Authority.USER)
			)
		)

		userRepository
			.saveAll(users)
			.subscribe {
				logger.debug { "User successfully saved into database with ID: ${it.id}" }
			}
	}
}