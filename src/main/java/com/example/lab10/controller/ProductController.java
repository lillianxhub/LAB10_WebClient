package com.example.lab10.controller;

import com.example.lab10.model.Product;
import com.example.lab10.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ProductController — Reactive REST Controller
 *
 * ✅ @RestController, @RequestMapping, Constructor Injection ครบแล้ว
 * ✅ endpoint GET /products/{id} ทำเสร็จแล้วเป็นตัวอย่าง (30%)
 * ❌ TODO: เติม method body ของ endpoint ที่เหลือ (70%)
 *
 * Endpoints ที่ต้องทำทั้งหมด:
 * GET /products → Flux<Product> (ดึงทั้งหมด)
 * GET /products/{id} → Mono<Product> ✅ ตัวอย่างทำแล้ว
 * POST /products → Mono<Product> (บันทึก)
 * DELETE /products/{id} → Mono<Void> (ลบ)
 * GET /products/category/{cat} → Flux<Product> (กรอง)
 * GET /products/{id}/price → Mono<Double> (ราคาหลังลด)
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    // ── Constructor Injection (DIP — SOLID) ─────────────
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // ══════════════════════════════════════════════════════
    // ✅ ตัวอย่างที่ทำเสร็จแล้ว — ศึกษาแล้วทำ endpoint ที่เหลือ
    // ══════════════════════════════════════════════════════

    /**
     * GET /products/{id}
     * คืน Mono<Product> — ค้นหา Product 1 รายการ
     *
     * ทดสอบ: GET http://localhost:8080/products/1
     */
    @GetMapping("/{id}")
    public Mono<Product> getById(@PathVariable String id) {
        return service.getById(id);
    }

    // ══════════════════════════════════════════════════════
    // ❌ TODO: เติม method body ด้านล่างนี้
    // ══════════════════════════════════════════════════════

    /**
     * GET /products
     * TODO: คืน Flux<Product> ทุกรายการ
     *
     * Hint: เรียก service.getAll()
     * ทดสอบ: GET http://localhost:8080/products
     */
    @GetMapping
    public Flux<Product> getAll() {
        // TODO: เติม code ตรงนี้
        return service.getAll(); // ← แก้บรรทัดนี้
    }

    /**
     * POST /products
     * TODO: รับ Product จาก request body แล้วบันทึก
     *
     * Hint: เรียก service.save(product)
     * ทดสอบ: POST http://localhost:8080/products
     * Body: { "name": "...", "price": 999.0, ... }
     */
    @PostMapping
    public Mono<Product> save(@RequestBody Product product) {
        // TODO: เติม code ตรงนี้
        return service.save(product); // ← แก้บรรทัดนี้
    }

    /**
     * DELETE /products/{id}
     * TODO: ลบ Product และคืน Mono<Void>
     *
     * Hint: เรียก service.delete(id)
     * ทดสอบ: DELETE http://localhost:8080/products/1
     */
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        // TODO: เติม code ตรงนี้
        return service.delete(id); // ← แก้บรรทัดนี้
    }

    /**
     * GET /products/category/{category}
     * TODO: คืน Flux<Product> ที่กรองตาม category
     *
     * Hint: เรียก service.getByCategory(category)
     * ทดสอบ: GET http://localhost:8080/products/category/Electronics
     */
    @GetMapping("/category/{category}")
    public Flux<Product> getByCategory(@PathVariable String category) {
        // TODO: เติม code ตรงนี้
        return service.getByCategory(category); // ← แก้บรรทัดนี้
    }

    /**
     * GET /products/{id}/price
     * TODO: คืน Mono<Double> ราคาหลังส่วนลด
     *
     * Hint: เรียก service.getDiscountedPrice(id)
     * ทดสอบ: GET http://localhost:8080/products/1/price
     */
    @GetMapping("/{id}/price")
    public Mono<Double> getDiscountedPrice(@PathVariable String id) {
        // TODO: เติม code ตรงนี้
        return service.getDiscountedPrice(id); // ← แก้บรรทัดนี้
    }
}
