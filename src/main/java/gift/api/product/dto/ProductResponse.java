package gift.api.product.dto;

import gift.api.category.Category;
import gift.api.product.Product;

public record ProductResponse(
    Category category,
    String name,
    Integer price,
    String imageUrl
) {
    public static ProductResponse of(Product product) {
        return new ProductResponse(product.getCategory(),
                                product.getName(),
                                product.getPrice(),
                                product.getImageUrl());
    }
}