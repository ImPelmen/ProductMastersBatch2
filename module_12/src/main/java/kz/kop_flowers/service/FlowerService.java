package kz.kop_flowers.service;

import kz.kop_flowers.model.dto.FlowerDto;
import kz.kop_flowers.model.request.FlowerUpdateRequest;

import java.util.List;

public interface FlowerService {

    List<FlowerDto> getAllFlowers();

    FlowerDto getFlowerById(Integer id);

    FlowerDto createFlower(FlowerDto flower);

    void deleteFlower(Integer id);

    List<FlowerDto> getFlowersByCategoryId(Integer id);

    void updateFlower(Integer id, FlowerUpdateRequest request);
}
