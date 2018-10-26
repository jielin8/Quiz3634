package com.idejie.android.quiz.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.idejie.android.quiz.R;
import com.idejie.android.quiz.models.Quiz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizFragment extends Fragment {
    TextView question;
    RadioGroup radioGroup;
    RadioButton choice1;
    RadioButton choice2;
    RadioButton choice3;
    LinearLayout layout_question;
    TextView correct;
    TextView feedback;
    Button btn_continue;
    ImageView q11;
    View view;
    Quiz quiz;
    int p = 0;
    int correctNum;
    List<Quiz> quizzes = getRandom5Quizzes();

    private List<String> titles = new ArrayList<>();
    private List<Integer> nums = new ArrayList<>();

    private DecimalFormat df = new DecimalFormat("0.00");
    private PieChart mPiechart;

    private List<Quiz> getRandom5Quizzes() {
        List<Quiz> quizzesAll = getQuizzes();
        Map<Integer, Quiz> quizMap = new HashMap<>();
        while (quizMap.size() < 5) {
            int id = (int) (Math.random() * (quizzesAll.size() - 1));
            quizMap.put(id, quizzesAll.get(id));

        }
        List<Quiz> quizzes = new ArrayList<>();
        for (int id : quizMap.keySet()) {
            quizzes.add(quizMap.get(id));
        }
        return quizzes;
    }

    private List<Quiz> getQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        Quiz quiz0 = new Quiz(0,
                "When will a content provider be activated?",
                "Using Intent",
                "Using SQLite",
                "Using ContentResolver ",
                3,
                "When we want to access data in a content provider, we use the ContentResolver object to communicate with the provider as a client. ContentResolver communicates with the provider object, an instance of a class that implements ContentProvider. ");
        quizzes.add(quiz0);
        Quiz quiz1 = new Quiz(1,
                "What is the use of the helper class in SQlite",
                "A helper class provide functionalities for deleting rows, inserting data into rows into a table.",
                "A helper class is used for fetching the data from remote servers and storing it into SQLiteDatabase",
                "A helper class allows database management ,creation and version management. This is the class where we will create all the tables, and upgrade tables",
                3,
                "A helper class allows DB manageement, creation and version management.");
        quizzes.add(quiz1);
        Quiz quiz2 = new Quiz(2,
                "How to show SQLite Database table information in android application? what is the best way to do it",
                "Use listview with cursor adapter",
                "Use grid view with cursor adapter",
                "Use table layout with cursor adapter.",
                3,
                "Showing data base information will be better suited with table layout.  since table layout is not an adapter view, you can’t use cursor adapter with it. So use table layout with cursor to show database table information.");
        quizzes.add(quiz2);
        Quiz quiz3 = new Quiz(3,
                "Which of the following statements about Content providers is incorrect?",
                "It manages access to a central repository of data ",
                "They are primarily intended to be used by other applications, which access the provider using a provider client object",
                "A content provider is unable to allow other applications to modify app data.",
                3,
                "Content providers can allow for another application to securely access and modify app data.");
        quizzes.add(quiz3);
        Quiz quiz4 = new Quiz(4,
                "How to share data between two applications?",
                " use sqlite database",
                "use content resolver",
                "use content provider",
                3,
                "Content provider is the android component, which has to be used if one application wants to share its data with other application.");
        quizzes.add(quiz4);
        Quiz quiz5 = new Quiz(5,
                "Is it OK to call getWritableDataBase() from the main UI Thread?",
                "Yes it can be",
                "getWritableDataBase() should not be called on any thread.",
                "No. because if it takes too much of time to create all the tables, then it may interrupt main thread and user experience will get disturbed.",
                3,
                "For the first time when db is being created, it may take more time than expected to create all the tables. So better to call getWritabledatabase in a separate background thread. If it takes too much of time to create all the tables, then it may interrupt main thread and user experience will get disturbed");
        quizzes.add(quiz5);
        Quiz quiz6 = new Quiz(6,
                "Will calling helper.getWritableDatabase() always calls onCreate() of Helper class?",
                " It will call helper class onCreate() function every time.",
                "It will call helper class onCreate() function every time whenever the user starts that application.",
                "It will call helper class onCreate() function only if database is created for the first time.",
                3,
                "It will call the helper class onCreate() only if the database is initialised for the first time");
        quizzes.add(quiz6);
        Quiz quiz7 = new Quiz(7,
                "Which of the following is the best reason to use a content provider?",
                "Provides a good abstraction layer",
                "Directly improves app performance",
                "Manages access to text data",
                1,
                "Content providers enable easy sharing of data with other layers and hides the details of how the data is stored through an abstraction layer.");
        quizzes.add(quiz7);
        Quiz quiz8 = new Quiz(8,
                "How to start a content provider using an intent?",
                "possible. Content provider is also a component of android, so we can use intent to start it",
                "possible. Content provider is also a component of android, so we can use intent to start it",
                "option 2 is correct because, we use content resolver to communicate with content provider",
                3,
                "Intents will be used to communicate or start components of android. Only exception is content provider. You can start an activity, service, and a broadcast receiver using intent but not content provider. For content provider we have to use contentresolver to communicate");
        quizzes.add(quiz8);
        Quiz quiz9 = new Quiz(9,
                "Which of the following presents the correct structure for a Content URI (uniform resource provider)?",
                "Scheme, Type of Data, Content Authority",
                "Content Authority, Scheme, Type of Data",
                "Scheme, Content Authority, Type of data",
                3,
                "A content URI is a URI that identifies data in a provider. Content URIs are structured by its scheme, content authority, and type of data");
        quizzes.add(quiz9);
        Quiz quiz10 = new Quiz(10,
                "Which of the following is correct complete the flowchart?",
                "A) ContentResolver B) Content Provider ",
                "A) Content Authority B) Content Resolver",
                "A) Content Resolver B) Content URI",
                1,
                "The Fragment in our UI calls a CursorLoader to the query, which in turn pulls the ContentProvider using the ContentResolver. This allows the UI to continue to be available to the user while the query is running. Hence the correct answer is A) ContentResolver B)Content Provider.");
        quizzes.add(quiz10);
        return quizzes;
    }

    /**
     * pie chart quiz ending
     */
    private void initChart(View view) {
        mPiechart = (PieChart) view.findViewById(R.id.mPieChart);
        //setting x axis
        mPiechart.animateX(1400);
        //use percent values
        mPiechart.setUsePercentValues(true);
        mPiechart.getLegend().setEnabled(true);
        //form size
        mPiechart.getLegend().setFormSize(10);
        //textsize
        mPiechart.getLegend().setTextSize(10);
        //positioning
        mPiechart.getLegend().setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        mPiechart.getLegend().setForm(Legend.LegendForm.SQUARE);
        mPiechart.setDescription("Pie Chart");
        //text size
        mPiechart.setDescriptionTextSize(12);
        //positioning
        mPiechart.setDescriptionPosition(950, 950);
        //no rotation
        mPiechart.setRotationEnabled(false);
    }

    // TODO: Customize parameter argument names
    private static final String DATA = "data";


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public QuizFragment() {
    }


    @SuppressWarnings("unused")
    public static QuizFragment newInstance(int columnCount) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putInt(DATA, columnCount);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_quiz, container, false);
        question = view.findViewById(R.id.quiz_title);
        radioGroup = view.findViewById(R.id.choice_group);
        correct = view.findViewById(R.id.correct);
        feedback = view.findViewById(R.id.feedback);
        btn_continue = view.findViewById(R.id.btn_continue);
        q11 = view.findViewById(R.id.q11);

        layout_question = view.findViewById(R.id.layout_question);

        initChart(view);

        Log.i("#Quiz:QuizFragment", quizzes.size() + "");
        Quiz q = quizzes.get(p);
        Log.i("#Quiz:QuizFragment", q.question + "");
        if (q.id == 10) {
            q11.setVisibility(View.VISIBLE);
        } else {
            q11.setVisibility(View.GONE);
        }
        question.setText(q.question);
        ((RadioButton) radioGroup.getChildAt(0)).setText(q.choice1);
        ((RadioButton) radioGroup.getChildAt(1)).setText(q.choice2);
        ((RadioButton) radioGroup.getChildAt(2)).setText(q.choice3);


        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (p < quizzes.size() - 1) {
                    p++;
                    quiz = quizzes.get(p);
                    if (quiz.id == 10) {
                        q11.setVisibility(View.VISIBLE);
                    } else {
                        q11.setVisibility(View.GONE);
                    }
                    radioGroup.clearCheck();
                    correct.setText("");
                    feedback.setText("");
                    question.setText(quiz.question);
                    ((RadioButton) radioGroup.getChildAt(0)).setText(quiz.choice1);
                    ((RadioButton) radioGroup.getChildAt(1)).setText(quiz.choice2);
                    ((RadioButton) radioGroup.getChildAt(2)).setText(quiz.choice3);
                    if (p <= 3) {
                        btn_continue.setText("Continue");
                    } else if (p == 4) {
                        btn_continue.setText("Finish");
                    } else
                        Log.i("#QuizFragment", "" + p);

                } else {

                    layout_question.setVisibility(View.GONE);
                    mPiechart.setVisibility(View.VISIBLE);

                    Log.i("#QuizFragment", "" + p);

                    titles.add("Correct");
                    nums.add(correctNum);
                    titles.add("Wrong");
                    nums.add(quizzes.size() - correctNum);

                    setData();

                }
            }

        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("#QuizFragment", "问题：" + quizzes.get(p).question + "你选了" + checkedId);
                if (checkedId == -1) {

                } else {

                    Log.i("#QuizFragment", "答案：" + quizzes.get(p).question + "你选了" + ((RadioButton) view.findViewById(checkedId)).getText());
                    try {
//                        Log.d("#Quiz#quiz",quiz.toString());
                        int c = radioGroup.getChildAt(quizzes.get(p).correctID - 1).getId();

                        int id = group.getCheckedRadioButtonId();

                        if (id == c) {
                            Log.i("#Quiz:QuizFragment", "Correct");
                            correct.setText("Correct");
                            correct.setTextColor(Color.GREEN);
                            correctNum++;
                        } else {
                            Log.i("#Quiz:QuizFragment", "Wrong");
                            correct.setText("Wrong");
                            correct.setTextColor(Color.RED);
                        }
                        feedback.setText(quizzes.get(p).feedback);

                    } catch (Exception e) {
                        Log.i("#Quiz", e.toString());
                    }


                }
            }
        });
        return view;
    }

    /**
     * 图表设置数据
     */
    private void setData() {
        //set data
        ArrayList<Entry> entrys = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            entrys.add(new Entry(nums.get(i), i));
        }
        //pie chart data
        PieDataSet dataset = new PieDataSet(entrys, "");
        //spacing
        dataset.setSliceSpace(3f);
        dataset.setSelectionShift(10f);
        //colors
        dataset.setColors(new int[]{
                Color.rgb(60, 179, 113),
                Color.rgb(255, 60, 60),
        });
        //padding
        PieData piedata = new PieData(titles, dataset);
        //setting font size
        piedata.setValueTextSize(12);
        piedata.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return df.format(value) + "%";
            }
        });
        mPiechart.setData(piedata);
    }

}
