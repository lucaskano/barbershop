package br.com.barbershopkano.barbershopkano.repository

import br.com.barbershopkano.barbershopkano.domain.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: JpaRepository<Cliente, Long> {
}