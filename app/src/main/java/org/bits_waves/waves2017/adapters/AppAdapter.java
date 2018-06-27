package org.bits_waves.waves2017.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.bits_waves.waves2017.listitems.AppItem;
import org.bits_waves.waves2017.R;

import java.util.List;

/**
 * Created by keshav on 10/9/17.
 */

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder> {
    private List<AppItem> listItems;
    private Context context;



    public AppAdapter(List<AppItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.our_team_fragement_app_card_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final AppItem listItem = listItems.get(position);
        holder.name.setText(listItem.getName());
        holder.position.setText(listItem.getPosition());


        holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"number",Toast.LENGTH_LONG).show();
                //String str=holder.number.getText().toString();
                Intent it=new Intent(Intent.ACTION_VIEW).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it.setData(Uri.parse(listItem.getLink()));
                context.startActivity(it);
            }
        });
        holder.link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"number",Toast.LENGTH_LONG).show();
                //String str=holder.number.getText().toString();
                Intent it1=new Intent(Intent.ACTION_VIEW).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it1.setData(Uri.parse(listItem.getLink2()));
                context.startActivity(it1);
            }
        });
        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"number",Toast.LENGTH_LONG).show();
                //String str=holder.number.getText().toString();
                Intent it2=new Intent(Intent.ACTION_SEND).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it2.setType("text/html");
                it2.putExtra(Intent.EXTRA_EMAIL,listItem.getEmail());
                context.startActivity(it2);
            }
        });
        holder.mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"number",Toast.LENGTH_LONG).show();
                //String str=holder.number.getText().toString();
                Intent it3=new Intent(Intent.ACTION_SEND).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it3.setType("text/html");
                it3.putExtra(Intent.EXTRA_EMAIL,listItem.getEmail2());
                context.startActivity(it3);
            }
        });
        holder.mob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"number",Toast.LENGTH_LONG).show();
                //String str=holder.number.getText().toString();
                Intent it4=new Intent(Intent.ACTION_DIAL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it4.setData(Uri.parse("tel:" +listItem.getNumber()));
                context.startActivity(it4);
            }
        });
        holder.mob2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"number",Toast.LENGTH_LONG).show();
                //String str=holder.number.getText().toString();
                Intent it5=new Intent(Intent.ACTION_DIAL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it5.setData(Uri.parse("tel:" +listItem.getNumber2()));
                context.startActivity(it5);
            }
        });

        Picasso.with(context).load(listItem.getImageUrl()).transform(new CircleTransform()).into(holder.imgViewIcon);
        holder.name2.setText(listItem.getName2());
        holder.position2.setText(listItem.getPosition2());
        Picasso.with(context).load(listItem.getImageUrl2()).transform(new CircleTransform()).into(holder.imgViewIcon2);

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView position;
        public ImageButton link, link2, mail, mail2, mob, mob2;
        public ImageView imgViewIcon;
        public TextView name2;
        public TextView position2;
        public ImageView imgViewIcon2;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            position = itemView.findViewById(R.id.email);
            link =  itemView.findViewById(R.id.info);
            link2 =  itemView.findViewById(R.id.info2);
            mail =  itemView.findViewById(R.id.mail);
            mail2 = itemView.findViewById(R.id.mail2);
            mob = itemView.findViewById(R.id.call);
            mob2 = itemView.findViewById(R.id.call2);
            imgViewIcon = itemView.findViewById(R.id.imageView3);
            name2 = itemView.findViewById(R.id.name2);
            position2 = itemView.findViewById(R.id.email2);
            imgViewIcon2 = itemView.findViewById(R.id.imageView32);

        }
    }

    class CircleTransform implements Transformation {
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
            if (squaredBitmap != source) {
                source.recycle();
            }

            Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            BitmapShader shader = new BitmapShader(squaredBitmap,
                    BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setAntiAlias(true);

            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);

            squaredBitmap.recycle();
            return bitmap;
        }

        @Override
        public String key() {
            return "circle";
        }
    }
}

