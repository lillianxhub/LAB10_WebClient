package com.example.lab10.service;

import com.example.lab10.model.Product;
import com.example.lab10.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ProductService — Business Logic Layer
 *
 * ✅ @Service, Constructor Injection ครบแล้ว (DIP — SOLID)
 * ❌ TODO: เติม method body ให้ครบทุก method
 *
 * หน้าที่: รับ request จาก Controller → เรียก Repository → คืนผล
 * (SRP — แต่ละ class มีหน้าที่เดียว)
 *
 * Hint Operators ที่ควรใช้:
 * .map(p -> ...) แปลงค่า
 * .flatMap(p -> ...) async transform
 * .defaultIfEmpty(...) fallback ถ้าว่าง
 * .switchIfEmpty(Mono...) fallback Mono ถ้าว่าง
 */
@Service
public class ProductService {

    // ── Constructor Injection (DIP — SOLID) ─────────────
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // ── 1. ดึง Product 1 รายการ ──────────────────────────
    /**
     * TODO: เรียก repository.findById(id) แล้วคืนผล
     * ถ้าไม่พบให้ throw RuntimeException("Product not found: " + id)
     *
     * Hint: repository.findById(id)
     * .switchIfEmpty(Mono.error(new RuntimeException(...)))
     */
    public Mono<Product> getById(String id) {
        // TODO: เติม code ตรงนี้
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Product not found: " + id)));// ← แก้บรรทัดนี้
    }

    // ── 2. ดึง Product ทั้งหมด ───────────────────────────
    /**
     * TODO: เรียก repository.findAll() แล้วคืนผล
     */
    public Flux<Product> getAll() {
        // TODO: เติม code ตรงนี้
        return repository.findAll(); // ← แก้บรรทัดนี้
    }

    // ── 3. บันทึก Product ────────────────────────────────
    /**
     * TODO: เรียก repository.save(product) แล้วคืนผล
     *
     * เพิ่มเติม: ถ้า product.getId() เป็น null ให้ generate id ใหม่
     * Hint: java.util.UUID.randomUUID().toString()
     */
    public Mono<Product> save(Product product) {
        // TODO: เติม code ตรงนี้
        if (product.getId() == null || product.getId().isEmpty()) {
            product.setId(java.util.UUID.randomUUID().toString());
        }
        return repository.save(product); // ← แก้บรรทัดนี้
    }

    // ── 4. ลบ Product ────────────────────────────────────
    /**
     * TODO: เรียก repository.deleteById(id) แล้วคืนผล
     */
    public Mono<Void> delete(String id) {
        // TODO: เติม code ตรงนี้
        return repository.deleteById(id); // ← แก้บรรทัดนี้
    }

    // ── 5. กรองตาม category ──────────────────────────────
    /**
     * TODO: เรียก repository.findByCategory(category) แล้วคืนผล
     */
    public Flux<Product> getByCategory(String category) {
        // TODO: เติม code ตรงนี้
        return repository.findByCategory(category); // ← แก้บรรทัดนี้
    }

    // ── 6. คำนวณราคาหลังส่วนลด ───────────────────────────
    /**
     * TODO: หา Product จาก id แล้วคืน discountedPrice
     *
     * Hint: getById(id)
     * .map(p -> p.getDiscountedPrice())
     */
    public Mono<Double> getDiscountedPrice(String id) {
        // TODO: เติม code ตรงนี้
        return getById(id).map(p -> p.getDiscountedPrice()); // ← แก้บรรทัดนี้
    }
}
