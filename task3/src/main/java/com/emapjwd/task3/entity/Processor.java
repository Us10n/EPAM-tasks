package com.emapjwd.task3.entity;

public class Processor extends AbstractDevice {
    private Double clockSpeed;

    public Processor() {
        super();
    }

    public Double getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(Double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Processor processor = (Processor) o;

        return clockSpeed != null ? clockSpeed.equals(processor.clockSpeed) : processor.clockSpeed == null;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = hash * 31 + clockSpeed.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Processor{");
        sb.append(super.toString());
        sb.append("clockSpeed=").append(clockSpeed);
        sb.append('}');
        return sb.toString();
    }
}
