package ru.geekbrains.education.identities;

import ru.geekbrains.education.model.Lesson;

import java.util.HashMap;
import java.util.Map;

public class LessonIdentityMap {
    private static Map<Long, Lesson> hash = new HashMap<>();

    public LessonIdentityMap() {
    }

    public static Lesson isInto(long key) {
        return hash.getOrDefault(key, null);
    }

    public static void add(Lesson lesson) {
        hash.put(lesson.getId(), lesson);
    }
}
