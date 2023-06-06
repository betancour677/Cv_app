package com.example.evaluacion_modulo4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.evaluacion_modulo4.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            messageFragment messageFragment = new messageFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragmentContainerView,messageFragment );
            transaction.commit();
        }

        binding.button2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });

        binding.button5.setOnClickListener(view -> {
            String phoneNumber = "56978273934";  // Número de teléfono de WhatsApp

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" ));
            startActivity(intent);

            binding.button4.setOnClickListener(view1 -> {
                String linkedinProfileUrl = "https://www.linkedin.com/in/emmanuel-betancour-escobar-7535a367/"; // URL de LinkedIn

                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(linkedinProfileUrl));
                startActivity(intent);
            });
        });



        }
    }
