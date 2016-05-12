package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.Tarefa;
import br.com.alura.gerenciador.dao.EmpresaDAO;


public class BuscaEmpresa implements Tarefa {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		//servlet executa a lógica
		String filtro = req.getParameter("filtro");

		Collection<Empresa> empresas = new EmpresaDAO()
				.buscaPorSimilaridade(filtro);

		req.setAttribute("empresas", empresas);

		//informa para Servlet FazTudo para onde redirecionar
		return "WEB-INF/paginas/buscaEmpresa.jsp";
	}

}
