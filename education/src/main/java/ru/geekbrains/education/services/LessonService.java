package ru.geekbrains.education.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.education.model.Lesson;
import ru.geekbrains.education.repositories.LessonRepository;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    public Lesson findLessonById(Long id) {
        return lessonRepository.findById(id).get();
    }

    public Page<Lesson> findAll(Specification<Lesson> spec, int page, int pageSize) {
        return lessonRepository.findAll(spec, PageRequest.of(page - 1, pageSize));
    }

}
