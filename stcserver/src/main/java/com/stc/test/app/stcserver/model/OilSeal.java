package com.stc.test.app.stcserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class OilSeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double innerDiameter;
    private double outerDiameter;
    private double thickness;
    private int quantity;

    public OilSeal() { }

    public OilSeal(Long id, double innerDiameter, double outerDiameter, double thickness, int quantity) {
        this.id = id;
        this.innerDiameter = innerDiameter;
        this.outerDiameter = outerDiameter;
        this.thickness = thickness;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getInnerDiameter() { return innerDiameter; }
    public void setInnerDiameter(double innerDiameter) { this.innerDiameter = innerDiameter; }

    public double getOuterDiameter() { return outerDiameter; }
    public void setOuterDiameter(double outerDiameter) { this.outerDiameter = outerDiameter; }

    public double getThickness() { return thickness; }
    public void setThickness(double thickness) { this.thickness = thickness; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OilSeal oilSeal = (OilSeal) o;
        return Double.compare(innerDiameter, oilSeal.innerDiameter) == 0 && Double.compare(outerDiameter, oilSeal.outerDiameter) == 0 && Double.compare(thickness, oilSeal.thickness) == 0 && quantity == oilSeal.quantity && Objects.equals(id, oilSeal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, innerDiameter, outerDiameter, thickness, quantity);
    }

    @Override
    public String toString() {
        return "OilSeal{" +
                "id=" + id +
                ", innerDiameter=" + innerDiameter +
                ", outerDiameter=" + outerDiameter +
                ", thickness=" + thickness +
                ", quantity=" + quantity +
                '}';
    }
}