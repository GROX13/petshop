package me.giorgirokhadze.petshop.user.model

import me.giorgirokhadze.petshop.security.Authority
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long = 0,
	@Column(unique = true, nullable = false)
	var username: String,
	@Column(unique = true, nullable = false)
	var email: String,
	@Column(nullable = false)
	var encodedPassword: String,
	@ElementCollection
	@Column(nullable = false)
	var authorities: Set<String> = setOf(Authority.USER)
) {
	fun toDTO() = UserDTO(
		id = id,
		username = username,
		email = email,
		encodedPassword = encodedPassword,
		authorities = authorities
	)
}