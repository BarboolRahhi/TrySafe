package in.trysafe.trysafe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class PostViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public PostViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }


    public void setDetails(Context ctx, String postName , String postImage, String postAbout ,String htmlLink){
        TextView mTitle = mView.findViewById(R.id.posttitle);
        TextView mAbout = mView.findViewById(R.id.postAbout);
        ImageView imageView = mView.findViewById(R.id.postImage);

        mTitle.setText(postName);
        mAbout.setText(postAbout);
        Picasso.get().load(postImage).placeholder(R.drawable.placeholderimage).networkPolicy(NetworkPolicy.OFFLINE).into(imageView);
    }
}
