package com.saimone.pastebox.repository;

import com.saimone.pastebox.model.PasteboxEntity;

import java.util.List;

public interface PasteboxRepository {
    PasteboxEntity geByHash(String hash);
    List<PasteboxEntity> getListOfPublicAndAlive(int amount);
    void add(PasteboxEntity pasteboxEntity);
}
