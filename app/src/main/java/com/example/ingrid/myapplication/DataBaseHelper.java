package com.example.ingrid.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.Cursor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by ingrid on 03/11/16.
 Referencia: https://guides.codepath.com/android/Local-Databases-with-SQLiteOpenHelper
 */
public class DataBaseHelper extends SQLiteOpenHelper {
        // Database Info
        private static final String TAG = SQLiteDatabase.class.getSimpleName();
        private static DataBaseHelper mInstance = null;
        private Context mCxt;

        private static final String DATABASE_NAME = "gerTemp";
        private static final int DATABASE_VERSION = 1;

        // Table Names
        private static final String TABLE_USUARIO = "usuario";
        private static final String TABLE_PERIODICO = "periodico";
        private static final String TABLE_UNICO = "unico";
        private static final String TABLE_RECORRENTE = "recorrente";

        // User Table Columns
        private static final String KEY_USER_ID = "id";
        private static final String KEY_LOGIN = "login";
        private static final String KEY_SENHA = "senha";

        // Recorrente Table Columns
        private static final String KEY_RECORRENTE_ID = "id";
        private static final String KEY_RECORRENTE_ANOTACAO = "anotacao";
        private static final String KEY_RECORRENTE_HORA_FINAL = "horaFinal";
        private static final String KEY_RECORRENTE_PROGRESSAO = "progressao";
        private static final String KEY_RECORRENTE_ITENS_FEITOS = "itensFeitos";
        private static final String KEY_RECORRENTE_TOTAL_ITENS = "totalItens";
        private static final String KEY_RECORRENTE_HORAS_DIA = "horasPorDia";
        private static final String KEY_RECORRENTE_DATA_FINAL = "dataFinal";
        private static final String KEY_RECORRENTE_PRIORIDADE = "prioridade";
        private static final String KEY_RECORRENTE_USER_ID_FK = "usuarioID";
        private static final String KEY_RECORRENTE_FALTAS ="faltas";
        private static final String KEY_RECORRENTE_LOCAL = "local";

        //Unico Table Columns
        private static final String KEY_UNICO_ID = "id";
        private static final String KEY_UNICO_ANOTACAO = "anotacao";
        private static final String KEY_UNICO_HORA_FINAL = "horaFinal";
        private static final String KEY_UNICO_HORA_INICIAL = "horaInicial";
        private static final String KEY_UNICO_DATA = "data";
        private static final String KEY_UNICO_LOCAL = "local";
        private static final String KEY_UNICO_PRIORIDADE ="prioridade";
        private static final String KEY_UNICO_USER_ID_FK = "usuarioID";

        //Periodico Table Columns
        private static final String KEY_PERIODICO_ID = "id";
        private static final String KEY_PERIODICO_ANOTACAO = "anotacao";
        private static final String KEY_PERIODICO_HORA_FINAL = "horaFinal";
        private static final String KEY_PERIODICO_HORA_INICIAL = "horaInicial";
        private static final String KEY_PERIODICO_LOCAL = "local";
        private static final String KEY_PERIODICO_PRIORIDADE ="prioridade";
        private static final String KEY_PERIODICO_REPETICAO ="repeticao";
        private static final String KEY_PERIODICO_FREQUENCIA ="frequencia";
        private static final String KEY_PERIODICO_FALTAS ="faltas";
        private static final String KEY_PERIODICO_USER_ID_FK = "usuarioID";


    public static synchronized DataBaseHelper getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new DataBaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mCxt = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USUARIO = "CREATE TABLE " + TABLE_USUARIO +
                "(" +
                KEY_USER_ID + " INTEGER PRIMARY KEY," +
                KEY_LOGIN + " TEXT" +
                KEY_SENHA + "TEXT" +
                ")";
        db.execSQL(CREATE_TABLE_USUARIO);

        String CREATE_TABLE_RECORRENTE = "CREATE TABLE " + TABLE_RECORRENTE +
                "(" +
                KEY_RECORRENTE_ID + " INTEGER PRIMARY KEY," +
                KEY_RECORRENTE_ANOTACAO + " TEXT" +
                KEY_RECORRENTE_HORA_FINAL + "TIMESTAMP" +
                KEY_RECORRENTE_PROGRESSAO + "FLOAT" +
                KEY_RECORRENTE_ITENS_FEITOS + "INTEGER" +
                KEY_RECORRENTE_TOTAL_ITENS + "INTEGER" +
                KEY_RECORRENTE_HORAS_DIA + "INTEGER" +
                KEY_RECORRENTE_DATA_FINAL + "DATE" +
                KEY_RECORRENTE_PRIORIDADE + "INTEGER" +
                KEY_RECORRENTE_USER_ID_FK + "INTEGER REFERENCES" + TABLE_USUARIO + "," +
                KEY_RECORRENTE_FALTAS + "INTEGER" +
                KEY_RECORRENTE_LOCAL + " TEXT" +
                ")";
        db.execSQL(CREATE_TABLE_RECORRENTE);

        String CREATE_TABLE_UNICO = "CREATE TABLE " + TABLE_RECORRENTE +
                "(" +
                KEY_UNICO_ID + " INTEGER PRIMARY KEY," +
                KEY_UNICO_ANOTACAO + " TEXT" +
                KEY_UNICO_HORA_FINAL + "TIMESTAMP" +
                KEY_UNICO_HORA_INICIAL + "TIMESTAMP" +
                KEY_UNICO_DATA  + "DATE" +
                KEY_UNICO_LOCAL + "TEXT" +
                KEY_UNICO_PRIORIDADE + "INTEGER" +
                KEY_UNICO_USER_ID_FK  + "INTEGER REFERENCES" + TABLE_USUARIO + "," +
                ")";
        db.execSQL(CREATE_TABLE_UNICO);

        String CREATE_TABLE_PERIODICO = "CREATE TABLE " + TABLE_RECORRENTE +
                "(" +
                KEY_PERIODICO_ID + " INTEGER PRIMARY KEY," +
                KEY_PERIODICO_ANOTACAO + " TEXT" +
                KEY_PERIODICO_HORA_FINAL  + "TIMESTAMP" +
                KEY_PERIODICO_HORA_INICIAL + "TIMESTAMP" +
                KEY_PERIODICO_REPETICAO  + "INTEGER" +
                KEY_PERIODICO_LOCAL + "TEXT" +
                KEY_PERIODICO_PRIORIDADE + "INTEGER" +
                KEY_PERIODICO_FREQUENCIA + "TEXT" +
                KEY_PERIODICO_FALTAS + "INTEGER" +
                KEY_PERIODICO_USER_ID_FK  + "INTEGER REFERENCES" + TABLE_USUARIO + "," +
                ")";
        db.execSQL(CREATE_TABLE_PERIODICO);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UNICO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERIODICO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECORRENTE);
        onCreate(db);
    }

    // Inserir atividade recorrente
    public void addUsuario(Usuario usuario) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            long userId = addOrUpdateUser(Usuario.user);

            ContentValues values = new ContentValues(); //valores que não são PK
            values.put(KEY_LOGIN, usuario.login);
            values.put(KEY_SENHA , usuario.senha);

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_USUARIO, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }

    //Inserir evento na tabela Recorrente
    public void addRecorrente(Recorrente recorrente) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            long userId = addOrUpdateUser(recorrente.userID );

            ContentValues values = new ContentValues(); //valores que não são PK
            values.put(KEY_RECORRENTE_ANOTACAO, recorrente.anotacao);
            values.put(KEY_RECORRENTE_HORA_FINAL, recorrente.horaFinal);
            values.put(KEY_RECORRENTE_PROGRESSAO, recorrente.progressao);
            values.put(KEY_RECORRENTE_ITENS_FEITOS, recorrente.itensFeitos);
            values.put(KEY_RECORRENTE_TOTAL_ITENS, recorrente.totalItens);
            values.put(KEY_RECORRENTE_HORAS_DIA, recorrente.horasDia);
            values.put(KEY_RECORRENTE_DATA_FINAL, recorrente.dataFinal);
            values.put(KEY_RECORRENTE_PRIORIDADE, recorrente.prioridade);
            values.put(KEY_RECORRENTE_FALTAS, recorrente.faltas);
            values.put(KEY_RECORRENTE_LOCAL, recorrente.local);
            values.put(KEY_RECORRENTE_USER_ID_FK, userId);
            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_USUARIO, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }


    //Inserir evento na tabela Unico
    public void addUnico(Unico unico) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            long userId = addOrUpdateUser(unico.userID );

            ContentValues values = new ContentValues(); //valores que não são PK
            values.put(KEY_UNICO_ANOTACAO, unico.anotacao);
            values.put(KEY_UNICO_HORA_FINAL,unico.horaFinal);
            values.put(KEY_UNICO_HORA_INICIAL, unico.horaInicial);
            values.put(KEY_UNICO_DATA, unico.data);
            values.put(KEY_UNICO_LOCAL, unico.local);
            values.put(KEY_UNICO_PRIORIDADE, unico.prioridade);
            values.put(KEY_RECORRENTE_USER_ID_FK, userId);

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_USUARIO, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }





    //Inserir evento na tabela Periodico
    public void addPeriodico(Periodico periodico) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            long userId = addOrUpdateUser(periodico.userID );

            ContentValues values = new ContentValues(); //valores que não são PK
            values.put(KEY_PERIODICO_ANOTACAO, periodico.anotacao);
            values.put(KEY_PERIODICO_HORA_FINAL,periodico.horaFinal);
            values.put(KEY_PERIODICO_HORA_INICIAL, periodico.horaInicial);
            values.put(KEY_PERIODICO_LOCAL, periodico.local);
            values.put(KEY_PERIODICO_PRIORIDADE, periodico.prioridade);
            values.put(KEY_PERIODICO_REPETICAO, periodico.repeticao);
            values.put(KEY_PERIODICO_FREQUENCIA, periodico.frequencia);
            values.put(KEY_PERIODICO_FALTAS, periodico.faltas);
            values.put(KEY_RECORRENTE_USER_ID_FK, userId);

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_USUARIO, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }



    // Insert or update a user in the database
    // Since SQLite doesn't support "upsert" we need to fall back on an attempt to UPDATE (in case the
    // user already exists) optionally followed by an INSERT (in case the user does not already exist).
    // Unfortunately, there is a bug with the insertOnConflict method
    // (https://code.google.com/p/android/issues/detail?id=13045) so we need to fall back to the more
    // verbose option of querying for the user's primary key if we did an update.
    public long addOrUpdateUser(Usuario user) {
        // The database connection is cached so it's not expensive to call getWriteableDatabase() multiple times.
        SQLiteDatabase db = getWritableDatabase();
        long userId = -1;

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_LOGIN, user.login);
            values.put(KEY_SENHA, user.senha);

            // First try to update the user in case the user already exists in the database
            // This assumes userNames are unique
            int rows = db.update(TABLE_USUARIO, values, KEY_LOGIN + "= ?", new String[]{user.login});

            // Check if update succeeded
            if (rows == 1) {
                // Get the primary key of the user we just updated
                String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                        KEY_USER_ID, TABLE_USUARIO, KEY_LOGIN);
                Cursor cursor = db.rawQuery(usersSelectQuery, new String[]{String.valueOf(user.login)});
                try {
                    if (cursor.moveToFirst()) {
                        userId = cursor.getInt(0);
                        db.setTransactionSuccessful();
                    }
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            } else {
                // user with this userName did not already exist, so insert new user
                userId = db.insertOrThrow(TABLE_USUARIO, null, values);
                db.setTransactionSuccessful();
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add or update user");
        } finally {
            db.endTransaction();
        }
        return userId;
    }

    // Pega todos os compromissiso recorrentes
    public List<Recorrente> getAllRecorrente() {
        List<Recorrente> recorrentes = new ArrayList<>();

        // SELECT * FROM POSTS
        // LEFT OUTER JOIN USERS
        // ON POSTS.KEY_POST_USER_ID_FK = USERS.KEY_USER_ID
        String RECORRENTE_SELECT_QUERY =
                String.format("SELECT * FROM %s LEFT OUTER JOIN %s ON %s.%s = %s.%s",
                        TABLE_RECORRENTE,
                        TABLE_USUARIO,
                        TABLE_RECORRENTE, KEY_RECORRENTE_USER_ID_FK,
                        TABLE_USUARIO, KEY_USER_ID);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(RECORRENTE_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Usuario newUser = new Usuario();
                    newUser.login = cursor.getString(cursor.getColumnIndex(KEY_LOGIN));
                    newUser.senha = cursor.getString(cursor.getColumnIndex(KEY_SENHA));

                    Recorrente newRecorrente = new Recorrente();
                    newRecorrente.anotacao = cursor.getString(cursor.getColumnIndex(KEY_RECORRENTE_ANOTACAO));
                    newRecorrente.local = cursor.getString(cursor.getColumnIndex(KEY_RECORRENTE_LOCAL));
                    newRecorrente.horaFinal = cursor.getString(cursor.getColumnIndex(KEY_RECORRENTE_HORA_FINAL));
                    newRecorrente.progressao = cursor.getFloat(KEY_RECORRENTE_PROGRESSAO);
                    newRecorrente.totalItens = cursor.getInt (cursor.getColumnIndex(KEY_RECORRENTE_TOTAL_ITENS));
                    newRecorrente.itensFeitos = cursor.getInt (cursor.getColumnIndex(KEY_RECORRENTE_ITENS_FEITOS));
                    newRecorrente.horasDia = cursor.getInt (cursor.getColumnIndex(KEY_RECORRENTE_HORAS_DIA));
                    newRecorrente.prioridade = cursor.getInt (cursor.getColumnIndex(KEY_RECORRENTE_PRIORIDADE));
                    newRecorrente.faltas = cursor.getInt (cursor.getColumnIndex(KEY_RECORRENTE_FALTAS);
                    newRecorrente.dataFinal= cursor.getInt (cursor.getColumnIndex(KEY_RECORRENTE_DATA_FINAL));
                    newRecorrente.userID = newUser;
                    recorrentes.add(newRecorrente);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return recorrentes;
    }
    // Pega todos os compromissos unicos
    public List<Unico> getAllUnico() {
        List<Unico> unicos = new ArrayList<>();

        // SELECT * FROM POSTS
        // LEFT OUTER JOIN USERS
        // ON POSTS.KEY_POST_USER_ID_FK = USERS.KEY_USER_ID
        String UNICOS_SELECT_QUERY =
                String.format("SELECT * FROM %s LEFT OUTER JOIN %s ON %s.%s = %s.%s",
                        TABLE_UNICO,
                        TABLE_USUARIO,
                        TABLE_UNICO, KEY_UNICO_USER_ID_FK,
                        TABLE_USUARIO, KEY_USER_ID);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(UNICOS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Usuario newUser = new Usuario();
                    newUser.login = cursor.getString(cursor.getColumnIndex(KEY_LOGIN));
                    newUser.senha = cursor.getString(cursor.getColumnIndex(KEY_SENHA));

                    Unico newUnico = new Unico();
                    newUnico.anotacao = cursor.getString(cursor.getColumnIndex(KEY_UNICO_ANOTACAO));
                    newUnico.local = cursor.getString(cursor.getColumnIndex(KEY_UNICO_LOCAL));
                    newUnico.horaFinal = cursor.getString(cursor.getColumnIndex(KEY_UNICO_HORA_FINAL));
                    newUnico.horaInicial = cursor.getString(cursor.getColumnIndex(KEY_UNICO_HORA_INICIAL));
                    newUnico.prioridade = cursor.getInt (cursor.getColumnIndex(KEY_UNICO_PRIORIDADE));
                    newUnico.data= cursor.getInt (cursor.getColumnIndex(KEY_UNICO_DATA));
                    newUnico.userID = newUser;
                    unicos.add(newUnico);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return unicos;
    }


    // Pega todos os compromissiso periodicos
    public List<Periodico> getAllPeriodico() {
        List<Periodico> periodicos = new ArrayList<>();

        // SELECT * FROM POSTS
        // LEFT OUTER JOIN USERS
        // ON POSTS.KEY_POST_USER_ID_FK = USERS.KEY_USER_ID
        String PERIODICOS_SELECT_QUERY =
                String.format("SELECT * FROM %s LEFT OUTER JOIN %s ON %s.%s = %s.%s",
                        TABLE_PERIODICO,
                        TABLE_USUARIO,
                        TABLE_PERIODICO, KEY_PERIODICO_USER_ID_FK,
                        TABLE_USUARIO, KEY_USER_ID);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(PERIODICOS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Usuario newUser = new Usuario();
                    newUser.login = cursor.getString(cursor.getColumnIndex(KEY_LOGIN));
                    newUser.senha = cursor.getString(cursor.getColumnIndex(KEY_SENHA));

                    Periodico newPeriodico = new Unico();
                    newPeriodico.anotacao = cursor.getString(cursor.getColumnIndex(KEY_PERIODICO_ANOTACAO));
                    newPeriodico.local = cursor.getString(cursor.getColumnIndex(KEY_PERIODICO_LOCAL));
                    newPeriodico.horaFinal = cursor.getString(cursor.getColumnIndex(KEY_PERIODICO_HORA_FINAL));
                    newPeriodico.horaInicial = cursor.getString(cursor.getColumnIndex(KEY_PERIODICO_HORA_INICIAL));
                    newPeriodico.prioridade = cursor.getInt (cursor.getColumnIndex(KEY_PERIODICO_PRIORIDADE));
                    newPeriodico.repeticao= cursor.getInt (cursor.getColumnIndex(KEY_PERIODICO_REPETICAO));
                    newPeriodico.frequencia= cursor.getString (cursor.getColumnIndex(KEY_PERIODICO_FREQUENCIA));
                    newPeriodico.faltas= cursor.getInt (cursor.getColumnIndex(KEY_PERIODICO_FALTAS));
                    newPeriodico.userID = newUser;
                    periodicos.add(newPeriodico);

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return periodicos;
    }
/*

    // Update the user's profile picture url
    public int updateUserProfilePicture(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_PROFILE_PICTURE_URL, user.profilePictureUrl);

        // Updating profile picture url for user with that userName
        return db.update(TABLE_USERS, values, KEY_USER_NAME + " = ?",
                new String[] { String.valueOf(user.userName) });
    }

    // Delete all posts and users in the database
    public void deleteAllPostsAndUsers() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            // Order of deletions is important when foreign key relationships exist.
            db.delete(TABLE_POSTS, null, null);
            db.delete(TABLE_USERS, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to delete all posts and users");
        } finally {
            db.endTransaction();
        }
    }
}
*/
}