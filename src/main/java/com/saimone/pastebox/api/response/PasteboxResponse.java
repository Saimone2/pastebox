package com.saimone.pastebox.api.response;

import com.saimone.pastebox.api.request.PasteboxStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasteboxResponse {
    private String data;
    private PasteboxStatus status;
}
