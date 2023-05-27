package com.saimone.pastebox.repository;

import com.saimone.pastebox.api.request.PasteboxStatus;
import com.saimone.pastebox.exception.NotFoundEntityException;
import com.saimone.pastebox.model.PasteboxEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class PasteboxRepositoryMap implements PasteboxRepository{
    private final Map<String, PasteboxEntity> vault = new ConcurrentHashMap<>();
    @Override
    public PasteboxEntity getByHash(String hash) {
        PasteboxEntity pasteboxEntity = vault.get(hash);
        if(pasteboxEntity == null) {
            throw new NotFoundEntityException("Pastebox not found with hash = " + hash);
        }
        return pasteboxEntity;
    }

    @Override
    public List<PasteboxEntity> getListOfPublicAndAlive(int amount) {
        LocalDateTime now = LocalDateTime.now();
        return vault.values().stream()
                .filter(pasteboxEntity -> pasteboxEntity.getPasteboxStatus() == PasteboxStatus.PUBLIC)
                .filter(pasteboxEntity -> pasteboxEntity.getLifetime().isAfter(now))
                .sorted(Comparator.comparing(PasteboxEntity::getId).reversed())
                .limit(amount)
                .collect(Collectors.toList());
    }

    @Override
    public void add(PasteboxEntity pasteboxEntity) {
        vault.put(pasteboxEntity.getHash(), pasteboxEntity);
    }
}
