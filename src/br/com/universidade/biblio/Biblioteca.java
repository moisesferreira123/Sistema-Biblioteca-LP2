package br.com.universidade.biblio;

import br.com.universidade.biblio.Usuario;
import br.com.universidade.biblio.Livro;
import br.com.universidade.biblio.Emprestimo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    private Usuario usuario;
    private Livro livro;
    private Utils utils;

    public Biblioteca() {
        this.usuario = new Usuario();
        this.livro = new Livro();
        this.utils = new Utils();
    }

    public Emprestimo registrarEmprestimo(Usuario u, Livro l, Date dataDeDevolucao) {
        GerenciadorDeDados gd = new GerenciadorDeDados();
        Emprestimo emprestimo = new Emprestimo(new Date(), dataDeDevolucao);
        
        // if(gd.consultarUsuarioBanco() == null) {
        //     System.out.println("Usuário inexistente.");
        //     return null;
        // }

        // if(gd.consultarLivroBanco() == null) {
        //     System.out.println("Livro inexistente");
        //     return null;
        // }

        if(!utils.validarTipoData(dataDeDevolucao) || dataDeDevolucao.before(new Date())) {
            System.out.println("Data de devolução inválida. Realize um empréstimo com a data após a data atual.");
            return null;
        }

        if(!l.isDisponivel) {
            System.out.println("Falha ao registrar empréstimo. Livro não está disponível no momento.");
            return null;
        }

        if(gd.registrarEmprestimoBanco(emprestimo)) {
            l.setDisponivel(false);
        } else {
            System.out.println("Falha ao registrar empréstimo.");
            return null;
        }


        u.adicionarEmprestimo(l);
        return emprestimo;
    }

    public Emprestimo registrarDevolucao(Usuario u, Livro l) {
        
    }

    public boolean adicionarLivro() {

    }

    public List<Livro> listarLivros() {
        
    }

    public boolean adicionarUsuario() {

    }

    public List<Usuario> listarUsuarios() {

    }
}
