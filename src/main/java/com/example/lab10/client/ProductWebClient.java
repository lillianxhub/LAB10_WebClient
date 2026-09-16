package com.example.lab10.client;

import com.example.lab10.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ProductWebClient — Reactive HTTP Client
 *
 * ✅ WebClient setup และ Bean config ครบแล้ว
 * ✅ method getProductById() ทำเสร็จแล้วเป็นตัวอย่าง (30%)
 * ❌ TODO: เติม method body ที่เหลือ (70%)
 *
 * WebClient method chain:
 * client.get() ← HTTP method
 * .uri("/products/{id}", id) ← URL
 * .retrieve() ← เริ่มรับ response
 * .bodyToMono(T.class) ← แปลงเป็น Mono<T>
 * .bodyToFlux(T.class) ← แปลงเป็น Flux<T>
 */
@Component
public class ProductWebClient {

    // ✅ WebClient ตั้งค่าแล้ว ชี้ไปที่ server ตัวเอง
    private final WebClient client = WebClient.create("http://localhost:8080");

    // ══════════════════════════════════════════════════════
    // ✅ ตัวอย่างที่ทำเสร็จแล้ว — ศึกษาแล้วทำ method ที่เหลือ
    // ══════════════════════════════════════════════════════

    /**
     * GET /products/{id} → Mono<Product>
     * ดึง Product 1 รายการจาก server
     */
    public Mono<Product> getProductById(String id) {
        return client.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class);
    }

    // ══════════════════════════════════════════════════════
    // ❌ TODO: เติม method body ด้านล่างนี้
    // ══════════════════════════════════════════════════════

    /**
     * GET /products → Flux<Product>
     * TODO: ดึง Product ทั้งหมดจาก server
     *
     * Hint: client.get()
     * .uri("/products")
     * .retrieve()
     * .bodyToFlux(Product.class)
     */
    public Flux<Product> getAllProducts() {
        // TODO: เติม code ตรงนี้
        return client.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class); // ← แก้บรรทัดนี้
    }

    /**
     * POST /products → Mono<Product>
     * TODO: ส่ง Product ใหม่ไปยัง server
     *
     * Hint: client.post()
     * .uri("/products")
     * .bodyValue(product) ← ส่ง body
     * .retrieve()
     * .bodyToMono(Product.class)
     */
    public Mono<Product> createProduct(Product product) {
        // TODO: เติม code ตรงนี้
        return client.post()
                .uri("/products")
                .retrieve()
                .bodyToMono(Product.class); // ← แก้บรรทัดนี้
    }

    /**
     * DELETE /products/{id} → Mono<Void>
     * TODO: ส่ง request ลบ Product
     *
     * Hint: client.delete()
     * .uri("/products/{id}", id)
     * .retrieve()
     * .bodyToMono(Void.class)
     */
    public Mono<Void> deleteProduct(String id) {
        // TODO: เติม code ตรงนี้
        return client.delete()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Void.class); // ← แก้บรรทัดนี้
    }

    /**
     * GET /products/category/{category} → Flux<Product>
     * TODO: ดึง Product ตาม category
     *
     * Hint: client.get()
     * .uri("/products/category/{category}", category)
     * .retrieve()
     * .bodyToFlux(Product.class)
     */
    public Flux<Product> getByCategory(String category) {
        // TODO: เติม code ตรงนี้
        return client.get()
                .uri("/products/category/{category}", category)
                .retrieve()
                .bodyToFlux(Product.class); // ← แก้บรรทัดนี้
    }

    /**
     * GET /products/{id}/price → Mono<Double>
     * TODO: ดึงราคาหลังส่วนลด
     * แล้ว chain .doOnNext() เพื่อ log ราคาที่ได้
     *
     * Hint: client.get()
     * .uri("/products/{id}/price", id)
     * .retrieve()
     * .bodyToMono(Double.class)
     * .doOnNext(price -> System.out.println("Price: " + price))
     */
    public Mono<Double> getDiscountedPrice(String id) {
        // TODO: เติม code ตรงนี้
        return client.get()
                .uri("/products/{id}/price", id)
                .retrieve()
                .bodyToMono(Double.class)
                .doOnNext(price -> System.out.println("Price: " + price)); // ← แก้บรรทัดนี้
    }
}
