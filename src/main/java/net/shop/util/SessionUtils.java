package net.shop.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.shop.Constants;
import net.shop.model.CurrentAccount;
import net.shop.model.ShoppingCart;

/**
 * Утилитный класс для работы с сессиями
 */
public class SessionUtils {

	/**
	 * Этот метод возвращает объект ShoppingCart из сессии. Если объекта ShoppingCart нет в сессии, то он создается и
	 * записывается в сессию.
	 * @param req
	 * @return
	 */
	public static ShoppingCart getCurrentShoppingCart(HttpServletRequest req) {
		ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART);
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			setCurrentShoppingCart(req, shoppingCart);
		}
		return shoppingCart;
	}

	public static boolean isCurrentShoppingCartCreated(HttpServletRequest req) {
		return req.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART) != null;
	}

	/**
	 * Записывает объект shoppingCart в сессию.
	 * @param req
	 * @param shoppingCart
	 */
	public static void setCurrentShoppingCart(HttpServletRequest req, ShoppingCart shoppingCart) {
		req.getSession().setAttribute(Constants.CURRENT_SHOPPING_CART, shoppingCart);
	}

	public static void clearCurrentShoppingCart(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().removeAttribute(Constants.CURRENT_SHOPPING_CART);
		WebUtils.setCookie(Constants.Cookie.SHOPPING_CART.getName(), null, 0, resp);
	}

	public static Cookie findShoppingCartCookie(HttpServletRequest req) {
		return WebUtils.findCookie(req, Constants.Cookie.SHOPPING_CART.getName());
	}

	public static void updateCurrentShoppingCartCookie(String cookieValue, HttpServletResponse resp) {
		WebUtils.setCookie(Constants.Cookie.SHOPPING_CART.getName(), cookieValue,
				Constants.Cookie.SHOPPING_CART.getTtl(), resp);
	}

	public static CurrentAccount getCurrentAccount(HttpServletRequest req) {
		return (CurrentAccount) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);
	}
	public static void setCurrentAccount(HttpServletRequest req, CurrentAccount currentAccount) {
		req.getSession().setAttribute(Constants.CURRENT_ACCOUNT, currentAccount);
	}
	public static boolean isCurrentAccountCreated(HttpServletRequest req) {
		return getCurrentAccount(req) != null;
	}

	private SessionUtils() {
	}
}
