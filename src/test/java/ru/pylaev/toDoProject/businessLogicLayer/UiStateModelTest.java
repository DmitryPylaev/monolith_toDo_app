package ru.pylaev.toDoProject.businessLogicLayer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UiStateModelTest {
    UiStateModel uiStateModel = new UiStateModel();

    @Test
    void checkOwnerIsOk() {
        uiStateModel.manageOwner(("user"));
        assertEquals("user", uiStateModel.getOwner());
    }

    @Test
    void checkOwnerIsRejected() {
        uiStateModel.manageOwner(":");
        assertNull(uiStateModel.getOwner());
    }
}