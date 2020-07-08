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
		return userRepository.findById(id).map(User::toDTO)
	}
	
	fun findAll(): Flux<UserDTO> {
		return userRepository.findAll().map(User::toDTO)
	}
}