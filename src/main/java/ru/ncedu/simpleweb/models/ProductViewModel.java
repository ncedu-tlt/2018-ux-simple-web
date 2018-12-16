package ru.ncedu.simpleweb.models;

public class ProductViewModel {
    private long id;
    private String name;
    private String description;
    private String categoryName;

    public ProductViewModel(Product product, Category category) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.categoryName = category.getName();
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}
