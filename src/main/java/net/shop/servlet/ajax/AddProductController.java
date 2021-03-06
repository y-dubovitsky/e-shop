package net.shop.servlet.ajax;

import net.shop.form.ProductForm;
import net.shop.model.ShoppingCart;
import net.shop.servlet.AbstractProductController;
import net.shop.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax/json/product/add")
public class AddProductController extends AbstractProductController {

    @Override
    protected void processProductForm(ProductForm form, ShoppingCart cart, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getOrderService().addProductToShoppingCart(form, cart);
        String cookieValue = getOrderService().serializeShoppingCart(cart);
        SessionUtils.updateCurrentShoppingCartCookie(cookieValue, resp);
    }
}
