package com.company.system;

public interface Session {
    void setValue(String key, Object data);
    Object getValue(String key);
    void removeValue(String key);
    void invalidate();
}

