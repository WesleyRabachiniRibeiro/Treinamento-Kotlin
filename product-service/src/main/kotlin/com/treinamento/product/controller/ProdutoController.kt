package com.treinamento.product.controller

import com.treinamento.product.controller.dto.PesquisaProdutoDTO
import com.treinamento.product.controller.dto.RegistroProdutoDTO
import com.treinamento.product.entity.Produto
import com.treinamento.product.mappers.ProdutoMapper
import com.treinamento.product.service.ProdutoService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
@Api(value="API REST Product")
@CrossOrigin(origins = ["*"])
class ProdutoController(private val service: ProdutoService) {

    @PostMapping
    @ApiOperation(value="Salva novos produtos criados")
    fun saveProduto(@RequestBody request: RegistroProdutoDTO): ResponseEntity<PesquisaProdutoDTO> {
        val produto = service.saveProduto(ProdutoMapper.fromDTO(request))
        return ResponseEntity.ok(ProdutoMapper.fromEntity(produto))
    }

    @GetMapping
    @ApiOperation(value="Retorna todos os produtos ativos cadastrados")
    fun searchAllProdutos() : ResponseEntity<List<Produto>> {
        return ResponseEntity.ok(service.listAllActiveProduct())
    }

    @GetMapping("{id}")
    @ApiOperation(value="Retorna um produto cadastrado")
    fun searchProduto(@PathVariable id : Long) : ResponseEntity<PesquisaProdutoDTO> {
        return try {
            val produto : Produto = service.searchProduto(id)
            ResponseEntity.ok(ProdutoMapper.fromEntity(produto))
        }catch (ex : RuntimeException){
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Atualiza os dados de um produto")
    fun updateProduto(
        @RequestBody registry: RegistroProdutoDTO,
        @PathVariable id: Long
    ): ResponseEntity<PesquisaProdutoDTO> {
        return try {
            val produto: Produto = service.updateProduto(ProdutoMapper.fromDTO(registry), id)
            ResponseEntity.ok(ProdutoMapper.fromEntity(produto))
        } catch (ex: RuntimeException) {
            ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}/desactivate")
    @ApiOperation(value = "Desativa um produto")
    fun desactiveProduct(@PathVariable id: Long): ResponseEntity<PesquisaProdutoDTO> {
        val produto = service.disableProduct(id)
        return ResponseEntity.ok(ProdutoMapper.fromEntity(produto))
    }

    @PatchMapping("/{id}/activate")
    @ApiOperation(value = "Ativa um produto")
    fun activeProduct(@PathVariable id: Long): ResponseEntity<PesquisaProdutoDTO> {
        val produto = service.ableProduct(id)
        return ResponseEntity.ok(ProdutoMapper.fromEntity(produto))
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Deleta a conta de um usuário")
    fun deleteProduto(@PathVariable id: Long): ResponseEntity<PesquisaProdutoDTO> {
        return try {
            service.deleteProduto(id)
            ResponseEntity.ok().build()
        } catch (ex: RuntimeException) {
            ResponseEntity.notFound().build()
        }
    }
}