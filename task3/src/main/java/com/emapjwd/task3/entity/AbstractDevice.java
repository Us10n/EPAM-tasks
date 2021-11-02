package com.emapjwd.task3.entity;

public class AbstractDevice {
    protected String deviceId;
    protected String brand;
    protected String releaseDate;
    protected Country origin;
    protected Integer price;
    protected Parameter parameter;
    protected Boolean isCritical;

    protected AbstractDevice() {
        brand = "undefined";
        parameter = new Parameter();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Country getOrigin() {
        return origin;
    }

    public void setOrigin(Country origin) {
        this.origin = origin;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Parameter getParameter() {
       return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public Boolean getCritical() {
        return isCritical;
    }

    public void setCritical(Boolean critical) {
        isCritical = critical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractDevice device = (AbstractDevice) o;

        if (deviceId != null ? !deviceId.equals(device.deviceId) : device.deviceId != null) return false;
        if (brand != null ? !brand.equals(device.brand) : device.brand != null) return false;
        if (releaseDate != null ? !releaseDate.equals(device.releaseDate) : device.releaseDate != null) return false;
        if (origin != device.origin) return false;
        if (price != null ? !price.equals(device.price) : device.price != null) return false;
        if (parameter != null ? !parameter.equals(device.parameter) : device.parameter != null) return false;
        return isCritical != null ? isCritical.equals(device.isCritical) : device.isCritical == null;
    }

    @Override
    public int hashCode() {
        int result = deviceId != null ? deviceId.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (parameter != null ? parameter.hashCode() : 0);
        result = 31 * result + (isCritical != null ? isCritical.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractDevice{");
        sb.append("deviceId='").append(deviceId).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", releaseDate='").append(releaseDate).append('\'');
        sb.append(", origin=").append(origin);
        sb.append(", price=").append(price);
        sb.append(", parameter=").append(parameter);
        sb.append(", isCritical=").append(isCritical);
        sb.append('}');
        return sb.toString();
    }
}
