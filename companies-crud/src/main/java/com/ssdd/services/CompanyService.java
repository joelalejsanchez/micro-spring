package com.ssdd.services;

import com.ssdd.entities.Company;

public interface CompanyService {
  Company[] readAll();

  Company create(Company company);

  Company readByName(String name);

  Company update(Company company, String name);

  void delete(String name);
}
