package br.com.barbershopkano.barbershopkano.service

import br.com.barbershopkano.barbershopkano.resource.dto.ClienteDTO
import org.springframework.stereotype.Service

@Service
interface ClienteService {
    fun listAllClientes(): List<ClienteDTO>
    fun saveCliente(clienteDTO: ClienteDTO)
    fun findById(id: Long): ClienteDTO
    fun updateCliente(id:Long, clienteDTO: ClienteDTO)
    fun deleteCliente(id: Long)
}