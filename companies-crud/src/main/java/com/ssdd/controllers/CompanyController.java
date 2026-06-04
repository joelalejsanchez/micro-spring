package com.ssdd.controllers;

import com.ssdd.entities.Company;
import com.ssdd.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping(path = "company")
@Slf4j
@Tag(name = "Companies resources")
public class CompanyController {
  private final CompanyService companyService;

  @Operation(summary = "get all companies")
  @GetMapping()
  public ResponseEntity<Company[]> getAll() {
    log.info("GET: companies");
    return ResponseEntity.ok(this.companyService.readAll());
  }

  @Operation(summary = "get a company given a company name")
  @GetMapping(path = "{name}")
  public ResponseEntity<Company> get(@PathVariable String name) {
    log.info("GET: company with name {}", name);
    return ResponseEntity.ok(this.companyService.readByName(name));
  }

  @Operation(summary = "post a company given a company from body")
  @PostMapping
  public ResponseEntity<Company> post(@RequestBody Company company) {
    log.info("POST: company with name {}", company.getName());
    return ResponseEntity.created(URI.create(this.companyService.create(company).getName())).build();
  }

  @Operation(summary = "update in a BD a company given a company from body")
  @PutMapping(path = "{name}")
  public ResponseEntity<Company> put(@RequestBody Company company, @PathVariable String name) {
    log.info("PUT: company with name {}", name);
    return ResponseEntity.ok(this.companyService.update(company, name));
  }

  @Operation(summary = "delete in a BD a company given a company")
  @DeleteMapping(path = "{name}")
  public ResponseEntity<?> delete(@PathVariable String name) {
    log.info("DELETE: company with name {}", name);
    this.companyService.delete(name);
    return ResponseEntity.noContent().build();
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleNotFound(NoSuchElementException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<String> handleDuplicate(DataIntegrityViolationException e) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body("Company already exists");
  }
}
