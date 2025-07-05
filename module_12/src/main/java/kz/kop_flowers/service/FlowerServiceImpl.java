package kz.kop_flowers.service;

import kz.kop_flowers.model.FlowerMapper;
import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.model.dto.FlowerDto;
import kz.kop_flowers.model.entity.Category;
import kz.kop_flowers.model.entity.Flower;
import kz.kop_flowers.model.exception.FlowerNotFoundException;
import kz.kop_flowers.model.request.FlowerUpdateRequest;
import kz.kop_flowers.repository.FlowerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlowerServiceImpl implements FlowerService {

    private final FlowerRepository flowerRepository;
    private final FlowerMapper mapper;
    private final CategoryService categoryService;

    @Override
    public List<FlowerDto> getAllFlowers() {
        List<Flower> flowers = flowerRepository.findAll();
        return flowers.stream()
                .map(mapper::fromEntityToDto)
                .toList();
    }

    @Override
    public FlowerDto getFlowerById(Integer id) {
        Flower flower = flowerRepository.findById(id).orElseThrow(() -> new FlowerNotFoundException("Flower is not exists"));
        return mapper.fromEntityToDto(flower);
    }

    @Override
    public FlowerDto createFlower(FlowerDto flowerDto) {
        Flower flower = Flower.builder()
                .name(flowerDto.getName())
                .price(flowerDto.getPrice())
                .size(flowerDto.getSize())
                .category(categoryService.getCategoryById(flowerDto.getCategory().getId()))
                .build();
        flower = flowerRepository.save(flower);
        return mapper.fromEntityToDto(flower);
    }

    @Override
    public void deleteFlower(Integer id) {
        flowerRepository.deleteById(id);
    }

    @Override
    public List<FlowerDto> getFlowersByCategoryId(Integer id) {
        List<Flower> flowers = flowerRepository.findAllByCategoryId(id);
        return flowers.stream()
                .map(mapper::fromEntityToDto)
                .toList();
    }

    @Override
    public void updateFlower(Integer id, FlowerUpdateRequest request) {
        Flower flower = flowerRepository.findById(id)
                .orElseThrow(() -> new FlowerNotFoundException("Flower with id " + id + " is not found!"));
        Category category = categoryService.getCategoryById(request.getCategory().getId());
        flower.setName(request.getName());
        flower.setPrice(request.getPrice());
        flower.setSize(request.getSize());
        flower.setCategory(category);
        flowerRepository.save(flower);
    }
}
