package ru.geekbrains.education.mappers;

import ru.geekbrains.education.identities.StandardIdentityMap;
import ru.geekbrains.education.model.AbstractModel;

/**
 * Общая часть для мапперов выделена в отдельный абстрактный маппер
 * */
public abstract class AbstractMapper <T extends AbstractModel> {
    protected StandardIdentityMap<T> identityMap = new StandardIdentityMap<>();

    public T getObject(int key) {
        T object = identityMap.isInto(key);
        if (object != null) {
            return object;
        } else {
            T newObject = findById(key);
            identityMap.add(newObject);
            return newObject;
        }
    }

    protected abstract T findById(long id);
}
