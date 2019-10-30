package pl.filewicz.warehouse;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JsonGenerator {

    private static List<Product> getProducts(WarehouseDao warehouseDao) {
        Product camera = new Product("Aparat fotograficzny Canon EOS", 120, 1550.99, "Canon EOS 2000D + EF-S 18-55mm f/3,5-5.6 IS II + torba SB130 + karta 16GB + SanDisk Extreme SDHC Class 10 UHS-I U3 V30 32GB");
        Product smartphone = new Product("Smartfon Samsung Galaxy S8", 350, 2850.99, "Smartfon SAMSUNG Galaxy S8 64GB SM-G950 Midnight Black");
        Product laptop = new Product("Laptop Samsung Notebook 9", 80, 3699.00, "Samsung Notebook 9 15FHD i7-7500U 8GB SSD512 1,3kg");

        Category photograpy = new Category("Fotografia", "Sprzęt foto - video, akcesoria oraz wszystko, co potrzebne do fotografii i filmowania.");
        Category computers = new Category("Komputery", " Sprzęt komputerowy m.in laptopy, komputery, tablety, akcesoria.");
        Category rtv = new Category("RTV i AGD", "Elektronika użytkowa, telewizory i sprzęt RTV, duże i małe AGD, komputery, tablety, telefony, sprzęt fotograficzny, gry i konsole oraz akcesoria.");
        Category phones = new Category("Telefony i Akcesoria", "Telefony komórkowe producentów: Samsung, Huawei, Apple, Xiaomi, LG, Sony, Nokia, HTC, Motorola i innych.");

        camera.addCategory(photograpy);
        camera.addCategory(rtv);

        smartphone.addCategory(phones);
        smartphone.addCategory(rtv);

        laptop.addCategory(computers);
        laptop.addCategory(rtv);

        warehouseDao.save(camera);
        warehouseDao.save(smartphone);
        warehouseDao.save(laptop);

        Product product1 = warehouseDao.getProduct(camera.getId());
        Product product2 = warehouseDao.getProduct(smartphone.getId());
        Product product3 = warehouseDao.getProduct(laptop.getId());

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        return products;
    }
    public static void main(String[] args) {

        WarehouseDao warehouseDao = new WarehouseDao();

        List<Product> products = getProducts(warehouseDao);

        Warehouse warehouse = new Warehouse("Warehouse 1",products);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("warehouse.json"),warehouse);

            String jsonPretty = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(warehouse);
            System.out.println(jsonPretty);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
