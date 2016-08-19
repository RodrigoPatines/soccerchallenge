package br.com.dualsoft.soccerchallange.models;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rodrigo.Patines on 06/08/2016.
 */
public class LoadDB {
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public void initialize() {
        //*** CONMEBOL ***//
        String keyConmebol = writeAssociation("Confederação Sul-Americana de Futebol", "CONMEBOL");
        //-- BRA --//
        String keyBra = writeCountry("Brasil", "BRA", keyConmebol);
        writeTeam("Brasil", "BRA", 5.0f, 1, keyBra, keyConmebol);
        writeTeam("Atlético Paranaense", "APR", 3.5f, 0, keyBra, keyConmebol);
        writeTeam("Atlético Mineiro", "ATL", 4.0f, 0, keyBra, keyConmebol);
        writeTeam("Avaí", "AVA", 3.0f, 0, keyBra, keyConmebol);
        writeTeam("Chapecoense", "CHA", 3.5f, 0, keyBra, keyConmebol);
        writeTeam("Coritiba", "COR", 3.0f, 0, keyBra, keyConmebol);
        writeTeam("Cruzeiro", "CRU", 4.0f, 0, keyBra, keyConmebol);
        writeTeam("Figueirense", "FIG", 3.5f, 0, keyBra, keyConmebol);
        writeTeam("Fluminense", "FLU", 3.5f, 0, keyBra, keyConmebol);
        writeTeam("Grêmio ", "GRE", 3.5f, 0, keyBra, keyConmebol);
        writeTeam("Internacional", "INT", 4.0f, 0, keyBra, keyConmebol);
        writeTeam("Joinville ", "JEC", 3.0f, 0, keyBra, keyConmebol);
        writeTeam("Palmeiras ", "PAL", 4.0f, 0, keyBra, keyConmebol);
        writeTeam("Ponte Preta", "PON", 3.0f, 0, keyBra, keyConmebol);
        writeTeam("Santos", "SAN", 3.5f, 0, keyBra, keyConmebol);
        writeTeam("São Paulo", "SAO", 4.0f, 0, keyBra, keyConmebol);
        writeTeam("Vasco da Gama", "VAS", 3.0f, 0, keyBra, keyConmebol);
        writeCoach("Rodrigo Patines de Medeiros", "Rodrigo", keyBra, keyConmebol);
        writeCoach("Rafael da Silva Medeiros", "Rafael", keyBra, keyConmebol);
        //-- ARG --//
        String keyArg = writeCountry("Argentina", "ARG", keyConmebol);
        writeTeam("Argentina", "ARG", 5.0f, 1, keyArg, keyConmebol);
        writeTeam("Boca Juniors", "BOC", 4.0f, 0, keyArg, keyConmebol);
        writeTeam("Estudiantes", "EST", 3.5f, 0, keyArg, keyConmebol);
        writeTeam("Independiente", "IND", 3.5f, 0, keyArg, keyConmebol);
        writeTeam("Lanús", "LAN", 3.5f, 0, keyArg, keyConmebol);
        writeTeam("Newell’s", "NEW", 3.5f, 0, keyArg, keyConmebol);
        writeTeam("Racing Club", "RAC", 3.5f, 0, keyArg, keyConmebol);
        writeTeam("River Plate", "RIV", 4.0f, 0, keyArg, keyConmebol);
        writeTeam("Rosario Central", "ROS", 3.5f, 0, keyArg, keyConmebol);
        writeTeam("San Lorenzo", "SAN", 3.5f, 0, keyArg, keyConmebol);
        //-- CHI --//
        String keyChi = writeCountry("Chile", "CHI", keyConmebol);
        writeTeam("Chile", "CHI", 4.0f, 1, keyChi, keyConmebol);
        writeTeam("Colo-Colo", "COL", 3.5f, 0, keyChi, keyConmebol);
        writeTeam("Uni. de Chile", "BOC", 3.5f, 0, keyChi, keyConmebol);
        //-- COL --//
        String keyCol = writeCountry("Colômbia", "COL", keyConmebol);
        writeTeam("Colômbia", "COL", 4.5f, 1, keyCol, keyConmebol);
        writeTeam("Atl. Nacional", "NAC", 3.5f, 0, keyCol, keyConmebol);
        writeTeam("Indep. Medellín", "IME", 3.5f, 0, keyCol, keyConmebol);
        //-- MEX --//
        String keyMex = writeCountry("México", "MEX", keyConmebol);
        writeTeam("México", "MEX", 4.0f, 1, keyMex, keyConmebol);
        writeTeam("América", "AME", 3.5f, 0, keyMex, keyConmebol);
        writeTeam("Cruz Azul", "CRA", 3.5f, 0, keyMex, keyConmebol);
        writeTeam("Guadalajara", "GUA", 3.0f, 0, keyMex, keyConmebol);
        writeTeam("Monterrey", "MON", 3.5f, 0, keyMex, keyConmebol);
        writeTeam("Pachuca", "PAC", 3.5f, 0, keyMex, keyConmebol);
        writeTeam("Tigres", "TIG", 3.5f, 0, keyMex, keyConmebol);
        writeTeam("Toluca", "TOL", 3.5f, 0, keyMex, keyConmebol);
        //-- ECU --//
        String keyEcu = writeCountry("Equador", "ECU", keyConmebol);
        writeTeam("Equador", "ECU", 3.5f, 1, keyEcu, keyConmebol);
        //-- PAR --//
        String keyPar = writeCountry("Paraguai", "PAR", keyConmebol);
        writeTeam("Paraguai", "PAR", 3.5f, 1, keyPar, keyConmebol);
        //-- PER --//
        String keyPer = writeCountry("Peru", "PER", keyConmebol);
        writeTeam("Peru", "PER", 3.5f, 1, keyPer, keyConmebol);
        //-- URU --//
        String keyUru = writeCountry("Uruguai", "URU", keyConmebol);
        writeTeam("Uruguai", "URU", 4.5f, 1, keyUru, keyConmebol);

        //*** UEFA ***//
        String keyUefa = writeAssociation("União das Federações Europeias de Futebol", "UEFA");
        //-- GBR --//
        String keyGbr = writeCountry("Inglaterra", "GBR", keyUefa);
        writeTeam("Inglaterra", "GBR", 5.0f, 1, keyGbr, keyUefa);
        writeTeam("Arsenal", "ARS", 5.0f, 0, keyGbr, keyUefa);
        writeTeam("Aston Villa", "AST", 4.0f, 0, keyGbr, keyUefa);
        writeTeam("Chelsea", "CHE", 5.0f, 0, keyGbr, keyUefa);
        writeTeam("Everton", "EVE", 4.5f, 0, keyGbr, keyUefa);
        writeTeam("Leicester City", "LEI", 4.0f, 0, keyGbr, keyUefa);
        writeTeam("Liverpool", "LIV", 4.5f, 0, keyGbr, keyUefa);
        writeTeam("Manchester City", "MAC", 5.0f, 0, keyGbr, keyUefa);
        writeTeam("Manchester United", "MAU", 5.0f, 0, keyGbr, keyUefa);
        writeTeam("Newcastle United", "NCU", 4.0f, 0, keyGbr, keyUefa);
        writeTeam("Spurs", "SPU", 4.5f, 0, keyGbr, keyUefa);
        writeTeam("West Ham", "WES", 4.0f, 0, keyGbr, keyUefa);
        //-- FRA --//
        String keyFra = writeCountry("França", "FRA", keyUefa);
        writeTeam("França", "FRA", 5.0f, 1, keyFra, keyUefa);
        writeTeam("AS Monaco", "MON", 4.5f, 0, keyFra, keyUefa);
        writeTeam("AS Saint-Étienne", "SAE", 4.0f, 0, keyFra, keyUefa);
        writeTeam("Giron. Bordeaux", "BOR", 4.0f, 0, keyFra, keyUefa);
        writeTeam("LOSC Lille", "LIL", 4.0f, 0, keyFra, keyUefa);
        writeTeam("Olympique Lyonnais", "LYO", 4.5f, 0, keyFra, keyUefa);
        writeTeam("Olympique Marseille", "MAR", 4.0f, 0, keyFra, keyUefa);
        writeTeam("Paris Saint-Germain", "PSG", 5.0f, 0, keyFra, keyUefa);
        //-- GER --//
        String keyGer = writeCountry("Alemanha", "GER", keyUefa);
        writeTeam("Alemanha", "GER", 5.0f, 1, keyGer, keyUefa);
        writeTeam("1899 Hoffenheim", "HOF", 4.0f, 0, keyGer, keyUefa);
        writeTeam("Bayer 04", "BA4", 4.5f, 0, keyGer, keyUefa);
        writeTeam("Bor. Dortmund", "BOR", 5.0f, 0, keyGer, keyUefa);
        writeTeam("Bor. M’gladbach", "BMG", 4.5f, 0, keyGer, keyUefa);
        writeTeam("FC Bayern", "BAY", 5.0f, 0, keyGer, keyUefa);
        writeTeam("FC Schalke 04", "SCH", 4.5f, 0, keyGer, keyUefa);
        writeTeam("VfL Wolfsburg", "WOL", 4.5f, 0, keyGer, keyUefa);
        //-- ITA --//
        String keyIta = writeCountry("Itália", "ITA", keyUefa);
        writeTeam("Itália", "ITA", 5.0f, 1, keyIta, keyUefa);
        writeTeam("Fiorentina", "FIO", 4.5f, 0, keyIta, keyUefa);
        writeTeam("Inter", "INT", 4.5f, 0, keyIta, keyUefa);
        writeTeam("Juventus", "JUV", 5.0f, 0, keyIta, keyUefa);
        writeTeam("Lazio", "LAZ", 4.5f, 0, keyIta, keyUefa);
        writeTeam("Milan", "MIL", 4.5f, 0, keyIta, keyUefa);
        writeTeam("Napoli", "NAP", 4.5f, 0, keyIta, keyUefa);
        writeTeam("Roma", "ROM", 4.5f, 0, keyIta, keyUefa);
        //-- NED --//
        String keyNed = writeCountry("Holanda", "NED", keyUefa);
        writeTeam("Holanda", "NED", 5.0f, 1, keyNed, keyUefa);
        writeTeam("Ajax", "AJX", 4.0f, 0, keyNed, keyUefa);
        writeTeam("Feyenoord", "FEY", 4.0f, 0, keyNed, keyUefa);
        writeTeam("PSV", "PSV", 4.0f, 0, keyNed, keyUefa);
        //-- POR --//
        String keyPor = writeCountry("Portugal", "POR", keyUefa);
        writeTeam("Portugal", "POR", 5.0f, 1, keyPor, keyUefa);
        writeTeam("FC Porto", "POR", 4.5f, 0, keyPor, keyUefa);
        writeTeam("SL Benfica", "BEN", 4.5f, 0, keyPor, keyUefa);
        writeTeam("Sporting", "", 4.5f, 0, keyPor, keyUefa);
        //-- RUS --//
        String keyRus = writeCountry("Rússia", "RUS", keyUefa);
        writeTeam("Rússia", "RUS", 4.5f, 1, keyRus, keyUefa);
        writeTeam("CSKA Moskva", "CSK", 4.5f, 0, keyRus, keyUefa);
        writeTeam("Dinamo Moscow", "DIN", 4.0f, 0, keyRus, keyUefa);
        writeTeam("Lokomotiv Moscow", "LOK", 4.0f, 0, keyRus, keyUefa);
        writeTeam("Rubin Kazan", "RUB", 3.5f, 0, keyRus, keyUefa);
        writeTeam("Spartak Moscow", "SPA", 4.0f, 0, keyRus, keyUefa);
        writeTeam("Zenit", "ZEN", 4.5f, 0, keyRus, keyUefa);
        //-- ESC --//
        String keyEsc = writeCountry("Escócia", "ESC", keyUefa);
        writeTeam("Celtic", "CEL", 3.5f, 0, keyEsc, keyUefa);
        //-- ESP --//
        String keyEsp = writeCountry("Espanha", "ESP", keyUefa);
        writeTeam("Espanha", "ESP", 5.0f, 1, keyEsp, keyUefa);
        writeTeam("Athletic Bilbao", "ABI", 4.5f, 0, keyEsp, keyUefa);
        writeTeam("Atlético Madrid", "AMA", 5.0f, 0, keyEsp, keyUefa);
        writeTeam("FC Barcelona", "", 5.0f, 0, keyEsp, keyUefa);
        writeTeam("Real Madrid", "RMD", 5.0f, 0, keyEsp, keyUefa);
        writeTeam("Sevilla FC", "SEV", 4.5f, 0, keyEsp, keyUefa);
        writeTeam("Valencia CF", "VAL", 4.5f, 0, keyEsp, keyUefa);
        writeTeam("Villarreal CF", "VIL", 3.5f, 0, keyEsp, keyUefa);
        //-- TUR --//
        String keyTur = writeCountry("Turquia", "TUR", keyUefa);
        writeTeam("Turquia", "TUR", 5.0f, 1, keyTur, keyUefa);
        writeTeam("Besiktas", "BES", 4.5f, 0, keyTur, keyUefa);
        writeTeam("Fenerbahçe", "FEN", 4.5f, 0, keyTur, keyUefa);
        writeTeam("Galatasaray", "GAL", 4.5f, 0, keyTur, keyUefa);
        //-- BEL --//
        String keyBel = writeCountry("Bélgica", "BEL", keyUefa);
        writeTeam("Bélgica", "BEL", 5.0f, 1, keyBel, keyUefa);
        //-- CZE --//
        String keyCze = writeCountry("República Tcheca", "CZE", keyUefa);
        writeTeam("República Tcheca", "CZE", 3.5f, 1, keyCze, keyUefa);
        //-- DEN --//
        String keyDen = writeCountry("Dinamarca", "DEN", keyUefa);
        writeTeam("Dinamarca", "DEN", 4.0f, 1, keyDen, keyUefa);
        //-- GRE --//
        String keyGre = writeCountry("Grécia", "GRE", keyUefa);
        writeTeam("Grécia", "GRE", 4.0f, 1, keyGre, keyUefa);
        //-- POL --//
        String keyPol = writeCountry("Polônia", "POL", keyUefa);
        writeTeam("Polônia", "POL", 4.0f, 1, keyPol, keyUefa);
        //-- SWE --//
        String keySwe = writeCountry("Suécia", "SWE", keyUefa);
        writeTeam("Suécia", "SWE", 4.0f, 1, keySwe, keyUefa);
        //-- SUI --//
        String keySui = writeCountry("Suíça", "SUI", keyUefa);
        writeTeam("Suíça", "SUI", 4.5f, 1, keySui, keyUefa);
        //-- GAL --//
        String keyGal = writeCountry("País de Gales", "GAL", keyUefa);
        writeTeam("País de Gales", "GAL", 4.0f, 1, keyGal, keyUefa);

        //*** CAF ***//
        String keyCaf = writeAssociation("Confederação Africana de Futebol", "CAF");
        //-- CMR --//
        String keyCmr = writeCountry("Camarões", "CMR", keyCaf);
        writeTeam("Camarões", "CMR", 4.0f, 1, keyCmr, keyCaf);
        //-- RSA --//
        String keyRsa = writeCountry("África do Sul", "RSA", keyCaf);
        writeTeam("África do Sul", "RSA", 3.5f, 1, keyRsa, keyCaf);

        //*** AFC ***//
        String keyAfc = writeAssociation("Confederação Asiática de Futebol", "AFC");
        //-- CHN --//
        String keyChn = writeCountry("China", "CHN", keyAfc);
        writeTeam("China", "CHN", 3.5f, 1, keyChn, keyAfc);

        //*** CONCACAF ***//
        String keyConcacaf = writeAssociation("Confederação de Futebol da América do Norte, Central e Caribe", "CONCACAF");
        //-- USA --//
        String keyUsa = writeCountry("Estados Unidos", "USA", keyConcacaf);
        writeTeam("Estados Unidos", "USA", 4.0f, 1, keyUsa, keyConcacaf);
    }

    public String writeAssociation(String name, String initials) {
        Association association = new Association(name, initials);
        String key = database.child("associations").push().getKey();
        database.child("associations/" + key).setValue(association);
        return key;
    }

    public String writeCountry(String name, String abbreviation, String associationKey) {
        Country country = new Country(name, abbreviation);
        String key = database.child("countries").push().getKey();
        database.child("countries/" + key).setValue(country);
        database.child("associations/" + associationKey + "/countries/" + key).setValue(country);
        return key;
    }

    public String writeTeam(String name, String abbreviation, Float starRating, Integer national, String countryKey, String associationKey) {
        Team team = new Team(name, abbreviation, starRating, national, countryKey);
        String key = database.child("teams").push().getKey();
        database.child("teams/" + key).setValue(team);

        Map<String, Object> data = new HashMap<>();
        data.put("countries/" + countryKey + "/teams/" + key, true);
        data.put("associations/" + associationKey + "/countries/" + countryKey + "/teams/" + key, true);
        database.updateChildren(data);

        return key;
    }

    public String writeCoach(String name, String nickname, String countryKey, String associationKey) {
        Coach coach = new Coach(name, nickname, countryKey);
        String key = database.child("coaches").push().getKey();
        database.child("coaches/" + key).setValue(coach);

        Map<String, Object> data = new HashMap<>();
        data.put("countries/" + countryKey + "/coaches/" + key, true);
        data.put("associations/" + associationKey + "/countries/" + countryKey + "/coaches/" + key, true);
        database.updateChildren(data);

        return key;
    }
}
