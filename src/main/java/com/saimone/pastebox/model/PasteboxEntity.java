package com.saimone.pastebox.model;

import com.saimone.pastebox.api.request.PasteboxStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PasteboxEntity {
    private long id;
    private String data;
    private String hash;
    private LocalDateTime lifetime;
    private PasteboxStatus pasteboxStatus;
}
