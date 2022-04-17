package com.ksharshembie.m3_lesson2_cw;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ksharshembie.m3_lesson2_cw.databinding.FragmentSecondBinding;
import com.ksharshembie.m3_lesson2_cw.databinding.FragmentSixthBinding;

public class SixthFragment extends Fragment {

    private FragmentSixthBinding binding;
    public static final String KEY6 = "key6";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSixthBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.text.setText(getArguments().getString(FifthFragment.KEY5));

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeventhFragment fragment = new SeventhFragment();
                Bundle bundle = new Bundle();
                bundle.putString(KEY6, binding.text.getText().toString());
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack("tag").commit();
            }
        });
    }
}