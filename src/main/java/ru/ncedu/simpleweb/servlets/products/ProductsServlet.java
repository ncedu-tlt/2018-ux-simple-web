package ru.ncedu.simpleweb.servlets.products;

import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.models.Category;
import ru.ncedu.simpleweb.models.Product;
import ru.ncedu.simpleweb.repositories.CategoriesRepository;
import ru.ncedu.simpleweb.repositories.ProductsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "products", urlPatterns = {"/products"})
public class ProductsServlet extends HttpServlet {
    private static final String PRODUCTS_ATTR = "products";
    private static final String CATEGORIES_ATTR = "categories";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductsRepository.getInstance().get();
        List<Category> categories = new ArrayList<>();
        for (Product product : products) {
            Category category = CategoriesRepository.getInstance().get(product.getCategoryId());
            categories.add(category);
        }

        req.setAttribute(PRODUCTS_ATTR, products);
        req.setAttribute(CATEGORIES_ATTR, categories );

        req.getRequestDispatcher(Views.PRODUCTS).forward(req, resp);
    }
}
