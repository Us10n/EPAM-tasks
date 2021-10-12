package com.epamjwd.task2.entity;

public class Cube extends Shape {
    private Point bottomA;
    private Point bottomB;
    private Point bottomC;
    private Point bottomD;
    private Point topA;
    private Point topB;
    private Point topC;
    private Point topD;

    public Cube() {
    }

    public Cube(Point[] points){
        this.bottomA = points[0];
        this.bottomB = points[1];
        this.bottomC = points[2];
        this.bottomD = points[3];
        this.topA = points[4];
        this.topB = points[5];
        this.topC = points[6];
        this.topD = points[7];
    }

    public Cube(Point bottomA, Point bottomB, Point bottomC, Point bottomD, Point topA, Point topB, Point topC, Point topD) {
        this.bottomA = bottomA;
        this.bottomB = bottomB;
        this.bottomC = bottomC;
        this.bottomD = bottomD;
        this.topA = topA;
        this.topB = topB;
        this.topC = topC;
        this.topD = topD;
    }

    public Point getBottomA() {
        return bottomA;
    }

    public void setBottomA(Point bottomA) {
        this.bottomA = bottomA;
    }

    public Point getBottomB() {
        return bottomB;
    }

    public void setBottomB(Point bottomB) {
        this.bottomB = bottomB;
    }

    public Point getBottomC() {
        return bottomC;
    }

    public void setBottomC(Point bottomC) {
        this.bottomC = bottomC;
    }

    public Point getBottomD() {
        return bottomD;
    }

    public void setBottomD(Point bottomD) {
        this.bottomD = bottomD;
    }

    public Point getTopA() {
        return topA;
    }

    public void setTopA(Point topA) {
        this.topA = topA;
    }

    public Point getTopB() {
        return topB;
    }

    public void setTopB(Point topB) {
        this.topB = topB;
    }

    public Point getTopC() {
        return topC;
    }

    public void setTopC(Point topC) {
        this.topC = topC;
    }

    public Point getTopD() {
        return topD;
    }

    public void setTopD(Point topD) {
        this.topD = topD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube that = (Cube) o;

        if (topA != null ? !topA.equals(that.topA) : that.topA != null) return false;
        if (topB != null ? !topA.equals(that.topA) : that.topA != null) return false;
        if (topC != null ? !topA.equals(that.topA) : that.topA != null) return false;
        if (topD != null ? !topA.equals(that.topA) : that.topA != null) return false;

        if (bottomA != null ? !bottomA.equals(that.bottomA) : that.bottomA != null) return false;
        if (bottomB != null ? !bottomB.equals(that.bottomB) : that.bottomB != null) return false;
        if (bottomC != null ? !bottomC.equals(that.bottomC) : that.bottomC != null) return false;
        if (bottomD != null ? !bottomD.equals(that.bottomD) : that.bottomD != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + ((topA == null) ? 0 : topA.hashCode());
        hash = 31 * hash + ((topB == null) ? 0 : topB.hashCode());
        hash = 31 * hash + ((topC == null) ? 0 : topC.hashCode());
        hash = 31 * hash + ((topD == null) ? 0 : topD.hashCode());
        hash = 31 * hash + ((bottomA == null) ? 0 : bottomA.hashCode());
        hash = 31 * hash + ((bottomB == null) ? 0 : bottomB.hashCode());
        hash = 31 * hash + ((bottomC == null) ? 0 : bottomC.hashCode());
        hash = 31 * hash + ((bottomD == null) ? 0 :bottomD.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "id=" + id +
                ", name='" + name +
                ", bottomA=" + bottomA +
                ", bottomB=" + bottomB +
                ", bottomC=" + bottomC +
                ", bottomD=" + bottomD +
                ", topA=" + topA +
                ", topB=" + topB +
                ", topC=" + topC +
                ", topD=" + topD + '\'' +
                '}';
    }
}
