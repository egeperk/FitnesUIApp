package com.egeperk.fitnesuiapp.fragment;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.egeperk.fitnesuiapp.FitnessMove;
import com.egeperk.fitnesuiapp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class PopupFragment extends Fragment {

    TextView nameText, descriptionText, calorieText;
    ImageView imageView;
    ProgressBar progressBar;

    private FitnessMove fitnessMove;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_popup,container,false);

        nameText = rootView.findViewById(R.id.fragment_popup_name_textview);
        descriptionText = rootView.findViewById(R.id.fragment_popup_description_textview);
        calorieText = rootView.findViewById(R.id.fragment_popup_calorie_textview);
        imageView = rootView.findViewById(R.id.fragment_popup_image_view);
        progressBar = rootView.findViewById(R.id.fragment_popup_progress_bar);

        nameText.setText(fitnessMove.getFitnessName());
        descriptionText.setText(fitnessMove.getFitnessDescription());
        calorieText.setText(""+fitnessMove.getFitnessCalorie());

        Picasso.get().load(fitnessMove.getFitnessPicture()).fit().centerCrop().into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {

            }
        });

        return rootView;
    }

    public static PopupFragment newInstance () {
        return new PopupFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fitnessMove = getActivity().getIntent().getParcelableExtra("INFO");

    }
}
