package br.estacio.cadastroalunos.service;

import br.estacio.cadastroalunos.model.Client;
import static br.estacio.cadastroalunos.service.DataService.conn;
import br.estacio.cadastroalunos.ui.MainFrame;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabi
 */
public class MainFrameService {
    
    public void create(Client c){
        Connection conn = DataService.open();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("INSERT INTO alunos (nucontrato,nome,dtnascimento,rg,cpf,curso,dtmatricula,observacoes,genero) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, c.getNucontrato());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getDtnascimento());
            stmt.setString(4, c.getRg());
            stmt.setString(5, c.getCpf());
            stmt.setString(6, c.getCurso());
            stmt.setString(7, c.getDtmatricula());
            stmt.setString(8, c.getObservacoes());
            stmt.setString(9, c.getGenero());
            //stmt.setString(9, c.getFoto());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
        } catch(SQLException e) {
            System.out.println(e);
        } finally {
            DataService.close();
        }
    }
    
    public void delete(Client c) {
        Connection conn = DataService.open();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("DELETE FROM alunos WHERE nucontrato = ?");
            stmt.setInt(1, c.getNucontrato());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e);
        } finally {
            DataService.close();
        }
    }
    
    public static Boolean inserir(Client c){
        Boolean sucesso = true;
        try {
            DataService.open();
            Statement stmt = DataService.conn.createStatement();
            stmt.executeUpdate(
                "INSERT INTO alunos (nucontrato,nome,dtnascimento,rg,cpf,curso,dtmatricula,observacoes,genero,foto)"
                        + "VALUES ('"+ c.getNucontrato() +"', '"+c.getNome()+"', '"+c.getDtnascimento()+"', '"+c.getRg()+"', '"+c.getCpf()+"', '"+c.getCurso()+"', '"+c.getDtmatricula()+"', '"+c.getObservacoes()+"', '"+c.getGenero()+"', '"+c.getFoto()+"'");
                DataService.close();
        } catch (SQLException e) {
            sucesso = false;
            DataService.close();
            e.printStackTrace();
        }
        return sucesso;
    }
    
    public void update(Client c) {
        Connection conn = DataService.open();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = conn.prepareStatement(
                    "UPDATE alunos SET nome = ?,dtnascimento = ?,rg = ?,cpf = ?,curso = ?,dtmatricula = ?,observacoes = ?,genero = ? WHERE nucontrato = ?"
            );
            stmt.setInt(1, c.getNucontrato());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getDtnascimento());
            stmt.setString(4, c.getRg());
            stmt.setString(5, c.getCpf());
            stmt.setString(6, c.getCurso());
            stmt.setString(7, c.getDtmatricula());
            stmt.setString(8, c.getObservacoes());
            stmt.setString(9, c.getGenero());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: " + e);
        } finally {
            DataService.close();
        }
    }
    
    public static ArrayList<Client> getAll() {
        
        Connection conn = DataService.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Client> alunos = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM alunos");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Client c;
                c = new Client();
                
                c.setNucontrato(rs.getInt("nucontrato"));
                c.setNome(rs.getString("nome"));
                c.setDtnascimento(rs.getString("dtnascimento"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setCurso(rs.getString("curso"));
                c.setDtmatricula(rs.getString("dtmatricula"));
                c.setObservacoes(rs.getString("observacoes"));
                c.setGenero(rs.getString("genero"));
                c.setFoto(rs.getString("Foto"));
                alunos.add(c);
            }
        } catch(SQLException ex){
            Logger.getLogger(MainFrameService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DataService.close();
        }
        return alunos;
    }
    
    public ArrayList<Client> readForNome(String nome) {
        Connection conn = DataService.open();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Client> alunos = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM alunos WHERE nome LIKE ?");
            stmt.setString(1,"%"+nome+"%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Client c = new Client();
                
                c.setNucontrato(rs.getInt("nucontrato"));
                c.setNome(rs.getString("nome"));
                c.setDtnascimento(rs.getString("dtnascimento"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setCurso(rs.getString("curso"));
                c.setDtmatricula(rs.getString("dtmatricula"));
                c.setObservacoes(rs.getString("observacoes"));
                c.setGenero(rs.getString("genero"));
                c.setFoto(rs.getString("Foto"));
                alunos.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(MainFrameService.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DataService.close();
        }
        
        return alunos;
    }
}
