package controller;

import factory.ProductServiceFactory;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

    private static final ProductService productService = ProductServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer productId = Integer.valueOf(request.getParameter("id"));
        productService.deleteProduct(productId);
        request.setAttribute("productDatabase", productService.getAll());
        request.getRequestDispatcher("/product.jsp").forward(request, response);
    }
}
