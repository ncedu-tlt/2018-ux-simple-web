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
    public static final String PRODUCTS_ADD = PRODUCTS_BASE + "/add.jsp";
    public static final String PRODUCTS_EDIT = PRODUCTS_BASE + "/edit.jsp";

    // Offices
    private static final String OFFICES_BASE = VIEWS_BASE + "/offices";
    public static final String OFFICES = OFFICES_BASE + "/index.jsp";
    public static final String OFFICES_ADD = OFFICES_BASE + "/add.jsp";
    public static final String OFFICES_EDIT = OFFICES_BASE + "/edit.jsp";

    // Offering
    public static final String OFFERINGS_BASE = VIEWS_BASE + "/offerings";
    public static final String OFFERINGS = OFFERINGS_BASE + "/index.jsp";
    public static final String OFFERINGS_ADD = OFFERINGS_BASE + "/add.jsp";
    public static final String OFFERINGS_EDIT = OFFERINGS_BASE + "/edit.jsp";

    //Countries
    private static final String COUNTRIES_BASE = VIEWS_BASE + "/countries";
    public static final String COUNTRIES = COUNTRIES_BASE + "/index.jsp";
    public static final String COUNTRIES_ADD = COUNTRIES_BASE + "/add.jsp";
    public static final String COUNTRIES_EDIT = COUNTRIES_BASE + "/edit.jsp";
}
