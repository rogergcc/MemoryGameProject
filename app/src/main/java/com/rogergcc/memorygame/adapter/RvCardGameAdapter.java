package com.rogergcc.memorygame.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.rogergcc.memorygame.R;
import com.rogergcc.memorygame.model.CardGame;

import java.util.List;

/**
 * RecyclerView adapter to display a list of location cards on top of the map
 */
public class RvCardGameAdapter extends
        RecyclerView.Adapter<RvCardGameAdapter.ViewHolder> {

    private List<CardGame> listOfLocations;
    private Context context;

    private static ClickListener clickListener;
    private Drawable emojiForCircle = null;
    private Drawable backgroundCircle = null;
    private int upperCardSectionColor = 0;


    public RvCardGameAdapter(List<CardGame> cardGameList,
                             Context context, ClickListener cardClickListener) {
        this.context = context;
        this.listOfLocations = cardGameList;

        this.clickListener = cardClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int singleRvCardToUse = R.layout.rv_item_cardgame;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(singleRvCardToUse, parent, false);
        return new ViewHolder(itemView);

//        View itemView = LayoutInflater.from(parent.getContext()).inflate( R.layout.rv_item_cardgame, parent, false);
//        // work here if you need to control height of your items
//        // keep in mind that parent is RecyclerView in this case
//        int height = parent.getMeasuredHeight() / 3;
//        itemView.setMinimumHeight(height);
//        return new ViewHolder(itemView);

    }

    public interface ClickListener {
        void onItemClick(int position);
    }

    @Override
    public int getItemCount() {
        return listOfLocations.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder card, int position) {

        CardGame locationCard = listOfLocations.get(position);

//        card.nameTextView.setText(locationCard.getFirstName());
//        card.addressTextView.setText(locationCard.getLastName());
//        card.phoneNumTextView.setText(locationCard.getPhoneNumber());

    }


    private void setAlphas(ViewHolder card, float addressAlpha, float hoursHeaderAlpha, float hoursNumAlpha,
                           float phoneHeaderAlpha, float phoneNumAlpha, float milesAbbreviationAlpha) {
//        card.addressTextView.setAlpha(addressAlpha);
//        card.hoursHeaderTextView.setAlpha(hoursHeaderAlpha);
//        card.hoursTextView.setAlpha(hoursNumAlpha);
//        card.phoneHeaderTextView.setAlpha(phoneHeaderAlpha);
//        card.phoneNumTextView.setAlpha(phoneNumAlpha);
//        card.milesAbbreviationTextView.setAlpha(milesAbbreviationAlpha);
    }


    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTextView;
        TextView addressTextView;
        TextView phoneNumTextView;
        TextView hoursTextView;
        TextView distanceNumberTextView;

        CardView cardView;
        ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.rv_cardgames);
//            nameTextView = itemView.findViewById(R.id.location_name_tv);
//            addressTextView = itemView.findViewById(R.id.location_description_tv);
//            phoneNumTextView = itemView.findViewById(R.id.location_phone_num_tv);
//
//            hoursTextView = itemView.findViewById(R.id.location_hours_tv);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(getLayoutPosition());
                }
            });

        }

        @Override
        public void onClick(View view) {
        }
    }
}
