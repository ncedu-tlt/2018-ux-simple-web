package ru.ncedu.simpleweb.servlets.products;

import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.models.Category;
import ru.ncedu.simpleweb.models.Product;
import ru.ncedu.simpleweb.models.ProductViewModel;
import ru.ncedu.simpleweb.repositories.CategoriesRepository;
import ru.ncedu.simpleweb.repositories.ProductsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "productsEdit", urlPatterns = {"/products/edit"})
public class ProductsEditServlet extends HttpServlet {

    private static final String PRODUCT_ATTR = "product";
    private static final String CATEGORIES_ATTR = "categories";
    private static final String CATEGORY_ID_ATTR = "categoryId";

    private static final String PRODUCT_ID_PARAM = "productId";

    private static final String NAME_PARAM = "name";
    private static final String DESCRIPTION_PARAM = "description";

    private static final String CATEGORY_PARAM = "category";

    private static final String ERROR_ATTR = "error";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long productId = Long.parseLong(req.getParameter(PRODUCT_ID_PARAM));
        Product product = ProductsRepository.getInstance().get(productId);
        Category category = CategoriesRepository.getInstance().get(product.getCategoryId());
        ProductViewModel productViewModel = new ProductViewModel(product, category);

        req.setAttribute(PRODUCT_ATTR, productViewModel);
        req.setAttribute(CATEGORIES_ATTR, CategoriesRepository.getInstance().get());
        req.setAttribute(CATEGORY_ID_ATTR, category.getId());

        req.getRequestDispatcher(Views.PRODUCTS_EDIT).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter(NAME_PARAM);
        String description = req.getParameter(DESCRIPTION_PARAM);
        String categoryIdStr = req.getParameter(CATEGORY_PARAM);
        long productId = Long.parseLong(req.getParameter(PRODUCT_ID_PARAM));

        if (!isValid(name, description, categoryIdStr)) {
            req.setAttribute(ERROR_ATTR, true);
            Product product = ProductsRepository.getInstance().get(productId);
            Category category = CategoriesRepository.getInstance().get(product.getCategoryId());
            ProductViewModel productViewModel = new ProductViewModel(product, category);

            req.setAttribute(PRODUCT_ATTR, productViewModel);
            req.setAttribute(CATEGORIES_ATTR, CategoriesRepository.getInstance().get());
            req.setAttribute(CATEGORY_ID_ATTR, category.getId());
            req.getRequestDispatcher(Views.PRODUCTS_EDIT).forward(req, resp);
            return;
        }

        long categoryId = Long.parseLong(categoryIdStr);

        Product product = ProductsRepository.getInstance().get(productId);
        product.setName(name);
        product.setCategoryId(categoryId);
        product.setDescription(description);

        ProductsRepository.getInstance().update(product);

        resp.sendRedirect(req.getContextPath() + "/products");
    }

    private boolean isValid(String name, String description, String categoryIdStr) {

        String nameWithoutSpace = name.trim();
        String categoryIdStrWithoutSpace = categoryIdStr.trim();
        String descriptionWithoutSpace = description.trim();
        return name != null && !nameWithoutSpace.isEmpty() &&
                description != null && !descriptionWithoutSpace.isEmpty() &&
                categoryIdStr != null && !categoryIdStrWithoutSpace.isEmpty();
    }
}
