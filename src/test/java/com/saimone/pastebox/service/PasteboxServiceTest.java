package com.saimone.pastebox.service;

import com.saimone.pastebox.api.request.PasteboxStatus;
import com.saimone.pastebox.api.response.PasteboxResponse;
import com.saimone.pastebox.exception.NotFoundEntityException;
import com.saimone.pastebox.model.PasteboxEntity;
import com.saimone.pastebox.repository.PasteboxRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PasteboxServiceTest {
    @Autowired
    private PasteboxService pasteboxService;

    @MockBean
    private PasteboxRepository pasteboxRepository;

    @Test
    public void notExistHash() {
        when(pasteboxRepository.getByHash(anyString())).thenThrow(NotFoundEntityException.class);
        assertThrows(NotFoundEntityException.class, () -> pasteboxService.getByHash(""));
        assertThrows(NotFoundEntityException.class, () -> pasteboxService.getByHash(" "));
        assertThrows(NotFoundEntityException.class, () -> pasteboxService.getByHash("fsddhhdfdhdf"));
    }

    @Test
    public void getExistHash() {
        PasteboxEntity pasteboxEntity = new PasteboxEntity();
        pasteboxEntity.setHash("1");
        pasteboxEntity.setData("11");
        pasteboxEntity.setPasteboxStatus(PasteboxStatus.PUBLIC);

        when(pasteboxRepository.getByHash("1")).thenReturn(pasteboxEntity);

        PasteboxResponse expected = new PasteboxResponse("11", PasteboxStatus.PUBLIC);
        PasteboxResponse actual = pasteboxService.getByHash("1");

        assertEquals(expected, actual);
    }
}
