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
        
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public List<ProdutosDTO> listarProdutos(){
       List<ProdutosDTO> listagem = new ArrayList();
       String sql = "select * from produtos";
       
       try{
           
        
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11", "root", "dpul1234");
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
    
    
    
        
}

