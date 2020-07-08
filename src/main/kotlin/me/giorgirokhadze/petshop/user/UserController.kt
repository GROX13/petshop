package me.giorgirokhadze.petshop.user

import me.giorgirokhadze.petshop.user.model.User
import me.giorgirokhadze.petshop.user.model.UserDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/users")
class UserController(
	private val userService: UserService
) {

	@GetMapping("/{id}")
	fun findById(@PathVariable id: Long): Mono<UserDTO> {
		return userService.findById(id)
	}

	@GetMapping
	fun findAll(): Flux<UserDTO> {
		return userService.findAll()
	}
}