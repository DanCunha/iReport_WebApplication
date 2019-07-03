package br.com.caelum.relatorio.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.relatorio.ConnectionFactory;
import br.com.caelum.relatorio.ConnectionFactoryMsSqlServer;
import br.com.caelum.relatorio.gerador.GeradorRelatorio;

@WebServlet("/material")
public class RelatorioMaterial extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
            String nome = request.getServletContext().getRealPath("/WEB-INF/jasper/Pdm_Material.jasper");
            Connection connection = new ConnectionFactoryMsSqlServer().getConnection();   
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            String idMaterial = request.getParameter("id_material");
            
            if(idMaterial != "") {
            	parametros.put("idMaterial", Integer.parseInt(idMaterial));	
            }                                 

            GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, connection);
            gerador.geraPDFParaOutputStream(response.getOutputStream());
			
			
			connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		} 
	}
	
}
