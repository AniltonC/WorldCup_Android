package com.infosystem.worldcup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "WorldCup.db";

    private static final String SQL_CREATE_TEAMS = "CREATE TABLE tb_teams (" +
            "name TEXT PRIMARY KEY, " +
            "url_icon TEXT NOT NULL, " +
            "group_name VARCHAR(1) NOT NULL)";

    private static final String SQL_POPULATE_TEAMS = "INSERT INTO tb_teams VALUES " +
            "('Brazil', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Brazil.png', 'A'), " +
            "('Mexico', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Mexico.png', 'A'), " +
            "('Croatia', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Croatia.png', 'A'), " +
            "('Cameroon', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Cameroon.png', 'A'), " +
            "('Netherlands', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Netherlands.png', 'B'), " +
            "('Chile', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Chile.png', 'B'), " +
            "('Spain', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Spain.png', 'B'), " +
            "('Australia', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Australia.png', 'B'), " +
            "('Colombia', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Australia.png', 'C'), " +
            "('Greece', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Greece.png', 'C'), " +
            "('Ivory Coast', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Ivory%20Coast.png', 'C'), " +
            "('Japan', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Japan.png', 'C'), " +
            "('Costa Rica', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Costa%20Rica.png', 'D'), " +
            "('Uruguay', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Uruguay.png', 'D'), " +
            "('Italy', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Italy.png', 'D'), " +
            "('England', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/England.png', 'D'), " +
            "('France', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/France.png', 'E'), " +
            "('Switzerland', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Switzerland.png', 'E'), " +
            "('Ecuador', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Ecuador.png', 'E'), " +
            "('Honduras', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Honduras.png', 'E'), " +
            "('Argentina', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Argentina.png', 'F'), " +
            "('Nigeria', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Nigeria.png', 'F'), " +
            "('Bosnia', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Bosnia%20and%20Herzegovina.png', 'F'), " +
            "('Iran', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Iran.png', 'F'), " +
            "('Germany', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Germany.png', 'G'), " +
            "('USA', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/USA.png', 'G'), " +
            "('Portugal', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Portugal.png', 'G'), " +
            "('Ghana', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Ghana.png', 'G'), " +
            "('Belgium', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Belgium.png', 'H'), " +
            "('Algeria', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Algeria.png', 'H'), " +
            "('Russia', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Russia.png', 'H'), " +
            "('South Korea', 'https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/South%20Korea.png', 'H')";

    private final String SQL_CREATE_MATCHES = "CREATE TABLE tb_matches (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "team_name_a TEXT NOT NULL, " +
            "team_name_b TEXT NOT NULL, " +
            "description TEXT NOT NULL, " +
            "stage TEXT NOT NULL, " +
            "stadium TEXT NOT NULL, " +
            "status TEXT, " +
            "goals_a INTEGER, " +
            "desc_goals_a TEXT, " +
            "goals_b INTEGER, " +
            "desc_goals_b TEXT, " +
            "winner VARCHAR(50), " +
            "FOREIGN KEY (team_name_a) REFERENCES tb_teams (name), " +
            "FOREIGN KEY (team_name_b) REFERENCES tb_teams (name), " +
            "FOREIGN KEY (winner) REFERENCES tb_teams (name)" +
            ")";

    private final String SQL_POPULATE_MATCHES = "INSERT INTO tb_matches VALUES " +
            "(NULL, 'Brazil', 'Croatia', '12 JUN - 17:00', 'GROUP A', 'Arena Corinthians', 'Full Time', '3', 'Neymar 29_ 71_(P)|Oscar 91_', '1', 'Marcelo 11_(GC)', 'Brazil'), " +
            "(NULL, 'Mexico', 'Cameroon', '13 JUN - 13:00', 'GROUP A', 'Estádio das Dunas', 'Full Time', '1', 'Peralta 61_', '0', ' ', 'Mexico'), " +
            "(NULL, 'Spain', 'Netherlands', '13 JUN - 16:00', 'GROUP B', 'Arena Fonte Nova', 'Full Time', '1', 'Xabi Alonso 27_(P)', '5', 'Robin Van Persie 44_ 72_|Robben 53_ 80_|Stefan de Vrij 64_', 'Netherlands'), " +
            "(NULL, 'Chile', 'Australia', '13 JUN - 18:00', 'GROUP B', 'Arena Pantanal', 'Full Time', '3', 'Alexis Sánchez 12_|Jorge Valdivia 14_|Jean Beausejour 92_', '1', 'Tim Cahill 35_', 'Chile'), " +
            "(NULL, 'Colombia', 'Greece', '14 JUN - 13:00', 'GROUP C', 'Estádio Mineirão', 'Full Time', '3', 'Armero 5_|Guiérrez 58_|James Rodríguez 93_', '0', ' ', 'Colombia'), " +
            "(NULL, 'Uruguay', 'Costa Rica', '14 JUN - 16:00', 'GROUP C', 'Estádio Castelão', 'Full Time', '1', 'Cavani 24_(P)', '3', 'Joel Campbell 54_|Óscar Duarte 57_|Marco Ureña 84_', 'Costa Rica'), " +
            "(NULL, 'England', 'Italy', '14 JUN - 18:00', 'GROUP D', 'Arena da Amazônia', 'Full Time', '1', 'Daniel Sturridge 37_', '2', 'Claudio Marchisio 35_|Mario Balotelli 50_', 'Italy'), " +
            "(NULL, 'Ivory Coast', 'Japan', '14 JUN - 22:00', 'GROUP D', 'Arena Pernambuco', 'Full Time', '2', 'Wilfried Bony 64_|Gervinho 66_', '1', 'Keisuke Honda 16_', 'Ivory Coast'), " +
            "(NULL, 'Switzerland', 'Ecuador', '15 JUN - 13:00', 'GROUP E', 'Estádio Mané Garrincha', 'Full Time', '2', 'Admir Mehmedi 48_|Haris Serferovic 93_', '1', 'Enner Valencia 22_', 'Switzerland'), " +
            "(NULL, 'France', 'Honduras', '15 JUN - 16:00', 'GROUP E', 'Estádio Beira-Rio', 'Full Time', '3', 'Benzema 45_(P) 72_|Noel Valladares 48_(GC)', '0', ' ', 'France'), " +
            "(NULL, 'Argentina', 'Bosnia', '15 JUN - 19:00', 'GROUP F', 'Maracanã', 'Full Time', '2', 'Sead Kolasinac 3_(GC)|Lionel Messi 65_', '1', 'Vedad Ibisevic 84_', NULL), " +
            "(NULL, 'Germany', 'Portugal', '16 JUN - 13:00', 'GROUP G', 'Arena Fonte Nova', 'Full Time', '4', 'Thomas Muller 12_(P) 45+1_ 78_|Hummels 32_', '0', ' ', NULL), " +
            "(NULL, 'Iran', 'Nigeria', '16 JUN - 16:00', 'GROUP F', 'Arena da Baixada', 'Full Time', '0', ' ', '0', ' ', NULL), " +
            "(NULL, 'Ghana', 'USA', '16 JUN - 19:00', 'GROUP G', 'Estádio das Dunas', 'Full Time', '1', 'André Ayew 82_', '2', 'Dempsey 1_|Jhon Anthony Brooks 86_', NULL), " +
            "(NULL, 'Belgium', 'Algeria', '17 JUN - 13:00', 'GROUP H', 'Estádio Mineirão', 'Full Time', '2', 'Fellaini 70_|Dries Mertens 80_', '1', 'Feghouli 25_(P)', NULL), " +
            "(NULL, 'Russia', 'South Korea', '17 JUN - 18:00', 'GROUP H', 'Arena Pantanal', 'Full Time', '1', 'Aleksander Kerjakov 74_', '1', 'Lee Keun-ho 68_', NULL)";

    private static final String SQL_DELETE_MATCHES = "DROP TABLE IF EXISTS tb_matches";
    private static final String SQL_DELETE_TEAMS = "DROP TABLE IF EXISTS tb_teams";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TEAMS);
        db.execSQL(SQL_CREATE_MATCHES);
        db.execSQL(SQL_POPULATE_TEAMS);
        db.execSQL(SQL_POPULATE_MATCHES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_MATCHES);
        db.execSQL(SQL_DELETE_TEAMS);
        onCreate(db);
    }
}
