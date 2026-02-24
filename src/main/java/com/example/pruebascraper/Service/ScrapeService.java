package com.example.pruebascraper.Service;

import com.example.pruebascraper.DTO.ProductoDTO;
import com.example.pruebascraper.DTO.ScrapeResponseDTO;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ScrapeService {

    public ScrapeResponseDTO scrape(String url) {
        if (url == null || !url.startsWith("https://listado.mercadolibre.com.mx/")) {
            throw new IllegalArgumentException("Url no valida");
        }
        List<ProductoDTO> productos = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .get();

            Elements items = doc.select("div.ui-search-result");
            for (Element item : items) {
                ProductoDTO producto = new ProductoDTO();

                String titulo = item.select("h2").text();
                producto.setTitulo(titulo);

                String precio = item.select(".andes-money-amount__fraction")
                        .text()
                        .replace(".", "")
                        .replace(",", "");

                if (!precio.isEmpty()) {
                    producto.setPrecio(Double.parseDouble(precio));
                    producto.setMoneda("MXN");
                }

                String productoUrl = item.select("a").attr("href");
                producto.setUrl(productoUrl);

                String imagenUrl = item.select("img").attr("src");
                producto.setImagenUrl(imagenUrl);

                String vendedor = item.select(".ui-search-official-store-label")
                        .text();
                producto.setVendedor(vendedor.isEmpty() ? "N/A" : vendedor);

                productos.add(producto);

            }
            System.out.println(doc.html());

        } catch (IOException ex) {
            throw new RuntimeException("Error en el scrap", ex);
        }
        ScrapeResponseDTO response = new ScrapeResponseDTO();
        response.setSourceUrl(url);
        response.setTotalProductos(productos.size());
        response.setScrapedAt(Instant.now());
        response.setProductos(productos);

        return response;
    }

}
