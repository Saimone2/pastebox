package com.saimone.pastebox.service;

import com.saimone.pastebox.api.request.PasteboxRequest;
import com.saimone.pastebox.api.response.PasteBoxUrlResponse;
import com.saimone.pastebox.api.response.PasteboxResponse;

import java.util.List;

public interface PasteboxService {
    PasteboxResponse getByHash(String hash);
    List<PasteboxResponse> getFirstPublicPasteboxes();
    PasteBoxUrlResponse create(PasteboxRequest pasteBoxRequest);
}
