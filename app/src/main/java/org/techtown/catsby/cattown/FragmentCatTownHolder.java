package org.techtown.catsby.cattown;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.techtown.catsby.R;

class FragmentCatTownHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    FragmentCatTownHolder(final Context context, View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);

    }
}

