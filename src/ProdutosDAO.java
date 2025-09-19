/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
   
    
    public void cadastrarProduto (ProdutosDTO produto){
         String sql = "insert into produtos (nome, valor, status) values" + "(?,?,?)";
         
       
        try{
            
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11?autoReconnect=true&useSSL=false", "root", "dpul1234");
        
        PreparedStatement conversa = connect.prepareStatement(sql);
        conversa.setString(1, produto.getNome());
        conversa.setInt(2, produto.getValor());
        conversa.setString(3, produto.getStatus());
        conversa.execute();
        
        JOptionPane.showMessageDialog(null, "cadastro feito com sucesso");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, " erro ao cadastrar");
        }
        
        
    }
    
    public List<ProdutosDTO> listarProdutos(){
       List<ProdutosDTO> listagem = new ArrayList();
       String sql = "select * from produtos";
       
       try{
           
        
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11?autoReconnect=true&useSSL=false", "root", "dpul1234");
        PreparedStatement conversa = connect.prepareStatement(sql);
        ResultSet rs = conversa.executeQuery();
        
        
       while(rs.next()){
           
           ProdutosDTO produto = new ProdutosDTO();
           
           produto.setId(rs.getInt("id"));
           produto.setNome(rs.getString("nome"));
           produto.setValor(rs.getInt("valor"));
           produto.setStatus(rs.getString("status"));
           
           listagem.add(produto);
           
       }
        
        
       }catch(SQLException e){
           
       }
       
       return listagem;
       
    }
    
   public List<ProdutosDTO> listarProdutosVendidos(){
       List<ProdutosDTO> listagem = new ArrayList();
       String sql = "select * from produtos where status = " + "'Vendido'";
       
       try{
           
       Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11?autoReconnect=true&useSSL=false", "root", "dpul1234");
       PreparedStatement conversa = connect.prepareStatement(sql);
       ResultSet rs = conversa.executeQuery();
       
       while(rs.next()){
       ProdutosDTO produto = new ProdutosDTO(); 
       
       produto.setId(rs.getInt("id"));
       produto.setNome(rs.getString("nome"));
       produto.setValor(rs.getInt("valor"));
       produto.setStatus(rs.getString("status"));
       
       listagem.add(produto);
           
       }
       
       
       }catch(SQLException e){
           
       }
       
       return listagem;
       
}   
    
   public void venderProduto(ProdutosDTO produto){
       String sql = "update produtos set status = 'Vendido' " + " where id = (?)";
       
       
       try{
       
           
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11?autoReconnect=true&useSSL=false", "root", "dpul1234");  
        PreparedStatement conversa = connect.prepareStatement(sql);
          conversa.setInt(1, produto.getId());
          conversa.execute();
           
          JOptionPane.showMessageDialog(null, "edicao feita com sucesso");
          
       }catch(SQLException e){
         JOptionPane.showMessageDialog(null, " erro ao editar" + e.getMessage());  
       }
       
   }
   
}

