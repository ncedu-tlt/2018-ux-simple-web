package ru.ncedu.simpleweb.consts;

public class Views {
    // Base
    private static final String VIEWS_BASE = "/WEB-INF/views";

    // Common
    public static final String INDEX = VIEWS_BASE + "/index.jsp";

    // Categories
    private static final String CATEGORIES_BASE = VIEWS_BASE + "/categories";
    public static final String CATEGORIES = CATEGORIES_BASE + "/index.jsp";
    public static final String CATEGORIES_ADD = CATEGORIES_BASE + "/add.jsp";

    // Products
    private static final String PRODUCTS_BASE = VIEWS_BASE + "/products";
    public static final String PRODUCTS = PRODUCTS_BASE + "/index.jsp";

}
