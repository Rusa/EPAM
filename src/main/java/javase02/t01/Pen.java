package javase02.t01;


/**
 * Created by rusamaha on 5/11/17.
 */
public class Pen {
    public  enum PenType {
        BALLPOINT, GEL, MECHANICAL, NIB, OTHER
    }

    public  enum Material {
        WOOD, METAL, PLASTIC, OTHER
    }

    private String brand;
    private String name;
    private String vendorCode;
    private PenType penType;
    private Material material;
    private String inkColor;
    private float nibSize;             // in mm
    private float weight;
    private String description;
    private Integer price;

    Pen(String brand, String name, String vendorCode, PenType penType, Material material, String inkColor, float nibSize,
        float weight, String description, Integer price) {

        this.brand = brand;
        this.name = name;
        this.vendorCode = vendorCode;
        this.penType = penType;
        this.material = material;
        this.inkColor = inkColor;
        this.nibSize = nibSize;
        this.weight = weight;
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (Float.compare(pen.nibSize, nibSize) != 0) return false;
        if (Float.compare(pen.weight, weight) != 0) return false;
        if (brand != null ? !brand.equals(pen.brand) : pen.brand != null) return false;
        if (name != null ? !name.equals(pen.name) : pen.name != null) return false;
        if (vendorCode != null ? !vendorCode.equals(pen.vendorCode) : pen.vendorCode != null) return false;
        if (penType != pen.penType) return false;
        if (material != pen.material) return false;
        if (inkColor != null ? !inkColor.equals(pen.inkColor) : pen.inkColor != null) return false;
        if (description != null ? !description.equals(pen.description) : pen.description != null) return false;
        return price != null ? price.equals(pen.price) : pen.price == null;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (vendorCode != null ? vendorCode.hashCode() : 0);
        result = 31 * result + (penType != null ? penType.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (inkColor != null ? inkColor.hashCode() : 0);
        result = 31 * result + (nibSize != +0.0f ? Float.floatToIntBits(nibSize) : 0);
        result = 31 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", penType=" + penType +
                ", material=" + material +
                ", inkColor='" + inkColor + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}