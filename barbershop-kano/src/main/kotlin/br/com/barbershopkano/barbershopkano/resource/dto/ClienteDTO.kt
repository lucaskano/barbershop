package br.com.barbershopkano.barbershopkano.resource.dto

import br.com.barbershopkano.barbershopkano.domain.Cliente
import java.time.LocalDate

data class ClienteDTO(
        val clienteId: Long = 0,
        val clienteNome: String,
        val clienteDocumento: String,
        val clienteDataNascimento: LocalDate
)

fun Cliente.toDTO() = ClienteDTO(
        clienteId = clienteId,
        clienteDocumento = clienteDocumento,
        clienteDataNascimento = clienteDataNascimento,
        clienteNome = clienteNome
)

fun ClienteDTO.toEntity() = Cliente(
        clienteId = clienteId,
        clienteNome = clienteNome,
        clienteDataNascimento = clienteDataNascimento,
        clienteDocumento = clienteDocumento
)

fun List<Cliente>.toDtoList() = map { ClienteDTO(
        clienteId = it.clienteId,
        clienteNome = it.clienteNome,
        clienteDocumento = it.clienteDocumento,
        clienteDataNascimento = it.clienteDataNascimento)}