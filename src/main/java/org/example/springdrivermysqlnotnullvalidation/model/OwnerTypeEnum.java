package org.example.springdrivermysqlnotnullvalidation.model;

import java.util.HashMap;
import java.util.Map;

public enum OwnerTypeEnum {

    PICPAY,
    BANK;

    private static Map<Short, OwnerTypeEnum> idsMap = new HashMap<>();

    static {
        idsMap.put((short) 0, PICPAY);
        idsMap.put((short) 1, BANK);
    }

    public Short toValue() {
        for (Map.Entry<Short, OwnerTypeEnum> entry : idsMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }

        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
