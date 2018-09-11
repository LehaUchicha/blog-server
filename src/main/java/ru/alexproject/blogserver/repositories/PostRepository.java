package ru.alexproject.blogserver.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.alexproject.blogserver.model.Post;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
}
