package com.example.souji.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.souji.androidlibrary.DisplayJoke;

/**
 * Created by souji on 3/8/16.
 */
public class MainFragment extends Fragment implements View.OnClickListener{



        private String mjoke;
        private Button jokeButton;


        public MainFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_main, container, false);

            jokeButton = (Button) root.findViewById(R.id.button);
            jokeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tellJoke(v);
                }
            });


            return root;
        }


        public void tellJoke(View view) {

            Toast.makeText(getActivity(), "Wait untill it loads...", Toast.LENGTH_SHORT).show();


            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
            endpointsAsyncTask.setListner(new EndpointsAsyncTask.TaskListner() {
                @Override
                public void getTaskResult(String result) {
                    mjoke = result;

                        startJokeActivity(result);


                }
            }).execute(getActivity());

        }

        private void startJokeActivity(String result) {
            Log.d("result"," "+result);
            Intent intent = new Intent(getActivity(), DisplayJoke.class);
            intent.putExtra(Intent.EXTRA_TEXT, result);
            startActivity(intent);
        }

        @Override
        public void onClick(View v) {
            tellJoke(v);
        }
    }




