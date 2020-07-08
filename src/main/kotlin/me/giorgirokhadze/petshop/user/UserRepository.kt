package me.giorgirokhadze.petshop.user

import me.giorgirokhadze.petshop.user.model.User
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Mono

interface UserRepository : R2dbcRepository<User, Long> {
	fun findUserByUsername(username: String): Mono<User>
}