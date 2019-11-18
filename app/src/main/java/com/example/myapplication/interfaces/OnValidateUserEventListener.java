package com.example.myapplication.interfaces;

import com.example.myapplication.core.web.entities.MaterialResult;

public interface OnValidateUserEventListener {
    void onValidateRequestSuccess(MaterialResult[] result);
    void onValidateRequestFail(String error);
}
