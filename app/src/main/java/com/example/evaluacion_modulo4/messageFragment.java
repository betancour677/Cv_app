package com.example.evaluacion_modulo4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evaluacion_modulo4.databinding.FragmentMessageBinding;


public class messageFragment extends Fragment {
    private FragmentMessageBinding binding;
    private static final String EMAIL_ADDRESS = "emmanuel.betancour@gmail.com";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMessageBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.enviarcorreobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeEmail();
            }
        });

        return view;
    }

    private void composeEmail() {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {EMAIL_ADDRESS});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del email");
        intent.putExtra(Intent.EXTRA_TEXT, "Hola, me gustaría contactarte...");
        intent.addCategory(Intent.CATEGORY_APP_EMAIL);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
