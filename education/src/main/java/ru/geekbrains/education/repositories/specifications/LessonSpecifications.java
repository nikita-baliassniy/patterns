package ru.geekbrains.education.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import ru.geekbrains.education.model.Lesson;

public class LessonSpecifications {
    private static Specification<Lesson> durationGreaterOrEqualsThan(double minDuration) {
        return (Specification<Lesson>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("duration"), minDuration);
    }

    private static Specification<Lesson> durationLesserOrEqualsThan(double maxDuration) {
        return (Specification<Lesson>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("duration"), maxDuration);
    }

    private static Specification<Lesson> specialisationLike(String specialisationPart) {
        return (Specification<Lesson>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("specialisation"), String.format("%%%s%%", specialisationPart));
    }

    private static Specification<Lesson> topicLike(String topicPart) {
        return (Specification<Lesson>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("topic"), String.format("%%%s%%", topicPart));
    }

    public static Specification<Lesson> build(MultiValueMap<String, String> params) {
        Specification<Lesson> spec = Specification.where(null);
        if (params.containsKey("min_duration") && !params.getFirst("min_duration").isBlank()) {
            spec = spec.and(LessonSpecifications.durationGreaterOrEqualsThan(Integer.parseInt(params.getFirst("min_duration"))));
        }
        if (params.containsKey("max_duration") && !params.getFirst("max_duration").isBlank()) {
            spec = spec.and(LessonSpecifications.durationLesserOrEqualsThan(Integer.parseInt(params.getFirst("max_duration"))));
        }
        if (params.containsKey("specialisation") && !params.getFirst("specialisation").isBlank()) {
            spec = spec.and(LessonSpecifications.specialisationLike(params.getFirst("specialisation")));
        }
        if (params.containsKey("topic") && !params.getFirst("topic").isBlank()) {
            spec = spec.and(LessonSpecifications.topicLike(params.getFirst("topic")));
        }
        return spec;
    }
}
