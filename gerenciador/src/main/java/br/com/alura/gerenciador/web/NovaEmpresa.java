package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.Tarefa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Tarefa{
       
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		//pega o nome da empresa a ser adicionada, passada pelo usuario
		String nome = req.getParameter("nome");
		
		Empresa empresa = new Empresa(nome);
		
		//adiciona empresa
		new EmpresaDAO().adiciona(empresa);
		
		//passando objeto empresa
		req.setAttribute("empresa", empresa);

		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}

}
