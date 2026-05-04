package com.example.pizza.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// [SEMINAR-23] Swagger/OpenAPI — инфраструктурное описание HTTP API.
// Оно живёт снаружи application/domain: документация REST не должна протекать в бизнес-ядро.
@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI pizzaDeliveryOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Pizza Delivery API")
            .version("0.1.0")
            .description("Учебное REST API для kata по DDD, Onion/Clean Architecture и Ports & Adapters.")
            .contact(new Contact().name("MIPT Seminar")))
        .servers(List.of(
            new Server().url("http://localhost:8080").description("Local backend"),
            new Server().url("/").description("Current host")
        ));
  }

  // FAQ:
  // Q: Почему OpenAPI-конфиг в infrastructure?
  // A: Swagger описывает HTTP-инфраструктуру. Application/domain не должны знать про документацию REST.
  // Q: Почему не добавляем аннотации OpenAPI в use cases?
  // A: Use cases должны оставаться независимыми от web/API tooling.
  // Q: Где открыть Swagger UI?
  // A: http://localhost:8080/swagger-ui/index.html
}
