package br.com.alura.gerenciador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String tarefa = req.getParameter("tarefa");
		// qual tarefa a ser executada?????

		if (tarefa == null) {
			throw new IllegalArgumentException(
					"Você esqueceu de passar a tarefa!!!!");
		}
		try {
			// para onde redirecionar?????
			tarefa = "br.com.alura.gerenciador.web." + tarefa;

			// Pega o nome da classe em tempo de compilacao
			Class<?> tipo = Class.forName(tarefa);
			// cria nova instancia da tarefa
			Tarefa instance = (Tarefa) tipo.newInstance();

			// executa lógica de negócio
			String pagina = instance.executa(req, resp);

			// redirecionar
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}
}
