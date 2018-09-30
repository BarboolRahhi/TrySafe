package in.trysafe.trysafe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class CourseViewHolder extends RecyclerView.ViewHolder {
    View mView;
    public CourseViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String courseName , String courseImage, String htmlLink){
        TextView mTitle = mView.findViewById(R.id.coursetitle);
        //TextView mAbout = mView.findViewById(R.id.postAbout);
        ImageView imageView = mView.findViewById(R.id.courseImage);

        mTitle.setText(courseName);
        Picasso.get().load(courseImage).placeholder(R.drawable.placeholderimage).networkPolicy(NetworkPolicy.OFFLINE).into(imageView);
    }
}
