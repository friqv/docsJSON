package a;

import a.CarSales;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromedioCarro {
    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader in = null;

        //leer el atchivo json
        try {
            fileReader = new FileReader("car_sales.json");
            in = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        //crear una lista donde meteremos objetos de la clase a.CarSales, y otra donde solo esten los precios
        Gson gson = new Gson();
        String jsonString;
        List<CarSales> carSalesLista = new ArrayList<>();
        Map<String, List<Double>> precioDeMarca = new HashMap<>();

            //se lee el archivo para que cada línea sea un objeto y lo metemos a la lista de objetos
        try {
            while ((jsonString = in.readLine()) != null) {
                CarSales carObj = gson.fromJson(jsonString, CarSales.class);
                carSalesLista.add(carObj);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (CarSales carSales : carSalesLista) {
            String brand = carSales.getCar();
            double price = carSales.getPrice();

            // añadir las marcas de carro a la lista
            if (!precioDeMarca.containsKey(brand)) {
                precioDeMarca.put(brand, new ArrayList<>());
            }

            // y al ya tener las marcas en la lista, se añaden los precios con las keys que ya le dimos( que es la marca)
            precioDeMarca.get(brand).add(price);
        }

        //se hace un ciclo para que por cada marca se puede sacar el promedio de precios
        for (Map.Entry<String, List<Double>> entry : precioDeMarca.entrySet()) {
            String brand = entry.getKey();
            List<Double> prices = entry.getValue();
            double promedioPrice = promedioMarca(prices);

            System.out.println("Marca: " + brand + ", Promedio de Precio: " + promedioPrice);
        }
    }

    private static double promedioMarca(List<Double> prices) {
        double sum = 0;
        for (double price : prices) {
            sum += price;
        }
        return sum / prices.size();
    }
}
