package ru.geekbrains.education.identities;

import ru.geekbrains.education.model.Teacher;

import java.util.HashMap;
import java.util.Map;

public class TeacherIdentityMap {
    private static Map<Long, Teacher> hash = new HashMap<>();

    public TeacherIdentityMap() {
    }

    public static Teacher isInto(long key) {
        return hash.getOrDefault(key, null);
    }

    public static void add(Teacher teacher) {
        hash.put(teacher.getId(), teacher);
    }
}
