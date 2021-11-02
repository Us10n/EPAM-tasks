package com.emapjwd.task3.entity;

public class Mouse extends AbstractDevice {
    private Integer dpi;

    public Mouse() {
        super();
    }

    public Integer getDpi() {
        return dpi;
    }

    public void setDpi(Integer dpi) {
        this.dpi = dpi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mouse mouse = (Mouse) o;

        return dpi != null ? dpi.equals(mouse.dpi) : mouse.dpi == null;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = hash * 31 + dpi.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Mouse{");
        sb.append(super.toString());
        sb.append("dpi=").append(dpi);
        sb.append('}');
        return sb.toString();
    }
}
