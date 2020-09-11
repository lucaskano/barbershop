package br.com.barbershopkano.barbershopkano.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_clientes")
class Cliente(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_cliente")
        val clienteId: Long = 0,

        @Column(name = "nm_cliente")
        val clienteNome: String,

        @Column(name = "nr_documento_cliente")
        val clienteDocumento: String,

        @Column(name = "dt_nascimento_cliente")
        val clienteDataNascimento: LocalDate
) {
        override fun toString(): String {
                return "Cliente(clienteId=$clienteId, clienteNome='$clienteNome', clienteDocumento='$clienteDocumento', clienteDataNascimento=$clienteDataNascimento)"
        }
}