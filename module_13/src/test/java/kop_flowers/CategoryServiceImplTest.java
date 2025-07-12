package kop_flowers;

import kz.kop_flowers.model.FlowerMapper;
import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.model.entity.Category;
import kz.kop_flowers.model.exception.CategoryNotFoundException;
import kz.kop_flowers.repository.CategoryRepository;
import kz.kop_flowers.service.CategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private FlowerMapper flowerMapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void testGetAllCategories() {
        List<Category> categories = List.of(
                Category.builder().id(1).name("Цветы для учителей").build(),
                Category.builder().id(2).name("Цветы для мамы").build()
        );

        List<CategoryDto> categoryDtoList = List.of(
                CategoryDto.builder().id(1).name("Цветы для учителей ДТО").build(),
                CategoryDto.builder().id(2).name("Цветы для мамы ДТО").build()
        );

        Mockito.when(categoryRepository.findAll()).thenReturn(categories);
        Mockito.when(flowerMapper.fromEntityToDto(categories.get(0))).thenReturn(categoryDtoList.get(0));
        Mockito.when(flowerMapper.fromEntityToDto(categories.get(1))).thenReturn(categoryDtoList.get(1));
        //
        //
        List<CategoryDto> result = categoryService.getAllCategories();
        //
        //
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Цветы для учителей ДТО", categoryDtoList.get(0).getName());
        Assertions.assertEquals("Цветы для мамы ДТО", categoryDtoList.get(1).getName());
        Mockito.verify(flowerMapper, Mockito.times(2)).fromEntityToDto(any(Category.class));
    }

    @Test
    public void testGetCategoryById_whenNotExists() {
        Mockito.when(categoryRepository.findById(any())).thenReturn(Optional.empty());
        CategoryNotFoundException exception = Assertions.assertThrows(CategoryNotFoundException.class, () -> categoryService.getCategoryById(any()));
        Assertions.assertEquals("Category is not found", exception.getMessage());
        Mockito.verify(flowerMapper, Mockito.never()).fromEntityToDto(any(Category.class));
    }

    @Test
    public void testCreateCategory() {
        CategoryDto inputCategoryDto = CategoryDto.builder()
                .name("Цветы для учителей ДТО")
                .build();

        Category savedCategory = Category.builder()
                .name("Цветы для учителей ДТО")
                .build();

        CategoryDto categoryDto = CategoryDto.builder()
                .id(1)
                .name("Цветы для учителей ДТО")
                .build();

        Mockito.when(categoryRepository.save(any(Category.class))).thenReturn(savedCategory);
        Mockito.when(flowerMapper.fromEntityToDto(savedCategory)).thenReturn(categoryDto);
        //
        //
        CategoryDto result = categoryService.createCategory(inputCategoryDto);
        //
        //
        Assertions.assertEquals("Цветы для учителей ДТО", result.getName());
        Mockito.verify(categoryRepository).save(any(Category.class));
    }

}
