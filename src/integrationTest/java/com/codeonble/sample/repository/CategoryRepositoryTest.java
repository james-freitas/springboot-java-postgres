package com.codeonble.sample.repository;

import com.codeonblue.sample.SampleApplication;
import com.codeonblue.sample.domain.Category;
import com.codeonblue.sample.repository.CategoryRepository;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {SampleApplication.class})
@FlywayTest
@AutoConfigureEmbeddedDatabase
@ContextConfiguration
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void cleanTable() {
        categoryRepository.deleteAll();
    }

    @Test
    void shouldInsertCategorySuccessfully() {

        Category category = Category.builder().description("Category 1").build();

        categoryRepository.save(category);

        assertThat(categoryRepository.count()).isEqualTo(1);
    }
}
