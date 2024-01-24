package com.example.ToDo.Service;

import com.example.ToDo.Model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

//import java.util.List;
//
//@Service
//public class RestTemplateService
//{
//    private final RestTemplate restTemplate;
//    public RestClientService()
//    {
//        restTemplate= RestTemplate.builder().baseUrl("https://jsonplaceholder.typicode.com/todos").build();
//    }
//    public List<Todo> getAllTodos()
//
//    {
//        return restTemplate.get().uri("").retrieve().body(List.class);
//    }
//    public Todo getTodoById(Integer id)
//    {
//        return restTemplate.get().uri("/" + id).retrieve().body(Todo.class);
//    }
//
//    public List<Todo> getAllTodosByCompleted(boolean completed)
//    {
//        return restTemplate.get().uri(usiBuilder->usiBuilder.path("").queryParam("completed",completed).build()).retrieve().body(List.class);
//    }
//}
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class RestTemplateService {

    private final RestTemplate restTemplate;

    public RestTemplateService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Todo> getAllTodos() {
        String url = "https://jsonplaceholder.typicode.com/todos";
        ResponseEntity<List<Todo>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>() {}
        );
        return responseEntity.getBody();
    }

    public Todo getTodoById(Integer id) {
        String url = "https://jsonplaceholder.typicode.com/todos/" + id;
        return restTemplate.getForObject(url, Todo.class);
    }

    public List<Todo> getAllTodosByCompleted(boolean completed) {
        String url = "https://jsonplaceholder.typicode.com/todos";
        String queryParam = "completed=" + completed;

        ResponseEntity<List<Todo>> responseEntity = restTemplate.exchange(
                url + "?" + queryParam,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>() {
                }
        );

        return responseEntity.getBody();
    }
}

