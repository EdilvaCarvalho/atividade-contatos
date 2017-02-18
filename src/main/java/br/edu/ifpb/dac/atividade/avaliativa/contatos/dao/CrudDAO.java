
package br.edu.ifpb.dac.atividade.avaliativa.contatos.dao;

import br.edu.ifpb.dac.atividade.avaliativa.contatos.entidades.Contato;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface CrudDAO {
    
    public void salvar(Contato contato);
    public void excluir(Contato contato);
    public List<Contato> listar();
    public Contato exibir(String nome);
}
