package com.mplatab.proyecto_todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.mplatab.proyecto_todolist.entity.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProyectoTodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;


	@Test
	void testCreateTodoSuccess() {
		var todo = Todo.builder()
			.title("task 1")
			.description("desc task 1")
			.isCompleted(false)
			.priority(1)
			.build();
		webTestClient.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].title").isEqualTo(todo.getTitle())
			.jsonPath("$[0].description").isEqualTo(todo.getDescription())
			.jsonPath("$[0].completed").isEqualTo(todo.isCompleted())
			.jsonPath("$[0].priority").isEqualTo(todo.getPriority());

	}

	@Test
	void testCreateTaskFailed() {
		webTestClient.post()
		.uri("/todos")
		.bodyValue(Todo.builder()
			.title("")
			.description("")
			.isCompleted(false)
			.priority(0)
			.build()
		)
		.exchange()
		.expectStatus().isBadRequest();
	}

}
