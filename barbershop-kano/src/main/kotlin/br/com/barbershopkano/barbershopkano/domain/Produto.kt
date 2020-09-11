package br.com.barbershopkano.barbershopkano.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "tb_produtos")
class Produto(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_produto")
        val id:Long = 0,

        @Column(name = "nm_produto")
        val nomeProduto: String,

        @Column(name = "desc_produto")
        val descProduto: String,

        @Column(name = "vl_produto")
        val precoProduto: BigDecimal,

        @Column(name = "qt_produto")
        val quantidadeProduto: Int
) {

}