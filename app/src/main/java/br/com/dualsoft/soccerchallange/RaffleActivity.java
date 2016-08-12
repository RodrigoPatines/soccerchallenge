package br.com.dualsoft.soccerchallange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.orm.query.Select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import br.com.dualsoft.soccerchallange.entities.Association;
import br.com.dualsoft.soccerchallange.entities.Coach;
import br.com.dualsoft.soccerchallange.entities.Country;
import br.com.dualsoft.soccerchallange.entities.Match;
import br.com.dualsoft.soccerchallange.entities.Raffle;
import br.com.dualsoft.soccerchallange.entities.Team;

public class RaffleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private DatabaseReference database;
    private CoordinatorLayout coordinatorLayout;
    private Raffle raffle;
    private RadioButton clubTeam;
    private RadioButton nationalTeam;
    private Spinner countrySpinner;
    private ArrayAdapter<ListItem> countryAdapter;
    private Spinner associationSpinner;
    private ArrayAdapter<ListItem> associationAdapter;
    private Spinner homeCoachSpinner;
    private Spinner awayCoachSpinner;
    private ArrayAdapter<ListItem> coachAdapter;
    private Button invertCoachButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raffle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        database = FirebaseDatabase.getInstance().getReference();
        Query query = database.child("associations");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<Map<String, br.com.dualsoft.soccerchallange.models.Association>> mapType = new GenericTypeIndicator<Map<String, br.com.dualsoft.soccerchallange.models.Association>>() { };
                Map<String, br.com.dualsoft.soccerchallange.models.Association> map = dataSnapshot.getValue(mapType);
                List<br.com.dualsoft.soccerchallange.models.Association> a = new ArrayList<br.com.dualsoft.soccerchallange.models.Association>(map.values());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        raffle = Raffle.first(Raffle.class);
        if (raffle == null)
            raffle = new Raffle(0, 0l, 0l, 0l, 0l);

        //Create clubTeam/nationalTeam
        clubTeam = (RadioButton)findViewById(R.id.clubTeam);
        clubTeam.setOnClickListener(this);
        nationalTeam = (RadioButton)findViewById(R.id.nationalTeam);
        nationalTeam.setOnClickListener(this);

        if (raffle.getNational() == 0)
            clubTeam.setChecked(true);
        else
            nationalTeam.setChecked(true);

        //Create countrySpinner
        countryAdapter = new ArrayAdapter<ListItem>(this, android.R.layout.simple_spinner_item);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryAdapter.add(new ListItem(0l, "Todos"));
        List<Country> countries = Select.from(Country.class).orderBy("NAME").list();
        for (Country country : countries) {
            countryAdapter.add(new ListItem(country.getId(), country.getName()));
        }
        countrySpinner = (Spinner)findViewById(R.id.countrySpinner);
        countrySpinner.setOnItemSelectedListener(this);
        countrySpinner.setAdapter(countryAdapter);
        Helper.selectSpinnerItemById(countrySpinner, raffle.getCountryId());

        //Create associationSpinner
        associationAdapter = new ArrayAdapter<ListItem>(this, android.R.layout.simple_spinner_item);
        associationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        associationAdapter.add(new ListItem(0l, "Todas"));
        List<Association> associations = Select.from(Association.class).orderBy("INITIALS").list();
        for (Association association : associations) {
            associationAdapter.add(new ListItem(association.getId(), association.getInitials()));
        }
        associationSpinner = (Spinner)findViewById(R.id.associationSpinner);
        associationSpinner.setOnItemSelectedListener(this);
        associationSpinner.setAdapter(associationAdapter);
        Helper.selectSpinnerItemById(associationSpinner, raffle.getAssociationId());

        //Create homeCoachSpinner/awayCoachSpinner
        coachAdapter = new ArrayAdapter<ListItem>(this, android.R.layout.simple_spinner_item);
        coachAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coachAdapter.add(new ListItem(0l, "Sorteio"));
        List<Coach> coaches = Select.from(Coach.class).orderBy("NAME").list();
        for (Coach coach : coaches) {
            coachAdapter.add(new ListItem(coach.getId(), coach.getName()));
        }
        homeCoachSpinner = (Spinner)findViewById(R.id.homeCoachSpinner);
        homeCoachSpinner.setOnItemSelectedListener(this);
        homeCoachSpinner.setAdapter(coachAdapter);
        Helper.selectSpinnerItemById(homeCoachSpinner, raffle.getHomeCoachId());
        awayCoachSpinner = (Spinner)findViewById(R.id.awayCoachSpinner);
        awayCoachSpinner.setOnItemSelectedListener(this);
        awayCoachSpinner.setAdapter(coachAdapter);
        Helper.selectSpinnerItemById(awayCoachSpinner, raffle.getAwayCoachId());

        invertCoachButton = (Button) findViewById(R.id.invertCoachButton);
        invertCoachButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.raffle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.raffle_done:
                this.raffleDone();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clubTeam:
                raffle.setNational(0);
                break;
            case R.id.nationalTeam:
                raffle.setNational(1);
                break;
            case R.id.invertCoachButton:
                this.invertCoach();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ListItem listItem = (ListItem)parent.getItemAtPosition(position);
        switch (parent.getId()) {
            case R.id.countrySpinner:
                raffle.setCountryId(listItem.getId());
                break;
            case R.id.associationSpinner:
                raffle.setAssociationId(listItem.getId());
                break;
            case R.id.homeCoachSpinner:
                raffle.setHomeCoachId(listItem.getId());
                break;
            case R.id.awayCoachSpinner:
                raffle.setAwayCoachId(listItem.getId());
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Helper.ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            this.finish();
        }
    }

    public void raffleDone() {
        Match match = new Match();
        List<Team> teams = new ArrayList();

        if (raffle.getAssociationId() == 0 && raffle.getCountryId() == 0) {
            List<Team> teamsFound = Team.find(Team.class, "NATIONAL = ?", raffle.getNational().toString());
            teams.addAll(teamsFound);
        } else if (raffle.getCountryId() > 0) {
            List<Team> teamsFound = Team.find(Team.class, "COUNTRY = ?", raffle.getCountryId().toString());
            teams.addAll(teamsFound);
        } else if (raffle.getAssociationId() > 0) {
            List<Country> countries = Country.find(Country.class, "ASSOCIATION = ?", raffle.getAssociationId().toString());
            for (Country country: countries) {
                teams.addAll(country.getTeams());
            }
        }

        for(int location = (teams.size() - 1); location > 0; location--) {
            if (teams.get(location).getNational() != raffle.getNational()){
                teams.remove(location);
            }
        }

        List<Coach> coaches = Coach.listAll(Coach.class);
        if (raffle.getHomeCoachId() > 0 && raffle.getAwayCoachId() == 0) {
            for(Coach coach: coaches){
                if (coach.getId() == raffle.getHomeCoachId()) {
                    coaches.remove(coach);
                    match.setHomeCoach(coach);
                    break;
                }
            }
            int location = Helper.getRandom(0, coaches.size() - 1);
            match.setAwayCoach(coaches.get(location));

        } else if (raffle.getHomeCoachId() == 0 && raffle.getAwayCoachId() > 0) {
            for(Coach coach: coaches){
                if (coach.getId() == raffle.getAwayCoachId()) {
                    coaches.remove(coach);
                    match.setAwayCoach(coach);
                    break;
                }
            }
            int location = Helper.getRandom(0, coaches.size() - 1);
            match.setHomeCoach(coaches.get(location));
        } else if (raffle.getHomeCoachId() > 0 && raffle.getAwayCoachId() > 0) {
            for(Coach coach: coaches) {
                if (coach.getId() == raffle.getHomeCoachId()) {
                    match.setHomeCoach(coach);
                }
                if (coach.getId() == raffle.getAwayCoachId()) {
                    match.setAwayCoach(coach);
                }
            }
        } else {
            int location = Helper.getRandom(0, coaches.size() - 1);
            Coach homeCoach = coaches.get(location);
            match.setHomeCoach(homeCoach);
            for(Coach coach: coaches){
                if (coach.getId() == homeCoach.getId()) {
                    coaches.remove(coach);
                    break;
                }
            }
            location = Helper.getRandom(0, coaches.size() - 1);
            match.setAwayCoach(coaches.get(location));
        }

        if (teams.size() > 1) {
            int location = Helper.getRandom(0, teams.size() - 1);
            Team homeTeam = teams.get(location);
            match.setHomeTeam(homeTeam);
            for(Team team: teams){
                if (team.getId() == homeTeam.getId()) {
                    teams.remove(team);
                    break;
                }
            }
            location = Helper.getRandom(0, teams.size() - 1);
            match.setAwayTeam(teams.get(location));

            raffle.save();

            Intent intent = new Intent(this, MatchRaffledActivity.class);
            intent.putExtra("match", match);
            startActivityForResult(intent, Helper.ACTIVITY_REQUEST_CODE);
        } else {
            Snackbar.make(coordinatorLayout, "Configuração sem times para sorteio!", Snackbar.LENGTH_LONG).show();
            return;
        }
    }

    private void invertCoach() {
        int position = homeCoachSpinner.getSelectedItemPosition();
        homeCoachSpinner.setSelection(awayCoachSpinner.getSelectedItemPosition());
        awayCoachSpinner.setSelection(position);
    }
}
