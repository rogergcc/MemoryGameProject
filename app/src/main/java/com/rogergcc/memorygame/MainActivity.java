package com.rogergcc.memorygame;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.rogergcc.memorygame.adapter.RvCardGameAdapter;
import com.rogergcc.memorygame.helpers.AutoFitGridLayoutManager;
import com.rogergcc.memorygame.helpers.ColumnQty;
import com.rogergcc.memorygame.helpers.GridSpacing;
import com.rogergcc.memorygame.helpers.ItemOffsetDecoration;
import com.rogergcc.memorygame.model.CardGame;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RvCardGameAdapter.ClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        List<CardGame> cardGames = new ArrayList<>();
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));
        cardGames.add(new CardGame("c","sf"));

        RecyclerView recyclerView = findViewById(R.id.rv_cardgames);

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 200);

        int mNoOfColumns = calculateNoOfColumns(this,160);

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, mNoOfColumns);

        ColumnQty columnQty = new ColumnQty(this, R.layout.rv_item_cardgame);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, columnQty.calculateNoOfColumns());


        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.fab_margin);


//        recyclerView.addItemDecoration(new GridSpacing(columnQty.calculateSpacing()));

        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setLayoutManager(mGridLayoutManager);

        RvCardGameAdapter rvCardGameAdapter = new RvCardGameAdapter(cardGames, this, this);
        rvCardGameAdapter.notifyDataSetChanged();

//        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvCardGameAdapter);
        recyclerView.setHasFixedSize(true);
//        recyclerView.setClipToPadding(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }


    @Override
    public void onItemClick(int position) {

    }
}
