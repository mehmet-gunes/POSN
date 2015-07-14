package com.posn.main.wall.posts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.posn.R;
import com.posn.datatypes.Post;
import com.posn.main.wall.WallArrayAdapter.PostType;
import com.posn.main.wall.comments.CommentActivity;


public class StatusPostItem implements ListViewPostItem, OnClickListener
   {

      private Context context;
      private Post postData;

      static class ViewHolderItem
         {
            TextView nameText;
            TextView dateText;
            TextView statusText;

            RelativeLayout commentButton;
            RelativeLayout shareButton;
         }


      public StatusPostItem(Context context, Post postData)
         {
            this.context = context;
            this.postData = postData;
         }


      @Override
      public int getViewType()
         {
            return PostType.STATUS_POST_ITEM.ordinal();
         }


      @Override
      public View getView(LayoutInflater inflater, View convertView)
         {
            //  View view = convertView;
            ViewHolderItem viewHolder;

            if (convertView == null)
               {
                  // inflate the layout
                  convertView = (View) inflater.inflate(R.layout.listview_wall_status_item, null);

                  // well set up the ViewHolder
                  viewHolder = new ViewHolderItem();
                  viewHolder.nameText = (TextView) convertView.findViewById(R.id.name);
                  viewHolder.dateText = (TextView) convertView.findViewById(R.id.date);
                  viewHolder.statusText = (TextView) convertView.findViewById(R.id.status);

                  viewHolder.commentButton = (RelativeLayout) convertView.findViewById(R.id.comment_button);
                  viewHolder.shareButton = (RelativeLayout) convertView.findViewById(R.id.share_button);

                  viewHolder.commentButton.setOnClickListener(this);
                  viewHolder.shareButton.setOnClickListener(this);

                  // store the holder with the view.
                  convertView.setTag(viewHolder);
               }
            else
               {
                  viewHolder = (ViewHolderItem) convertView.getTag();
               }

            // set the data into the views
            viewHolder.nameText.setText(postData.friend);
            viewHolder.dateText.setText(postData.date);
            viewHolder.statusText.setText(postData.content);

            return convertView;
         }


      @Override
      public void onClick(View v)
         {
            switch (v.getId())
               {
                  case R.id.comment_button:

                     // launch comment activity
                     Intent intent = new Intent(context, CommentActivity.class);
                     context.startActivity(intent);

                     break;

                  case R.id.share_button:
                     break;
               }
         }

   }