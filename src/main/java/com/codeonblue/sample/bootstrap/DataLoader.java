package com.codeonblue.sample.bootstrap;

import com.codeonblue.sample.domain.Category;
import com.codeonblue.sample.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final CategoryRepository categoryRepository;

    public DataLoader(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            loadData();
        }
        logger.info(">>> Database loaded. Record count of: " + categoryRepository.count());
    }

    private void loadData() {
        Category category = Category.builder().description("Gadgets").build();
        categoryRepository.save(category);
    }
}
