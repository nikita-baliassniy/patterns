package ru.geekbrains.education.identities;

import ru.geekbrains.education.model.AbstractModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Сделан общий универсальный вариант кода для айдентити мапы для сокращения дублирования
 * */
public class StandardIdentityMap<T extends AbstractModel> {
    protected Map<Long, T> hash = new HashMap<>();

    public T isInto(long key) {
        return hash.getOrDefault(key, null);
    }

    public void add(T object) {
        hash.put(object.getId(), object);
    }
}
