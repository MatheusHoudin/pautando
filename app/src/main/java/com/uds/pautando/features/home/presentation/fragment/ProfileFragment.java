package com.uds.pautando.features.home.presentation.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uds.pautando.R;
import com.uds.pautando.features.sign_in.data.model.SignInUser;
import com.uds.pautando.features.sign_in.presentation.viewmodel.CurrentUserViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        final TextView userName = view.findViewById(R.id.user_name_profile);
        final TextView email = view.findViewById(R.id.user_email_profile);

        CurrentUserViewModel currentUserViewModel = new CurrentUserViewModel();
        currentUserViewModel.init();

        currentUserViewModel.getUserMutableLiveData().observe(getActivity(), new Observer<SignInUser>() {
            @Override
            public void onChanged(SignInUser signInUser) {
                userName.setText("Olá, "+signInUser.getName());
                email.setText(signInUser.getEmail());
            }
        });
        return view;
    }
}