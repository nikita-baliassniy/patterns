package ru.geekbrains.education.identities;

import ru.geekbrains.education.model.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientIdentityMap {
    private static Map<Long, Client> hash = new HashMap<>();

    public ClientIdentityMap() {
    }

    public static Client isInto(long key) {
        return hash.getOrDefault(key, null);
    }

    public static void add(Client client) {
        hash.put(client.getId(), client);
    }
}
