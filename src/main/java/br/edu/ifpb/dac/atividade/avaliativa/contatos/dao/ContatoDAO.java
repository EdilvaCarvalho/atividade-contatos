package br.edu.ifpb.dac.atividade.avaliativa.contatos.dao;

import br.edu.ifpb.dac.atividade.avaliativa.contatos.conexao.Conexao;
import br.edu.ifpb.dac.atividade.avaliativa.contatos.entidades.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class ContatoDAO implements CrudDAO {

    @Override
    public void salvar(Contato contato) {
        Connection conexao = Conexao.getConexao();
        String sql = "INSERT INTO CONTATO (NOME, TELEFONE) VALUES (?, ?)";
        try {
            PreparedStatement ps;
            if (contato.getId() == null) {

                ps = conexao.prepareStatement(sql);

            } else {
                String sql2 = "UPDATE CONTATO SET NOME = ?, TELEFONE = ? WHERE ID = ?";
                ps = conexao.prepareStatement(sql2);
                ps.setInt(3, contato.getId());
            }
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void excluir(Contato contato) {
        Connection conexao = Conexao.getConexao();
        String sql = "DELETE FROM CONTATO WHERE ID = ?";
        try {
            PreparedStatement ps;
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, contato.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Contato> listar() {
        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM CONTATO";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            List<Contato> contatos = new ArrayList<>();
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("ID"));
                contato.setNome(rs.getString("NOME"));
                contato.setTelefone(rs.getString("TELEFONE"));
                contatos.add(contato);
            }
            Conexao.fecharConexao();
            Collections.sort(contatos);
            return contatos;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Contato exibir(String nome) {
        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM CONTATO WHERE NOME = ?";
        PreparedStatement ps;

        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            Contato contato = new Contato();
            if (rs.next()) {
                contato.setId(rs.getInt("ID"));
                contato.setNome(rs.getString("NOME"));
                contato.setTelefone(rs.getString("TELEFONE"));
            }
            return contato;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
