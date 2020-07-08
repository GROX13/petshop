package me.giorgirokhadze.petshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PetShopApplication

fun main(args: Array<String>) {
	runApplication<PetShopApplication>(*args)
}
