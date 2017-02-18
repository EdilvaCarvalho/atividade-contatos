
package br.edu.ifpb.dac.atividade.avaliativa.contatos.bean;

import br.edu.ifpb.dac.atividade.avaliativa.contatos.dao.ContatoDAO;
import br.edu.ifpb.dac.atividade.avaliativa.contatos.entidades.Contato;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Edilva
 */
@Named
@SessionScoped
public class ControladorDeContatos implements Serializable{
    private Contato contato = new Contato();
    private Contato pesquisa = new Contato();
    private List<Contato> contatos = new ArrayList<>();
    private ContatoDAO contatoDAO = new ContatoDAO();
    private String nome;

    public ControladorDeContatos() {
    }
    
    public void cadastrar(){
        contatoDAO.salvar(contato);
        contato = new Contato();
        listar();
    }
    
    public void editar(Contato c){
        contato = c;
    }
    
    public void excluir(Contato c){
        contatoDAO.excluir(c);
        listar();
    }
    
    public void listar(){
        contatos = contatoDAO.listar();
    }
    
    public void exibir(){
        pesquisa = contatoDAO.exibir(nome);
        this.nome = "";
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public ContatoDAO getContatoDAO() {
        return contatoDAO;
    }

    public void setContatoDAO(ContatoDAO contatoDAO) {
        this.contatoDAO = contatoDAO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Contato pesquisa) {
        this.pesquisa = pesquisa;
    }
    
}
