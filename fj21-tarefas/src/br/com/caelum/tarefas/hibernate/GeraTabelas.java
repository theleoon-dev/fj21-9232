package br.com.caelum.tarefas.hibernate;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.tarefas.modelo.Tarefa;
import br.com.caelum.tarefas.modelo.Usuario;

public class GeraTabelas {
	
	public static void main(String[] args) {
		//gravandoTarefa();
		//buscarPorId();
		//apagaTarefa();
		//atualizaTarefa();
		//buscaPersonalizada();
		criandoTarefaComUsuario();
	}
	
	public static void gravandoTarefa() {
		System.out.println("Iniciando o gera tabelas");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager manager = factory.createEntityManager();
		
		Tarefa tarefa = new Tarefa();
		tarefa.setDataFinalizacao(Calendar.getInstance());
		tarefa.setDescricao("Java para Desenvolvimento App");
		tarefa.setFinalizado(true);
		
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("ID da tarefa criada: " + tarefa.getId());
		
		manager.close();
		factory.close();
	}
	
	public static void buscarPorId() {

		System.out.println("Iniciando o buscarPorId");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		Tarefa tarefa = manager.find(Tarefa.class, 2L);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa carregada: " + tarefa.toString());
		
		manager.close();
		factory.close();
		
	}
	
	public static void apagaTarefa() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa tarefa = manager.find(Tarefa.class, 1L);
		
		manager.getTransaction().begin();
		manager.remove(tarefa);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
	
	public static void atualizaTarefa() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa tarefa = manager.find(Tarefa.class, 2L);
		
		tarefa.setDescricao("Tarefa atualizada");
		tarefa.setDataFinalizacao(null);
		tarefa.setFinalizado(false);
		
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
	
	public static void buscaPersonalizada() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		
		// JPQL
		Query query = manager.createQuery("select t from Tarefa as t " + " where t.finalizado = :paramFinalizado");
		
		// Criteria (join, inner join)
		// Predicate (filtros)
		
		query.setParameter("paramFinalizado", true);
		
		List<Tarefa> tarefas = query.getResultList();
		
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa);
		}
		
		manager.close();
		factory.close();
	}
	
	public static void criandoTarefaComUsuario() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		
		// criando um novo usuário
		Usuario usuario = new Usuario();
		usuario.setLogin("leonardo");
		usuario.setSenha("caelum");
		
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
		// criando uma nova tarefa com usuario
		
		Tarefa tarefa = new Tarefa();
		tarefa.setDataFinalizacao(Calendar.getInstance());
		tarefa.setDescricao("Java para Desenvolvimento App");
		tarefa.setFinalizado(true);
		
		tarefa.setUsuario(usuario);
		
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		
	}

}
