package ru.mail.knhel7.controller_service_repository;

import ru.mail.knhel7.exception.NotFoundPostException;
import ru.mail.knhel7.model.Post;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;


public class PostService {

  private final PostRepository repository;

  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public List<Post> all() {
    return new CopyOnWriteArrayList<>(repository.getPosts().values());
  }

  public Post getById(long id) {
//    return repository.getById(id).orElse(new Post(
//            0, "The post id=" + id + " was not found"));
    return repository.getById(id).orElseThrow(NotFoundPostException::new);
  }

  public Post save(Post post) {
    return repository.save(post);
  }

  public void removeById(long id) {
    repository.removeById(id);
  }
}
