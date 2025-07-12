package kop_flowers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.kop_flowers.controller.CategoryController;
import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        categoryService = Mockito.mock(CategoryService.class);
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllCategories() throws Exception {
        List<CategoryDto> categoryDtoList = List.of(
                CategoryDto.builder().id(1).name("Цветы для учителей ДТО").build(),
                CategoryDto.builder().id(2).name("Цветы для мамы ДТО").build()
        );

        Mockito.when(categoryService.getAllCategories()).thenReturn(categoryDtoList);

        mockMvc.perform(get("/api/category/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$[0].name").value("Цветы для учителей ДТО"))
                .andExpect(jsonPath("$[1].name").value("Цветы для мамы ДТО"));
    }

    @Test
    void testCreateCategory() throws Exception {
        CategoryDto requestDto = CategoryDto.builder()
                .name("Цветы для учителей ДТО")
                .build();

        CategoryDto responseDto = CategoryDto.builder()
                .id(1)
                .name("Цветы для учителей ДТО")
                .build();

        Mockito.when(categoryService.createCategory(Mockito.any())).thenReturn(responseDto);

        mockMvc.perform(post("/api/category"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Цветы для учителей ДТО"));
    }
}
