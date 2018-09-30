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
public class HomeFragment extends Fragment {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;
    ProgressDialog progressDialog;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Post");
        mRef.keepSynced(true);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();



        FirebaseRecyclerAdapter<PostViewModal, PostViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<PostViewModal, PostViewHolder>(
                        PostViewModal.class,
                        R.layout.postlist,
                        PostViewHolder.class,
                        mRef

                ) {
                    @Override
                    protected void populateViewHolder(PostViewHolder viewHolder, PostViewModal model, int position) {


                        viewHolder.setDetails(getContext(), model.getPostName(), model.getPostImage(), model.getPostAbout(), model.getHtmlLink());
                        progressDialog.dismiss();

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
    }
}

