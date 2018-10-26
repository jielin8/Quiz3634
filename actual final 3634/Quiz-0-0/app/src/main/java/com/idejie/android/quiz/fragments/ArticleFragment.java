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
import com.idejie.android.quiz.adapters.ArticleAdapter;
import com.idejie.android.quiz.models.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleFragment extends Fragment {
    RecyclerView recyclerView;
    ArticleAdapter adapter;

    private static final String ARG_COLUMN_COUNT = "column-count";


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ArticleFragment() {
    }

    @SuppressWarnings("unused")
    public static ArticleFragment newInstance(int columnCount) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        recyclerView = view.findViewById(R.id.articles_list);
        final List<Article> articles = getArticles();
        adapter = new ArticleAdapter(getActivity(), articles, new ArticleAdapter.OnItemClickCallback<Article>() {
            @Override
            public void onClick(View view, Article info) {
                Log.d("#Quiz","####"+info.article_title);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("title",info.article_title);
                bundle.putString("content",info.article_content);
                intent.putExtras(bundle);
                intent.setClass(getActivity(),DetailActivity.class);
                startActivity(intent);
            }
        });
//recycler view container
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL));

        return view;
    }

   //articles and content
    private List<Article> getArticles() {
        List<Article> articles= new ArrayList<>();
        Article article0 = new Article(0,
                "https://icdn7.digitaltrends.com/image/dsc_4920-720x720.jpg",
                "Android: 10 Years in the Making",
                "The smartphone has come a long way since the first iPhone launched in 2007. While Apple’s iOS is arguably the world’s first smartphone operating system, Google’s Android is by far the most popular.\n" +
                        "\n" +
                        "\n" +
                        "Android has evolved significantly since its inception, first being released on an HTC-made T-Mobile device back in 2008. Some might not know, however, that Android’s history dates back before it was available on smartphones. \n" +
                        "\n" +
                        "\n" +
                        "“In fact, Android was first created in 2003 by Andy Rubin, who first started developing the OS for digital cameras. Soon, he realized that the market for digital camera operating systems perhaps wasn’t all that big, and Android, Inc. diverted its attention toward smartphones. \n" +
                        "\n" +
                        "It wasn’t until 2005 that Google purchased Android, Inc., and while not much about Android was known at the time, many took it as a signal that Google would use the platform to enter the phone business. Eventually, Google did enter the smartphone business — but not as a hardware manufacturer. \n" +
                        "\n" +
                        "" +
                        "" +
                        "”");
        Article article1 = new Article(1,
                "https://icdn3.digitaltrends.com/image/android-9-pie-review-app-switcher-2-720x720.jpg",
                "Android 9.0 Pie: What's New",
                "Android Pie brings with it a number of visual changes — so much so that from a visual perspective, it’s the biggest change to Android in a few years.\n" +
                        "\n" +
                        "\n" +
                        "Most notably, Android 9.0 Pie does away with the three-button setup that has existed in Android for years, replacing it with a single pill-shaped button and gestures for controlling things like multitasking. Android 9.0 Pie also brings with it some changes to notifications, including extra control over the types of notifications that show up and where they show up, as well as Google’s new “Digital Wellbeing,” a feature that essentially tells you how often you use your phone, the apps that you use the most, and so on. The feature is aimed at helping users better manage their digital lives and curb smartphone addiction.\n" +
                        "\n" +
                        "Other features include adaptive battery, which limits how much battery background apps can use, as well as “App Actions,” which are deep-links to certain app features that show up straight from the app drawer.");
        Article article2 = new Article(2,
                "https://cdn57.androidauthority.net/wp-content/uploads/2015/04/sqlite-and-Android-792x446.jpg",
                "SQLite: Why use it",
                "Most Android apps will need to persist user data at sometime. There are different ways to store user data, but SQLite databases are a very convenient and speedy method of saving user (or app) data and information.\n" +
                        "\n" +
                        "SQLite is an Open Source SQL database that stores the database as a text file on a device. Basic familiarity with SQL sets up a developer nicely to use Android’s sqlite implementation. And for developers not familiar with SQL, do not be discouraged, SQL is pretty straightforward to learn, use and implement. SQLite is a relational database management system just like Oracle, MySQL and PostgreSQL. Due to its small footprint and public domain license, it is possibly the most widely deployed database engine in the world, it can be found in all types of software ranging from embedded systems, browsers, and operating systems.\n" +
                        "\n" +
                        "Android has a built in SQLite implementation, and application specific database files are stored in a private disk space that’s inaccessible to other applications. This way, no application can access another application’s data.\n" +
                        "\n");
        Article article3 = new Article(3,
                "https://upload.wikimedia.org/wikipedia/en/thumb/6/62/MySQL.svg/440px-MySQL.svg.png",
                "Benefits of Learning Android",
                "Learning the Android language may be a challenge for those who choose to undertake this feat. But it has significant rewards, some of which are listed below. \n" +
                        "\n" +
                        "1. High user base: The mobile app industry is growing regarding the huge and growing user base, symbolize the influence of this system." +
                        "\n" +
                        "2. No Licensing Fees: Android being an open source platform, It can be collected free to develop an app and expand its prototype.\n" +
                        "\n" +
                        "3.Cross-Platform Compatibility: Android platform offers developers chance for developmental research in partnership with other platforms.\n" +
                        "\n" +
                        "4. Flexibility: Android has no developmental condition like iOS platform, Android is highly flexible to go after many developmental capabilities.");
        Article article4 = new Article(4,
                "https://upload.wikimedia.org/wikipedia/commons/b/bb/Android_open_source_project.png",
                "Android App Development: Additional Resources",
                "A big part of learning is having good sources of information. At the beginning it’s not obvious where to go, and unfortunately some good sources are difficult to discover by your own.\n" +
                        "\n" +
                        "developer.android.com: The main reference for Android developers. This website is not only an API reference documentation, but a design resources hub, distribution guide and a training site.\n" +
                        "\n" +
                        "Udacity: Provides Android courses (free and paid) in partnership with Google.\n" +
                        "\n" +
                        "Medium.com: Is one of the favorite places for Android developers to share their knowledge about Android.\n" +
                        "\n" +
                        "Fragmented Podcast: One of the best podcasts, it includes content created by important community members, and others about libraries and they even have series about Effective Java and Kotlin.");
        Article article5 = new Article(5,
                "https://upload.wikimedia.org/wikipedia/en/thumb/6/62/MySQL.svg/440px-MySQL.svg.png",
                "SQLite vs MySQL",
                "SQLite is a library that gets embedded inside the application that makes use of it. It offers an amazing set of tools to handle all sorts of data. As a self-contained, file-based database, SQLite can be compared to hosted alternatives, like MySQL.\n" +
                        "\n" +
                        "SQLite is file-based — the database consists of a single file on the disk, which makes it extremely portable and reliable. Although it might appear like a “simple” DB implementation, SQL is used in SQLite. SQLite is meant to be great for both developing and testing and offers more than what is needed for development.\n" +
                        "\n" +
                        "On the other hand, MySQL is very easy to work with. For instance, it can be easily installed, third-party tools make it a simple database to get started with, and it's enriched with features. It supports a lot of SQL functionality that is expected from an RDBMS. MySQL is secured, which makes it highly advanced.");
        Article article6 = new Article(6,
                "https://upload.wikimedia.org/wikipedia/commons/b/bb/Android_open_source_project.png",
                "Discussion: When should I use a Content Provider?",
                "It is a good idea to use a ContentProvider even if you don't intend to make it public.\n" +
                        "\n" +
                        "It's good practice to provide the extra level of abstraction over your data to make it easier to change internally. What if you decide to change the underlying database structure at a later time? If you use a ContentProvider you can contain all the structural changes within it, where as if you don't use one, you are forced to change all areas of the code that are affected by the structural changes. Besides, it's nice to be able to re-use the same standard API for accessing data rather than littering your code with low-level access to the database.\n" +
                        "\n" +
                        "Also, there is always the chance that you might want to expose your data in the future. If you don't use a ContentProvider up front, it will be much harder to retrofit it in at a later date.\n" +
                        "\n" +
                        "Then, there's the other parts of the Android where ContentProvider's are required/recommended such as when using SyncAdapters and if you want an App Widget that involves data access for instance.\n" +
                        "\n" +
                        "In summary, there is very little overhead involved in writing a ContentProvider up front (once you have learned the API which is a good idea anyway) so it makes sense to do so, even for private data.");

        articles.add(article0);
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);


        return articles;
    }


}