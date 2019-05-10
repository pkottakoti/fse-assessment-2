package alisnobba.searchservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {


    @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String category;
    String brand;
    String color;
    double price;

    Product(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




    public Product(String category, String brand, String color, double price) {
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }




}
