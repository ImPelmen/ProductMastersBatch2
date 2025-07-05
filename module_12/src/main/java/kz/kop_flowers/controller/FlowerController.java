package kz.kop_flowers.controller;

import kz.kop_flowers.model.dto.FlowerDto;
import kz.kop_flowers.model.entity.Flower;
import kz.kop_flowers.model.request.FlowerUpdateRequest;
import kz.kop_flowers.service.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flowers")
@RequiredArgsConstructor
public class FlowerController {

    private final FlowerService flowerService;

    @GetMapping()
    public List<FlowerDto> getFlowers() {
        return flowerService.getAllFlowers();
    }

    @GetMapping("/{id}")
    public FlowerDto getFlowerById(
            @PathVariable Integer id
    ) {
        return flowerService.getFlowerById(id);
    }

    @PostMapping()
    public FlowerDto createFlower(
            @RequestBody FlowerDto flower
    ) {
        return flowerService.createFlower(flower);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlower(
            @PathVariable Integer id
    ) {
        flowerService.deleteFlower(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{categoryId}", params = "by-category")
    public ResponseEntity<List<FlowerDto>> getFlowersByCategoryId(
            @PathVariable Integer categoryId
    ) {
        return ResponseEntity.ok(flowerService.getFlowersByCategoryId(categoryId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateFlower(
            @PathVariable Integer id,
            @RequestBody FlowerUpdateRequest request) {
        flowerService.updateFlower(id, request);
        return ResponseEntity.ok().build();
    }

}
