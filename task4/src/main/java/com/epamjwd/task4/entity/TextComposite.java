package com.epamjwd.task4.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent{
    private ComponentType componentType;
    private List<TextComponent> textComponents=new ArrayList<>();

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public boolean add(TextComponent component) {
        return textComponents.add(component.clone());
    }

    @Override
    public boolean addAll(List<TextComponent> components) {
        List<TextComponent> cloneList=new ArrayList<>(components.size());
        components.forEach(component -> cloneList.add(component.clone()));
        return textComponents.addAll(cloneList);
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

    @Override
    public TextComponent clone() {
        TextComponent clone=new TextComposite(this.componentType);
        List<TextComponent> cloneList=new ArrayList<>(textComponents.size());
        textComponents.forEach(component -> cloneList.add(component.clone()));
        clone.addAll(cloneList);
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (componentType != that.componentType) return false;
        return textComponents != null ? textComponents.equals(that.textComponents) : that.textComponents == null;
    }

    @Override
    public int hashCode() {
        int result = componentType != null ? componentType.hashCode() : 0;
        result = 31 * result + (textComponents != null ? textComponents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        String componentDelimiter = componentType.getDelimiter();
        for (TextComponent textComponent : textComponents) {
            sb.append(textComponent.toString()).append(componentDelimiter);
        }
        return sb.toString();
    }
}
