package com.demo.greetingmessageservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/message")
public class MessageController {
  public static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

  @GetMapping
  @Operation(summary = "Hello Message", description = "Returns Hello message")
  public ResponseEntity<String> getMessage(
      @RequestHeader(value = "X-trace-id", required = false) String traceId) {
    LOGGER.info("traceId: {}", traceId);
    return ResponseEntity.ok().header("X-trace-Id", traceId).body("Hello");
  }
}
