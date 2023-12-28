package ru.mail.knhel7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mail.knhel7.controller_service_repository.PostController;
import ru.mail.knhel7.controller_service_repository.PostRepository;
import ru.mail.knhel7.controller_service_repository.PostService;


@Configuration
public class JavaConfig {

    @Bean
    public PostController postController(PostService service) {
        return new PostController(service);
    }

    @Bean
    public PostService postService(PostRepository repository) {
        return new PostService(repository);
    }

    @Bean
    public PostRepository postRepository() {
        return PostRepository.get();
    }
}
