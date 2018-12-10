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
import java.util.List;

@WebServlet(name = "categories", urlPatterns = {"/categories"})
public class CategoriesServlet extends HttpServlet {

    private static final String CATEGORIES_ATTR = "categories";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = CategoriesRepository.getInstance().get();
        req.setAttribute(CATEGORIES_ATTR, categories);

        req.getRequestDispatcher(Views.CATEGORIES).forward(req, resp);
    }
}
