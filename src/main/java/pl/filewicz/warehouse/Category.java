package pl.filewicz.warehouse;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private int id;
    private String categoryName;
    private String description;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "category_products",
            joinColumns = {@JoinColumn(name = "cat_id", referencedColumnName = "id_category")},
            inverseJoinColumns = {@JoinColumn(name = "prod_id", referencedColumnName = "id_product")}
    )
    private List<Product> products = new ArrayList<>();

    public Category() {

    }

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        product.setCategories((List<Category>) this);
        products.add(product);

    }

    @Override
    public String toString() {
        return categoryName + " "+description;
    }
}

