package gift.ui.admin;

import gift.api.product.ProductService;
import gift.api.product.dto.ProductRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;

    public AdminController(ProductService productService) {
        this. productService = productService;
    }

    @GetMapping()
    public String view(Model model, Pageable pageable) {
        model.addAttribute("products", productService.getProducts(pageable));
        model.addAttribute("productDto", new ProductRequest());
        return "administrator";
    }

    @PostMapping("/add")
    public RedirectView add(@Valid ProductRequest productRequest) {
        productService.add(productRequest);
        return new RedirectView("/api/products");
    }

    @PutMapping("/update/{id}")
    public RedirectView update(@PathVariable("id") long id, @Valid ProductRequest productRequest) {
        productService.update(id, productRequest);
        return new RedirectView("/api/products");
    }

    @DeleteMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") long id) {
        productService.delete(id);
        return new RedirectView("/api/products");
    }
}
