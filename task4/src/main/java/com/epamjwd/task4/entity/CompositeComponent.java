package com.epamjwd.task4.entity;

import java.util.ArrayList;
import java.util.List;

public class CompositeComponent implements TextComponent{
    private ComponentType componentType;
    private List<TextComponent> textComponents=new ArrayList<>();

    public CompositeComponent(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public boolean add(TextComponent component) {
        return textComponents.add(component);
    }

    @Override
    public boolean remove(TextComponent component) {
        return textComponents.remove(component);
    }

    @Override
    public List<TextComponent> getChild() {
        return List.copyOf(textComponents);
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }
}
