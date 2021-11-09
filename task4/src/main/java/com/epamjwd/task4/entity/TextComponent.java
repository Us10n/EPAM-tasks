package com.epamjwd.task4.entity;

import java.util.List;

public interface TextComponent {
    boolean add(TextComponent component);
    boolean remove(TextComponent component);
    List<TextComponent> getChild();
    ComponentType getType();
}
