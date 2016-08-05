package br.com.dualsoft.soccerchallange;

import android.content.res.Configuration;

import com.orm.SugarApp;
import com.orm.SugarContext;

import br.com.dualsoft.soccerchallange.entities.Association;
import br.com.dualsoft.soccerchallange.entities.Coach;
import br.com.dualsoft.soccerchallange.entities.Country;
import br.com.dualsoft.soccerchallange.entities.Team;

/**
 * Created by Rodrigo.Patines on 24/07/2016.
 */
public class SugarApplication extends SugarApp {
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());
        this.initialLoad();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private void initialLoad() {
        if (Association.count(Association.class) > 0)
            return;
        Association association = new Association("Confederação Sul-Americana de Futebol", "CONMEBOL");
        association.save();
        Country country = new Country("Brasil", "BRA", association);
        country.save();
        (new Team("Brasil", "BRA", 5.0f, 1, country)).save();
        (new Team("Atlético Paranaense", "APR", 3.5f, 0, country)).save();
        (new Team("Atlético Mineiro", "ATL", 4.0f, 0, country)).save();
        (new Team("Avaí", "AVA", 3.0f, 0, country)).save();
        (new Team("Chapecoense", "CHA", 3.5f, 0, country)).save();
        (new Team("Coritiba", "COR", 3.0f, 0, country)).save();
        (new Team("Cruzeiro", "CRU", 4.0f, 0, country)).save();
        (new Team("Figueirense", "FIG", 3.5f, 0, country)).save();
        (new Team("Fluminense", "FLU", 3.5f, 0, country)).save();
        (new Team("Grêmio ", "GRE", 3.5f, 0, country)).save();
        (new Team("Internacional", "INT", 4.0f, 0, country)).save();
        (new Team("Joinville ", "JEC", 3.0f, 0, country)).save();
        (new Team("Palmeiras ", "PAL", 4.0f, 0, country)).save();
        (new Team("Ponte Preta", "PON", 3.0f, 0, country)).save();
        (new Team("Santos", "SAN", 3.5f, 0, country)).save();
        (new Team("São Paulo", "SAO", 4.0f, 0, country)).save();
        (new Team("Vasco da Gama", "VAS", 3.0f, 0, country)).save();
        (new Coach("Rodrigo Patines de Medeiros", "Rodrigo", country)).save();
        (new Coach("Rafael da Silva Medeiros", "Rafael", country)).save();

        country = new Country("Argentina", "ARG", association);
        country.save();
        (new Team("Argentina", "ARG", 5.0f, 1, country)).save();
        (new Team("Boca Juniors", "BOC", 4.0f, 0, country)).save();
        (new Team("Estudiantes", "EST", 3.5f, 0, country)).save();
        (new Team("Independiente", "IND", 3.5f, 0, country)).save();
        (new Team("Lanús", "LAN", 3.5f, 0, country)).save();
        (new Team("Newell’s", "NEW", 3.5f, 0, country)).save();
        (new Team("Racing Club", "RAC", 3.5f, 0, country)).save();
        (new Team("River Plate", "RIV", 4.0f, 0, country)).save();
        (new Team("Rosario Central", "ROS", 3.5f, 0, country)).save();
        (new Team("San Lorenzo", "SAN", 3.5f, 0, country)).save();

        country = new Country("Chile", "CHI", association);
        country.save();
        (new Team("Chile", "CHI", 4.0f, 1, country)).save();
        (new Team("Colo-Colo", "COL", 3.5f, 0, country)).save();
        (new Team("Uni. de Chile", "BOC", 3.5f, 0, country)).save();

        country = new Country("Colômbia", "COL", association);
        country.save();
        (new Team("Colômbia", "COL", 4.5f, 1, country)).save();
        (new Team("Atl. Nacional", "NAC", 3.5f, 0, country)).save();
        (new Team("Indep. Medellín", "IME", 3.5f, 0, country)).save();

        country = new Country("México", "MEX", association);
        country.save();
        (new Team("México", "MEX", 4.0f, 1, country)).save();
        (new Team("América", "AME", 3.5f, 0, country)).save();
        (new Team("Cruz Azul", "CRA", 3.5f, 0, country)).save();
        (new Team("Guadalajara", "GUA", 3.0f, 0, country)).save();
        (new Team("Monterrey", "MON", 3.5f, 0, country)).save();
        (new Team("Pachuca", "PAC", 3.5f, 0, country)).save();
        (new Team("Tigres", "TIG", 3.5f, 0, country)).save();
        (new Team("Toluca", "TOL", 3.5f, 0, country)).save();

        country = new Country("Equador", "ECU", association);
        country.save();
        (new Team("Equador", "ECU", 3.5f, 1, country)).save();

        country = new Country("Paraguai", "PAR", association);
        country.save();
        (new Team("Paraguai", "PAR", 3.5f, 1, country)).save();

        country = new Country("Peru", "PER", association);
        country.save();
        (new Team("Peru", "PER", 3.5f, 1, country)).save();

        country = new Country("Uruguai", "URU", association);
        country.save();
        (new Team("Uruguai", "URU", 4.5f, 1, country)).save();

        association = new Association("União das Federações Europeias de Futebol", "UEFA");
        association.save();
        country = new Country("Inglaterra", "GBR", association);
        country.save();
        (new Team("Inglaterra", "GBR", 5.0f, 1, country)).save();
        (new Team("Arsenal", "ARS", 5.0f, 0, country)).save();
        (new Team("Aston Villa", "AST", 4.0f, 0, country)).save();
        (new Team("Chelsea", "CHE", 5.0f, 0, country)).save();
        (new Team("Everton", "EVE", 4.5f, 0, country)).save();
        (new Team("Leicester City", "LEI", 4.0f, 0, country)).save();
        (new Team("Liverpool", "LIV", 4.5f, 0, country)).save();
        (new Team("Manchester City", "MAC", 5.0f, 0, country)).save();
        (new Team("Manchester United", "MAU", 5.0f, 0, country)).save();
        (new Team("Newcastle United", "NCU", 4.0f, 0, country)).save();
        (new Team("Spurs", "SPU", 4.5f, 0, country)).save();
        (new Team("West Ham", "WES", 4.0f, 0, country)).save();

        country = new Country("França", "FRA", association);
        country.save();
        (new Team("França", "FRA", 5.0f, 1, country)).save();
        (new Team("AS Monaco", "MON", 4.5f, 0, country)).save();
        (new Team("AS Saint-Étienne", "SAE", 4.0f, 0, country)).save();
        (new Team("Giron. Bordeaux", "BOR", 4.0f, 0, country)).save();
        (new Team("LOSC Lille", "LIL", 4.0f, 0, country)).save();
        (new Team("Olympique Lyonnais", "LYO", 4.5f, 0, country)).save();
        (new Team("Olympique Marseille", "MAR", 4.0f, 0, country)).save();
        (new Team("Paris Saint-Germain", "PSG", 5.0f, 0, country)).save();

        country = new Country("Alemanha", "GER", association);
        country.save();
        (new Team("Alemanha", "GER", 5.0f, 1, country)).save();
        (new Team("1899 Hoffenheim", "HOF", 4.0f, 0, country)).save();
        (new Team("Bayer 04", "BA4", 4.5f, 0, country)).save();
        (new Team("Bor. Dortmund", "BOR", 5.0f, 0, country)).save();
        (new Team("Bor. M’gladbach", "BMG", 4.5f, 0, country)).save();
        (new Team("FC Bayern", "BAY", 5.0f, 0, country)).save();
        (new Team("FC Schalke 04", "SCH", 4.5f, 0, country)).save();
        (new Team("VfL Wolfsburg", "WOL", 4.5f, 0, country)).save();

        country = new Country("Itália", "ITA", association);
        country.save();
        (new Team("Itália", "ITA", 5.0f, 1, country)).save();
        (new Team("Fiorentina", "FIO", 4.5f, 0, country)).save();
        (new Team("Inter", "INT", 4.5f, 0, country)).save();
        (new Team("Juventus", "JUV", 5.0f, 0, country)).save();
        (new Team("Lazio", "LAZ", 4.5f, 0, country)).save();
        (new Team("Milan", "MIL", 4.5f, 0, country)).save();
        (new Team("Napoli", "NAP", 4.5f, 0, country)).save();
        (new Team("Roma", "ROM", 4.5f, 0, country)).save();

        country = new Country("Holanda", "NED", association);
        country.save();
        (new Team("Holanda", "NED", 5.0f, 1, country)).save();
        (new Team("Ajax", "AJX", 4.0f, 0, country)).save();
        (new Team("Feyenoord", "FEY", 4.0f, 0, country)).save();
        (new Team("PSV", "PSV", 4.0f, 0, country)).save();

        country = new Country("Portugal", "POR", association);
        country.save();
        (new Team("Portugal", "POR", 5.0f, 1, country)).save();
        (new Team("FC Porto", "POR", 4.5f, 0, country)).save();
        (new Team("SL Benfica", "BEN", 4.5f, 0, country)).save();
        (new Team("Sporting", "", 4.5f, 0, country)).save();

        country = new Country("Rússia", "RUS", association);
        country.save();
        (new Team("Rússia", "RUS", 4.5f, 1, country)).save();
        (new Team("CSKA Moskva", "CSK", 4.5f, 0, country)).save();
        (new Team("Dinamo Moscow", "DIN", 4.0f, 0, country)).save();
        (new Team("Lokomotiv Moscow", "LOK", 4.0f, 0, country)).save();
        (new Team("Rubin Kazan", "RUB", 3.5f, 0, country)).save();
        (new Team("Spartak Moscow", "SPA", 4.0f, 0, country)).save();
        (new Team("Zenit", "ZEN", 4.5f, 0, country)).save();

        country = new Country("Escócia", "ESC", association);
        country.save();
        (new Team("Celtic", "CEL", 3.5f, 0, country)).save();

        country = new Country("Espanha", "ESP", association);
        country.save();
        (new Team("Espanha", "ESP", 5.0f, 1, country)).save();
        (new Team("Athletic Bilbao", "ABI", 4.5f, 0, country)).save();
        (new Team("Atlético Madrid", "AMA", 5.0f, 0, country)).save();
        (new Team("FC Barcelona", "", 5.0f, 0, country)).save();
        (new Team("Real Madrid", "RMD", 5.0f, 0, country)).save();
        (new Team("Sevilla FC", "SEV", 4.5f, 0, country)).save();
        (new Team("Valencia CF", "VAL", 4.5f, 0, country)).save();
        (new Team("Villarreal CF", "VIL", 3.5f, 0, country)).save();

        country = new Country("Turquia", "TUR", association);
        country.save();
        (new Team("Turquia", "TUR", 5.0f, 1, country)).save();
        (new Team("Besiktas", "BES", 4.5f, 0, country)).save();
        (new Team("Fenerbahçe", "FEN", 4.5f, 0, country)).save();
        (new Team("Galatasaray", "GAL", 4.5f, 0, country)).save();

        country = new Country("Bélgica", "BEL", association);
        country.save();
        (new Team("Bélgica", "BEL", 5.0f, 1, country)).save();

        country = new Country("República Tcheca", "CZE", association);
        country.save();
        (new Team("República Tcheca", "CZE", 3.5f, 1, country)).save();

        country = new Country("Dinamarca", "DEN", association);
        country.save();
        (new Team("Dinamarca", "DEN", 4.0f, 1, country)).save();

        country = new Country("Grécia", "GRE", association);
        country.save();
        (new Team("Grécia", "GRE", 4.0f, 1, country)).save();

        country = new Country("Polônia", "POL", association);
        country.save();
        (new Team("Polônia", "POL", 4.0f, 1, country)).save();

        country = new Country("Suécia", "SWE", association);
        country.save();
        (new Team("Suécia", "SWE", 4.0f, 1, country)).save();

        country = new Country("Suíça", "SUI", association);
        country.save();
        (new Team("Suíça", "SUI", 4.5f, 1, country)).save();

        country = new Country("País de Gales", "GAL", association);
        country.save();
        (new Team("País de Gales", "GAL", 4.0f, 1, country)).save();

        association = new Association("Confederação Africana de Futebol", "CAF");
        association.save();
        country = new Country("Camarões", "CMR", association);
        country.save();
        (new Team("Camarões", "CMR", 4.0f, 1, country)).save();

        country = new Country("África do Sul", "RSA", association);
        country.save();
        (new Team("África do Sul", "RSA", 3.5f, 1, country)).save();

        association = new Association("Confederação Asiática de Futebol", "AFC");
        association.save();
        country = new Country("China", "CHN", association);
        country.save();
        (new Team("China", "CHN", 3.5f, 1, country)).save();

        association = new Association("Confederação de Futebol da América do Norte, Central e Caribe", "CONCACAF");
        association.save();
        country = new Country("Estados Unidos", "USA", association);
        country.save();
        (new Team("Estados Unidos", "USA", 4.0f, 1, country)).save();
    }
}
