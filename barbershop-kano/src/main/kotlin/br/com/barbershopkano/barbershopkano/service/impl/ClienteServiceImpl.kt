package br.com.barbershopkano.barbershopkano.service.impl

import br.com.barbershopkano.barbershopkano.domain.Cliente
import br.com.barbershopkano.barbershopkano.repository.ClienteRepository
import br.com.barbershopkano.barbershopkano.resource.dto.ClienteDTO
import br.com.barbershopkano.barbershopkano.resource.dto.toDTO
import br.com.barbershopkano.barbershopkano.resource.dto.toDtoList
import br.com.barbershopkano.barbershopkano.resource.dto.toEntity
import br.com.barbershopkano.barbershopkano.service.ClienteService
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ClienteServiceImpl(val clienteRepository: ClienteRepository) : ClienteService {

    private val log = LoggerFactory.getLogger(ClienteServiceImpl::class.java)

    override fun listAllClientes() = clienteRepository.findAll().toDtoList()
    override fun saveCliente(clienteDTO: ClienteDTO) {
        clienteRepository.save(clienteDTO.toEntity())
    }

    override fun findById(id: Long): ClienteDTO {
        val cliente = clienteRepository.findByIdOrNull(id) ?: throw Exception("Cliente não encontrado")
        return cliente.toDTO()
    }

    override fun updateCliente(id: Long, clienteDTO: ClienteDTO) {
        if(checkIfExists(id)){
            val newCliente = toUpdate(objDto = clienteDTO, id = id)
            log.info("Cliente a ser atualizado: $newCliente")
            clienteRepository.save(newCliente)
        }
        else{
            log.error("Erro ao tentar encontrar cliente no banco de dados com id $id")
            throw Exception("Cliente não encontrado para o id: $id")
        }
    }

    override fun deleteCliente(id: Long) {
        clienteRepository.deleteById(id)
    }

    private fun checkIfExists(id: Long): Boolean{
        findById(id).let { return true }
    }

    private fun toUpdate(id: Long, objDto: ClienteDTO) = Cliente(
                clienteId = id,
                clienteNome = objDto.clienteNome,
                clienteDocumento = objDto.clienteDocumento,
                clienteDataNascimento = objDto.clienteDataNascimento
        )

}