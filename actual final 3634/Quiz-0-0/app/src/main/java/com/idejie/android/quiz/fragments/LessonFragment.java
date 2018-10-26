package com.idejie.android.quiz.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.idejie.android.quiz.DetailActivity;
import com.idejie.android.quiz.R;
import com.idejie.android.quiz.adapters.LessonAdapter;
import com.idejie.android.quiz.models.Lesson;

import java.util.ArrayList;
import java.util.List;


public class LessonFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private RecyclerView recyclerView ;
    private LessonAdapter adapter;

    public LessonFragment() {
    }


    @SuppressWarnings("unused")
    public static LessonFragment newInstance(int columnCount) {
        LessonFragment fragment = new LessonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson, container, false);
        recyclerView = view.findViewById(R.id.lessons_list);
        List<Lesson> lessons = getLessons();
        adapter = new LessonAdapter(getActivity(), lessons, new LessonAdapter.OnItemClickCallback<Lesson>() {
            @Override
            public void onClick(View view, Lesson info) {
                Log.d("#Quiz","####"+info.lesson_name);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("title",info.lesson_name);
                bundle.putString("content",info.lesson_content);
                intent.putExtras(bundle);
                intent.setClass(getActivity(),DetailActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL));
        return view;
    }

    public static List<Lesson> getLessons() {
        List<Lesson> rets=new ArrayList<>();
        Lesson lesson1 = new Lesson(0,
                "Content Providers: Introduction",
                "https://www.tutorialspoint.com/android/images/content1.jpg",
                "What is a Content Provider and why do we use them?\n" +
                        "\n" +
                        "Content providers act as a layer between the DataBase and the activity\n" +
                        "\n" +
                        "•Content Providers serve as a good abstraction layer between the data source and UI code. They can add data validation and modify how data is stored whilst the UI code remains unaffected.\n" +
                        "\n" +
                        "Content Providers manage a shared set of app data. We can store the data in the file system, an SQLite database, on the web, or any other persistent storage location our app can access.\n " +
                        "\n" +
                        "Through the content provider, other apps can query or even modify the data. \n" +
                        "\n" +
                        "For example, the Android system provides a content provider that manages the user's contact information. As such, any app with the proper permissions can query part of the content provider (such as ContactsContract.Data) to read and write information about a particular person.\n" +
                        "\n" +
                        "Content providers are also useful for reading and writing data that is private to your app and not shared. E.g. The Note Pad sample app uses a content provider to save notes." );
        rets.add(lesson1);
        Lesson lesson2 = new Lesson(1,
                "Content Providers: Accessing a C.P. ",
                "https://developer.android.com/guide/topics/providers/images/content-provider-tech-stack.png",
                "How to access a content provider?" +
                        "\n" +
                        "When you want to access data in a content provider, you use the ContentResolver object in your application to communicate with the provider as a client.\n" +
                        "\n" +
                        "The ContentResolver object communicates with the provider object which is an instance of a class that implements ContentProvider. The provider object receives data requests from clients, performs the requested action, and returns the results. \n" +
                        "\n" +
                        "This object has methods that call identically-named methods in the provider object, an instance of one of the concrete subclasses of ContentProvider. \n" +
                        "\n" +
                        " TheContentResolver methods provide the basic \"CRUD\" (create, retrieve, update, and delete) functions of persistent storage.\n" +
                        "\n" +
                        "A common pattern for accessing a ContentProvider from your UI uses a CursorLoader to run an asynchronous query in the background. The Activity or Fragment in your UI call a CursorLoader to the query, which in turn gets the ContentProvider using the ContentResolver. \n" +
                        "\n" +
                        "This allows the UI to continue to be available to the user while the query is running. This pattern involves the interaction of a number of different objects, as well as the underlying storage mechanism.\n" +
                        "");
        rets.add(lesson2);
        Lesson lesson3 = new Lesson(2,
                "Content Providers: Steps to Create a C.P.",
                "https://realtimeapi.io/wp-content/uploads/2017/09/realtime-api.png",
                "There are a number of simple steps involved to create your own content provider\n" +
                        "\n" +
                        "First of all you need to create a Content Provider class that extends the ContentProviderbaseclass.\n" +
                        "\n" +
                        "Second, define the content provider URI address which will be used to access the content.\n"+
                        "\n" +
                        "Then, create a database to keep the content. Android traditionally uses the SQLite database whose framework needs to override onCreate() method which will use SQLite Open Helper method to create or open the provider's database. \n" +
                        "" +
                        "When your application is launched, the onCreate() handler of each of its Content Providers is called on the main application thread.\n" +
                        "\n" +
                        "Next you will have to implement Content Provider queries to perform different database specific operations. \n"+
                        "\n" +
                        "Finally register your Content Provider in the activity file using <provider> tag. \n" +
                        "\n" +
                        "\n" +
                        "We can find useful queries, which are displayed below\n" +
                        "\n" +
                        "onCreate() This method is called when the provider is started. \n"+
                        "\n" +
                        "query() This method receives a request from a client. The result is returned as a Cursor object. \n" +
                        "\n" +
                        "insert()This method inserts a new record into the content provider.\n" +
                        "\n" +
                        "delete() This method deletes an existing record from the content provider.\n " +
                        "\n" +
                        "update() This method updates an existing record from the content provider. \n" +
                        "\n" +
                        "getType() This method returns the MIME type of the data at the given URI.\n" +
                        "\n" +

                        "*");
        rets.add(lesson3);
        Lesson lesson4= new Lesson(3,
                "Content Providers: Relationship with DB ",
                "https://static.thenounproject.com/png/996048-200.png",
                "How are Content Providers related to SQLite?\n" +
                        "\n" +
                        "\n" +
                        "Content providers let you centralize content in one place and have many different applications access it as needed. \n" +
                        "\n" +
                        "A content provider behaves very much like a database where you can query it, edit its content, as well as add or delete content using insert(), update(), delete(), and query() methods. In most cases this data is stored in an SQlite database.\n\n" +
                        "\n" +
                        "");

        rets.add(lesson4);

        Lesson lesson5 = new Lesson(5,
                "SQLite: Introduction",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/SQLite370.svg/1200px-SQLite370.svg.png",
                "SQLite is a software library which provides a simple relational database management system that stores data in a local persistent storage on a device.\n" +
                        "\n" +
                        "It is the most widely deployed database in the world with several high-profile projects, including being used by Airbus in their A350 aircraft projects, and Apple in their iMessage system.\n" +
                        "\n" +
                        "Android includes SQLite as its public domain database engine. Unlike traditional database management systems such as SQL Server or Oracle, SQLite is completely self-contained, meaning that is does not require a separate server to operate.\n" +
                        "\n" +
                        "When an application uses SQLite, the integration works with functional and direct calls made to a file holding the data such as the SQLite Database instead of communicating through an interface of a port or socket.  \n" +
                        "\n" +
                        "This makes SQLite extremely agile and efficient.\n" +
                        "\n" +
                        "SQLite can be integrated in file based scenarios - when the entire database resides in a single file on the disk, making it an extremely portable and lightweight solution.\n" +
                        "Despite the omission of some standard SQL features such as Right, Outer Join etc, it retains many of the same features, providing ease to those who are familiar with SQL. \n" +
                        "Consequently, it serves as an appropriate means to conduct testing during the development phase of applications.\n" +
                        "\n" +
                        "");

        rets.add(lesson5);
        Lesson lesson6 = new Lesson(6,
                "SQLite: Features",
                "https://lh3.googleusercontent.com/ilhhAWDJ3xE6FzhMJ5Bob9m2qwjZIkcb_p9VCumnpmAUWGJCo_vYgFUSR3Cvw3GFtjYaBckAa07s8S7x9veT_qL_dmci9D29yxSrAjwJf9AOGFgEt5EkKeSzSqWMGkqHn6LrJau4SYHKEkvrHTJ8A8Ru4gZ2ijxp6zwQUaPURAObKIsptwHUCAd0F4FH60ntEFjvKrVdVABjBCLaaZRwmJkaWrvQauvpZph-ST7-9E04mwfuWdkQha3aG8YiJ9V4HqoS7CB8GSAGbthfMa2nL4ofzY5hAjQYOIKx7FDjP_n7zqw_WHBYJOkgOPsj3AYmAeIq9Z7DG_y4A0woCKlTvMhHFegC76jx_E2GMtUmQScCeSQBFV66C7ijcpoDc8uNJzWL_qgFRs36RCxjbhrGD1_ptd_ypOZfj2J2YC98NPk6KCLTjYBX__0knd0VYnbayjXr8h2eTnvD_DZ_nRLPG23Snc07FDuZJRXdbDwj-VUoqhT6v81FkJ83O1zqzPw1bQ9oMDMr4AaV9rqtyXObEKt2dXPtwgqkrflV2Mm1vEdpNY7CEPZcGYwFWHoB67R0IpMiKwwEtzrD37pB42jcjyV644Kn2Nvfq1S6v9DvGaOA8lXwFiRhBFCxTspqMdCB=s512-no",
                "SQLite is self-contained, server-less, does not need configuration and is transactional.\n" +
                        "\n" +
                        "Self Contained:\n" +
                        "SQLite is self-contained means it requires minimal support from the operating system or external library. This makes SQLite usable in any environments especially in embedded devices like iPhones, Android phones, game consoles, handheld media players, etc.\n" +
                        "\n" +
                        "Self Contained:\n" +
                        "As SQL does not need configurations, and due to the serverless architecture, you don’t need to “install” SQLite before using it. There is no server process that needs to be configured, started, and stopped.\n" +
                        "\n" +
                        "Transactional:\n" +
                        "SQlite is a transactional database that all changes and queries are atomic, consistent, isolated, and durable (ACID).\n" +
                        "\n" +
                        "SQLite guarantees all the transactions are ACID compliant even if the transaction is interrupted by program crash, operation system dump, or power failure to the computer" +

                        "");

        rets.add(lesson6);
        Lesson lesson7 = new Lesson(7,
                "SQLite: Usage ",
                "https://i2.wp.com/www.electronicarmory.com/wp-content/uploads/2016/03/android-database-logo.png",
                "How should we use the features of SQLite?\n" +
                        "\n" +
                        "SQLite supports all the relational database features. In order to access this database, you don't need to establish any kind of connections for it like JDBC,ODBC etc.\n" +
                        "\n" +
                        "•The main package is android.database.sqlite that contains the classes to manage your own databases. \n" +
                        "\n" +
                        "In order to create a database, call the method openOrCreateDatabase with your database name and mode as a parameter. It returns an instance of SQLite database which you have to receive in your own object.  \n" +
                        "\n" +
                        "SQLite SELECT statement is used to fetch the data from a SQLite database table which returns data in the form of a result table. These result tables are also called result sets.\n" +
                        "\n" +
                        "SQLite INSERT INTO Statement is used to add new rows of data into a table in the database.\n" +
                        "\n" +
                        "SQLite UPDATE Query is used to modify the existing records in a table. You can use WHERE clause with UPDATE query to update selected rows, otherwise all the rows would be updated.\n" +
                        "\n" +
                        "SQLite DELETE Query is used to delete the existing records from a table. You can use WHERE clause with DELETE query to delete the selected rows, otherwise all the records would be deleted.\n" +
                        "\n" +
                        " ");
        rets.add(lesson7);
        return rets;


    }


}