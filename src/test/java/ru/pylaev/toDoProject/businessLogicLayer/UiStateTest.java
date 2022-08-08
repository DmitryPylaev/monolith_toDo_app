package ru.pylaev.toDoProject.businessLogicLayer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UiStateTest {
    UiState uiState = new UiState();

    @Test
    void checkOwnerIsOk() {
        uiState.manageOwner(("user"));
        assertEquals("user", uiState.getOwner());
    }

    @Test
    void checkOwnerIsRejected() {
        uiState.manageOwner(":");
        assertNull(uiState.getOwner());
    }
}