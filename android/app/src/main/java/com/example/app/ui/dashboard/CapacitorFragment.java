package com.example.app.ui.dashboard;

import android.os.Bundle;

import com.getcapacitor.BridgeFragment;

import io.capawesome.capacitorjs.plugins.mlkit.barcodescanning.BarcodeScannerPlugin;
import com.example.app.UIControlPlugin;

public class CapacitorFragment extends BridgeFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPlugin(UIControlPlugin.class);
        addPlugin(BarcodeScannerPlugin.class);
    }

    protected void load(Bundle savedInstanceState) {
        super.load(savedInstanceState);
    }

}