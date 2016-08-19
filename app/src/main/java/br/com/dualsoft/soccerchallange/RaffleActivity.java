package br.com.dualsoft.soccerchallange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.dualsoft.soccerchallange.db.Data;
import br.com.dualsoft.soccerchallange.models.Association;
import br.com.dualsoft.soccerchallange.models.Coach;
import br.com.dualsoft.soccerchallange.models.Country;
import br.com.dualsoft.soccerchallange.models.Match;
import br.com.dualsoft.soccerchallange.models.Raffle;
import br.com.dualsoft.soccerchallange.models.Team;
import joquery.CQ;
import joquery.Filter;
import joquery.core.QueryException;

public class RaffleActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private RaffleActivity self;
    private CoordinatorLayout coordinatorLayout;
    private Raffle raffle;

    private RadioButton clubTeam;
    private RadioButton nationalTeam;
    private Spinner countrySpinner;
    private Spinner associationSpinner;
    private Spinner homeCoachSpinner;
    private Spinner awayCoachSpinner;
    private Button invertCoachButton;

    private ArrayAdapter<ListItem> countryAdapter;
    private ArrayAdapter<ListItem> associationAdapter;
    private ArrayAdapter<ListItem> coachAdapter;

    private List<Association> associations;
    private List<Country> countries;
    private List<Team> teams;
    private List<Coach> coaches;

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
        self = this;

        this.showProgressDialog();

        Data.getDb().child("raffle")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue() == null)
                            raffle = new Raffle();
                        else
                            raffle = dataSnapshot.getValue(Raffle.class);

                        //Create clubTeam/nationalTeam
                        clubTeam = (RadioButton)findViewById(R.id.clubTeam);
                        clubTeam.setOnClickListener(self);
                        nationalTeam = (RadioButton)findViewById(R.id.nationalTeam);
                        nationalTeam.setOnClickListener(self);
                        if (raffle.getNational() == 0)
                            clubTeam.setChecked(true);
                        else
                            nationalTeam.setChecked(true);

                        self.loadCountries();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        self.hideProgressDialog();
                        Toast.makeText(self, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void loadCountries() {
        Data.getDb()
                .child("countries")
                .orderByChild("name")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Create countrySpinner
                        countryAdapter = new ArrayAdapter<>(self, android.R.layout.simple_spinner_item);
                        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        countryAdapter.add(new ListItem("", "Todos"));
                        self.countries = Data.getCountries(dataSnapshot);
                        for (Country country : countries) {
                            countryAdapter.add(new ListItem(country.getKey(), country.getName(), country));
                        }
                        countrySpinner = (Spinner)findViewById(R.id.countrySpinner);
                        countrySpinner.setOnItemSelectedListener(self);
                        countrySpinner.setAdapter(countryAdapter);
                        Helper.selectSpinnerItemById(countrySpinner, raffle.getCountry().getKey());

                        self.loadAssociations();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        self.hideProgressDialog();
                        Toast.makeText(self, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void loadAssociations() {
        Data.getDb()
                .child("associations")
                .orderByChild("initials")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Create associationSpinner
                        associationAdapter = new ArrayAdapter<>(self, android.R.layout.simple_spinner_item);
                        associationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        associationAdapter.add(new ListItem("", "Todas"));
                        self.associations = Data.getAssociations(dataSnapshot);
                        for (Association association : associations) {
                            associationAdapter.add(new ListItem(association.getKey(), association.getInitials()));
                        }
                        associationSpinner = (Spinner)findViewById(R.id.associationSpinner);
                        associationSpinner.setOnItemSelectedListener(self);
                        associationSpinner.setAdapter(associationAdapter);
                        Helper.selectSpinnerItemById(associationSpinner, raffle.getAssociation().getKey());

                        self.loadCoaches();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        self.hideProgressDialog();
                        Toast.makeText(self, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void loadCoaches() {
        Data.getDb()
                .child("coaches")
                .orderByChild("name")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Create homeCoachSpinner/awayCoachSpinner
                        coachAdapter = new ArrayAdapter<>(self, android.R.layout.simple_spinner_item);
                        coachAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        coachAdapter.add(new ListItem("", "Sorteio"));
                        self.coaches = Data.getCoaches(dataSnapshot);
                        for (Coach coach : coaches) {
                            coachAdapter.add(new ListItem(coach.getKey(), coach.getName(), coach));
                        }
                        homeCoachSpinner = (Spinner)findViewById(R.id.homeCoachSpinner);
                        homeCoachSpinner.setOnItemSelectedListener(self);
                        homeCoachSpinner.setAdapter(coachAdapter);
                        Helper.selectSpinnerItemById(homeCoachSpinner, raffle.getHomeCoach().getKey());
                        awayCoachSpinner = (Spinner)findViewById(R.id.awayCoachSpinner);
                        awayCoachSpinner.setOnItemSelectedListener(self);
                        awayCoachSpinner.setAdapter(coachAdapter);
                        Helper.selectSpinnerItemById(awayCoachSpinner, raffle.getAwayCoach().getKey());

                        invertCoachButton = (Button) findViewById(R.id.invertCoachButton);
                        invertCoachButton.setOnClickListener(self);

                        self.loadTeams();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        self.hideProgressDialog();
                        Toast.makeText(self, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void loadTeams() {
        Data.getDb()
                .child("teams")
                .orderByChild("name")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        self.teams = Data.getTeams(dataSnapshot);
                        self.hideProgressDialog();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        self.hideProgressDialog();
                        Toast.makeText(self, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
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
                raffle.setCountry((Country) listItem.getObject());
                break;
            case R.id.associationSpinner:
                raffle.setAssociation((Association) listItem.getObject());
                break;
            case R.id.homeCoachSpinner:
                raffle.setHomeCoach((Coach) listItem.getObject());
                break;
            case R.id.awayCoachSpinner:
                raffle.setAwayCoach((Coach) listItem.getObject());
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

    /*
        if (raffle.getAssociation().getKey() == "" && raffle.getCountry().getKey() == "") {
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
        }*/
    }

    private void invertCoach() {
        int position = homeCoachSpinner.getSelectedItemPosition();
        homeCoachSpinner.setSelection(awayCoachSpinner.getSelectedItemPosition());
        awayCoachSpinner.setSelection(position);
    }
}
