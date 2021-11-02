package com.emapjwd.task3.entity;

public class Parameter {
    private boolean peripheral;
    private double powerUsage;
    private boolean coolerBundled;
    private Group group;
    private Port port;

    public Parameter() {
    }

    public Parameter(boolean peripheral, double powerUsage, boolean coolerBundled, Group group, Port port) {
        this.peripheral = peripheral;
        this.powerUsage = powerUsage;
        this.coolerBundled = coolerBundled;
        this.group = group;
        this.port = port;
    }

    public boolean isPeripheral() {
        return peripheral;
    }

    public void setPeripheral(boolean peripheral) {
        this.peripheral = peripheral;
    }

    public double getPowerUsage() {
        return powerUsage;
    }

    public void setPowerUsage(double powerUsage) {
        this.powerUsage = powerUsage;
    }

    public boolean isCoolerBundled() {
        return coolerBundled;
    }

    public void setCoolerBundled(boolean coolerBundled) {
        this.coolerBundled = coolerBundled;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parameter parameter = (Parameter) o;

        if (peripheral != parameter.peripheral) return false;
        if (Double.compare(parameter.powerUsage, powerUsage) != 0) return false;
        if (coolerBundled != parameter.coolerBundled) return false;
        if (group != parameter.group) return false;
        return port == parameter.port;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (peripheral ? 1 : 0);
        temp = Double.doubleToLongBits(powerUsage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (coolerBundled ? 1 : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Parameter{");
        sb.append("peripheral=").append(peripheral);
        sb.append(", powerUsage=").append(powerUsage);
        sb.append(", coolerBundled=").append(coolerBundled);
        sb.append(", group=").append(group);
        sb.append(", port=").append(port);
        sb.append('}');
        return sb.toString();
    }
}
