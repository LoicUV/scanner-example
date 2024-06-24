package com.example.app;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.getcapacitor.BridgeActivity;

import com.example.app.databinding.ActivityMainBinding;
import com.example.app.ui.dashboard.CapacitorFragment;
import com.example.app.ui.home.OtherFragment;

public class MainActivity extends BridgeActivity {
    final Fragment fragment1 = new OtherFragment();
    final Fragment capacitorFragment = new CapacitorFragment();
    final FragmentManager fm = getSupportFragmentManager();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.otherContainer, fragment1);
        ft.add(R.id.webContainer, capacitorFragment);

        ft.commit();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.otherContainer.getVisibility() == View.GONE) {
                    resumeOtherMode();
                } else {
                    pauseOtherMode();
                }
            }
        });
    }

    public void startOtherMode() {
        binding.button.setVisibility(View.VISIBLE);
        binding.otherContainer.setVisibility(View.VISIBLE);
    }

    public void resumeOtherMode() {
        binding.otherContainer.setVisibility(View.VISIBLE);
        binding.button.setText("show other");
    }

    public void pauseOtherMode() {
        binding.otherContainer.setVisibility(View.GONE);
        binding.button.setText("back to cap");
    }
}