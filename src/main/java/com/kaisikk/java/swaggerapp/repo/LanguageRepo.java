package com.kaisikk.java.swaggerapp.repo;

import com.kaisikk.java.swaggerapp.domain.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepo extends CrudRepository<Language, Long> {
}
