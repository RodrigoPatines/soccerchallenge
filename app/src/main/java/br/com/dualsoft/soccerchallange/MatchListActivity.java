package br.com.dualsoft.soccerchallange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.orm.query.Select;

import java.util.List;

import br.com.dualsoft.soccerchallange.adapters.MatchListViewAdapter;
import br.com.dualsoft.soccerchallange.entities.Match;

public class MatchListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Match> matches = Select.from(Match.class).orderBy("DATE").list();
        MatchListViewAdapter matchListViewAdapter = new MatchListViewAdapter(this, matches);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(matchListViewAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Match match = (Match)parent.getItemAtPosition(position);
        MatchListViewAdapter matchListViewAdapter = (MatchListViewAdapter)parent.getAdapter();

    }
}
