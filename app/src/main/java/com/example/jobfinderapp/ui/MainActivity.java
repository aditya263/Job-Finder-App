package com.example.jobfinderapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.jobfinderapp.R;
import com.example.jobfinderapp.base.BaseActivity;
import com.example.jobfinderapp.base.BaseViewModel;
import com.example.jobfinderapp.data.api.ConnectionServer;
import com.example.jobfinderapp.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>
        implements MainViewModel.Navigator {

    @Inject
    ConnectionServer server;

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewDataBinding();
        viewModel = new ViewModelProvider(this,
                new MainViewModel.ModelFactory(this, server)
        ).get(MainViewModel.class);
    }


}