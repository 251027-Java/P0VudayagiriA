package org.example.Service;

import org.example.models.ClothingItem;
import org.example.Repository.IRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClosetServiceTest {

    @Mock
    IRepository mockRepo;

    @InjectMocks
    private ClosetService service;

    //Test 1: Test if adding a clothing item works correctly
    @Test
    public void testAddClothing() {
        ClothingItem newItem = new ClothingItem(1, "Blue Jeans");
        when(mockRepo.createClothingItem(any(ClothingItem.class))).thenReturn(newItem);

        ClothingItem result = service.addClothing("Blue Jeans");

        assertEquals("Blue Jeans", result.getName());
        assertEquals(1, result.getId());
    }

    //Test 2: Test that an empty name returns null
    @Test
    public void testAddClothingEmptyName() {
        ClothingItem result = service.addClothing("");
        
        assertNull(result);
    }

    //Test 3: Test getting clothes when closet is empty
    @Test
    public void testGetAllClothesWhenEmpty() {
        List<ClothingItem> emptyList = new ArrayList<>();
        when(mockRepo.getAllClothingItems()).thenReturn(emptyList);

        List<ClothingItem> result = service.getAllClothes();

        assertTrue(result.isEmpty());
    }

    //Test 4: Test assigning a category to clothing
    @Test
    public void testAssignCategory() {
        when(mockRepo.assignCategoryToClothing(1, 1)).thenReturn(true);

        boolean result = service.assignCategory(1, 1);

        assertTrue(result);
    }
}



