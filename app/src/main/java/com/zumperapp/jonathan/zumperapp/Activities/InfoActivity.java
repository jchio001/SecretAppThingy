package com.zumperapp.jonathan.zumperapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zumperapp.jonathan.zumperapp.API.APIConstants;
import com.zumperapp.jonathan.zumperapp.API.Models.Details.DetailsBundle;
import com.zumperapp.jonathan.zumperapp.API.Models.Details.Review;
import com.zumperapp.jonathan.zumperapp.API.RetrofitClient;
import com.zumperapp.jonathan.zumperapp.R;
import com.zumperapp.jonathan.zumperapp.ViewHolders.ReviewViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.w3c.dom.Text;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity {
    @Bind(R.id.progress_bar) ProgressBar progressBar;
    @Bind(R.id.name) TextView name;
    @Bind(R.id.address) TextView address;
    @Bind(R.id.phone_number) TextView phoneNumber;
    @Bind(R.id.rating) TextView rating;
    @Bind(R.id.restaurant_img) ImageView imageView;
    @Bind(R.id.scroll_view) ScrollView scrollView;
    @Bind(R.id.reviews_list) LinearLayout reviewsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            RetrofitClient.getDetails(bundle.getString(APIConstants.PLACE_ID));
        } else {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }

        return true;
    }

    @Subscribe
    public void onDetailsResp(DetailsBundle detailsBundle) {
        progressBar.setVisibility(View.GONE);
        name.setText(detailsBundle.getDetailsResults().getName());
        address.setText(detailsBundle.getDetailsResults().getFormattedAddress());
        phoneNumber.setText(detailsBundle.getDetailsResults().getFormattedPhoneNumber());
        rating.setText(String.format(
                "Rating: %.1f",
                detailsBundle.getDetailsResults().getRating()));
        Picasso.with(this).load(
                detailsBundle.getDetailsResults().getPhotos().get(0).generatePhotoUrl())
                .into(imageView);
        loadReviews(detailsBundle.getDetailsResults().getReviews());
        scrollView.setVisibility(View.VISIBLE);
    }

    public void loadReviews(List<Review> reviews) {
        for (Review r : reviews) {
            reviewsList.addView(createReviewView(r));
        }
    }

    public View createReviewView(Review review) {
        View v = LayoutInflater.from(this).inflate(R.layout.layout_review, null);
        // Don't need a reference to the view holder for now. Used view holders since I needed
        // something to hold references to the views temporarily so I can populate them with the
        // values from review
        new ReviewViewHolder(v, review, this);
        return v;
    }
}
