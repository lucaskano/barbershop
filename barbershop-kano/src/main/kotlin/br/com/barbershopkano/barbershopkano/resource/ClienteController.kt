package br.com.barbershopkano.barbershopkano.resource

import br.com.barbershopkano.barbershopkano.resource.dto.ClienteDTO
import br.com.barbershopkano.barbershopkano.service.ClienteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("clientes")
class ClienteController(val clienteService: ClienteService) {

    @GetMapping
    fun listaClientes() = clienteService.listAllClientes()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<ClienteDTO> =
            ResponseEntity.ok(clienteService.findById(id))

    @PostMapping
    fun addCliente(@RequestBody clienteDTO: ClienteDTO): ResponseEntity<ClienteDTO>{
        clienteService.saveCliente(clienteDTO)
        return ResponseEntity.ok().build()
    }

    @PutMapping("/{id}")
    fun updateCliente(@PathVariable("id") id: Long, @RequestBody clienteDTO: ClienteDTO): ResponseEntity<ClienteDTO>{
        clienteService.updateCliente(id, clienteDTO)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCliente(@PathVariable("id") id: Long): ResponseEntity<ClienteDTO>{
        clienteService.deleteCliente(id)
        return ResponseEntity.ok().build()
    }

}