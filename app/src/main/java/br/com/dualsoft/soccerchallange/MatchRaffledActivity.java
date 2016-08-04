package br.com.dualsoft.soccerchallange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.dualsoft.soccerchallange.models.Match;

public class MatchRaffledActivity extends AppCompatActivity {
    private Match match;
    private TextView homeTeam;
    private TextView awayTeam;
    private TextView homeCoach;
    private TextView awayCoach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_raffled);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        match = (Match)intent.getSerializableExtra("match");

        homeTeam = (TextView) findViewById(R.id.homeTeam);
        awayTeam = (TextView) findViewById(R.id.awayTeamTextView);
        homeCoach = (TextView) findViewById(R.id.homeCoach);
        awayCoach = (TextView) findViewById(R.id.awayCoach);

        homeTeam.setText(match.getHomeTeam().getName());
        awayTeam.setText(match.getAwayTeam().getName());
        homeCoach.setText(match.getHomeCoach().getName());
        awayCoach.setText(match.getAwayCoach().getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.match_raffled, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.setResult(Activity.RESULT_CANCELED);
                this.finish();
                return true;
            case R.id.match_raffled_done:
                this.matchRaffleDone();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void matchRaffleDone() {
        match.save();
        this.setResult(Activity.RESULT_OK);
        this.finish();
    }
}
