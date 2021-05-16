package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowNeighbourActivity extends AppCompatActivity {
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.nameView)
    TextView nameView;
    @BindView(R.id.listName)
    TextView listName;
    @BindView(R.id.listAdress)
    TextView listAdress;
    @BindView(R.id.listTel)
    TextView listTel;
    @BindView(R.id.listMail)
    TextView listMail;
    @BindView(R.id.contentAbout)
    TextView contentAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_neighbour);
        ButterKnife.bind(this);

        ImageButton back = (ImageButton)findViewById(R.id.backHome);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            Neighbour neighbour = (Neighbour) extras.getSerializable("neighbour");
            String image = neighbour.getAvatarUrl().replace("150","450");
            String facebook = "www.facebook.fr/" +neighbour.getName().toLowerCase();

            Glide.with(imageView.getContext())
                    .load(image)
                    .into(imageView);
            nameView.setText(neighbour.getName());
            listName.setText(neighbour.getName());
            listAdress.setText(neighbour.getAddress());
            listTel.setText(neighbour.getPhoneNumber());
            listMail.setText(facebook);
            contentAbout.setText(neighbour.getAboutMe());

        }


    }

}
