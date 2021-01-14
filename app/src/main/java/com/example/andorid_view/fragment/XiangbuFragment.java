package com.example.andorid_view.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.andorid_view.MainActivity;
import com.example.andorid_view.R;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class XiangbuFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_xiangbu, container, false);
        Gallery g = view.findViewById(R.id.xiangbu_gallery);


        g.setAdapter(new ImageAdapter(getContext()));
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private class ImageAdapter extends BaseAdapter {
        Context mcontext = null;
        private Integer[] myImageIds = {R.drawable.mm1,R.drawable.mm2,R.drawable.mm3,R.drawable.mm4};
        int MGalleryBackground;
        public ImageAdapter(Context context) {
            mcontext = context;
            TypedArray a = mcontext.obtainStyledAttributes(R.styleable.Gallery);
            MGalleryBackground = a.getResourceId(R.styleable.Gallery_android_galleryItemBackground,0);
            a.recycle();
        }



        @Override
        public int getCount() {
            return myImageIds.length;
        }

        @Override
        public Object getItem(int position) {
            return myImageIds[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            Inflater inflater = new Inflater(context,R)
            ImageView i = new ImageView(mcontext);
            i.setImageResource((int)getItem(position));
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            i.setLayoutParams(new Gallery.LayoutParams(500,888));

            i.setBackgroundResource(MGalleryBackground);
            return i;
        }
    }


}