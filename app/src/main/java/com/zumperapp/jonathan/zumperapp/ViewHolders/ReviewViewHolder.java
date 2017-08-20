package com.zumperapp.jonathan.zumperapp.ViewHolders;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconTextView;
import com.zumperapp.jonathan.zumperapp.API.Models.Details.Review;
import com.zumperapp.jonathan.zumperapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

// Handles populating an instance of layout_review with a passed in Review object
public class ReviewViewHolder {
    @Bind(R.id.reviewer_name) TextView reviewerName;
    @Bind({R.id.star1, R.id.star2,
            R.id.star3, R.id.star4,
            R.id.star5}) IconTextView[] stars;
    @Bind(R.id.review_body) TextView reviewBody;
    @Bind(R.id.time) TextView time;

    public ReviewViewHolder(View v, Review r, Context context) {
        ButterKnife.bind(this, v);
        reviewerName.setText(r.getAuthorName());
        colorStars(r.getRating(), context);
        reviewBody.setText(r.getText());
        time.setText(r.getRelativeTimeDescription());
    }

    public void colorStars(int rating, Context context) {
        for (int i = 0; i < rating; ++i) {
            stars[i].setTextColor(ContextCompat.getColor(context, R.color.dandelion));
        }

        for (int j = rating; j < 5; ++j) {
            stars[j].setTextColor(ContextCompat.getColor(context, R.color.grey));
        }
    }
}
