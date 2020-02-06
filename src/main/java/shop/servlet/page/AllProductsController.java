package shop.servlet.page;

import shop.servlet.AbstractController;
import shop.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products")
public class AllProductsController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<?> products = getBusinessService().getProducts();
//        req.setAttribute("products", products);
        RoutingUtils.forwardToPage("products.jsp", req, resp);

    }
}