package com.example.arch.architecturecomponentexample;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arch.architecturecomponentexample.chucknorrisapi.pojo.ChuckJoke;

public class MainActivity extends LifecycleActivity{

    private MainViewModel viewModel;

    private TextView textView;

    private ProgressBar progressBar;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        this.viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        this.viewModel.joke().observe(this, this::updateFields);
        this.viewModel.isLoading().observe(this, this::setLoading);

    }

    private void initViews() {
        this.textView = (TextView) findViewById(R.id.tv);
        this.progressBar = (ProgressBar) findViewById(R.id.pb);
        this.button = (Button) findViewById(R.id.btn);
        this.button.setOnClickListener(v -> {
            if (this.viewModel != null){
                viewModel.generateJoke();
            }
        });
    }

    public void setLoading(Boolean isLoading) {

        SugarUtils.setViewVisibility(this.progressBar, isLoading);
        SugarUtils.setViewVisibility(this.button, !isLoading);
        SugarUtils.setViewVisibility(this.textView, !isLoading);

    }

    public void updateFields(Response<ChuckJoke, String> response) {
        if (response.getValue() == null) {
            SugarUtils.showLongTimeToast(this, response.getError());
        } else {
            this.textView.setText(response.getValue().getJoke());
        }
    }
}