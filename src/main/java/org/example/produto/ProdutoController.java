package org.example.produto;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.HashMap;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping
    public HashMap<Integer, Produto> getProdutos() {
        return Produto.getProdutosCadastrados();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarProduto(@RequestBody Produto produto) {
        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            return "Nome do produto não pode ser nulo ou vazio";
        }

        if (produto.getPreco() <= 0) {
            return "Preço deve ser maior que zero";
        }

        if (produto.getQuantidade() < 0) {
            return "Quantidade não pode ser negativa";
        }

        new Produto(produto.getNome(), produto.getPreco(), produto.getQuantidade());
        return "Produto salvo com sucesso";
    }

    @GetMapping("/{id}")
    public Produto getProduto(@PathVariable Integer id) {
        return Produto.buscarProduto(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduto(@PathVariable Integer id) {
        if (Produto.removerProduto(id)) {
            return "Produto removido com sucesso";
        }
        return "Produto não encontrado";
    }

    @PostMapping("/{id}/estoque")
    public String adicionarEstoque(@PathVariable Integer id, @RequestBody int quantidade) {
        Produto produto = Produto.buscarProduto(id);
        if (produto != null) {
            produto.adicionarEstoque(quantidade);
            return "Estoque atualizado com sucesso";
        }
        return "Produto não encontrado";
    }

    @PostMapping("/{id}/reduzir")
    public String reduzirEstoque(@PathVariable Integer id, @RequestBody int quantidade) {
        Produto produto = Produto.buscarProduto(id);
        if (produto != null) {
            if (produto.getQuantidade() >= quantidade) {
                produto.reduzirQuantidade(quantidade);
                return "Quantidade reduzida com sucesso";
            }
            return "Erro: Estoque insuficiente";
        }
        return "Produto não encontrado";
    }
}
