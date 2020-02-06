package shop.service.impl;

import shop.service.OrderService;
import shop.service.ProductService;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServiceManager { //! Использует паттерн синглтон

    private final ProductService productService;
    private final OrderService orderService;
    private final Properties applicationProperties = new Properties();

    /**
     * This constructor is called after public static ServiceManager getInstance
     * @param context
     */
    private ServiceManager(ServletContext context) {
        loadApplicationProperties(); //* Загружает свойства из файла
        productService = new ProductServiceImpl();
        orderService = new OrderServiceImpl();
    }

    /**
     * A service manager is created once when a static method is called. When the static method is called, the constructor is called in which objects "productService" and "orderService" are created that also exist in a single instance, since the service manager is a singleton.
     * @param context
     * @return
     */
    public static ServiceManager getInstance(ServletContext context) {
        ServiceManager instance = (ServiceManager) context.getAttribute("SERVICE_MANAGER"); //! singleton
        if (instance == null) {
            instance = new ServiceManager(context);
            context.setAttribute("SERVICE_MANAGER", instance);
        }
        return instance;
    }

    public void close() { //close resources
    }

    /**
     * This method returns the property by key from the properties file;
     * @param key - name of property
     * @return
     */
    public String getApplicationProperty(String key) {
        return applicationProperties.getProperty(key);
    }

    public final ProductService getProductService() {
        return productService;
    }

    public final OrderService getOrderService() {
        return orderService;
    }

    /**
     * Loads a property from a properties file;
     */
    private void loadApplicationProperties() {
        try(InputStream in = ServiceManager.class.getClassLoader().getResourceAsStream("META-INF/application.properties")) {
            applicationProperties.load(in);
        } catch (IOException i) {
            throw new RuntimeException(i);
        }
    }
}
