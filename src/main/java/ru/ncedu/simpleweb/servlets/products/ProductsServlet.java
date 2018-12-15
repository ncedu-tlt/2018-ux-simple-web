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
import java.util.List;

@WebServlet(name = "products", urlPatterns = {"/products"})
public class ProductsServlet extends HttpServlet {
    private static final String PRODUCTS_ATTR = "products";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductsRepository.getInstance().get();
        req.setAttribute(PRODUCTS_ATTR, products);

        req.getRequestDispatcher(Views.PRODUCTS).forward(req, resp);
    }
}
