package nl.devolksbank.android.jokeviewer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity
{

    private static final String EXTRA_JOKE = "EXTRA_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        if (getIntent().hasExtra(EXTRA_JOKE))
        {
            TextView textView = findViewById(R.id.joke_textview);
            textView.setText(getIntent().getStringExtra(EXTRA_JOKE));
        }
    }

}
