package in.trysafe.trysafe;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment {

    RecyclerView mRecyclerView,mRecyclerView1,mRecyclerView2;
    FirebaseDatabase mFirebaseDatabase,mFirebaseDatabase1,mFirebaseDatabase2;
    DatabaseReference mRef,mRef1,mRef2;
    ProgressDialog progressDialog;

    public StudyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_study, container, false);

//        progressDialog = new ProgressDialog(getActivity());
//        progressDialog.setMessage("Loading...");
//        progressDialog.setCanceledOnTouchOutside(false);
//        progressDialog.show();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView1 = view.findViewById(R.id.recyclerView1);
        mRecyclerView1.setHasFixedSize(true);

        mRecyclerView2 = view.findViewById(R.id.recyclerView2);
        mRecyclerView2.setHasFixedSize(true);




        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Courses");
        mRef.keepSynced(true);

        mFirebaseDatabase1 = FirebaseDatabase.getInstance();
        mRef1 = mFirebaseDatabase1.getReference("Programming");
        mRef1.keepSynced(true);

        mFirebaseDatabase2 = FirebaseDatabase.getInstance();
        mRef2 = mFirebaseDatabase2.getReference("Eee");
        mRef2.keepSynced(true);


        return view;

    }


    @Override
    public void onStart() {
        super.onStart();



        FirebaseRecyclerAdapter<courseViewModel,CourseViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<courseViewModel, CourseViewHolder>(
                        courseViewModel.class,
                        R.layout.courselist,
                        CourseViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(CourseViewHolder viewHolder, courseViewModel model, int position) {


                        viewHolder.setDetails(getContext(),model.getCourseName(),model.getCourseImage(), model.getHtmlLink());

                        final String link = getItem(position).getHtmlLink();

                        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getContext(), PostWebView.class);
                                intent.putExtra("mLink", link);
                                startActivity(intent);
                            }
                        });
                    }
                };

        mRecyclerView.setAdapter(firebaseRecyclerAdapter);


        /////programing

        FirebaseRecyclerAdapter<courseViewModel,CourseViewHolder> firebaseRecyclerAdapter1 =
                new FirebaseRecyclerAdapter<courseViewModel, CourseViewHolder>(
                        courseViewModel.class,
                        R.layout.courselist,
                        CourseViewHolder.class,
                        mRef1
                ) {
                    @Override
                    protected void populateViewHolder(CourseViewHolder viewHolder, courseViewModel model, int position) {


                        viewHolder.setDetails(getContext(),model.getCourseName(),model.getCourseImage(), model.getHtmlLink());

                        final String link = getItem(position).getHtmlLink();

                        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getContext(), PostWebView.class);
                                intent.putExtra("mLink", link);
                                startActivity(intent);
                            }
                        });
                    }
                };

        mRecyclerView1.setAdapter(firebaseRecyclerAdapter1);



        ////Science and Techonlogy


        FirebaseRecyclerAdapter<courseViewModel,CourseViewHolder> firebaseRecyclerAdapter2 =
                new FirebaseRecyclerAdapter<courseViewModel, CourseViewHolder>(
                        courseViewModel.class,
                        R.layout.courselist,
                        CourseViewHolder.class,
                        mRef2
                ) {
                    @Override
                    protected void populateViewHolder(CourseViewHolder viewHolder, courseViewModel model, int position) {


                        viewHolder.setDetails(getContext(),model.getCourseName(),model.getCourseImage(), model.getHtmlLink());

                        final String link = getItem(position).getHtmlLink();

                        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getContext(), PostWebView.class);
                                intent.putExtra("mLink", link);
                                startActivity(intent);
                            }
                        });
                    }
                };

        mRecyclerView2.setAdapter(firebaseRecyclerAdapter2);

    }






}
