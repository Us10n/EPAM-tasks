package com.epamjwd.task4.entity;

import java.util.List;

public class CharacterLeaf implements TextComponent {
    private ComponentType componentType;
    private Character character;

    public CharacterLeaf(ComponentType componentType, Character character) {
        this.componentType = componentType;
        this.character = character;
    }

    @Override
    public boolean add(TextComponent component) {
        return false;
    }

    @Override
    public boolean addAll(List<TextComponent> components) {
        return false;
    }

    @Override
    public boolean remove(TextComponent component) {
        return false;
    }

    @Override
    public List<TextComponent> getChild() {
        return null;
    }

    @Override
    public ComponentType getType() {
        return null;
    }

    @Override
    public TextComponent clone() {
        return new CharacterLeaf(this.componentType, this.character);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterLeaf that = (CharacterLeaf) o;

        if (componentType != that.componentType) return false;
        return character != null ? character.equals(that.character) : that.character == null;
    }

    @Override
    public int hashCode() {
        int result = componentType != null ? componentType.hashCode() : 0;
        result = 31 * result + (character != null ? character.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return character.toString();
    }
}
