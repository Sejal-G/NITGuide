package com.example.nit_guide;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderContact extends RecyclerView.ViewHolder {

    ImageView img;
    TextView tvHeading,tvSubHeading;

    public ViewHolderContact(@NonNull View itemView) {
        super(itemView);
        img=(ImageView)itemView.findViewById(R.id.img_contact);
        tvHeading=(TextView)itemView.findViewById(R.id.tv_heading);
        tvSubHeading=(TextView)itemView.findViewById(R.id.tv_subheading);

    }
}
