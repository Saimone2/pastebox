package com.saimone.pastebox.controller;

import com.saimone.pastebox.api.request.PasteboxRequest;
import com.saimone.pastebox.api.response.PasteBoxUrlResponse;
import com.saimone.pastebox.api.response.PasteboxResponse;
import com.saimone.pastebox.service.PasteboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PasteboxController {

    private final PasteboxService service;

    @GetMapping("/")
    public List<PasteboxResponse> getPublicPasteList() {
        return service.getFirstPublicPasteboxes();
    }

    @GetMapping("/{hash}")
    public PasteboxResponse getByHash(@PathVariable String hash) {
        return service.getByHash(hash);
    }

    @PostMapping("/")
    public PasteBoxUrlResponse add(@RequestBody PasteboxRequest request) {
        return service.create(request);
    }
}
