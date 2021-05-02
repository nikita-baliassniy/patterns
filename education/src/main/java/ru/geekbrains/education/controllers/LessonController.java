package ru.geekbrains.education.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.education.model.Lesson;
import ru.geekbrains.education.repositories.specifications.LessonSpecifications;
import ru.geekbrains.education.services.LessonService;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @GetMapping
    public Page<Lesson> getAllLessons(@RequestParam MultiValueMap<String, String> params,
                                      @RequestParam(name = "p", defaultValue = "1") Integer page) {
        if (page < 1) {
            page = 1;
        }
        return lessonService.findAll(LessonSpecifications.build(params), page, 10);
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id) {
        return lessonService.findLessonById(id);
    }

}
