package net.shop;

public final class Constants {

	public static final String CURRENT_SHOPPING_CART = "CURRENT_SHOPPING_CART";
	
	public static final int MAX_PRODUCT_COUNT_PER_SHOPPING_CART = 10;
	
	public static final int MAX_PRODUCTS_PER_SHOPPING_CART = 20;
	
	public static final String ACCOUNT_ACTIONS_HISTORY = "ACCOUNT_ACTIONS_HISTORY";

	public static final int MAX_PRODUCTS_PER_HTML_PAGE = 12;

	//? Зачем тут константы? Можно и без них обойтись
	public static final String CATEGORY_LIST = "CATEGORY_LIST";

	public static final String PRODUCERS_LIST = "PRODUCERS_LIST";

	public static final String CURRENT_ACCOUNT = "CURRENT_ACCOUNT";

	public static final String SUCCESS_REDIRECT_URL_AFTER_SIGIN = "SUCCESS_REDIRECT_URL_AFTER_SIGIN";

	public static final String CURRENT_REQUEST_URL = "CURRENT_REQUEST_URL";

	public static final Integer ORDERS_PER_PAGE = 5;



	public enum Cookie { //? Что за метод?
		//1 year ttl
		SHOPPING_CART("iSCC", 60 * 60 * 24 * 365);

		private final String name;
		private final int ttl;

		private Cookie(String name, int ttl) {
			this.name = name;
			this.ttl = ttl;
		}

		public String getName() {
			return name;
		}

		public int getTtl() {
			return ttl;
		}
	}
}
