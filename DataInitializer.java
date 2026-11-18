package com.example.tourist;

import com.example.tourist.model.Tourist;
import com.example.tourist.repository.TouristRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner loadSampleTourists(TouristRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Tourist("Aarav", "Taj Mahal", "India"));
                repository.save(new Tourist("Mia", "Eiffel Tower", "France"));
                repository.save(new Tourist("Noah", "Great Wall", "China"));
            }
        };
    }
}
