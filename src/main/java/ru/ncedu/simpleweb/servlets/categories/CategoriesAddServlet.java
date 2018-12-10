package ru.ncedu.simpleweb.servlets.categories;

import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.models.Category;
import ru.ncedu.simpleweb.repositories.CategoriesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "categoriesAdd", urlPatterns = {"/categories/add"})
public class CategoriesAddServlet extends HttpServlet {

    private static final String NAME_PARAM = "name";
    private static final String DESCRIPTION_PARAM = "description";

    private static final String ERROR_ATTR = "error";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Views.CATEGORIES_ADD).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(NAME_PARAM);
        String description = req.getParameter(DESCRIPTION_PARAM);

        if (!isValid(name, description)) {
            req.setAttribute(ERROR_ATTR, true);
            req.getRequestDispatcher(Views.CATEGORIES_ADD).forward(req, resp);
            return;
        }

        Category category = new Category();
        category.setName(name);
        category.setDescription(description);

        CategoriesRepository.getInstance().add(category);

        resp.sendRedirect(req.getContextPath() + "/categories");
    }

    private boolean isValid(String name, String description) {
        return name != null && !name.isEmpty() &&
                description != null && !description.isEmpty();
    }
}
