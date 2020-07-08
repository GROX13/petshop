package me.giorgirokhadze.petshop.user

import me.giorgirokhadze.petshop.user.model.User
import me.giorgirokhadze.petshop.user.model.UserDTO
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(
	private val userRepository: UserRepository
) {

	fun findById(id: Long): Mono<UserDTO> {
		val optionalUser = userRepository.findById(id)
		return if (optionalUser.isPresent) Mono.just(optionalUser.get().toDTO()) else Mono.empty()
	}

	fun findAll(): Flux<UserDTO> {
		val data = userRepository.findAll().map(User::toDTO)
		return Flux.fromIterable(data)
	}
}