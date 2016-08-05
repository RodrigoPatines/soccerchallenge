package br.com.dualsoft.soccerchallange.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.dualsoft.soccerchallange.R;
import br.com.dualsoft.soccerchallange.entities.Match;

/**
 * Created by Rodrigo.Patines on 01/08/2016.
 */
public class MatchListViewAdapter extends BaseAdapter {
    private List<Match> items;
    private LayoutInflater layoutInflater;

    public MatchListViewAdapter(Context context, List<Match> items) {
        this.items = items;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MatchHolder matchHolder;

        if(convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.match_list_item, parent, false);

            matchHolder = new MatchHolder();
            matchHolder.dateTextView = (TextView) convertView.findViewById(R.id.dateTextView);
            matchHolder.statusTextView = (TextView) convertView.findViewById(R.id.statusTextView);
            matchHolder.homeTeamTextView = (TextView) convertView.findViewById(R.id.homeTeamTextView);
            matchHolder.awayTeamTextView = (TextView) convertView.findViewById(R.id.awayTeamTextView);
            matchHolder.homeCoachTextView = (TextView) convertView.findViewById(R.id.homeCoachTextView);
            matchHolder.awayCoachTextView = (TextView) convertView.findViewById(R.id.awayCoachTextView);
            matchHolder.homeScoreTextView = (TextView) convertView.findViewById(R.id.homeScoreTextView);
            matchHolder.awayScoreTextView = (TextView) convertView.findViewById(R.id.awayScoreTextView);

            convertView.setTag(matchHolder);
        }
        else
        {
            matchHolder = (MatchHolder) convertView.getTag();
        }

        Match match = items.get(position);
        if (match.getDate() == null) {
            matchHolder.dateTextView.setText("");
            matchHolder.statusTextView.setText("Em andamento");
            matchHolder.homeScoreTextView.setText("");
            matchHolder.awayScoreTextView.setText("");
        } else {
            matchHolder.dateTextView.setText(match.getDate().toString());
            matchHolder.statusTextView.setText("Finalizada");
            String homeScore = match.getHomeScore().toString();
            if (match.getHomePenaltyScore() != null) {
                homeScore += " (" + match.getHomePenaltyScore().toString() + ")";
            }
            matchHolder.homeScoreTextView.setText(homeScore);
            String awayScore = match.getAwayPenaltyScore().toString();
            if (match.getAwayPenaltyScore() != null) {
                awayScore += " (" + match.getAwayPenaltyScore().toString() + ")";
            }
            matchHolder.awayScoreTextView.setText(awayScore);
        }
        matchHolder.homeTeamTextView.setText(match.getHomeTeam().getName());
        matchHolder.awayTeamTextView.setText(match.getAwayTeam().getName());
        matchHolder.homeCoachTextView.setText(match.getHomeCoach().getName());
        matchHolder.awayCoachTextView.setText(match.getAwayCoach().getName());

        return convertView;
    }

    private static class MatchHolder {
        private TextView dateTextView;
        private TextView statusTextView;
        private TextView homeTeamTextView;
        private TextView awayTeamTextView;
        private TextView homeCoachTextView;
        private TextView awayCoachTextView;
        private TextView homeScoreTextView;
        private TextView awayScoreTextView;
    }
}
